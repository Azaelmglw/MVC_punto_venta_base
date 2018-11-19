package models;

import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;

import aux_classes.Purchase;
import aux_classes.TransactionDetail;

/**
 *
 * @author azaelmglw
 */

public class ModelPurchases {
    private final ModelMain model_main;
    
    private Stack<String> purchase_data = new Stack<>();
    private ObservableList<Purchase> purchases_data = FXCollections.observableArrayList();
    private ObservableList<TransactionDetail> purchase_details = FXCollections.observableArrayList();
    
    public ModelPurchases(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ObservableList<Purchase> ObtainPurchasesData(String rows_showed, int offset_rows) {
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM Purchases LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()) {
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("brand"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("provider_id"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("branch_office_id"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("total"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("iva"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("subtotal"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("date"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("user_name"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("user_id"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("id"));
                purchases_data.add(new Purchase(purchase_data));
            }
            
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the purchases data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return purchases_data;
    }
    
    public ObservableList<TransactionDetail> ObtainPurchaseDetails(Purchase selected_purchase) {
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM obtain_purchase_details(?);");
            getModelMain().getPSQLPreparedStatement().setString(1, selected_purchase.getId());
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()) {
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("total"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("purchase_price"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("product_quantity"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("product_name"));
                purchase_data.push(getModelMain().getPSQLResult_Set().getString("product_id"));
                purchase_details.add(new TransactionDetail(purchase_data));
            }
            
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the purchase details: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return purchase_details;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
    public ObservableList<TransactionDetail> getPurchaseDetails() {
        return purchase_details;
    }
    
}
