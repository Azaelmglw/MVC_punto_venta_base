package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelPurchases;

/**
 *
 * @author azaelmglw
 */

public class ControllerPurchases implements Initializable {
    private final ModelPurchases model_purchases;
    private final ControllerMain controller_main;
    
    public ControllerPurchases(ArrayList models, ArrayList controllers){
        this.model_purchases = (ModelPurchases)models.get(10);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
