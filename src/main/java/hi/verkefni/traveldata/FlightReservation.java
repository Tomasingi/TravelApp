package hi.verkefni.traveldata;

public class FlightReservation {
    private int Id;
    private User user;
    private int passengers;
    private Flight flight;
    private Seat seat;
    private int bothways;


    public FlightReservation(int id, User user, int passengers, Flight flight, Seat seat, int bothways) {
        Id = id;
        this.user = user;
        this.passengers = passengers;
        this.flight = flight;
        this.seat = seat;
        this.bothways = bothways;
    }

    public int getId() {
        return Id;
    }

    public int getBothways() {return bothways;}

    public void setBothways(int bothways) {
        this.bothways = bothways;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
