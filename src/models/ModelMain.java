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
    [0] -> main             |   [1] -> main_menu    |   [2] -> console_menu |   [3] -> terminal_menu    |   
    [4] -> branch_offices   |   [5] -> providers    |   [6] -> users        |   [7] -> clients          |
    [8] -> products         |   [9] -> discounts    |   [10] -> purchases   |   [11] -> sales           |
    [12] -> reports         |
    */
    
    /*  Text Formatters array list position:
    [0] -> username_formatter   |   [1] -> user_password_formatter  |*/
    
    /*  Alerts array list position:
    [0] -> confirmation_alert   |   [1] -> error_alert  |
    */
    
    /*  User Input array list position:
    [0] -> username |   [1] -> password |
    */
    
    private final Stage primaryStage;
        
    private ArrayList<BooleanProperty> ui_bools = new ArrayList<>();
    
    private Object transferible_object;
    
    private Connection psql_connection;
    private PreparedStatement psql_prepared_statement;
    private CallableStatement psql_callable_statement;
    private ResultSet psql_result_set;
    private ResultSet psql_result_set_2;
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
            
            PSQLPrepareStatement("SELECT COUNT(UsuarioID) AS Verified FROM Usuarios WHERE UsuarioID = ? AND contraseña = ?;");
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
            psql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ACMEdb", "azaelmglw", "pos");
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
            psql_connection.setAutoCommit(true);
            psql_prepared_statement = psql_connection.prepareStatement(psql_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch(SQLException e){
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while preparing the statement " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLPrepareTransactionStatement(String psql_query) {
        try {            
            Connect();
            psql_connection.setAutoCommit(false);
            psql_prepared_statement = psql_connection.prepareStatement(psql_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while preparing the transaction statement " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLExecuteQueryPS() {
        try {
            psql_result_set = psql_prepared_statement.executeQuery();
            psql_connection.close();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the query: " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLExecuteQueryPS_2() {
        try {
            psql_result_set_2 = psql_prepared_statement.executeQuery();
            psql_connection.close();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the query: " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLExecuteTransactionQueryPS() {
        try {
            psql_result_set = psql_prepared_statement.executeQuery();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the transaction query: " + e);
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
    
    public void PSQLExecuteTransactionUpdate() {
        try {
            psql_prepared_statement.executeUpdate();
            psql_prepared_statement.close();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the transaction update: " + e);
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
    
    public void PSQLExecuteTransactionSentence() {
        try {
            psql_prepared_statement.execute();
            psql_prepared_statement.close();  
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while executing the transaction sentence: " + e);
            getAlert(1).showAndWait();
        }
    }
    
    public void PSQLCommitTransaction() {
        try {
            psql_connection.commit();
            psql_connection.setAutoCommit(true);
            psql_connection.close();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while commiting the transaction: " + e);
            getAlert(1).showAndWait();
        } 
    }
    
    public void PSQLRollbackTransaction() {
        try {
            psql_connection.rollback();
            psql_connection.setAutoCommit(true);
            psql_connection.close();
        }
        catch(SQLException e) {
            getAlert(1).setHeaderText("Error 000: A problem has ocurred while rollbacking the transaction: " + e);
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
    
    public ResultSet getPSQLResult_Set(){
        return psql_result_set;
    }
    
    public ResultSet getPSQLResult_Set_2(){
        return psql_result_set;
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
    
    public BooleanProperty getUI_Bool(int bool_position) {
        return ui_bools.get(bool_position);
    }
    
    public void setUI_Bool(int bool_position, BooleanProperty ui_bool) {
        ui_bools.add(bool_position, ui_bool);
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

    public Object getTransferible_object() {
        return transferible_object;
    }

    public void setTransferible_object(Object transferible_object) {
        this.transferible_object = transferible_object;
    }

    public String getUser_Input(int input_position) {
        return user_input.get(input_position);
    }

    public void setUser_Input(int input_position, String user_input) {
        this.user_input.add(input_position, user_input);
    }       
}