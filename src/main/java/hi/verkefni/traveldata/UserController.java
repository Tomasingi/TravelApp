package hi.verkefni.traveldata;

public class UserController {
    public void create(User user) {
        DataFactory.insertUser(user);
    }
}