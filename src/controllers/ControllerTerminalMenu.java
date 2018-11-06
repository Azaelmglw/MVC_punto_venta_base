package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    
}
