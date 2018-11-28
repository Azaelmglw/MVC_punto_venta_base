package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelNewPurchase;

/**
 *
 * @author azaelmglw
 */

public class ControllerNewPurchase  implements Initializable {
    private final ModelNewPurchase model_new_purchase;
    private final ControllerMain controller_main;
    
    public ControllerNewPurchase(ArrayList models_list, ArrayList controllers_list) {
        this.model_new_purchase = (ModelNewPurchase)models_list.get(14);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
