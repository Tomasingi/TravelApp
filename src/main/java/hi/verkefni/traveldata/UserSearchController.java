package hi.verkefni.traveldata;

import java.util.List;

import static hi.verkefni.traveldata.DataFactory.selectAllUsers;

public class UserSearchController {

    public static User searchById(int id){
        List<User> Users = selectAllUsers();

        Users.removeIf(i -> i.getId() != id);
        return Users.get(0);
    }

    public static int nextId() {
        // TODO: Skila næsta mögulega id
        return -1;
    }

}
