package hi.verkefni.traveldata;

public class TravelLocation {
    public static final int HOFUDBORGARSVAEDID = 1;
    public static final int SUDURNES = 2;
    public static final int SUDURLAND = 3;
    public static final int AUSTURLAND = 4;
    public static final int NORDURLAND_EYSTRA = 5;
    public static final int NORDURLAND_VESTRA = 6;
    public static final int VESTFIRDIR = 7;
    public static final int VESTURLAND = 8;

    private final String name;
    private final Integer location;

    public TravelLocation(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }

    public String getLocationString() {
        return switch (location) {
            case 1 -> "Höfuðborgarsvæðið";
            case 2 -> "Suðurnes";
            case 3 -> "Suðurland";
            case 4 -> "Austurland";
            case 5 -> "Norðurland eystra";
            case 6 -> "Norðurland vestra";
            case 7 -> "Vestfirðir";
            case 8 -> "Vesturland";
            default -> "";
        };
    }
}
