package hi.verkefni.travelapp;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class TravelController {
    @FXML
    private Pane viewPort;

    private final UserController userController = new UserController();
    private final LoginView loginView = new LoginView();
    private final SignupView signupView = new SignupView();
    private final TravelView travelView = new TravelView();

    public void initialize() {
        signupView.addLink(this);
        loginView.addLink(this);
        signup();
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
    }

    public void create(User user) {
        userController.create(user);
    }
}