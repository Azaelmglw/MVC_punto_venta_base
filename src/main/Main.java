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
 * @author Azaelmglw
 */

public class Main extends Application{
    
    public static void main(String oamg[]) {  
        Application.launch(oamg);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            ArrayList<FXMLLoader> loaders_list = new ArrayList<>(5);
            ArrayList<Object> models_list = new ArrayList<>(5);
            ArrayList<Object> controllers_list = new ArrayList<>(5);
            
            // FXML Loaders Declaration.
            FXMLLoader loader_main = new FXMLLoader(getClass().getResource("ViewMain.fxml"));
            FXMLLoader loader_users =  new FXMLLoader(getClass().getResource("ViewUsers.fxml"));
            
            loaders_list.add(0, loader_main);
            loaders_list.add(1, loader_users);
                        
            /*  To maintain an MVC structure and avoid performance issues due to infinite instantiation, 
            each one of the application Models, Controllers, Parents and Scenes have been instanced in 
            this exact class and method.*/
            
            /*  In order to be able to get the <<model_main>> which contains the <<primaryStage>> in the Controllers
            and allow the modification of it's <<root>> (switching views), the Controller of each respective 
            <<.fxml>> file needs to be declared outside of itself and before the <<load()>> method is called 
            or it's build will fail.*/
            
            /*  Models array list position:
            [0] -> model_main   |   [1] -> model_users    |
            */
            
            /*  Controllers array list position:
            [0] -> controller_main  |   [1] -> controller_users   |
            */
            
            ModelMain model_main = new ModelMain(primaryStage);
            models_list.add(0, model_main);
            ControllerMain controller_main = new ControllerMain(model_main);
            loader_main.setController(controller_main);
            controllers_list.add(0, controller_main);
            
            ModelUsers model_users = new ModelUsers(model_main);
            models_list.add(1, model_users);
            ControllerUsers controller_users = new ControllerUsers(models_list, controllers_list);
            loader_users.setController(controller_users);
            controllers_list.add(1, controller_users);
           
            //  Parents Declaration.
            Parent main = (Parent)loader_main.load();
            Parent user_details = (Parent)loader_users.load();
            
            /*  Once all the Parent variables are declared, the <<model_main>> needs to receive the reference 
            for each one trough it's <<set()>> method, making available all the Parents to the Controllers.*/
            
            //  Parents Assignation.
            model_main.setParent(0, main);
            model_main.setParent(1, user_details);
            
            //  Scenes Declaration.
            Scene main_scene = new Scene(main, 800, 768);
            
            //  Unary Operators Declaration.
            UnaryOperator<TextFormatter.Change> text_filter = c -> {
                if(!c.getText().matches("[A-Z]") && !c.getText().matches("[a-z]") && !c.getText().matches(" ") || c.isDeleted()){
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
            TextFormatter<String> name_formatter = new TextFormatter<>(text_filter);
            TextFormatter<String> telephone_formatter = new TextFormatter<>(telephone_filter);
            
            //  Text Formatters Assignation.
            model_main.setTextFormatter(0, name_formatter);
            model_main.setTextFormatter(1, telephone_formatter);
            
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
            primaryStage.setTitle("Base Datos Scenes MVC v0.1");
            primaryStage.setScene(main_scene);
            primaryStage.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}