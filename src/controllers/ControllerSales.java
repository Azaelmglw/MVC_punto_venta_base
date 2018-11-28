package controllers;

import aux_classes.Sale;
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
import models.ModelSales;

/**
 *
 * @author azaelmglw
 */

public class ControllerSales implements Initializable {
    private final ModelSales model_sales;
    private final ControllerMain controller_main;
    
    public ControllerSales(ArrayList models, ArrayList controllers){
        this.model_sales = (ModelSales)models.get(11);
        this.controller_main = (ControllerMain)controllers.get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SalesTableSetup();
        SaleDetailsTableSetup();
        model_sales.getModelMain().getUI_Bool(11).addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue == true) {
                rows_showed_selector_cbbox.getSelectionModel().select(0);
                DisplaySalesData();
            }
        });
    
    }
    
    @FXML
    private TableView sales_table_tbview, sale_details_table_tbview;
    
    @FXML
    private TableColumn id_col, branch_office_id_col, client_name_col, user_id_col, user_name_col, date_col, subtotal_col, saved_total_col, iva_col, total_col, 
    product_id_col, product_name_col, quantity_col, sale_price_col, detail_total_col;
    
    @FXML
    private ComboBox rows_showed_selector_cbbox;
    
    @FXML
    private void SearchSale(ActionEvent event) {
        System.out.println("Search Sale TRIGGERED");
        
    }
    
    @FXML
    private void LaunchConsoleMenu(ActionEvent event){
        controller_main.SwitchPrimaryStageRoot(model_sales.getModelMain().getParent(2));
    }
    
    @FXML
    private void SetRowsShowed(ActionEvent event){
        System.out.println("Set Rows Showed TRIGGERED");
        
    }
    
    @FXML
    private void GetSelectedRowId(MouseEvent event){
        System.out.println("Obtain Row Id TRIGGERED");
        sale_details_table_tbview.getItems().removeAll(model_sales.getSaleDetails());
        DisplaySaleDetails();
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
    
    private void DisplaySalesData() {
        sales_table_tbview.setItems(model_sales.ObtainSalesData(rows_showed_selector_cbbox.getSelectionModel().getSelectedItem().toString(), 0));
    }
    
    private void DisplaySaleDetails(){
        sale_details_table_tbview.setItems(model_sales.ObtainSaleDetails((Sale)sales_table_tbview.getSelectionModel().getSelectedItem()));
    }
    
    private void SalesTableSetup() {
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        branch_office_id_col.setCellValueFactory(new PropertyValueFactory<>("branch_office_id"));
        client_name_col.setCellValueFactory(new PropertyValueFactory<>("client_name"));
        user_id_col.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        user_name_col.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        subtotal_col.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        saved_total_col.setCellValueFactory(new PropertyValueFactory<>("saved_total"));
        iva_col.setCellValueFactory(new PropertyValueFactory<>("iva"));
        total_col.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    
    private void SaleDetailsTableSetup() {
        product_id_col.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("product_quantity"));
        sale_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        detail_total_col.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    
}
