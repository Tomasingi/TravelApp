package hi.verkefni.traveldata;

import java.util.List;

public class HotelSearchController {

    public static Room findRoomById(int id){
        List<Room> Rooms = DataFactory.selectAllRooms();
        Rooms.removeIf(i -> i.getHotelID() != id);
        return Rooms.get(0);
    }

    public static Hotel findHotelById(int id){
        List<Hotel> Hotels = DataFactory.selectAllHotels();
        Hotels.removeIf(i -> i.getId() != id);
        return Hotels.get(0);
    }
}
