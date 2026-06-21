import java.util.LinkedList;
public class Courier_Info{
    //class Instance
    String carrierId;
    String carrierName;
    String fleetType;
   //To store shipment info inside each courier
    LinkedList<ShipmentInfo> items = new LinkedList<>();

    //Constructor
    Courier_Info(String ID, String Name, String Type, String Item_ID, String Item_Type, String Score, String Date, int Time, int Tax){
        carrierId = ID;
        carrierName =  Name;
        fleetType = Type;
        
       //each time Courier Info object is created, it will automatically add shipment info inside LinkedList in Courier_Info class
        items.add(new ShipmentInfo( Item_ID, Item_Type,  Score, Date,  Time,  Tax));

    }

}
