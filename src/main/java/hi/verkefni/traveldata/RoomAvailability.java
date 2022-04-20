package hi.verkefni.traveldata;

import java.time.LocalDate;

public class RoomAvailability extends Reservation {
    private Room room;
    private LocalDate date;
    private int occupied;

    public RoomAvailability(int id, LocalDate date, int occupied) {
        this.id = id;
        this.date = date;
        this.occupied = occupied;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
}