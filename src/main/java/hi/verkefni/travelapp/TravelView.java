package hi.verkefni.travelapp;

import hi.verkefni.traveldata.DataFactory;
import hi.verkefni.traveldata.DayTour;
import hi.verkefni.traveldata.Reservation;
import hi.verkefni.traveldata.TravelLocation;
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
import java.util.*;

public class TravelView extends VBox {
    @FXML
    private VBox fxSearchResults;
    @FXML
    private ImageView fxSearchIcon;
    @FXML
    private CheckBox fxFlightsCheck;
    @FXML
    private CheckBox fxHotelsCheck;
    @FXML
    private CheckBox fxDaytoursCheck;
    @FXML
    private DatePicker fxBeginningDate;
    @FXML
    private DatePicker fxEndDate;
    @FXML
    private TextField fxSearchBar;
    @FXML
    private ChoiceBox<String> fxSortBy;
    @FXML
    private AnchorPane fxMainView;
    @FXML
    private AnchorPane fxSelected;
    @FXML
    private Label fxSubtotal;
    @FXML
    private ImageView fxCart;

    private int subtotal = 0;
    private List<Reservation> reservations;
    private final List<Reservation> slice = new ArrayList<>();
    private final List<Reservation> selected = new ArrayList<>();
    private final Comparator<Reservation> compareByDate = Comparator.comparing(Reservation::getBeginningDate);
    private final Comparator<Reservation> compareByPrice = Comparator.comparing(Reservation::getPrice);
    private final Comparator<Reservation> compareByName = Comparator.comparing(Reservation::getName);
    private TravelController travelController;

    public TravelView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("travel-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        reservations = DataFactory.selectAllDayTour();
        TravelLocation akureyri = new TravelLocation("Akureyri", TravelLocation.NORDURLAND_EYSTRA);
        TravelLocation egilsstadir = new TravelLocation("Egilsstaðir", TravelLocation.AUSTURLAND);
        DayTour dayTour1 = new DayTour(101,"Walk around reykjavik", LocalDate.of(2022,6,6),new TravelLocation("Höfuðborgarsvæðið",TravelLocation.HOFUDBORGARSVAEDID),"Walk Tour","Walk with an experianced tour guide around Reykjavík.",14,5,5990,0, 2,"English",1);
        DayTour dayTour2 = new DayTour(102,"Trip to nauthólsvík", LocalDate.of(2022,7,6), new TravelLocation("Höfuðborgarsvæðið",TravelLocation.HOFUDBORGARSVAEDID),"Busride and beach","Take a bus to nauthólsvík beach and enjoy the sun",8,14,9990,1, 1,"English",2);
        DayTour dayTour3 = new DayTour(103,"Þjóðminjasafnið", LocalDate.of(2022,8,6), new TravelLocation("Höfuðborgarsvæðið",TravelLocation.HOFUDBORGARSVAEDID),"Museum","Take a look at Icelands best valued antices with a guide",18,3,16990,0, 1,"English",3);
        DayTour dayTour4 = new DayTour(104,"Blue Lagoon", LocalDate.of(2022,6,6),new TravelLocation("Suðurnes",TravelLocation.SUDURNES), "Swimming","Go to the world famous Blue Lagoon to get ripped of. You will be paying 1/5 of an iphone to go bathing in weird looking water.",16,25,39990,1, 1,"Danish",4);
        DayTour dayTour5 = new DayTour(105,"Volcano museum", LocalDate.of(2022,7,6), new TravelLocation("Suðurnes",TravelLocation.SUDURNES),"Museum","Go to the Volcano museum to look at a once in a lifetime show",15,7,15990,1, 1,"English",5);
        reservations.add(dayTour1);
        reservations.add(dayTour2);
        reservations.add(dayTour3);
        reservations.add(dayTour4);
        reservations.add(dayTour5);
    }

    public void initialize() {
        fxSearchIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/search.png")));
        fxCart.setImage(new Image(getClass().getResourceAsStream("images/icons/cart.png")));
    }

    public void searchHandler() {
        slice.clear();

        boolean flights = fxFlightsCheck.isSelected();
        boolean hotels = fxHotelsCheck.isSelected();
        boolean daytours = fxDaytoursCheck.isSelected();
        String[] searchWords = fxSearchBar.getText().toLowerCase().split(" ");

        for (Reservation r : reservations) {
            // Check text
            boolean rightText = true;

            Set<String> matchWords = new TreeSet<>();

            String[] nameArray = r.getName().toLowerCase().split(" ");
            matchWords.addAll(Arrays.asList(nameArray));
            String[] descriptionArray = r.getDescription().toLowerCase().split(" ");
            matchWords.addAll(Arrays.asList(descriptionArray));

            matchWords.add(r.getBeginningLocation().getName().toLowerCase());
            matchWords.add(r.getBeginningLocation().getLocationString().toLowerCase());
            matchWords.add(r.getEndLocation().getName().toLowerCase());
            matchWords.add(r.getEndLocation().getLocationString().toLowerCase());

            for (String s : searchWords) {
                if (s != "") {
                    if (!matchWords.contains(s)) {
                        rightText = false;
                        break;
                    }
                }
            }
            if (!rightText) {
                continue;
            }

            // Check type and date restrictions
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


        // Sort results
        switch (fxSortBy.valueProperty().getValue()) {
            case "Date" -> slice.sort(compareByDate);
            case "Price" -> slice.sort(compareByPrice);
            default -> slice.sort(compareByName);
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
            Reservation reservation = reservationView.getReservation();
            if (!selected.contains(reservation)) {
                selected.add(reservation);
                selected.sort(compareByDate);
                int index = selected.indexOf(reservation);
                BookedView bookedView = new BookedView(reservation);
                bookedView.link(this);
                fxSelected.getChildren().add(index, bookedView);

                subtotal += reservation.getPrice();
                updateSubtotalText();
            }
        }
    }

    public void remove(Reservation reservation) {
        fxSelected.getChildren().remove(selected.indexOf(reservation));
        selected.remove(reservation);
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

    public void updateAmount() {
        calculateSubtotal();
    }

    public void updateAmount(int amount) {
        subtotal += amount;
        updateSubtotalText();
    }

    private void calculateSubtotal() {
        int newSubtotal = 0;
        for (Node view : fxSelected.getChildren()) {
            BookedView bookedView = (BookedView) view;
            newSubtotal += bookedView.priceProperty().getValue();
        }
        subtotal = newSubtotal;
        updateSubtotalText();
    }

    private void updateSubtotalText() {
        fxSubtotal.setText("Subtotal: " + subtotal + " ISK");
    }

    public void addLink(TravelController travelController) {
        this.travelController = travelController;
    }

    public void cartHandler() {
        travelController.goToCart(selected);
    }
}
