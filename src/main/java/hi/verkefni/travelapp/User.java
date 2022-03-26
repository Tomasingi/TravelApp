package hi.verkefni.travelapp;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private final SortedSet<Reservation> reservations = new TreeSet<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
