package main;

import models.*;
import controllers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

/**
 *
 * @author azaelmglw
 */

public class Main extends Application{
    
    public static void main(String oamg[]) {  
        Application.launch(oamg);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            ArrayList<FXMLLoader> loaders_list = new ArrayList<>(20);
            ArrayList<Object> models_list = new ArrayList<>(20);
            ArrayList<Object> controllers_list = new ArrayList<>(20);
            
            // FXML Loaders Declaration.
            FXMLLoader loader_main = new FXMLLoader(getClass().getResource("ViewMain.fxml"));
            FXMLLoader loader_main_menu =  new FXMLLoader(getClass().getResource("ViewMainMenu.fxml"));
            FXMLLoader loader_console_menu = new FXMLLoader(getClass().getResource("ViewConsoleMenu.fxml"));
            FXMLLoader loader_terminal_menu = new FXMLLoader(getClass().getResource("ViewTerminalMenu.fxml"));
            
            loaders_list.add(0, loader_main);
            loaders_list.add(1, loader_main_menu);
            loaders_list.add(2, loader_console_menu);
            loaders_list.add(3, loader_terminal_menu);
                        
            /*  To maintain an MVC structure and avoid performance issues due to infinite instantiation, 
            each one of the application Models, Controllers, Parents and Scenes have been instanced in 
            this exact class and method.*/
            
            /*  In order to be able to get the <<model_main>> which contains the <<primaryStage>> in the Controllers
            and allow the modification of it's <<root>> (switching views), the Controller of each respective 
            <<.fxml>> file needs to be declared outside of itself and before the <<load()>> method is called 
            or it's build will fail.*/
            
            /*  Models array list position:
            [0] -> model_main   |   [1] -> model_main_menu  |   [2] -> model_console_menu   |   [3] -> model_terminal_menu  |
            */
            
            /*  Controllers array list position:
            [0] -> controller_main  |   [1] -> controller_main_menu |   [2] -> controller_console_menu  |   [3] -> controller_terminal_menu |
            */
            
            ModelMain model_main = new ModelMain(primaryStage);
            models_list.add(0, model_main);
            ControllerMain controller_main = new ControllerMain(model_main);
            loader_main.setController(controller_main);
            controllers_list.add(0, controller_main);
            
            ModelMainMenu model_main_menu = new ModelMainMenu(model_main);
            models_list.add(1, model_main_menu);
            ControllerMainMenu controller_main_menu = new ControllerMainMenu(models_list, controllers_list);
            loader_main_menu.setController(controller_main_menu);
            controllers_list.add(1, controller_main_menu);
            
            
            ModelConsoleMenu model_console_menu = new  ModelConsoleMenu(model_main);
            models_list.add(2, model_console_menu);
            ControllerConsoleMenu controller_console_menu = new ControllerConsoleMenu(models_list, controllers_list);
            loader_console_menu.setController(controller_console_menu);
            controllers_list.add(2, controller_console_menu);
            
            ModelTerminalMenu model_terminal_menu = new ModelTerminalMenu(model_main);
            models_list.add(3, model_terminal_menu);
            ControllerTerminalMenu controller_terminal_menu = new ControllerTerminalMenu(models_list, controllers_list);
            loader_terminal_menu.setController(controller_terminal_menu);
            controllers_list.add(3, controller_terminal_menu);
            
            
           
            //  Parents Declaration.
            Parent main = (Parent)loader_main.load();
            Parent main_menu = (Parent)loader_main_menu.load();
            Parent console_menu = (Parent)loader_console_menu.load();
            Parent terminal_menu = (Parent)loader_terminal_menu.load();
            
            /*  Once all the Parent variables are declared, the <<model_main>> needs to receive the reference 
            for each one trough it's <<set()>> method, making available all the Parents to the Controllers.*/
            
            //  Parents Assignation.
            model_main.setParent(0, main);
            model_main.setParent(1, main_menu);
            
            //  Scenes Declaration.
            Scene main_scene = new Scene(main, 800, 768);
            
            //  Unary Operators Declaration.
            UnaryOperator<TextFormatter.Change> login_username_filter = c -> {
                if(!c.getText().matches("[A-Z]") && !c.getText().matches("[0-9]") || c.isDeleted()){
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()){
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> login_user_password_filter = c -> {
                if(!c.getText().matches("[A-Z]") && !c.getText().matches("[a-z]") && !c.getText().matches("[0-9]") || c.isDeleted()){
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()){
                    return c;
                }
                return c;
            };
            
            
            
            UnaryOperator<TextFormatter.Change> telephone_filter = c -> {
                if(!c.getText().matches("[0-9]") || c.isDeleted()){
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()){
                    return c;
                }
                return c;
            };
            
            //  Text Formatters Declaration.
            TextFormatter<String> username_formatter = new TextFormatter<>(login_username_filter);
            TextFormatter<String> user_password_formatter = new TextFormatter<>(login_user_password_filter);
            
            //  Text Formatters Assignation.
            model_main.setTextFormatter(0, username_formatter);
            model_main.setTextFormatter(1, user_password_formatter);
            
            //  Alerts Declaration.
            Alert confirmation_alert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation_alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
            Alert error_alert = new Alert(Alert.AlertType.ERROR);
            error_alert.setTitle("Something went wrong");
            
            //  Alerts Assignation.
            model_main.setAlert(0, confirmation_alert);
            model_main.setAlert(1, error_alert);
            
            /*  Only the <<main>> UI is set in this method, all of the other manipulations of <<primaryStage>>
            need to be declared in it's respective Controllers.*/
            primaryStage.setTitle("ACME FX_v0.1");
            primaryStage.setScene(main_scene);
            primaryStage.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}