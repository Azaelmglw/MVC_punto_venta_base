package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import models.ModelTerminalMenu;

/**
 *
 * @author azaelmglw
 */

public class ControllerTerminalMenu implements Initializable {
    private final ModelTerminalMenu model_terminal_menu;
    private final ControllerMain controller_main;
    
    public ControllerTerminalMenu(ArrayList models, ArrayList controllers){
        this.model_terminal_menu = (ModelTerminalMenu)models.get(3);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    private void LaunchNewSale(ActionEvent event){
        System.out.println("Launch New Sale TRIGGERED");
    }
    
    @FXML
    private void LaunchNewPurchase(ActionEvent event){
        System.out.println("Launch New Purchase TRIGGERED");
    }
    
    @FXML
    private void LaunchStock(ActionEvent event){
        System.out.println("Launch Stock TRIGGERED");
    }
    
    @FXML
    private void LaunchReports(ActionEvent event){
        System.out.println("Launch Reports TRIGGERED");
    }
    
}
