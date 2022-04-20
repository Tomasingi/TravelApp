package hi.verkefni.traveldata;

import java.util.ArrayList;
import java.util.List;

public class Airplane implements Comparable<Airplane> {
    private int id;
    private final List<Seat> seats;
    private final List<Integer> aisleArrangement;

    public Airplane(int id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
        this.aisleArrangement = new ArrayList<>();
    }

    public int compareTo(Airplane other) {
        return Integer.compare(id, other.getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Integer> getAisleArrangement() {
        return aisleArrangement;
    }
}
