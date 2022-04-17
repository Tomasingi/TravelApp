package hi.verkefni.traveldata;

import java.time.LocalDate;
import java.util.ArrayList;

public class TourSearchController {



    public static DayTour SearchById(int id){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getId().equals(id));
        return Tours.get(0);
    }



    public static ArrayList<DayTour> SearchByDate(LocalDate searchDate){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getDate().equals(searchDate));

        return Tours;
    }

    public static ArrayList<DayTour> SearchBetweenDates(LocalDate after, LocalDate before){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> i.getDate().isAfter(before) || i.getDate().isBefore(after));
        return Tours;
    }

    public ArrayList<DayTour> SearchByType(String typeQuest){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getType().equals(typeQuest));

        return Tours;
    }

    public static ArrayList<DayTour> SearchByName(String nameQuest){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getName().equals(nameQuest));
        return Tours;
    }

    public static ArrayList<DayTour> SearchUnderPrice(int maxPrice){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> i.getPrice() > maxPrice);

        return Tours;
    }

    public static ArrayList<DayTour> CheckHotelPickUp(int x){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> i.getHotelPickUp() != x);

        return Tours;
    }

    public ArrayList<DayTour> SearchByTourDifficulty(int difficultyQuest){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> i.getDifficulty() != difficultyQuest);

        return Tours;
    }

    public static ArrayList<DayTour> SearchByLanguage(String languageQuest){
        ArrayList<DayTour> Tours = new ArrayList<>();
        Tours = (ArrayList<DayTour>) DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getLanguage().equals(languageQuest));

        return Tours;
    }
}
