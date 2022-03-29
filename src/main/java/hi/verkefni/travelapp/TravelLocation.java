package hi.verkefni.travelapp;

public class TravelLocation {
    public static final String HOFUDBORGARSVAEDID = "Höfuðborgarsvæðið";
    public static final String SUDURNES = "Suðurnes";
    public static final String VESTURLAND = "Vesturland";
    public static final String VESTFIRDIR = "Vestfirðir";
    public static final String NORDURLAND_VESTRA = "Norðurland vestra";
    public static final String NORDURLAND_EYSTRA = "Norðurland eystra";
    public static final String AUSTURLAND = "Austurland";
    public static final String SUDURLAND = "Suðurland";

    private String name;
    private String location;

    public TravelLocation(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
