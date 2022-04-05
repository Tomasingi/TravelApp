package hi.verkefni.travelapp;

import java.time.LocalDate;

public class DayTour extends Reservation {
    private String type;
    private int rating;
    private int availability;
    private boolean pickup;
    private int difficulty;
    private String language;

    public DayTour(int id, String name, LocalDate date, String type, String description, int rating, int availability, int price, boolean pickup, int difficulty, String language, TravelLocation beginningLocation, TravelLocation endLocation) {
        this.id = id;
        this.name = name;
        this.beginningDate = date;
        this.endDate = date;
        this.type = type;
        this.description = description;
        this.rating = rating;
        this.availability = availability;
        this.price = price;
        this.pickup = pickup;
        this.difficulty = difficulty;
        this.language = language;
        this.beginningLocation = beginningLocation;
        this.endLocation = endLocation;
    }

    public String getType() {
        return type;
    }
}
