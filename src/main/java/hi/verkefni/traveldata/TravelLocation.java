package hi.verkefni.traveldata;

public class TravelLocation {
    public static final Integer HOFUDBORGARSVAEDID = 1;
    public static final Integer SUDURNES = 2;
    public static final Integer VESTURLAND = 8;
    public static final Integer VESTFIRDIR = 7;
    public static final Integer NORDURLAND_VESTRA = 6;
    public static final Integer NORDURLAND_EYSTRA = 5;
    public static final Integer AUSTURLAND = 4;
    public static final Integer SUDURLAND = 3;

    private String name;
    private Integer location;

    public TravelLocation(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
