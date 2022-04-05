package hi.verkefni.travelapp;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelView extends VBox {
    @FXML
    private VBox fxSearchResults;
    @FXML
    private ImageView searchIcon;
    @FXML
    private CheckBox flightsCheck;
    @FXML
    private CheckBox hotelsCheck;
    @FXML
    private CheckBox daytoursCheck;
    @FXML
    private DatePicker fxBeginningDate;
    @FXML
    private DatePicker fxEndDate;
    @FXML
    private TextField searchBar;
    @FXML
    private ChoiceBox sortBy;
    @FXML
    private AnchorPane fxMainView;
    @FXML
    private AnchorPane fxSelected;

    private List<Reservation> reservations;
    private final List<Reservation> slice = new ArrayList<>();
    private final List<Reservation> selected = new ArrayList<>();
    private final Comparator<Reservation> compareByDate = Comparator.comparing(Reservation::getBeginningDate);
    private final Comparator<Reservation> compareByPrice = Comparator.comparing(Reservation::getPrice);
    private final Comparator<Reservation> compareByName = Comparator.comparing(Reservation::getName);

    public TravelView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("travel-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        reservations = new ArrayList<>();
        TravelLocation akureyri = new TravelLocation("Akureyri", TravelLocation.NORDURLAND_EYSTRA);
        TravelLocation egilsstadir = new TravelLocation("Egilsstaðir", TravelLocation.AUSTURLAND);
        DayTour dayTour1 = new DayTour(1,"Diamondring", LocalDate.of(2022,6,10), "Busride","Busride around the Diamondring",18,15,15000,true, 1,"English", akureyri, akureyri);
        DayTour dayTour2 = new DayTour(2,"Whale watching", LocalDate.of(2022,6,11), "Boatride","Boatride to look at whales",17,4,35000,true, 2,"English", akureyri, egilsstadir);
        DayTour dayTour3 = new DayTour(3,"Duck watching", LocalDate.of(2022,6,12), "Busride and Walking","Busride to lake myvatn to look at ducks",14,17,8000,false, 4,"English", egilsstadir, akureyri);
        DayTour dayTour4 = new DayTour(4,"Siglufjord sightseeing", LocalDate.of(2022,6,13), "Busride","Busride to the town of Siglufjord",20,2,45000,true, 1,"English", akureyri, akureyri);
        DayTour dayTour5 = new DayTour(5,"Walk around Akureyri", LocalDate.of(2022,6,14), "Walking tour","Walk with a guide around Akureyri",15,7,2500,false, 3,"English", egilsstadir, egilsstadir);
        DayTour dayTour6 = new DayTour(6,"Walk around Akureyri", LocalDate.of(2022,6,14), "Walking tour","Walk with a guide around Akureyri",15,7,2500,false, 3,"English", egilsstadir, egilsstadir);
        reservations.add(dayTour1);
        reservations.add(dayTour2);
        reservations.add(dayTour3);
        reservations.add(dayTour4);
        reservations.add(dayTour5);
        reservations.add(dayTour6);
    }

    public void initialize() {
        searchIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/search.png")));
    }

    public void searchHandler() {
        slice.clear();

        boolean flights = flightsCheck.isSelected();
        boolean hotels = hotelsCheck.isSelected();
        boolean daytours = daytoursCheck.isSelected();
        String[] searchWords = searchBar.getText().split(" ");

        for (Reservation r : reservations) {
            boolean rightType = flights && (r instanceof Flight)
                    || hotels && (r instanceof Hotel)
                    || daytours && (r instanceof DayTour)
                    || (!flights && !hotels && !daytours);
            LocalDate lb = fxBeginningDate.getValue();
            LocalDate ub = fxEndDate.getValue();
            LocalDate beginning = r.getBeginningDate();
            LocalDate end = r.getEndDate();
            boolean notEarly = (lb == null) || (beginning.isAfter(lb));
            boolean notLate = (ub == null) || (end.isBefore(ub));
            boolean rightDate = notEarly && notLate;
            if (rightType && rightDate) {
                slice.add(r);
            }
        }

        switch (sortBy.valueProperty().getValue().toString()) {
            case "Date":
                slice.sort(compareByDate);
                break;
            case "Price":
                slice.sort(compareByPrice);
                break;
            default:
                slice.sort(compareByName);
                break;
        }

        renderSearch();
    }

    public void resize() {
        double offset = 0.0;
        for (Node i : fxMainView.getChildren()) {
            ReservationView view = (ReservationView) i;
            view.setPrefWidth(fxMainView.getWidth());
            view.setLayoutY(offset);
            offset += view.getHeight() * 1.1;
        }

        offset = 0.0;
        for (Node i : fxSelected.getChildren()) {
            BookedView view = (BookedView) i;
            view.setPrefWidth(fxSelected.getWidth());
            view.setLayoutY(offset);
            offset += view.getHeight() * 1.1;
        }
    }

    private void selectHandler(ReservationView reservationView, MouseEvent e) {
        reservationView.selectedProperty().setValue(true);
        for (Node i : fxMainView.getChildren()) {
            ReservationView view = (ReservationView) i;
            if (view != reservationView) {
                view.selectedProperty().setValue(false);
            }
            view.updateSelected();
        }
        int numClicks = e.getClickCount();
        if (numClicks == 2) {
            if (!selected.contains(reservationView.getReservation())) {
                selected.add(reservationView.getReservation());
                renderSelected();
            }
        }
    }

    private void renderSelected() {
        selected.sort(compareByDate);
        fxSelected.getChildren().clear();
        int counter = 0;
        for (Reservation r : selected) {
            BookedView view = new BookedView(r);
            view.setIndex(counter);
            fxSelected.getChildren().add(view);
            counter++;
        }
    }

    private void renderSearch() {
        fxMainView.getChildren().clear();
        int counter = 0;
        for (Reservation r : slice) {
            ReservationView reservationView = new ReservationView(r);
            reservationView.setOnMouseClicked(e -> selectHandler(reservationView, e));
            reservationView.setIndex(counter);
            fxMainView.getChildren().add(reservationView);
            counter++;
        }
    }
}
