package models;

import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.Product;
import aux_classes.ProductStock;
import java.sql.SQLException;

/**
 *
 * @author azaelmglw
 */

public class ModelProducts {
    private final ModelMain model_main;
    
    private Stack<String> product_data = new Stack<>();
    private ObservableList<Product> products_data = FXCollections.observableArrayList();
    private ObservableList<ProductStock> product_stock = FXCollections.observableArrayList();
    
    public ModelProducts(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ObservableList<Product> ObtainProductsData(String rows_showed, int offset_rows){
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM productos ORDER BY productoid LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()){
                product_data.push(getModelMain().getPSQLResult_Set().getString("activo_producto"));
                product_data.push(getModelMain().getPSQLResult_Set().getString("unidad_medida"));
                product_data.push("" + getModelMain().getPSQLResult_Set().getDouble("precio_venta"));
                product_data.push(getModelMain().getPSQLResult_Set().getString("marca"));
                product_data.push(getModelMain().getPSQLResult_Set().getString("tipo"));
                product_data.push(getModelMain().getPSQLResult_Set().getString("nombre"));
                product_data.push(getModelMain().getPSQLResult_Set().getString("productoid"));
                products_data.add(new Product(product_data));
            }
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the products data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return products_data;
    }
    
    public ObservableList<ProductStock> ObtainProductStock(Product selected_product){
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM obtain_product_branch_offices_stock(?);");
            getModelMain().getPSQLPreparedStatement().setString(1, selected_product.getId());
            getModelMain().PSQLExecuteQueryPS();

            while(getModelMain().getPSQLResult_Set().next()) {
                product_data.push(getModelMain().getPSQLResult_Set().getString("stock"));
                product_data.push(getModelMain().getPSQLResult_Set().getString("branch_office"));
                product_stock.add(new ProductStock(product_data));
            }
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the product's stock: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return product_stock;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
    public ObservableList<Product> getProductsData() {
        return products_data;
    }
    
    public ObservableList<ProductStock> getProductStock() {
        return product_stock;
    }
    
}
