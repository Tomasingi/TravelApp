package hi.verkefni.traveldata;

import java.time.LocalDate;
import java.util.List;

public class TourSearchController {

    public static DayTour searchById(int id){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getId().equals(id));
        return (DayTour) Tours.get(0);
    }

    public static List<Reservation> searchByDate(LocalDate searchDate){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !((DayTour) i).getDate().equals(searchDate));
        return Tours;
    }

    public static List<Reservation> searchBetweenDates(LocalDate after, LocalDate before){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> ((DayTour) i).getDate().isAfter(before) || ((DayTour) i).getDate().isBefore(after));
        return Tours;
    }

    public List<Reservation> searchByType(String typeQuest){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !((DayTour) i).getType().equals(typeQuest));
        return Tours;
    }

    public static List<Reservation> searchByName(String nameQuest){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !i.getName().equals(nameQuest));
        return Tours;
    }

    public static List<Reservation> searchUnderPrice(int maxPrice){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> i.getPrice() > maxPrice);
        return Tours;
    }

    public static List<Reservation> checkHotelPickUp(int x){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> ((DayTour) i).getHotelPickUp() != x);
        return Tours;
    }

    public List<Reservation> searchByTourDifficulty(int difficultyQuest){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> ((DayTour) i).getDifficulty() != difficultyQuest);
        return Tours;
    }

    public static List<Reservation> searchByLanguage(String languageQuest){
        List<Reservation> Tours = DataFactory.selectAllDayTour();

        Tours.removeIf(i -> !((DayTour) i).getLanguage().equals(languageQuest));
        return Tours;
    }
}
