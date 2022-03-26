package hi.verkefni.travelapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SignupView extends VBox {
    @FXML
    private TextField fxName;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxPassword;
    @FXML
    private TextField fxConfirmPassword;
    @FXML
    private Label fxNameError;
    @FXML
    private Label fxEmailError;
    @FXML
    private Label fxPasswordError;
    @FXML
    private Label fxConfirmPasswordError;

    private TravelController travelController;

    public SignupView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        fxNameError.visibleProperty().set(false);
        fxEmailError.visibleProperty().set(false);
        fxPasswordError.visibleProperty().set(false);
        fxConfirmPasswordError.visibleProperty().set(false);
    }

    public void createAccountHandler() {
        boolean failed = false;

        if (fxName.getText().equals("")) {
            fxNameError.visibleProperty().set(true);
            failed = true;
        } else {
            fxNameError.visibleProperty().set(false);
        }
        if (fxEmail.getText().equals("")) {
            fxEmailError.visibleProperty().set(true);
            failed = true;
        } else {
            fxEmailError.visibleProperty().set(false);
        }
        if (fxPassword.getText().equals("")) {
            fxPasswordError.visibleProperty().set(true);
            failed = true;
        } else {
            fxPasswordError.visibleProperty().set(false);
        }
        if (!fxPassword.getText().equals(fxConfirmPassword.getText())) {
            fxConfirmPasswordError.visibleProperty().set(true);
            failed = true;
        } else {
            fxConfirmPasswordError.visibleProperty().set(false);
        }

        if (!failed) {
            User newUser = new User(
                    fxName.getText(),
                    fxEmail.getText(),
                    fxPassword.getText()
            );
            travelController.create(newUser);
        }
    }

    public void loginHandler() {
        travelController.login();
    }

    public void addLink(TravelController travelController) {
        this.travelController = travelController;
    }
}
