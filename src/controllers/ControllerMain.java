package controllers;

import models.ModelMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Azaelmglw
 */

public class ControllerMain implements Initializable {
    
    private final ModelMain model_main;
    
    public ControllerMain(ModelMain model_main){
        this.model_main = model_main;
    }
         
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        account_tfield.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(account_tfield.getTextFormatter() == null){
                account_tfield.setTextFormatter(model_main.getTextFormatter(0));
                password_pfield.setTextFormatter(model_main.getTextFormatter(1));
            }
        });
    }
    
    @FXML
    private TextField account_tfield;
    
    @FXML 
    private PasswordField password_pfield;
    
    
    @FXML
    private void LaunchMainMenu(ActionEvent event) {
        setUserInput();
        if(model_main.VerifyUser()){
            SwitchPrimaryStageRoot(model_main.getParent(1));
            CleanScene();
        }
    }
    
    public void setUserInput(){
        model_main.setUser_Input(0, account_tfield.getText());
        model_main.setUser_Input(1, password_pfield.getText());
    }
    
    public void SwitchPrimaryStageRoot(Parent root){
        model_main.getPrimaryStage().getScene().setRoot(root);
    }
    
    private void CleanScene(){
        account_tfield.setText("");
        password_pfield.setText("");
    }
}