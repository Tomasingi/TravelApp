package hi.verkefni.travelapp;

import hi.verkefni.traveldata.Hotel;
import hi.verkefni.traveldata.Reservation;
import hi.verkefni.traveldata.Room;
import hi.verkefni.traveldata.RoomAvailability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HotelBodyView extends ReservationBodyView {
    @FXML
    private AnchorPane fxStandards;
    @FXML
    private AnchorPane fxDeluxes;
    @FXML
    private AnchorPane fxSuites;

    public HotelBodyView(Reservation reservation, TravelView travelView) {
        this.reservation = reservation;
        this.travelView = travelView;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hotelbody-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        for (Room room : ((Hotel) reservation).getRooms()) {
            for (RoomAvailability availability : room.getAvailabilities()) {
                HotelRoomView hotelRoomView = new HotelRoomView(availability);
                switch (room.getType()) {
                    case Room.STANDARD -> fxStandards.getChildren().add(hotelRoomView);
                    case Room.DELUXE -> fxDeluxes.getChildren().add(hotelRoomView);
                    case Room.SUITE -> fxSuites.getChildren().add(hotelRoomView);
                }
            }
        }
    }

    public void resize() {
        int counter;

        counter = 0;
        for (Node i : fxStandards.getChildren()) {
            HotelRoomView view = (HotelRoomView) i;
            view.setLayoutY(counter * view.getHeight() * 1.1);
            counter++;
        }
        counter = 0;
        for (Node i : fxDeluxes.getChildren()) {
            HotelRoomView view = (HotelRoomView) i;
            view.setLayoutY(counter * view.getHeight() * 1.1);
            counter++;
        }
        counter = 0;
        for (Node i : fxSuites.getChildren()) {
            HotelRoomView view = (HotelRoomView) i;
            view.setLayoutY(counter * view.getHeight() * 1.1);
            counter++;
        }
    }
}
