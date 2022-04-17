package hi.verkefni.traveldata;

import java.util.ArrayList;

public class HotelSearchController {

    public static Room findRoomById(int id){
        ArrayList<Room> Rooms = new ArrayList<>();
        Rooms = (ArrayList<Room>) DataFactory.selectAllRooms();

        Rooms.removeIf(i -> i.getHotelID() != id);
        return Rooms.get(0);
    }

    public static Hotel findHotelById(int id){
        ArrayList<Hotel> Hotels = new ArrayList<>();
        Hotels = (ArrayList<Hotel>) DataFactory.selectAllHotels();

        Hotels.removeIf(i -> i.getID() != id);
        return Hotels.get(0);
    }
}
