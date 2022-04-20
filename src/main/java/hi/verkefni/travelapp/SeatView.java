package hi.verkefni.travelapp;

import hi.verkefni.traveldata.Seat;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class SeatView extends Rectangle {
    private static final Color UNAVAILABLE = Color.valueOf("#DDD");
    private static final Color AVAILABLE = Color.valueOf("#4A5");
    private static final Color SELECTED = Color.valueOf("#FB0");
    private static final Color RESERVED = Color.valueOf("#07B");
    private final Seat seat;
    private boolean selected = false;

    private FlightBodyView flightBodyView;

    public SeatView(Seat seat, FlightBodyView flightBodyView) {
        this.seat = seat;
        seat.setSeatView(this);
        this.flightBodyView = flightBodyView;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seat-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        if (seat.isOccupied() == 1) {
            this.fillProperty().setValue(UNAVAILABLE);
        } else {
            this.fillProperty().setValue(AVAILABLE);
            this.setOnMouseClicked(e -> selectHandler(e));
        }
    }

    public void deselect() {
        if (!selected) {
            this.fillProperty().setValue(AVAILABLE);
        } else {
            this.fillProperty().setValue(RESERVED);
        }
    }

    private void addReservation() {
        this.fillProperty().setValue(RESERVED);
        flightBodyView.addReservation(this);
    }

    public void removeReservation() {
        this.fillProperty().setValue(AVAILABLE);
        flightBodyView.removeReservation(this);
    }

    public void setAvailable() {
        selected = false;
        deselect();
    }

    public Seat getSeat() {
        return seat;
    }

    private void selectHandler(MouseEvent e) {
        flightBodyView.select(this);
        this.fillProperty().set(SELECTED);
        if (e.getClickCount() > 1) {
            selected = !selected;
            if (selected) {
                addReservation();
            } else {
                removeReservation();
            }
        }
    }
}
