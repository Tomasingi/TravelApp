package hi.verkefni.traveldata;

public class Airplane {
    private int id;
    private Seat seat;

    public Airplane(int id, Seat seat) {
        this.id = id;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
