package hi.verkefni.traveldata;

import hi.verkefni.travelapp.ReservationView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Reservation {
    protected Integer id;
    protected String name = "";
    protected Integer price;
    protected String description = "";
    protected int rating;
    protected final List<Review> reviews = new ArrayList<>();
    protected TravelLocation beginningLocation;
    protected TravelLocation endLocation;
    protected LocalDate date;

    protected ReservationView reservationView;

    public ReservationView getReservationView() {
        return reservationView;
    }

    public void setReservationView(ReservationView reservationView) {
        this.reservationView = reservationView;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public TravelLocation getBeginningLocation() {
        return beginningLocation;
    }

    public TravelLocation getEndLocation() {
        return endLocation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
