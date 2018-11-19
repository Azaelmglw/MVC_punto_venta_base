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

import models.ModelPurchases;
import aux_classes.Purchase;

/**
 *
 * @author azaelmglw
 */

public class ControllerPurchases implements Initializable {
    private final ModelPurchases model_purchases;
    private final ControllerMain controller_main;
    
    public ControllerPurchases(ArrayList models, ArrayList controllers) {
        this.model_purchases = (ModelPurchases)models.get(10);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PurchasesTableSetup();
        PurchaseDetailsTableSetup();
        model_purchases.getModelMain().getPurchasesBool().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true) {
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayPurchasesData();
            }
            else {
                
            }
        });
    }
    
    @FXML
    private TableView purchases_table_tbview, purchase_details_table_tbview;
    
    @FXML
    private TableColumn id_col, branch_office_id_col, provider_id_col, brand_col, user_id_col, user_name_col, date_col, subtotal_col, iva_col, total_col, 
    product_id_col, product_name_col, quantity_col, purchase_price_col, detail_total_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private void SearchPurchase(ActionEvent event) {
        System.out.println("Search Purchase TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event){
        controller_main.SwitchPrimaryStageRoot(model_purchases.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        purchase_details_table_tbview.getItems().removeAll(model_purchases.getPurchaseDetails());
        DisplayPurchaseDetails();
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
    
    private void DisplayPurchasesData() {
        purchases_table_tbview.setItems(model_purchases.ObtainPurchasesData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
    private void DisplayPurchaseDetails(){
        purchase_details_table_tbview.setItems(model_purchases.ObtainPurchaseDetails((Purchase)purchases_table_tbview.getSelectionModel().getSelectedItem()));
    }
    
    private void PurchasesTableSetup() {
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        branch_office_id_col.setCellValueFactory(new PropertyValueFactory<>("branch_office_id"));
        provider_id_col.setCellValueFactory(new PropertyValueFactory<>("provider_id"));
        brand_col.setCellValueFactory(new PropertyValueFactory<>("brand"));
        user_id_col.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        user_name_col.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        subtotal_col.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        iva_col.setCellValueFactory(new PropertyValueFactory<>("iva"));
        total_col.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    
    private void PurchaseDetailsTableSetup() {
        product_id_col.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("product_quantity"));
        purchase_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        detail_total_col.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    
}
