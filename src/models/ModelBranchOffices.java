package models;

import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.util.Stack;
import javafx.collections.FXCollections;

import aux_classes.BranchOffice;

/**
 *
 * @author azaelmglw
 */

public class ModelBranchOffices {
    private final ModelMain model_main;
    
    private Stack<String> branch_office_data = new Stack<>();
    private ObservableList<BranchOffice> branch_offices_data = FXCollections.observableArrayList();
    
    public ModelBranchOffices(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ObservableList<BranchOffice> ObtainBranchOfficesData(String rows_showed, int offset_rows){
        try{
            getModelMain().PSQLPrepareStatement("SELECT * FROM sucursales ORDER BY sucursalid LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()){
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("activo_sucursal"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("estado"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("ciudad"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("telefono"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("email"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("codigo_postal"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("colonia"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("numero"));
                branch_office_data.push(getModelMain().getPSQLResult_Set().getString("sucursalid"));
                branch_offices_data.add(new BranchOffice(branch_office_data));
            }
            
        }
        catch(SQLException e){
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the branch offices data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return branch_offices_data;
    }
    
    public String ObtainBranchOfficeDetails(BranchOffice branch_office) {
        String description = "";
        try {
            model_main.PSQLPrepareStatement("SELECT * FROM obtain_branch_office_details(?);");
            model_main.getPSQLPreparedStatement().setString(1, branch_office.getId());
            model_main.PSQLExecuteQueryPS();
            model_main.getPSQLResult_Set().first();
            description += "Current Managers -> " + getModelMain().getPSQLResult_Set().getString("Current_Managers") + ".\n" +
            "Current Employees -> " + getModelMain().getPSQLResult_Set().getString("Current_Employees") + ".\n" +
            "Current Providers -> " + getModelMain().getPSQLResult_Set().getString("Current_Providers") + ".\n" +
            "Current Stock -> " + getModelMain().getPSQLResult_Set().getString("Current_Stock") + ".\n" +
            "Spent In Purchases -> " + getModelMain().getPSQLResult_Set().getString("Spent_In_Purchases") + ".\n" +
            "Gained From Sales -> " + getModelMain().getPSQLResult_Set().getString("Gained_From_Sales") + ".\n";
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the selected branch office details: " + e);
            getModelMain().getAlert(1).showAndWait();
        }  
        return description;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
    public Stack<String> getBranchOfficeData(){
        return branch_office_data;
    }
}
