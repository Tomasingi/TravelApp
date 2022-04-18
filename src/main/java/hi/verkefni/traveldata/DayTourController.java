package hi.verkefni.traveldata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayTourController {

    public void insertDayTour(String name, String type, String description, int rating, int availability, int price, int hotelPickUp, int difficulty, String language, TravelLocation location, LocalDate date) {
        DayTour dayTour = new DayTour(findNextIdDayTour(),name,date,location,type,description,rating,availability,price,hotelPickUp,difficulty,language,ReviewController.findNextReviewId());
        DataFactory.insertDayTour(dayTour);
    }

    /*public DayTour select(int id){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getId().equals(id));
        return Tours.get(0);
    }*/

    public int findNextIdDayTour() {
        List<Reservation> Tours = DataFactory.selectAllDayTour();
        int id = Tours.get(0).getId();
        for (Reservation tour : Tours) {
            if (tour.getId() > id) {
                id = tour.getId();
            }
        }
        return id+1;
    }

    public void RemoveDayTour(DayTour dayTour){
        String sql = "DELETE FROM DayTour WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editName(DayTour dayTour, String name){
        String sql = "UPDATE DayTour SET name='" + name + "' WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editDescription(DayTour dayTour, String des){
        String sql = "UPDATE DayTour SET description='" + des + "' WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editType(DayTour dayTour, String type){
        String sql = "UPDATE DayTour SET type='" + type + "' WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editAvailability(DayTour dayTour, int availability){
        String sql = "UPDATE DayTour SET availability=" + availability + " WHERE id=" + dayTour.getId() +";";
        DataFactory.runSQL(sql);
    }

    public void editPrice(DayTour dayTour, int price){
        String sql = "UPDATE DayTour SET price=" + price + " WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editHotelPickUp(DayTour dayTour, int hpu){
        String sql = "UPDATE DayTour SET hotelPickUp=" + hpu + " WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editDifficulty(DayTour dayTour, int Diff){
        String sql = "UPDATE DayTour SET difficulty=" + Diff + " WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editLanguage(DayTour dayTour, String language){
        String sql = "UPDATE DayTour SET language='" + language + "' WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void editDate(DayTour dayTour, LocalDate date){
        String sql = "UPDATE DayTour SET date='" + date.toString() + "' WHERE id=" + dayTour.getId() + ";";
        DataFactory.runSQL(sql);
    }

}
