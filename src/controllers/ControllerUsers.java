package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import models.ModelUsers;

/**
 *
 * @author azaelmglw
 */

public class ControllerUsers implements Initializable {
    private final ModelUsers model_users;
    private final ControllerMain controller_main;
    
    public ControllerUsers(ArrayList models, ArrayList controllers){
        this.model_users = (ModelUsers)models.get(6);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model_users.getModelMain().getUsersBool().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true){
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayUsersData();
            }
            else{
                
            }
        });
    }
    
    @FXML
    private TableView users_table_tbview;
    
    @FXML
    private TableColumn id_col, branch_office_id_col, type_col, name_col, phone_number_col, email_col, active_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private TextArea description_field_txarea;
    
    @FXML
    private void AddUser(ActionEvent event){
        System.out.println("Add User TRIGGERED");
        //controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(0));
        
    }
    
    @FXML
    private void EditUser(ActionEvent event){
        System.out.println("Edit User TRIGGERED");
        
    }
    
    @FXML
    private void DeactivateUser(ActionEvent event){
        System.out.println("Deactivate User TRIGGERED");
        
    }
    
    @FXML
    private void SearchUser(ActionEvent event){
        System.out.println("Search User TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event) {
        controller_main.SwitchPrimaryStageRoot(model_users.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        model_users.ObtainUserDetails(users_table_tbview.getSelectionModel().getSelectedIndex());
        description_field_txarea.setText("RFC -> " + model_users.getUserData().pop() + ".\n" +
        "Street -> " + model_users.getUserData().pop() + ".\n" +
        "Suburb -> " + model_users.getUserData().pop() + ".\n" +
        "Inernal Number -> " + model_users.getUserData().pop() + ".\n" +
        "External Number -> " + model_users.getUserData().pop() + ".\n" +
        "Post Address -> " + model_users.getUserData().pop() + ".\n" +
        "City -> " + model_users.getUserData().pop() + ".\n" +
        "State -> " + model_users.getUserData().pop() + ".\n" +
        "Insurance Number -> " + model_users.getUserData().pop() + ".\n" +
        "CURP -> " + model_users.getUserData().pop() + ".\n");
    }
    
    @FXML
    private void First(ActionEvent event){
        System.out.println("First TRIGGERED");
        
    }
    
    @FXML
    private void Previous(ActionEvent event){
        System.out.println("Previous TRIGGERED");
        
    }
    
    @FXML
    private void Next(ActionEvent event){
        System.out.println("Next TRIGGERED");
        
    }
    
    @FXML
    private void Last(ActionEvent event){
        System.out.println("Last TRIGGERED");
        
    }
    
    private void DisplayUsersData(){
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        branch_office_id_col.setCellValueFactory(new PropertyValueFactory<>("branch_office_id"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        phone_number_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
        users_table_tbview.setItems(model_users.ObtainUsersData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
}
