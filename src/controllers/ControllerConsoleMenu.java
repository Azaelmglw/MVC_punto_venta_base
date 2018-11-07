package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.ModelConsoleMenu;

/**
 *
 * @author azaelmglw
 */

public class ControllerConsoleMenu implements Initializable{
    private final ModelConsoleMenu model_console_menu;
    private final ControllerMain controller_main;
    
    public ControllerConsoleMenu(ArrayList models, ArrayList controllers){
        this.model_console_menu = (ModelConsoleMenu)models.get(2);
        this.controller_main = (ControllerMain) controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }
    
    @FXML
    private void LaunchBranchOffices(ActionEvent event){
        System.out.println("Launch BranchOffices TRIGGERED");
    }
    
    @FXML
    private void LaunchProviders(ActionEvent event){
        System.out.println("Launch Providers TRIGGERED");
    }
    
    @FXML
    private void LaunchUsers(ActionEvent event){
        System.out.println("Launch Users TRIGGERED");
    }
    
    @FXML
    private void LaunchClients(ActionEvent event){
        System.out.println("Launch Clients TRIGGERED");
    }
    
    @FXML
    private void LaunchProducts(ActionEvent event){
        System.out.println("Launch Products TRIGGERED");
    }
    
    @FXML
    private void LaunchDiscounts(ActionEvent event){
        System.out.println("Launch Discounts TRIGGERED");
    }
    
    @FXML
    private void LaunchPurchases(ActionEvent event){
        System.out.println("Launch Purchases TRIGGERED");
    }
    
    @FXML
    private void LaunchSales(ActionEvent event){
        System.out.println("Launch Sales TRIGGERED");
    }
    
    @FXML
    private void LaunchReports(ActionEvent event){
        System.out.println("Launch Reports TRIGGERED");
    }
    
}
