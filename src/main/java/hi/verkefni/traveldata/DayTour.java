package hi.verkefni.traveldata;

import java.time.LocalDate;

public class DayTour extends Reservation {
    private LocalDate date;
    private TravelLocation location;
    private String type;
    private String description;
    private int rating;
    private int availability;
    private int price;
    private int hotelPickUp;//1 for yes/0 for no
    private int difficulty;
    private String language;
    private int review_id;


    public DayTour(Integer id, String name, LocalDate date, TravelLocation location, String type, String description, int rating, int availability, int price, int hotelPickUp, int difficulty, String language, int review_id) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.type = type;
        this.description = description;
        this.rating = rating;
        this.availability = availability;
        this.price = price;
        this.hotelPickUp = hotelPickUp;
        this.difficulty = difficulty;
        this.language = language;
        this.review_id = review_id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TravelLocation getLocation() {
        return location;
    }

    public void setLocation(TravelLocation location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHotelPickUp() {
        return hotelPickUp;
    }

    public void setHotelPickUp(int hotelPickUp) {
        this.hotelPickUp = hotelPickUp;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }
}
