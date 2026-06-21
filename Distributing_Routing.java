import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Distributing_Routing{
  
    int q1, q2, q3;
    
    LinkedList<Courier_Info> CI = new LinkedList<>();
    
  // to preserve the original content of all Queue after poll() method
    Queue<Courier_Info> backup_Queue = new ArrayDeque<>();

  
  //3 queues for Queue 1, Queue2 , Queue3
    Queue<Courier_Info> Queue1_Regional_Micro_Distribution = new ArrayDeque<>();

    Queue<Courier_Info> Queue2_Cross_Border_Express = new ArrayDeque<>();   

    Queue<Courier_Info> Queue3_Industrial_Bulk_Logistics_Fleet = new ArrayDeque<>();
    
    
//store content from CI according to number of shipment and the condition of next variable
    void Ditribute_Queue(){
        
        
        boolean next = false;
        
        for(int i = 0; i < CI.size(); i++){
            //if shipment is below or equal to 2 and NOT next
            if(CI.get(i).items.size() <= 2 && !next){
                Queue1_Regional_Micro_Distribution.offer(CI.get(i));
                
                 
                next = true;

            }
           //if shipment is below or equal to 2 and next   
            else if(CI.get(i).items.size() <= 2 && next){
                Queue2_Cross_Border_Express.offer(CI.get(i));
                next = false;
            }
              //if shipment is above 2
            else{
                Queue3_Industrial_Bulk_Logistics_Fleet.offer(CI.get(i));
            }

        }

      //store inside local variable for summary method
        q1 = Queue1_Regional_Micro_Distribution.size();
        q2 = Queue2_Cross_Border_Express.size();
        q3 = Queue3_Industrial_Bulk_Logistics_Fleet.size();

    }
 
   

}
