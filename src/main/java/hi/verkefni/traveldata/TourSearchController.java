package hi.verkefni.traveldata;

import java.time.LocalDate;
import java.util.List;

public class TourSearchController {
    public static DayTour SearchById(int id){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> !i.getId().equals(id));
        return Tours.get(0);
    }

    public static List<DayTour> SearchByDate(LocalDate searchDate){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> !i.getDate().equals(searchDate));
        return Tours;
    }

    public static List<DayTour> SearchBetweenDates(LocalDate after, LocalDate before){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> i.getDate().isAfter(before) || i.getDate().isBefore(after));
        return Tours;
    }

    public List<DayTour> SearchByType(String typeQuest){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> !i.getType().equals(typeQuest));
        return Tours;
    }

    public static List<DayTour> SearchByName(String nameQuest){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> !i.getName().equals(nameQuest));
        return Tours;
    }

    public static List<DayTour> SearchUnderPrice(int maxPrice){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> i.getPrice() > maxPrice);
        return Tours;
    }

    public static List<DayTour> CheckHotelPickUp(int x){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> i.getHotelPickUp() != x);
        return Tours;
    }

    public List<DayTour> SearchByTourDifficulty(int difficultyQuest){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> i.getDifficulty() != difficultyQuest);
        return Tours;
    }

    public static List<DayTour> SearchByLanguage(String languageQuest){
        List<DayTour> Tours = DataFactory.selectAllDayTour();
        Tours.removeIf(i -> !i.getLanguage().equals(languageQuest));
        return Tours;
    }
}
