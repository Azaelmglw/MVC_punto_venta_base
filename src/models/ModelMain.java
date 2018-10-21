package models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

/**
 *
 * @author Azaelmglw
 */

public class ModelMain {
    /*  Parents array list position:
    [0] -> main    |   [1] -> main_menu |  [2] -> terminal_menu |  [3] -> console_menu | [4] -> users 
    [5] -> clients | 
    */
    
    /*  Alerts array list position:
    [0] -> confirmation_alert   |   [1] -> error_alert  |
    */
  
    /*  Ecrypting variables array list position:
    [0] -> string_builder   |   [2] -> encryption_type
    */
    
    /*  Activation Bools array list position:
    [0] -> main_bool            |   [1] -> main_menu_bool   |   [2] -> terminal_menu_bool   |
    [3] -> console_menu_bool    |   [4] -> users_bool       |   [5] -> clients_bool         | 
    */
    
    /*  Table Models array list position:
    [0] -> users_table  |   clients_table   |
    */
    
    /*  User Input array list position:
    [0] -> username |   [1] -> password
    */
    
    private final Stage primaryStage;
    
    /*  There are some events that would've unefficient to link to a button or some of the other basic
    controls, in this case, we want to load the users data without the need of a button and that's why
    we use <<BooleanProperties>> that can then be put into a listener which will fire an event whenever
    the value of the Property is changed.
    This way we can manage by code the exact moment when we want to load the mayority of the tables data.
    */
    
    private BooleanProperty main_bool = new SimpleBooleanProperty(false);
    private BooleanProperty users_bool = new SimpleBooleanProperty(false);
   
    private Connection psql_connection;
    private PreparedStatement psql_prepared_statement;
    private CallableStatement psql_callable_statement;
    private ResultSet psql_result_set;
    private String psql_query;
    
    private List<Parent> parents = new ArrayList<>(20);
    private List<TextFormatter> text_formatters = new ArrayList<>(20);
    private List<Alert> alerts = new ArrayList<>(20);
    private List<String> user_input = new ArrayList<>(5);
    
    
    public ModelMain(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public boolean VerifyUser() {
        try {
            MessageDigest cipher = MessageDigest.getInstance("SHA-256");
            byte[] hash = cipher.digest(user_input.get(1).getBytes(StandardCharsets.UTF_8));
            
            PSQLPrepareStatement("SELECT COUNT(userid) AS Verified FROM Users WHERE userid = ? AND user_password = ?;");
            getPSQLPreparedStatement().setString(1, user_input.get(0));
            getPSQLPreparedStatement().setBytes(2, hash);
            PSQLExecuteQueryPS();
            
            getPSQLResult_Set().first();
            if(getPSQLResult_Set().getInt("Verified") == 1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while connecting to the database. " + e);
            getAlert(1).showAndWait();
        }
        catch(NoSuchAlgorithmException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while connecting to the database. " + e);
            getAlert(1).showAndWait();
        }
        return false;
    } 
    
    public void Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            psql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SOPV_OMMEGA", "postgres", "postgres");
        } 
        catch (SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while connecting to the database. " + e);
            getAlert(1).showAndWait();
        } 
        catch (ClassNotFoundException e) {
            getAlert(1).setHeaderText("Error 000:  I don't even know man " + e);
            getAlert(1).showAndWait();
        }
    } 
    
    public void PSQLPrepareStatement(String psql_query){
        try {
            Connect();
            psql_prepared_statement = psql_connection.prepareStatement(psql_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while preparing the statement " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLExecuteQueryPS() {
        try {
            Connect();
            psql_result_set = psql_prepared_statement.executeQuery();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the query: " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLExecuteUpdatePS() {
        try {
            psql_prepared_statement.executeQuery();
            psql_connection.close();
            psql_prepared_statement.close();
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the update: " + e);
            getAlert(1).showAndWait();
        }
        
    }
    
    public void PSQLExecuteSentenece(){
        try{
            psql_prepared_statement.execute();
            psql_connection.close();
            psql_prepared_statement.close();
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the sentence: " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLPrepareCallCS(){
        try {
            Connect();
            psql_callable_statement = psql_connection.prepareCall(psql_query);
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while preparing the call " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLExecuteCall() {
        try {
            psql_callable_statement.execute();
            psql_callable_statement.close();
            psql_connection.close();
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the call " + e);
            getAlert(1).showAndWait();
        }
        
    }
    
    public PreparedStatement getPSQLPreparedStatement(){
        return psql_prepared_statement;
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Parent getParent(int parent_position) {
        return parents.get(parent_position);
    }

    public void setParent(int parent_position, Parent parent) {
        this.parents.add(parent_position, parent);
    }
    
    public TextFormatter getTextFormatter(int text_formatter_position){
        return text_formatters.get(text_formatter_position);
    }
    
    public void setTextFormatter(int text_formatter_position, TextFormatter text_formatter){
        this.text_formatters.add(text_formatter_position, text_formatter);
    }
    
    public Alert getAlert(int alert_position){
        return this.alerts.get(alert_position);
    }
    
    public void setAlert(int alert_position, Alert alert){
        this.alerts.add(alert_position, alert);
    }
    
    public ResultSet getPSQLResult_Set(){
        return psql_result_set;
    }
    
    public BooleanProperty getMainBool(){
        return main_bool;
    }
    
    public void setMainBool(boolean bool_value){
        main_bool.setValue(bool_value);
    }
    
    public BooleanProperty getUsersBool(){
        return users_bool;
    }
    
    public void setUsersBool(boolean bool_value){
        users_bool.setValue(bool_value);
    }

    public String getUser_Input(int input_position) {
        return user_input.get(input_position);
    }

    public void setUser_Input(int input_position, String user_input) {
        this.user_input.add(input_position, user_input);
    }       
}