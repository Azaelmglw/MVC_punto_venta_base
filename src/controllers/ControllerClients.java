package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import models.ModelClients;

/**
 *
 * @author azaelmglw
 */

public class ControllerClients implements Initializable{
    private final ModelClients model_clients;
    private final ControllerMain controller_main;
    
    public ControllerClients(ArrayList models, ArrayList controllers){
        this.model_clients = (ModelClients)models.get(7);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
