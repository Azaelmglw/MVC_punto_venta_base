package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import models.ModelBranchOfficeManipulation;
import aux_classes.User;
import javafx.scene.control.ComboBox;

/**
 *
 * @author azaelmglw
 */

public class ControllerBranchOfficeManipulation implements Initializable {
    private final ModelBranchOfficeManipulation model_branch_office_manipulation;
    private final ControllerMain controller_main;
    
    public ControllerBranchOfficeManipulation(ArrayList models_list, ArrayList controllers_list) {
        this.model_branch_office_manipulation = (ModelBranchOfficeManipulation)models_list.get(15);
        this.controller_main = (ControllerMain)controllers_list.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        manager_manipulation_cbbox.getSelectionModel().select(0);
        ManagersTableSetup();
        model_branch_office_manipulation.getModelMain().getUI_Bool(12).addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true) {
                EnableInputFormatters();
                DisplayManagersData();
            }
            
        });
    }
    
    @FXML
    private TextField number_txfield, suburb_txfield, post_address_txfield, email_txfield, phone_number_txfield, city_txfield, state_txfield;
    
    @FXML
    private TableView managers_table_tbview;
    
    @FXML
    private TableColumn id_col, name_col, phone_number_col, rfc_col, post_address_col, email_col, city_col, state_col, insurance_number_col, curp_col;
    
    @FXML
    private ComboBox manager_manipulation_cbbox;
    
    @FXML
    private void SaveChanges(ActionEvent event) {
        System.out.println("Save Changes TRIGGERED.");
        ObtainBranchOfficeData();
        model_branch_office_manipulation.UpdateBranchOfficeData();   
    }
    
    @FXML
    private void CancelChanges(ActionEvent event) {
        System.out.println("Cancel Changes TRIGGERED.");
        model_branch_office_manipulation.getModelMain().getUI_Bool(12).set(false);
        managers_table_tbview.getItems().removeAll(model_branch_office_manipulation.getManagersData());
        model_branch_office_manipulation.getModelMain().setTransferible_object(null);
        controller_main.SwitchPrimaryStageRoot(model_branch_office_manipulation.getModelMain().getParent(4));
    }
    
    @FXML
    private void AddManager(ActionEvent event) {
        System.out.println("Add Manager TRIGGERED.");
        model_branch_office_manipulation.setAssignedManagers((User)managers_table_tbview.getSelectionModel().getSelectedItem());
        managers_table_tbview.getItems().removeAll(model_branch_office_manipulation.getAssignedManagers());
    }
    
    @FXML
    private void MouseDragged(MouseEvent event) {
        //
    }
    
    private void EnableInputFormatters () {
        number_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(2));
        suburb_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(3));
        post_address_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(4));
        email_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(5));
        phone_number_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(6));
        city_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(7));
        state_txfield.setTextFormatter(model_branch_office_manipulation.getModelMain().getTextFormatter(8));
    }
    
    private void ObtainBranchOfficeData() {
        model_branch_office_manipulation.getBranchOffice().setNumber(number_txfield.getText());
        model_branch_office_manipulation.getBranchOffice().setSuburb(suburb_txfield.getText());
        model_branch_office_manipulation.getBranchOffice().setPost_address(post_address_txfield.getText());
        model_branch_office_manipulation.getBranchOffice().setEmail(email_txfield.getText());
        model_branch_office_manipulation.getBranchOffice().setPhone_number(phone_number_txfield.getText());
        model_branch_office_manipulation.getBranchOffice().setCity(city_txfield.getText());
        model_branch_office_manipulation.getBranchOffice().setState(state_txfield.getText());
    }
    
    private void DisplayManagersData() {
        managers_table_tbview.setItems(model_branch_office_manipulation.ObtainManagersData());
    }
    
    private void ManagersTableSetup() {
        id_col.setCellValueFactory(new PropertyValueFactory("id"));
        name_col.setCellValueFactory(new PropertyValueFactory("full_name"));
        phone_number_col.setCellValueFactory(new PropertyValueFactory("phone_number"));
        rfc_col.setCellValueFactory(new PropertyValueFactory("rfc"));
        post_address_col.setCellValueFactory(new PropertyValueFactory("post_address"));
        email_col.setCellValueFactory(new PropertyValueFactory("email"));
        city_col.setCellValueFactory(new PropertyValueFactory("city"));
        state_col.setCellValueFactory(new PropertyValueFactory("state"));
        insurance_number_col.setCellValueFactory(new PropertyValueFactory("insurance_number"));
        curp_col.setCellValueFactory(new PropertyValueFactory("curp"));
    }
     
}
