package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.fxml.Initializable;

import models.ModelBranchOffices;

/**
 *
 * @author azaelmglw
 */

public class ControllerBranchOffices implements Initializable {
    private final ModelBranchOffices model_branch_offices;
    private final ControllerMain controller_main;
    
    public ControllerBranchOffices(ArrayList models, ArrayList controllers){
        this.model_branch_offices = (ModelBranchOffices)models.get(4);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model_branch_offices.getModelMain().getBranchOfficesBool().addListener(((observable, oldValue, newValue) -> {
            if(newValue == true){
                
            }
            else{
                
            }
        }));
    }
    
}
