package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelUserManipulation;

/**
 *
 * @author azaelmglw
 */

public class ControllerUserManipulation implements Initializable {
    private final ModelUserManipulation model_user_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerUserManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_user_manipulation = (ModelUserManipulation)models_list.get(17);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
