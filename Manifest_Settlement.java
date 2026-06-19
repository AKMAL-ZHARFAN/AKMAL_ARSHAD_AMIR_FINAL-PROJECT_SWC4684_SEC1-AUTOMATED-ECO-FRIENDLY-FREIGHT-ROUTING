import java.util.Stack;
import java.util.Queue;

public class Manifest_Settlement{
    
    Stack<Courier_Info> DispatchStack = new Stack<>();
    public void Dispatch(Queue<Courier_Info> q1, Queue<Courier_Info> q2, Queue<Courier_Info> q3){
        
        
        while(q1.size() > 0 || q2.size() > 0 || q3.size() > 0){
            
            for(int i = 0; i < 5; i++){
                if(q1.size() > 0){
                    DispatchStack.push(q1.poll());
                    
                }
                else{
                    break;
                }
            }

            for(int i = 0; i < 5; i++){
                if(q2.size() > 0){
                    DispatchStack.push(q2.poll());
                    
                }
                else{
                    break;
                }
            }

            for(int i = 0; i < 5; i++){
                if(q3.size() > 0){
                    DispatchStack.push(q3.poll());

                }
                else{
                    break;
                }

            }

        }
    }

    

}