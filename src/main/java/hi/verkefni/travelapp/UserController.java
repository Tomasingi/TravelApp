package hi.verkefni.travelapp;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final List<User> users = new ArrayList<>();

    public void create(User user) {
        users.add(user);
    }

    public void delete(User user) {
        users.remove(user);
    }

    public void changePassword(User user, String password) {
        int index = users.indexOf(user);
        users.get(index).changePassword(password);
    }

    public List<User> getUsers() {
        return users;
    }
}
