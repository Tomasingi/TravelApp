package hi.verkefni.traveldata;

public class Reservations {
    int id;
    int userId;
    int reservationId;

    public Reservations(int id, int userId, int reservationId) {
        this.id = id;
        this.userId = userId;
        this.reservationId = reservationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
