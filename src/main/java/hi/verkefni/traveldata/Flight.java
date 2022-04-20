package hi.verkefni.traveldata;

import java.time.LocalDate;

public class Flight extends Reservation {
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
        this.beginningLocation = departure.getLocation();
        this.endLocation = arrival.getLocation();
        this.name = departure.getAirport().getShortName() + " -> " + arrival.getAirport().getShortName();
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
