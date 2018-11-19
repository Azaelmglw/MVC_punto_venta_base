package models;

import java.sql.SQLException;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.Discount;

/**
 *
 * @author azaelmglw
 */

public class ModelDiscounts {
    private final ModelMain model_main;
    
    private Stack<String> discount_data = new Stack();
    private ObservableList<Discount> discounts_data = FXCollections.observableArrayList();
    
    public ModelDiscounts(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ObservableList<Discount> ObtainDiscountsData(String rows_showed, int offset_rows) {
        try {
            getModelMain().PSQLPrepareStatement("SELECT * FROM descuentos ORDER BY descuentoid LIMIT ? OFFSET ?");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()){
                discount_data.push(getModelMain().getPSQLResult_Set().getString("tipo"));
                discount_data.push(getModelMain().getPSQLResult_Set().getString("porcentaje_aplicado"));
                discount_data.push(getModelMain().getPSQLResult_Set().getString("nombre_descuento"));
                discount_data.push(getModelMain().getPSQLResult_Set().getString("descuentoid"));
                discounts_data.add(new Discount(discount_data));
            }
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the discounts data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return discounts_data;
    }
    
    public String ObtainDiscountDetails(Discount selected_discount){
        String description = "";
        try {
            if(selected_discount.getType().equals("Acumulado")) {
                getModelMain().PSQLPrepareStatement("SELECT * FROM descuentos_acumulado WHERE descuentoid = ?;");
                getModelMain().getPSQLPreparedStatement().setString(1, selected_discount.getId());
                getModelMain().PSQLExecuteQueryPS();
                getModelMain().getPSQLResult_Set().first();
                description += "Accumulation Flag -> " + getModelMain().getPSQLResult_Set().getString("bandera_acumulacion") + ".\n" +
                "Active -> " + getModelMain().getPSQLResult_Set().getString("activo_descuento") + ".\n";
            }
            else {
                getModelMain().PSQLPrepareStatement("SELECT * FROM descuentos_temporada WHERE descuentoid = ?;");
                getModelMain().getPSQLPreparedStatement().setString(1, selected_discount.getId());
                getModelMain().PSQLExecuteQueryPS();
                getModelMain().getPSQLResult_Set().first();
                description += "Launch Date -> " + getModelMain().getPSQLResult_Set().getString("fecha_inicio") + ".\n" +
                "Expiration Date -> " + getModelMain().getPSQLResult_Set().getString("fecha_expiracion") + ".\n";
            }
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the discount's details: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return description;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
}