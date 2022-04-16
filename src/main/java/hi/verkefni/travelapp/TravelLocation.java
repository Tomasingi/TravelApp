package hi.verkefni.travelapp;

public class TravelLocation {
    public static final int HOFUDBORGARSVAEDID = 1;
    public static final int SUDURNES = 2;
    public static final int VESTURLAND = 3;
    public static final int VESTFIRDIR = 4;
    public static final int NORDURLAND_VESTRA = 5;
    public static final int NORDURLAND_EYSTRA = 6;
    public static final int AUSTURLAND = 7;
    public static final int SUDURLAND = 8;

    private String name;
    private Integer location;

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
        switch (location) {
            case 1:
                return "Höfuðborgarsvæðið";
            case 2:
                return "Suðurnes";
            case 3:
                return "Vesturland";
            case 4:
                return "Vestfirðir";
            case 5:
                return "Norðurland vestra";
            case 6:
                return "Norðurland eystra";
            case 7:
                return "Austurland";
            case 8:
                return "Suðurland";
            default:
                return "";
        }
    }
}
