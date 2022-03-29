package hi.verkefni.travelapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Reservation {
    protected int id;
    protected String name;
    protected int price;
    protected final List<Review> reviews = new ArrayList<>();
    protected TravelLocation beginningLocation;
    protected TravelLocation endLocation;
    protected LocalDate beginningDate;
    protected LocalDate endDate;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public  List<Review> getReviews() {
        return reviews;
    }

    public TravelLocation getBeginningLocation() {
        return beginningLocation;
    }

    public TravelLocation getEndLocation() {
        return endLocation;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
