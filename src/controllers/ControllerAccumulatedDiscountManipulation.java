package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelAccumulatedDiscountManipulation;

/**
 *
 * @author azaelmglw
 */

public class ControllerAccumulatedDiscountManipulation implements Initializable {
    private final ModelAccumulatedDiscountManipulation model_accumulated_discount_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerAccumulatedDiscountManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_accumulated_discount_manipulation = (ModelAccumulatedDiscountManipulation)models_list.get(20);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
