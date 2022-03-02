module hi.verkefni.travelapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.verkefni.travelapp to javafx.fxml;
    exports hi.verkefni.travelapp;
}