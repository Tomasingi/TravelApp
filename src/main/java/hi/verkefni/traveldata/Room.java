package hi.verkefni.traveldata;

enum Size{
    Standard("Standard"),
    Deluxe("Deluxe"),
    Suite("Suite");

    private final String RoomType;

    Size(String RoomType){
        this.RoomType = RoomType;
    }

    public String getSize(){
        return RoomType;
    }
}

public class Room {

    private int Id;
    private Size type;
    private int price;
    private int capacity;
    private int hotelId;

    public Room(int Id, Size type, int price, int capacity,int hotelId) {
        this.Id = Id;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.hotelId = hotelId; // tengja þetta við Id í hótel klasa
    }

    public Size getSize() {
        return type;
    }

    public void setSize(Size type) {
        this.type = type;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
