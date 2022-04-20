package hi.verkefni.traveldata;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public static final String STANDARD = "Standard";
    public static final String DELUXE = "Deluxe";
    public static final String SUITE = "Suite";

    private int id;
    private int price;
    private String type;
    private int capacity;
    private int hotelId;
    private final List<RoomAvailability> availabilities;

    public Room(int id, String type, int price, int capacity, int hotelId, List<RoomAvailability> availabilities) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.hotelId = hotelId; // tengja þetta við Id í hótel klasa
        this.availabilities = availabilities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public List<RoomAvailability> getAvailabilities() {
        return availabilities;
    }
}
