package models;

import java.sql.SQLException;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.Client;

/**
 *
 * @author azaelmglw
 */

public class ModelClients {
    private final ModelMain model_main;
    
    private Stack<String> client_data = new Stack<>();
    private ObservableList<Client> clients_data = FXCollections.observableArrayList();
    
    public ModelClients(ModelMain model_main){
        this.model_main = model_main;  
    }
    
    public ObservableList<Client> ObtainClientsData(String rows_showed, int offset_rows){
        try{
            getModelMain().PSQLPrepareStatement("SELECT * FROM clientes ORDER BY clienteid LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()){
                client_data.push(getModelMain().getPSQLResult_Set().getString("total_acumulado"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("fecha_creacion"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("numero_interior"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("rfc"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("descuentoid"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("activo_cliente"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("estado"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("ciudad"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("email"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("codigo_postal"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("numero_exterior"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("colonia"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("calle"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("telefono"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("apellido_materno"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("apellido_paterno"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("nombre"));
                client_data.push(getModelMain().getPSQLResult_Set().getString("clienteid"));
                clients_data.add(new Client(client_data));
            }
            
        }
        catch(SQLException e){
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the clients data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return clients_data;
    }
    
    public void ObtainClientDetails(int selected_client){
        client_data.push(clients_data.get(selected_client).getState());
        client_data.push(clients_data.get(selected_client).getCity());
        client_data.push(clients_data.get(selected_client).getPostAddress());
        client_data.push(clients_data.get(selected_client).getExternal_number());
        client_data.push(clients_data.get(selected_client).getInternal_number());
        client_data.push(clients_data.get(selected_client).getSuburb());
        client_data.push(clients_data.get(selected_client).getStreet());
        client_data.push(clients_data.get(selected_client).getRfc());
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
    public Stack<String> getClientData(){
        return client_data;
    }
    
}
