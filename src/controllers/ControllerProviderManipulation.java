package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelProviderManipulation;

/**
 *
 * @author azaelmglw
 */

public class ControllerProviderManipulation implements Initializable {
    private final ModelProviderManipulation model_provider_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerProviderManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_provider_manipulation = (ModelProviderManipulation)models_list.get(16);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
