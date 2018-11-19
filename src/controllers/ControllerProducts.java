package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.PropertyValueFactory;

import models.ModelProducts;
import aux_classes.Product;

/**
 *
 * @author azaelmglw
 */

public class ControllerProducts implements Initializable {
    private final ModelProducts model_products;
    private final ControllerMain controller_main;
    
    public ControllerProducts(ArrayList models, ArrayList controllers){
        this.model_products = (ModelProducts)models.get(8);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProductsTableSetup();
        StockTableSetup();
        model_products.getModelMain().getProductsBool().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true) {
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplayProductsData();
            }
        });
    }
    
    @FXML
    private TableView products_table_tbview, stock_table_tbview;
    
    @FXML
    private TableColumn id_col, name_col, type_col, brand_col, sale_price_col, meassurement_unit_col, active_col,
    branch_office_id_col, stock_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private void AddProduct(ActionEvent event) {
        System.out.println("Add Product TRIGGERED");
        //controller_main.SwitchPrimaryStageRoot(model_branch_offices.getModelMain().getParent(0));
        
    }
    
    @FXML
    private void EditProduct(ActionEvent event) {
        System.out.println("Edit Product TRIGGERED");
        
    }
    
    @FXML
    private void DeactivateProduct(ActionEvent event) {
        System.out.println("Deactivate Product TRIGGERED");
        
    }
    
    @FXML
    private void SearchProduct(ActionEvent event) {
        System.out.println("Search Product TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event){
        controller_main.SwitchPrimaryStageRoot(model_products.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        stock_table_tbview.getItems().removeAll(model_products.getProductStock());
        DisplayStockData();
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
    
    private void DisplayProductsData() {
        products_table_tbview.setItems(model_products.ObtainProductsData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
    private void DisplayStockData(){
        stock_table_tbview.setItems(model_products.ObtainProductStock((Product)products_table_tbview.getSelectionModel().getSelectedItem()));
    }
    
    private void ProductsTableSetup() {
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        brand_col.setCellValueFactory(new PropertyValueFactory<>("brand"));
        sale_price_col.setCellValueFactory(new PropertyValueFactory<>("sale_price"));
        meassurement_unit_col.setCellValueFactory(new PropertyValueFactory<>("meassurement_unit"));
        active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
    }
    
    private void StockTableSetup() {
        branch_office_id_col.setCellValueFactory(new PropertyValueFactory<>("branch_office_id"));
        stock_col.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }
    
}
