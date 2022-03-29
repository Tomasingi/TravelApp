package hi.verkefni.travelapp;

import java.time.LocalDate;

public class DayTour extends Reservation {

    public DayTour(int id, String name, LocalDate date, String a, String b, int c, int d, int e, boolean f, int g, String language) {
        this.id = id;
        this.name = name;
        this.beginningDate = date;
        this.endDate = date;
        this.beginningLocation = new TravelLocation("Akureyri", TravelLocation.NORDURLAND_EYSTRA);
        this.endLocation = new TravelLocation("Egilsstaðir", TravelLocation.AUSTURLAND);
    }
}
