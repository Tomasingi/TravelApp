package hi.verkefni.travelapp;

import hi.verkefni.traveldata.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    public final List<User> database = new ArrayList<>();

    public void insert(User user) {
        database.add(user);
    }

    public User search(String name) {
        for (User user : database) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
        database.remove(user);
    }
}
