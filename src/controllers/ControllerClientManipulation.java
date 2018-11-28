package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelClientManipulation;

/**
 *
 * @author azaelmglw
 */

public class ControllerClientManipulation implements Initializable{
    private final ModelClientManipulation model_client_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerClientManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_client_manipulation = (ModelClientManipulation)models_list.get(18);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
