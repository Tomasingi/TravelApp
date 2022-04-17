package hi.verkefni.traveldata;

import java.util.ArrayList;

import static hi.verkefni.traveldata.DataFactory.selectAllUsers;

public class UserSearchController {

    public static User SearchById(int id){
        ArrayList<User> Users = new ArrayList<>();
        Users = (ArrayList<User>) selectAllUsers();

        Users.removeIf(i -> i.getID() != id);
        return Users.get(0);

    }

}
