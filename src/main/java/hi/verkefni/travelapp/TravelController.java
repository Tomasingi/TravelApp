package hi.verkefni.travelapp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    public void initialize() {
        signupView.addLink(this);
        loginView.addLink(this);
        setTimeline();
        timeline.play();
        signup();
    }

    private void setTimeline() {
        KeyFrame k = new KeyFrame(Duration.millis(20),
                e -> resize());
        timeline = new Timeline(k);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void signup() {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(signupView);
        resize();
    }

    public void login() {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(loginView);
        resize();
    }

    public void travel() {
        viewPort.getChildren().clear();
        viewPort.getChildren().add(travelView);
        travelView.searchHandler();
        resize();
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