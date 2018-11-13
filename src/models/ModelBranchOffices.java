package models;

import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.util.Stack;

import aux_classes.BranchOffice;
import javafx.collections.FXCollections;

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
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
    public ObservableList<BranchOffice> ObtainBranchOfficesData(){
        try{
            getModelMain().PSQLPrepareStatement("SELECT * FROM sucursales ORDER BY sucursalid;");
            getModelMain().PSQLExecuteQueryPS();
            getModelMain().getPSQLResult_Set().first();
            
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
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the branch offices data:" + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return branch_offices_data;
    }
}
