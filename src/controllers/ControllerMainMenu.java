package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import models.ModelMainMenu;

/**
 *
 * @author Azaelmglw
 */

public class ControllerMainMenu implements Initializable {
    private final ModelMainMenu model_users;
    private final ControllerMain controller_main;
    
    public ControllerMainMenu(ArrayList models, ArrayList controllers){
        this.model_users = (ModelMainMenu)models.get(1);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    private void LaunchTerminal(ActionEvent event){
        System.out.println("Launch Terminal TRIGGERED");
        controller_main.SwitchPrimaryStageRoot(model_users.getModelMain().getParent(3));
    }
    
    @FXML
    private void LaunchConsole(ActionEvent event){
        System.out.println("Launch Console TRIGGERED");
        controller_main.SwitchPrimaryStageRoot(model_users.getModelMain().getParent(2));
    }
}
