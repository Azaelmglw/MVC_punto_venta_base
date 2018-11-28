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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import models.ModelBranchOffices;
import aux_classes.BranchOffice;

/**
 *
 * @author azaelmglw
 */

public class ControllerBranchOffices implements Initializable {
    private final ModelBranchOffices model_branch_offices;
    private final ControllerMain controller_main;
    
    public ControllerBranchOffices(ArrayList models, ArrayList controllers){
        this.model_branch_offices = (ModelBranchOffices)models.get(4);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BranchOfficesTableSetup();
        model_branch_offices.getModelMain().getUI_Bool(4).addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true) {
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayBranchOfficesData();
            }
            else {
                
            }
        });
    }
    
    @FXML
    private TableView branch_offices_table_tbview;
    
    @FXML
    private TableColumn id_col, number_col, suburb_col, post_address_col, email_col, 
    phone_number_col, city_col, state_col, active_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private TextArea description_field_txarea;
    
    @FXML
    private void AddBranchOffice(ActionEvent event){
        System.out.println("Add Branch Office TRIGGERED");
        model_branch_offices.getModelMain().getUI_Bool(12).set(true);
        controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(15));
    }
    
    @FXML
    private void EditBranchOffice(ActionEvent event){
        System.out.println("Edit Branch Office TRIGGERED");
        model_branch_offices.getModelMain().getUI_Bool(12).set(true);
        model_branch_offices.getModelMain().setTransferible_object(branch_offices_table_tbview.getSelectionModel().getSelectedItem());
        controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(15));
    }
    
    @FXML
    private void DeactivateBranchOffice(ActionEvent event){
        System.out.println("Deactivate Branch Office TRIGGERED");
        
    }
    
    @FXML
    private void SearchBranchOffice(ActionEvent event){
        System.out.println("Search Branch Office TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event) {
        controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        description_field_txarea.setText(model_branch_offices.ObtainBranchOfficeDetails((BranchOffice)branch_offices_table_tbview.getSelectionModel().getSelectedItem()));
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
    
    private void DisplayBranchOfficesData() {
        branch_offices_table_tbview.setItems(model_branch_offices.ObtainBranchOfficesData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
    private void BranchOfficesTableSetup() {
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        number_col.setCellValueFactory(new PropertyValueFactory<>("number"));
        suburb_col.setCellValueFactory(new PropertyValueFactory<>("suburb"));
        post_address_col.setCellValueFactory(new PropertyValueFactory<>("post_address"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone_number_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        city_col.setCellValueFactory(new PropertyValueFactory<>("city"));
        state_col.setCellValueFactory(new PropertyValueFactory<>("state"));
        active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
    }
}