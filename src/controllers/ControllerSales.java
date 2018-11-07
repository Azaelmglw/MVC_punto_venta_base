package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import models.ModelSales;

/**
 *
 * @author azaelmglw
 */

public class ControllerSales implements Initializable {
    private final ModelSales model_sales;
    private final ControllerMain controller_main;
    
    public ControllerSales(ArrayList models, ArrayList controllers){
        this.model_sales = (ModelSales)models.get(11);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //
    }
    
}
