package controllers;

import aux_classes.Provider;
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

import models.ModelProviders;

/**
 *
 * @author azaelmglw
 */

public class ControllerProviders implements Initializable{
    private final ModelProviders model_providers;
    private final ControllerMain controller_main;
    
    public ControllerProviders(ArrayList models, ArrayList controllers){
        this.model_providers = (ModelProviders)models.get(5);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model_providers.getModelMain().getProvidersBool().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true){
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayProvidersData();
            }
            else {
                
            }
        });
    
    }
    
    @FXML
    private TableView providers_table_tbview;
    
    @FXML
    private TableColumn id_col, name_col, brand_col, phone_number_col, email_col, active_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private TextArea description_field_txarea;
    
    @FXML
    private void AddProvider(ActionEvent event){
        System.out.println("Add Branch Office TRIGGERED");
        //controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(0));
        
    }
    
    @FXML
    private void EditProvider(ActionEvent event){
        System.out.println("Edit Branch Office TRIGGERED");
        
    }
    
    @FXML
    private void DeactivateProvider(ActionEvent event){
        System.out.println("Deactivate Branch Office TRIGGERED");
        
    }
    
    @FXML
    private void SearchProvider(ActionEvent event){
        System.out.println("Search Branch Office TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event){
        controller_main.SwitchPrimaryStageRoot(model_providers.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        model_providers.ObtainProviderDetails(providers_table_tbview.getSelectionModel().getSelectedIndex());
        description_field_txarea.setText("Street -> " + model_providers.getProviderData().pop() + ".\n" +
        "Suburb -> " + model_providers.getProviderData().pop() + ".\n" +
        "External Number -> " + model_providers.getProviderData().pop() + ".\n" +
        "Post Address -> " + model_providers.getProviderData().pop() + ".\n" +
        "City -> " + model_providers.getProviderData().pop() + ".\n" +
        "State -> " + model_providers.getProviderData().pop() + ".\n");
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
    
    private void DisplayProvidersData(){
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        brand_col.setCellValueFactory(new PropertyValueFactory<>("brand"));
        phone_number_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
        providers_table_tbview.setItems(model_providers.ObtainProvidersData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
}
