package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelReports;

/**
 *
 * @author azaelmglw
 */

public class ControllerReports implements Initializable {
    private final ModelReports model_reports;
    private final ControllerMain controller_main;
    
    public ControllerReports(ArrayList models, ArrayList controllers){
        this.model_reports = (ModelReports)models.get(12);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
}
