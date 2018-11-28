package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelNewSale;

/**
 *
 * @author azaelmglw
 */

public class ControllerNewSale implements Initializable {
    private final ModelNewSale model_new_sale;
    private final ControllerMain controller_main;
    
    public ControllerNewSale(ArrayList models_list, ArrayList controllers_list) {
        this.model_new_sale = (ModelNewSale)models_list.get(13);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
