package hi.verkefni.traveldata;

import java.time.LocalDate;

public class Hotel extends Reservation {
    private TravelLocation location;
    private int roomCap;
    private int breakfast;
    private int reviewId;

    public Hotel(int id, String name, TravelLocation location, int roomCap, int breakfast, int reviewId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.roomCap = roomCap;
        this.breakfast = breakfast;
        this.reviewId = reviewId;
        this.beginningLocation = location;
        this.endLocation = location;
        this.date = LocalDate.of(2022, 06, 06);
        this.price = 1000000;
    }

    public TravelLocation getLocation() {
        return location;
    }

    public void setLocation(TravelLocation location) {
        this.location = location;
    }

    public int getRoomCap() {
        return roomCap;
    }

    public void setRoomCap(int roomCap) {
        this.roomCap = roomCap;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
}
