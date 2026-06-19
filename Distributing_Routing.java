import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Distributing_Routing{
  
    int q1, q2, q3;
    
    LinkedList<Courier_Info> CI = new LinkedList<>();
    
    
    Queue<Courier_Info> backup_Queue = new ArrayDeque<>();
    

    Queue<Courier_Info> Queue1_Regional_Micro_Distribution = new ArrayDeque<>();

    Queue<Courier_Info> Queue2_Cross_Border_Express = new ArrayDeque<>();   

    Queue<Courier_Info> Queue3_Industrial_Bulk_Logistics_Fleet = new ArrayDeque<>();
    
    

    void Ditribute_Queue(){
        
        
        boolean next = false;
        
        for(int i = 0; i < CI.size(); i++){

            if(CI.get(i).items.size() <= 2 && !next){
                Queue1_Regional_Micro_Distribution.offer(CI.get(i));
                
                 
                next = true;

            }
            else if(CI.get(i).items.size() <= 2 && next){
                Queue2_Cross_Border_Express.offer(CI.get(i));
                next = false;
            }
            else{
                Queue3_Industrial_Bulk_Logistics_Fleet.offer(CI.get(i));
            }

        }
        
        q1 = Queue1_Regional_Micro_Distribution.size();
        q2 = Queue2_Cross_Border_Express.size();
        q3 = Queue3_Industrial_Bulk_Logistics_Fleet.size();

    }
 
   

}