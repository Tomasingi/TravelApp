package hi.verkefni.traveldata;

public class Seat {
    private int id;
    private int price;
    private int occupied;

    public Seat(int id, int price, int occupied) {
        this.id = id;
        this.price = price;
        this.occupied = occupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int isOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
}
