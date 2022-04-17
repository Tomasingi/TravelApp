package hi.verkefni.traveldata;


import java.time.LocalDate;

public class HotelReservation {

    private int id;
    private User user;
    private Room room;
    private Hotel hotel;
    private LocalDate date;

    public HotelReservation(int id, User user, Room room, Hotel hotel, LocalDate date) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.hotel = hotel;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(int userId) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
