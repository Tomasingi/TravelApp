package hi.verkefni.traveldata;

public class User {
    private int Id;
    private String name;
    private String email;


    public User(int Id, String name, String email) {
        this.Id = Id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}