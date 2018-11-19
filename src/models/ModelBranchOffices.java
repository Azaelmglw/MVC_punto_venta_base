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
    
    public void ObtainBranchOfficeDetails(BranchOffice branch_office) {
        try {
            model_main.PSQLPrepareStatement("SELECT * FROM obtain_branch_office_details(?);");
            model_main.getPSQLPreparedStatement().setString(1, branch_office.getId());
            model_main.PSQLExecuteQueryPS();
            model_main.getPSQLResult_Set().first();
            branch_office_data.push(model_main.getPSQLResult_Set().getString("Gained_From_Sales"));
            branch_office_data.push(model_main.getPSQLResult_Set().getString("Spent_In_Purchases"));
            branch_office_data.push(model_main.getPSQLResult_Set().getString("Current_Stock"));
            branch_office_data.push(model_main.getPSQLResult_Set().getString("Current_Providers"));
            branch_office_data.push(model_main.getPSQLResult_Set().getString("Current_Employees"));
            branch_office_data.push(model_main.getPSQLResult_Set().getString("Current_Managers"));
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the selected branch office details: " + e);
            getModelMain().getAlert(1).showAndWait();
        }  
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
    public Stack<String> getBranchOfficeData(){
        return branch_office_data;
    }
}
