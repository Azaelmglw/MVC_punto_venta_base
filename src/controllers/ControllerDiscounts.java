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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import models.ModelDiscounts;
import aux_classes.Discount;
import javafx.scene.control.TextArea;

/**
 *
 * @author azaelmglw
 */

public class ControllerDiscounts implements Initializable{
    private final ModelDiscounts model_discounts;
    private final ControllerMain controller_main;
    
    public ControllerDiscounts(ArrayList models, ArrayList controllers){
        this.model_discounts = (ModelDiscounts)models.get(9);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DiscountsTableSetup();
        model_discounts.getModelMain().getUI_Bool(9).addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true) {
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayDiscountData();
            }
        });
    }
    
    @FXML
    private TableView discounts_table_tbview;
    
    @FXML
    private TableColumn id_col, name_col, applied_percentage_col, type_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private TextArea description_field_txarea;
    
    @FXML
    private void AddDiscount(ActionEvent event) {
        System.out.println("Add Discount TRIGGERED");
        //controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(0));
        
    }
    
    @FXML
    private void EditDiscount(ActionEvent event) {
        System.out.println("Edit Discount TRIGGERED");
        
    }
    
    @FXML
    private void DeactivateDiscount(ActionEvent event) {
        System.out.println("Deactivate Discount TRIGGERED");
        
    }
    
    @FXML
    private void SearchDiscount(ActionEvent event) {
        System.out.println("Search Discount TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event){
        controller_main.SwitchPrimaryStageRoot(model_discounts.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        description_field_txarea.setText(model_discounts.ObtainDiscountDetails((Discount)discounts_table_tbview.getSelectionModel().getSelectedItem()));
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
    
    private void DisplayDiscountData() {
        discounts_table_tbview.setItems(model_discounts.ObtainDiscountsData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
   
    private void DisplayDiscountDetails(){
        
    }
    
    private void DiscountsTableSetup() {
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        applied_percentage_col.setCellValueFactory(new PropertyValueFactory<>("applied_percentage"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("type")); 
    }
    
}
