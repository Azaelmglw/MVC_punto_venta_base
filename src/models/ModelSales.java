package models;

import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.Sale;
import aux_classes.TransactionDetail;
import java.sql.SQLException;

/**
 *
 * @author azaelmglw
 */

public class ModelSales {
    private final ModelMain model_main;
    
    private Stack<String> sale_data = new Stack<>();
    private ObservableList<Sale> sales_data = FXCollections.observableArrayList();
    private ObservableList<TransactionDetail> sale_details = FXCollections.observableArrayList();
    
    public ModelSales(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ObservableList<Sale> ObtainSalesData(String rows_showed, int offset_rows) {
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM Sales LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()) {
                sale_data.push(getModelMain().getPSQLResult_Set().getString("saved_total"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("client_name"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("branch_office_id"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("total"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("iva"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("subtotal"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("date"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("user_name"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("user_id"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("id"));
                sales_data.add(new Sale(sale_data));
            }
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the sales data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return sales_data;
    }
    
    public ObservableList<TransactionDetail> ObtainSaleDetails(Sale selected_sale) {
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM obtain_sale_details(?);");
            getModelMain().getPSQLPreparedStatement().setString(1, selected_sale.getId());
            getModelMain().PSQLExecuteQueryPS();
            
            
            while(getModelMain().getPSQLResult_Set().next()) {
                sale_data.push(getModelMain().getPSQLResult_Set().getString("total"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("sale_price"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("product_quantity"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("product_name"));
                sale_data.push(getModelMain().getPSQLResult_Set().getString("product_id"));
                sale_details.add(new TransactionDetail(sale_data));
            }    
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the sale details: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return sale_details;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
    public ObservableList<TransactionDetail> getSaleDetails() {
        return sale_details;
    }
    
}
