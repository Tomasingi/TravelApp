package hi.verkefni.travelapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Reservation {
    private String name;
    private int price;
    private final List<Review> reviews = new ArrayList<>();
    private TravelLocation beginningLocation;
    private TravelLocation endLocation;
    private LocalDate beginningDate;
    private LocalDate endDate;


}
