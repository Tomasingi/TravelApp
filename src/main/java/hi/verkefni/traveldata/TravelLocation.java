package hi.verkefni.traveldata;

public class TravelLocation {
    public static final int HOFUDBORGARSVAEDID = 1;
    public static final int SUDURNES = 2;
    public static final int VESTURLAND = 3;
    public static final int VESTFIRDIR = 4;
    public static final int NORDURLAND_VESTRA = 5;
    public static final int NORDURLAND_EYSTRA = 6;
    public static final int AUSTURLAND = 7;
    public static final int SUDURLAND = 8;

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
            case 3 -> "Vesturland";
            case 4 -> "Vestfirðir";
            case 5 -> "Norðurland vestra";
            case 6 -> "Norðurland eystra";
            case 7 -> "Austurland";
            case 8 -> "Suðurland";
            default -> "";
        };
    }
}
