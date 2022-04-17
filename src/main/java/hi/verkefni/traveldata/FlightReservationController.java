package hi.verkefni.traveldata;

import java.util.ArrayList;

public class FlightReservationController {
    private ArrayList<FlightReservation> flightReservations = (ArrayList<FlightReservation>) DataFactory.selectAllFlightReservations();

    public int findNextIdFlightReservation() {
        ArrayList<FlightReservation> fr = new ArrayList<>();
        fr = (ArrayList<FlightReservation>) DataFactory.selectAllFlightReservations();
        int id = fr.get(0).getId();
        for (int n = 0; n < fr.size(); n++) {
            if (fr.get(n).getId() > id) {
                id = fr.get(n).getId();
            }
        }
        return id+1;
    }

    public void addFlightReservation(User user, Flight flight, Seat seat) {
        int id = findNextIdFlightReservation();
        FlightReservation fr = new FlightReservation(id, user, 1, flight, seat, 0);
        seatBooked(fr);
        DataFactory.insertFlightReservation(fr);
    }

    public void deleteFlightReservation(int id){
        String sql = "DELETE FROM FlightReservation WHERE id = " + id + ";";
        DataFactory.runSQL(sql);
    }

    public void seatBooked(FlightReservation fr) {
        int id = fr.getSeat().getId();
        String sql = "UPDATE Seat SET occupied = " + 1 + " WHERE id = " + id + ";";
        DataFactory.runSQL(sql);
    }
}

