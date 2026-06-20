import javax.swing.JOptionPane;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class UI_Engine{

    ArrayList<Integer> totalTax_Queue = new ArrayList<>();

    void MainMenu(){
        JOptionPane.showMessageDialog(null, "======AUTOMATED ECO-FRIENDLY FREIGHT ROUTING======");
    }

    void Queue_UI(String Queue_Name){
        JOptionPane.showMessageDialog(null, "Compiling " + Queue_Name + " Distribution Routing....");
    }

    void Manifest_Settlement(){
        JOptionPane.showMessageDialog(null, "Processing.... Manifest_Settlement");
    }

    void Stack_UI(){
        JOptionPane.showMessageDialog(null, "Unloading Stack....");
    }

    void Summary(){
        JOptionPane.showMessageDialog(null, "Collecting data for summary...");
    }

     void System_Complete_UI(){
        JOptionPane.showMessageDialog(null, "Automated Eco-Friendly Freight Routing complete!");
    }

    void System_Summary(int q1Size, int q2Size, int q3Size, int TotalParse, int TotalCarrier, int tax1, int tax2, int tax3){

        JOptionPane.showMessageDialog(null, "===================================\n" + " SUPPLY SYSTEM SUMMARY \n" + "===================================\n\n" + "Total Record Parse: " + TotalParse + 
            "\nTotal Carrier: " + (q1Size + q2Size + q3Size) + "\n\n------------------------------------\n" + "QUEUE DISTRIBUTION \n" + "------------------------------------\n\n" + 
            "Regional Micro Distribution: " + q1Size + " Carrier" + "\nCross Border Express: " + q2Size+ " Carrier" + "\nIndustrial Bulk Logistics Fleet: " + q3Size + " Carrier" +
            "\n\n------------------------------------\n" + "CARBON TAX SUMMARY \n" + "------------------------------------\n\n" + "Queue 1: >> RM" + tax1 + "\nQueue 2: >> RM" + tax2 + 
            "\nQueue 3: >>  RM" + tax3 + "\n\nGrand Total Carbon Tax: >>RM" + (tax1 + tax2 + tax3) + "<<");

    }

    void Distributing_Routing_UI(Queue <Courier_Info> Source_Queue, Queue<Courier_Info> Backup_Queue, String Queue_Headline, String Queue_Name){

        String oldID =  " ";
        int taxSum_Queue = 0;
        int count = 0;
        String line = "";
        int page = 1;
        boolean Headline = true;
        int num = 1;

        while(!Source_Queue.isEmpty()){
            Backup_Queue.offer(Source_Queue.peek());
            Courier_Info courier = Source_Queue.poll();

            
            if(Headline){
                line+= ( Queue_Headline + "\n" + "\n" + "==========PAGE: " + page++ +"==========" +"\n" );
                Headline = false;
            }
            for(int i = 0; i <  courier.items.size(); i++){
                if(!courier.carrierId.equals(oldID)){
                    line += ("(" + num++ + ") " + "Carrier name: " + courier.carrierName + "\nFleet Classification Type: " + courier.fleetType +  "\n\n" + "====" + courier.carrierName + " Shipment Items==== " + "\n\n-"  + courier.items.get(i).shipmentId +  "|" + courier.items.get(i).packageType + "\n");
                    taxSum_Queue += courier.items.get(i).carbonTaxCost;
                    oldID = courier.carrierId;

                }
                else{
                    line+= ("-" + courier.items.get(i).shipmentId +  "|" + courier.items.get(i).packageType + "\n" );
                    taxSum_Queue += courier.items.get(i).carbonTaxCost;

                }
                if(courier.items.size()-1 == i){
                    line +=("\n-----------------------------------------------------------" + "\n");

                        
                    count++;
                }
                if(count == 3 ){
                    JOptionPane.showMessageDialog(null, line);
                    line = "";
                    count = 0;
                    Headline = true;
                    break;
                }
                if(Source_Queue.isEmpty()){

                    JOptionPane.showMessageDialog(null, line);
                    line = "";
                    break;
                }

            }

        }
        totalTax_Queue.add(taxSum_Queue);
        line+= ("\n" + "==========================" + "\n\nTotal Carbon Tax for: \n" + Queue_Name + "\n >>RM" + taxSum_Queue + "\n\n ==========================");
        JOptionPane.showMessageDialog(null, line);

        while(!Backup_Queue.isEmpty()){

            Source_Queue.offer(Backup_Queue.poll());

        }

    }

    void Manifest_Settlement_UI(Stack<Courier_Info> Source_Stack){

        String oldID =  " ";
        int taxSum_Stack = 0;
        int count = 0;
        String line = "";
        int page = 1;
        boolean Headline = true;
        int num = 1;

        while(!Source_Stack.isEmpty()){
            Courier_Info courier = Source_Stack.pop();

            if(Headline){
                line+= ( "=======STACK CONTENT======= " + "\n" + "\n" + "==========PAGE: " + page++ +"==========" +"\n-----------------------------------------------------------" + "\n" );
                Headline = false;
            }
            for(int i = 0; i <  courier.items.size(); i++){
                if(!courier.carrierId.equals(oldID)){
                    taxSum_Stack = courier.items.get(i).carbonTaxCost;
                    line += ("(" + num++ + ") " +"Carrier name: " + courier.carrierName + "\nFleet Classification Type: " + courier.fleetType + "\nTotal Shipment Handle: " + courier.items.size() + "\n\n" + "====" + courier.carrierName + " Shipment Items==== " + "\n\n-"  + courier.items.get(i).shipmentId +  "|" + courier.items.get(i).packageType + "\n");

                    oldID = courier.carrierId;
                }
                else{
                    taxSum_Stack = courier.items.get(i).carbonTaxCost;
                    line+= ("-" + courier.items.get(i).shipmentId +  "|" + courier.items.get(i).packageType + "\n" );

                }
                if(courier.items.size()-1 == i){
                    line += ("\nTax carbon: RM" + taxSum_Stack);
                    line +=("\n-----------------------------------------------------------" + "\n");
                    count++;
                }
                if(count == 3 ){

                    JOptionPane.showMessageDialog(null, line);
                    line = "";
                    count = 0;
                    Headline = true;
                    break;
                }
                if(Source_Stack.isEmpty()){

                    JOptionPane.showMessageDialog(null, line);
                    line = "";
                    break;
                }

            }
        }


    }
}
