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

import models.ModelClients;

/**
 *
 * @author azaelmglw
 */

public class ControllerClients implements Initializable{
    private final ModelClients model_clients;
    private final ControllerMain controller_main;
    
    public ControllerClients(ArrayList models, ArrayList controllers){
        this.model_clients = (ModelClients)models.get(7);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model_clients.getModelMain().getClientsBool().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true){
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayClientsData();
            }
            else{
            
            }
        });
    }

    @FXML
    private TableView clients_table_tbview;
    
    @FXML
    private TableColumn id_col, discount_id_col, name_col, phone_number_col, email_col, creation_date_col, accumulated_total_col, active_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private TextArea description_field_txarea;
    
    @FXML
    private void AddClient(ActionEvent event){
        System.out.println("Add Client TRIGGERED");
        //controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(0));
        
    }
    
    @FXML
    private void EditClient(ActionEvent event){
        System.out.println("Edit Client TRIGGERED");
        
    }
    
    @FXML
    private void DeactivateClient(ActionEvent event){
        System.out.println("Deactivate Client TRIGGERED");
        
    }
    
    @FXML
    private void SearchClient(ActionEvent event){
        System.out.println("Search Client TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event){
        controller_main.SwitchPrimaryStageRoot(model_clients.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        model_clients.ObtainClientDetails(clients_table_tbview.getSelectionModel().getSelectedIndex());
        description_field_txarea.setText("RFC -> " + model_clients.getClientData().pop() + ".\n" +
        "Street -> " + model_clients.getClientData().pop() + ".\n" +
        "Suburb -> " + model_clients.getClientData().pop() + ".\n" +
        "Inernal Number -> " + model_clients.getClientData().pop() + ".\n" +
        "External Number -> " + model_clients.getClientData().pop() + ".\n" +
        "Post Address -> " + model_clients.getClientData().pop() + ".\n" +
        "City -> " + model_clients.getClientData().pop() + ".\n" +
        "State -> " + model_clients.getClientData().pop() + ".\n");
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
    
    private void DisplayClientsData(){
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        discount_id_col.setCellValueFactory(new PropertyValueFactory<>("discount_id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        phone_number_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        creation_date_col.setCellValueFactory(new PropertyValueFactory<>("creation_date"));
        accumulated_total_col.setCellValueFactory(new PropertyValueFactory<>("accumulated_total"));
        active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
        clients_table_tbview.setItems(model_clients.ObtainClientsData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
}
