package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelProductManipulation;

/**
 *
 * @author azaelmglw
 */

public class ControllerProductManipulation  implements Initializable {
    private final ModelProductManipulation model_product_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerProductManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_product_manipulation = (ModelProductManipulation)models_list.get(19);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
