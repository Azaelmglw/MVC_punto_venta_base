package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelDiscounts;

/**
 *
 * @author azaelmglw
 */

public class ControllerDiscounts implements Initializable{
    private final ModelDiscounts model_discounts;
    private final ControllerMain controller_main;
    
    public ControllerDiscounts(ArrayList models, ArrayList controllers){
        this.model_discounts = (ModelDiscounts)models.get(9);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
