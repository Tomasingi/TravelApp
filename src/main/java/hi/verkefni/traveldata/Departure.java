package hi.verkefni.traveldata;

import java.time.LocalDate;

public class Departure {
    private int Id;
    private Airport airport;
    private TravelLocation location;
    private LocalDate date;

    public Departure(int id, Airport airport, TravelLocation location, LocalDate date) {
        Id = id;
        this.airport = airport;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public TravelLocation getLocation() {
        return location;
    }

    public void setLocation(TravelLocation location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}