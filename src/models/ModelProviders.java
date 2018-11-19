package models;

import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.Provider;
import java.sql.SQLException;

/**
 *
 * @author azaelmglw
 */

public class ModelProviders {
    private final ModelMain model_main;
    
    private Stack<String> provider_data = new Stack<>();
    private ObservableList<Provider> providers_data = FXCollections.observableArrayList();
    
    public ModelProviders(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ObservableList<Provider> ObtainProvidersData(String rows_showed, int offset_rows) {
        try{
            getModelMain().PSQLPrepareStatement("SELECT * FROM proveedores ORDER BY proveedorid LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()){
                provider_data.push(getModelMain().getPSQLResult_Set().getString("empresa"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("activo_proveedor"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("estado"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("ciudad"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("email"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("codigo_postal"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("numero"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("colonia"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("calle"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("telefono"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("apellido_materno"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("apellido_paterno"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("nombre"));
                provider_data.push(getModelMain().getPSQLResult_Set().getString("proveedorid"));
                providers_data.add(new Provider(provider_data));
            }
        }
        catch(SQLException e){
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the branch offices data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return providers_data;
    }
    
    public void ObtainProviderDetails(int selected_provider){
        provider_data.push(providers_data.get(selected_provider).getState());
        provider_data.push(providers_data.get(selected_provider).getCity());
        provider_data.push(providers_data.get(selected_provider).getPostAddress());
        provider_data.push(providers_data.get(selected_provider).getExternal_number());
        provider_data.push(providers_data.get(selected_provider).getSuburb());
        provider_data.push(providers_data.get(selected_provider).getStreet());
    }

    public ModelMain getModelMain(){
        return model_main;
    }
    
    public Stack<String> getProviderData(){
        return provider_data;
    }
}
