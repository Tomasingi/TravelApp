package hi.verkefni.traveldata;

public class DTReservation {
    private User user;
    private DayTour dayTour;
    private int amountOfPeople;
    private int reservationId;


    public DTReservation(User user, DayTour dayTour, int amountOfPeople, int reservationId) {
        this.dayTour = dayTour;
        this.amountOfPeople = amountOfPeople;
        this.user = user;
        this.reservationId = reservationId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public DayTour getDayTour() {
        return dayTour;
    }

    public void setDayTour(DayTour dayTour) {
        this.dayTour = dayTour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
