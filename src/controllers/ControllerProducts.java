package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelProducts;

/**
 *
 * @author azaelmglw
 */

public class ControllerProducts implements Initializable {
    private final ModelProducts model_products;
    private final ControllerMain controller_main;
    
    public ControllerProducts(ArrayList models, ArrayList controllers){
        this.model_products = (ModelProducts)models.get(8);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
