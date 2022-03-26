package hi.verkefni.travelapp;

import java.util.ArrayList;
import java.util.List;

public abstract class TravelItem {
    private String name;
    private int price;
    private final List<Review> reviews = new ArrayList<>();
}
