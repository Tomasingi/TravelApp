package hi.verkefni.traveldata;

import java.util.ArrayList;

public class DTReservationController {

    public int findNextIdDTReservation() {
        ArrayList<DTReservation> Tours = new ArrayList<>();
        Tours = (ArrayList<DTReservation>) DataFactory.selectAllDayTourReservations();
        int id = Tours.get(0).getReservationId();
        for (int n = 0; n < Tours.size(); n++) {
            if (Tours.get(n).getReservationId() > id) {
                id = Tours.get(n).getReservationId();
            }
        }
        return id+1;
    }

    public boolean addDTReservation(User user, DayTour dayTour, int amountOfP){
        if(dayTour.getAvailability() < amountOfP){return false;}

        int newAvailability = dayTour.getAvailability() - amountOfP;

        String sql = "UPDATE DayTour SET availability=" + newAvailability + " WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);

        DTReservation res = new DTReservation(user, dayTour, amountOfP, findNextIdDTReservation());
        DataFactory.insertDTReservation(res);
        return true;
    }

    public void removeDTReservation(DTReservation res){
        String sql = "DELETE FROM DayTourReservation WHERE id=" + res.getReservationId() + ";";
        DataFactory.runSQL(sql);
    }
    
    public static ArrayList<DTReservation> findDTReservationByUser(int userId) {
        ArrayList<DTReservation> Tours = new ArrayList<>();
        Tours = (ArrayList<DTReservation>) DataFactory.selectAllDayTourReservations();

        Tours.removeIf(i -> i.getUser().getId() != userId);
        return Tours;
    }
}
