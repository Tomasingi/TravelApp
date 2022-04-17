package hi.verkefni.traveldata;

import java.util.ArrayList;

public class LocationSearch {

    public static TravelLocation findLocationById(int id){
        ArrayList<TravelLocation> Loc = new ArrayList<>();
        Loc = (ArrayList<TravelLocation>) DataFactory.selectAllLocation();

        assert Loc != null;
        Loc.removeIf(i -> i.getLocation() != id);
        return Loc.get(0);
    }

}
