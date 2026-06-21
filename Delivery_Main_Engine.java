import java.io.*;
import java.util.*;
public class Delivery_Main_Engine{

    Distributing_Routing DR = new  Distributing_Routing();
    Manifest_Settlement MS = new Manifest_Settlement();
    UI_Engine UI = new UI_Engine();
    int totalParse; //to count total line in supply_chain_manifest.txt file
    String oldID; //to detect id duplication
    int counter; //to get index shipment element list inside carrier class
    void File_Reader(){
        try{
            FileReader fr = new FileReader("supply_chain_manifest.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            String courier = "";

            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, "|");
                
              //each token is stored in local variable using nextToken() method
                String ID = st.nextToken();
                courier = st.nextToken();
                String courier_type = st.nextToken();
                String item_ID = st.nextToken();
                String item_type = st.nextToken();
                String eco_score = st.nextToken();
                String dispatch_date = st.nextToken();
                int Estimate_Time = Integer.parseInt(st.nextToken());
                int Carbon_Tax = Integer.parseInt(st.nextToken());

                if(!ID .equals(oldID) ){ 
                    DR.CI.add(new Courier_Info(ID, courier, courier_type, item_ID, item_type, eco_score, dispatch_date, Estimate_Time, Carbon_Tax));
                    counter++;
                    totalParse++;

                    oldID = ID;

                }
                else{
                    //group shipment under the same courier instead of duplicating the same courier
                    totalParse++;
                    DR.CI.get(counter - 1).items.add(new ShipmentInfo(item_ID, item_type, eco_score, dispatch_date, Estimate_Time, Carbon_Tax));

                }

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    //the main program flow
    void System_ON(){
        
        UI.MainMenu();
        
        File_Reader();
        
        UI.Queue_UI("Regional Micro Distribution");

        DR. Ditribute_Queue();
        
        UI.Distributing_Routing_UI(DR.Queue1_Regional_Micro_Distribution, DR.backup_Queue, "=============QUEUE 1: Regional Micro Distribution=============", "Regional Micro Distribution");

        UI.Queue_UI("Cross Border Express");

        UI.Distributing_Routing_UI(DR.Queue2_Cross_Border_Express, DR.backup_Queue,"=============QUEUE 2: Cross Border Express=============", " Cross Border Express");
        
        UI.Queue_UI("Industrial Bulk Logistics Fleet");
        
        UI.Distributing_Routing_UI(DR.Queue3_Industrial_Bulk_Logistics_Fleet, DR.backup_Queue, "=============QUEUE 3: Industrial Bulk Logistics Fleet=============", " Industrial Bulk Logistics Fleet");
        
        UI.Stack_UI();
       
        MS.Dispatch(DR.Queue1_Regional_Micro_Distribution, DR.Queue2_Cross_Border_Express, DR.Queue3_Industrial_Bulk_Logistics_Fleet);
        
        UI.Manifest_Settlement_UI(MS.DispatchStack);
        
        UI.Summary();
        
        UI.System_Summary(DR.q1, DR.q2, DR.q3, totalParse, UI.totalTax_Queue.get(0), UI.totalTax_Queue.get(1),UI.totalTax_Queue.get(2)  );

        UI.System_Complete_UI();
        
        
    }

}
