package hi.verkefni.traveldata;

enum Size{
    Standard("Standard"),
    Deluxe("Deluxe"),
    Suite("Suite");

    private final String RoomType;

    private Size(String RoomType){
        this.RoomType = RoomType;
    }

    public String getSize(){
        return RoomType;
    }
}

public class Room {

    private int ID;
    private Size type;
    private int price;
    private int capacity;
    private int hotelID;

    public Room(int ID, Size type, int price, int capacity,int hotelID) {
        this.ID = ID;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.hotelID = hotelID; // tengja þetta við ID í hótel klasa
    }

    public Size getSize() {
        return type;
    }

    public void setSize(Size type) {
        this.type = type;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
