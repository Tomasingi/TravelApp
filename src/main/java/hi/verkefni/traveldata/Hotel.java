package hi.verkefni.traveldata;

public class Hotel {
    private int ID;
    private String name;
    private TravelLocation location;
    private int roomCap;
    private int breakfast;
    private int reviewId;

    public Hotel(int ID, String name, TravelLocation location, int roomCap, int breakfast, int reviewId) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.roomCap = roomCap;
        this.breakfast = breakfast;
        this.reviewId = reviewId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
