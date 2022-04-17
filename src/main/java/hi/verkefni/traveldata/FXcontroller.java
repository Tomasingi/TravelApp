package hi.verkefni.traveldata;/*package _DayTour_;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXcontroller implements Initializable {

    @FXML
    private Button searchButton;
    @FXML
    private ListView PickedDayTourListView;
    @FXML
    private ListView AvailableDayTourListView;
    @FXML
    private TextField NameTextField;
    @FXML
    private DatePicker DateDateField;
    @FXML
    private TextField BelowPriceTextField;
    @FXML
    private TextField DTTypeTextField;
    @FXML
    private TextField UserTextField;
    @FXML
    private Button ChangeUserButton;

    public void ChangeUserButtonOnActivity(ActionEvent event){
        Boolean check = true;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equals(UserTextField.getText())){
                theUser = users.get(i);
                check = false;
            }
        }
        if(check){
            UserTextField.setText("Need a valid name");
        }
    }

    private DataFactory dataFactory = new DataFactory();
    private User theUser;
    private ObservableList<User> users = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users = dataFactory.getUsers();
        theUser = users.get(0);
        PickedDayTourListView.setItems((ObservableList) theUser.getReservations());
        AvailableDayTourListView.setItems((ObservableList) DataFactory.getdayTour());
    }
}
*/