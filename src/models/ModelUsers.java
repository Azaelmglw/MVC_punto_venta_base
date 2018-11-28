package models;

import java.sql.SQLException;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.User;

/**
 *
 * @author azaelmglw
 */

public class ModelUsers {
    private final ModelMain model_main;
    
    private Stack<String> user_data = new Stack<>();
    private ObservableList<User> users_data = FXCollections.observableArrayList();
    
    public ModelUsers(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ObservableList<User> ObtainUsersData(String rows_showed, int offset_rows){
        try{
            getModelMain().PSQLPrepareStatement("SELECT * FROM usuarios ORDER BY usuarioid LIMIT ? OFFSET ?;");
            getModelMain().getPSQLPreparedStatement().setInt(1, Integer.parseInt(rows_showed));
            getModelMain().getPSQLPreparedStatement().setInt(2, offset_rows);
            getModelMain().PSQLExecuteQueryPS();
            
            while(getModelMain().getPSQLResult_Set().next()){
                user_data.push(getModelMain().getPSQLResult_Set().getString("curp"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("numero_seguro"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("numero_interior"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("rfc"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("tipo"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("sucursalid"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("activo_usuario"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("estado"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("ciudad"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("email"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("codigo_postal"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("numero_exterior"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("colonia"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("calle"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("telefono"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("apellido_materno"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("apellido_paterno"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("nombre"));
                user_data.push(getModelMain().getPSQLResult_Set().getString("usuarioid"));
                users_data.add(new User(user_data, getModelMain().getPSQLResult_Set().getBytes("contraseña")));
                
            }
            
        }
        catch(SQLException e){
            getModelMain().getAlert(1).setHeaderText("Error 000: An error has occurred while obtaining the users data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return users_data;
    }
    
    public void ObtainUserDetails(int selected_user){
        user_data.push(users_data.get(selected_user).getCurp());
        user_data.push(users_data.get(selected_user).getInsurance_number());
        user_data.push(users_data.get(selected_user).getState());
        user_data.push(users_data.get(selected_user).getCity());
        user_data.push(users_data.get(selected_user).getPost_address());
        user_data.push(users_data.get(selected_user).getExternal_number());
        user_data.push(users_data.get(selected_user).getInternal_number());
        user_data.push(users_data.get(selected_user).getSuburb());
        user_data.push(users_data.get(selected_user).getStreet());
        user_data.push(users_data.get(selected_user).getRfc());
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
    public Stack<String> getUserData(){
        return user_data;
    }
    
}
