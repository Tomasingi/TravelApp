package hi.verkefni.traveldata;

public class Airport {
    private int Id;
    private String shortName;
    private String name;
    //private String location;

    public Airport(int Id, String shortName, String name/* String location*/) {
        this.Id = Id;
        this.shortName = shortName;
        this.name = name;
        //this.location = location;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
