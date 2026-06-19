public class ShipmentInfo{
    String shipmentId;
    String packageType; 
    String ecoPriorityScore; 
    String dispatchDate; 
    int estimatedTransitTime; 
    int carbonTaxCost;

    ShipmentInfo(String ID, String Type, String Score, String Date, int Time, int Tax){

        shipmentId = ID;
        packageType = Type;
        ecoPriorityScore = Score;
        dispatchDate = Date;
        estimatedTransitTime = Time; 
        carbonTaxCost = Tax;

    }

}