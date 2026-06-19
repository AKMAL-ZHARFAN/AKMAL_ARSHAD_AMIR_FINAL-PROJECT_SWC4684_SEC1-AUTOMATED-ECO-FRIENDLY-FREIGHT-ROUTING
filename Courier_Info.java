import java.util.LinkedList;
public class Courier_Info{
    String carrierId;
    String carrierName;
    String fleetType;

    LinkedList<ShipmentInfo> items = new LinkedList<>();

    Courier_Info(String ID, String Name, String Type, String Item_ID, String Item_Type, String Score, String Date, int Time, int Tax){
        carrierId = ID;
        carrierName =  Name;
        fleetType = Type;

        items.add(new ShipmentInfo( Item_ID, Item_Type,  Score, Date,  Time,  Tax));

    }

}