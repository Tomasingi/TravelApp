package hi.verkefni.travelapp;

import hi.verkefni.traveldata.Reservation;
import hi.verkefni.traveldata.User;
import hi.verkefni.traveldata.UserController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class TravelController {
    @FXML
    private Pane viewPort;

    public static final int OFFSET = 36; //Header offset for Gnome on Ubuntu Linux
    private Stage stage;
    private Timeline timeline;
    private final UserController userController = new UserController();
    private final LoginView loginView = new LoginView();
    private final SignupView signupView = new SignupView();
    private final TravelView travelView = new TravelView();
    private final PaymentView paymentView = new PaymentView();

    public void initialize() {
        signupView.addLink(this);
        loginView.addLink(this);
        travelView.addLink(this);
        paymentView.addLink(this);
        setTimeline();
        timeline.play();
        signup();
    }

    private void setTimeline() {
        KeyFrame k = new KeyFrame(Duration.millis(20), e -> resize());
        timeline = new Timeline(k);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void signup() {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(signupView);
    }

    public void login() {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(loginView);
    }

    public void travel() {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(travelView);
        travelView.searchHandler();
    }

    public void goToCart(List<Reservation> selected) {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(paymentView);
    }

    public void resize() {
        if (stage != null) {
            VBox child = (VBox) viewPort.getChildren().get(0);
                child.setPrefWidth(stage.getWidth());
                child.setPrefHeight(stage.getHeight() - OFFSET);
            if (child == travelView) {
                travelView.resize();
            }
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void create(User user) {
        userController.create(user);
    }
}