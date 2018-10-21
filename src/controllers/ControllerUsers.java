package controllers;

import models.ModelUsers;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Azaelmglw
 */

public class ControllerUsers implements Initializable {
    private final ModelUsers model_users;
    private final ControllerMain controller_main;
    
    public ControllerUsers(ArrayList models, ArrayList controllers){
        this.model_users = (ModelUsers)models.get(1);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
