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
        model_console_menu.getModelMain().getUI_Bool(4).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(4));
    }
    
    @FXML
    private void LaunchProviders(ActionEvent event){
        System.out.println("Launch Providers TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(5).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(5));
    }
    
    @FXML
    private void LaunchUsers(ActionEvent event){
        System.out.println("Launch Users TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(6).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(6));
    }
    
    @FXML
    private void LaunchClients(ActionEvent event){
        System.out.println("Launch Clients TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(7).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(7));
    }
    
    @FXML
    private void LaunchProducts(ActionEvent event){
        System.out.println("Launch Products TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(8).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(8));
    }
    
    @FXML
    private void LaunchDiscounts(ActionEvent event){
        System.out.println("Launch Discounts TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(9).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(9));
    }
    
    @FXML
    private void LaunchPurchases(ActionEvent event){
        System.out.println("Launch Purchases TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(10).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(10));
    }
    
    @FXML
    private void LaunchSales(ActionEvent event){
        System.out.println("Launch Sales TRIGGERED");
        model_console_menu.getModelMain().getUI_Bool(11).set(true);
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(11));
    }
    
    @FXML
    private void LaunchReports(ActionEvent event){
        System.out.println("Launch Reports TRIGGERED");
        controller_main.SwitchPrimaryStageRoot(model_console_menu.getModelMain().getParent(12));
    }
}
