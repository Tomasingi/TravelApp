package hi.verkefni.travelapp;

import hi.verkefni.traveldata.User;

public class UserController {
    private final UserDatabase userDatabase = new UserDatabase();

    public void create(User user) {
        userDatabase.insert(user);
    }

    public void delete(User user) {
        userDatabase.delete(user);
    }

    public User searchUser(String name) {
        return userDatabase.search(name);
    }

    public void changePassword(User user, String password) {
        user.setPassword(password);
    }

    public void changeEmail(User user, String password) {
        user.setEmail(password);
    }
}
