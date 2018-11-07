package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelProviders;

/**
 *
 * @author azaelmglw
 */

public class ControllerProviders implements Initializable{
    private final ModelProviders model_providers;
    private final ControllerMain controller_main;
    
    public ControllerProviders(ArrayList models, ArrayList controllers){
        this.model_providers = (ModelProviders)models.get(5);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
