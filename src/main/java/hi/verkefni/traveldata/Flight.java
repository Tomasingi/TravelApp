package hi.verkefni.traveldata;

import java.time.LocalDate;

public class Flight {
    private int id;
    private LocalDate date;
    private int price;
    private Arrival arrival;
    private Departure departure;
    private Airplane plane;


    public Flight(int id, LocalDate date, int price, Arrival arrival, Departure departure, Airplane plane) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.arrival = arrival;
        this.departure = departure;
        this.plane = plane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }


}
