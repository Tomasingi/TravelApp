package hi.verkefni.traveldata;

import hi.verkefni.travelapp.SeatView;

public class Seat extends Reservation implements Comparable<Seat> {
    private int occupied;

    private SeatView seatView;

    public Seat(int id, int price, int occupied) {
        this.id = id;
        this.price = price;
        this.occupied = occupied;
        this.name = "Flight";
    }

    public int compareTo(Seat other) {
        return Integer.compare(id, other.getId());
    }

    public void setId(int id) {
        this.id = id;
    }

    public int isOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public void setSeatView(SeatView seatView) {
        this.seatView = seatView;
    }

    public SeatView getSeatView() {
        return seatView;
    }
}
