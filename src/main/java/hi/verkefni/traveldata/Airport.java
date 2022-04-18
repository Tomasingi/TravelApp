package hi.verkefni.traveldata;

public class Airport {
    private int id;
    private String shortName;
    private String name;
    //private String location;

    public Airport(int id, String shortName, String name/* String location*/) {
        this.id = id;
        this.shortName = shortName;
        this.name = name;
        //this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    /*public String getLocation() {
        return location;
    }*/

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setLocation(String location) {
        this.location = location;
    }*/

    public String getShortName() {
        return shortName;
    }
}
