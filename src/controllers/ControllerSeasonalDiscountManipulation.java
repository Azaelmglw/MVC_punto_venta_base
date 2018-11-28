
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelSeasonalDiscountManipulation;

/**
 *
 * @author azaelmglw
 */

public class ControllerSeasonalDiscountManipulation implements Initializable {
    private final ModelSeasonalDiscountManipulation model_seasonal_discount_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerSeasonalDiscountManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_seasonal_discount_manipulation = (ModelSeasonalDiscountManipulation)models_list.get(21);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
