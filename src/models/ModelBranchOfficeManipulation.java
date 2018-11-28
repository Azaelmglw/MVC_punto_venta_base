package models;

import aux_classes.BranchOffice;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import aux_classes.User;
import java.sql.SQLException;

/**
 *
 * @author azaelmglw
 */

public class ModelBranchOfficeManipulation {
    private final ModelMain model_main;
    
    private Stack<String> manager_data = new Stack<>();
    private ObservableList<User> managers_data = FXCollections.observableArrayList();
    private ObservableList<User> assigned_managers = FXCollections.observableArrayList();
    
    private BranchOffice branch_office;
    
    public ModelBranchOfficeManipulation(ModelMain model_main) {
        this.model_main = model_main;
        this.branch_office = new BranchOffice(model_main);
    }
    
    public void UpdateBranchOfficeData() {
        try {
            if((BranchOffice)getModelMain().getTransferible_object() == null) {
                branch_office.setId(branch_office.GenerateNewBranchOfficeId());
                getModelMain().PSQLPrepareTransactionStatement("INSERT INTO sucursales(SucursalID, Numero, Colonia, Codigo_Postal, Email, Telefono, Ciudad, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
                getModelMain().getPSQLPreparedStatement().setString(1, branch_office.getId());
                getModelMain().getPSQLPreparedStatement().setString(2, branch_office.getNumber());
                getModelMain().getPSQLPreparedStatement().setString(3, branch_office.getSuburb());
                getModelMain().getPSQLPreparedStatement().setString(4, branch_office.getPost_address());
                getModelMain().getPSQLPreparedStatement().setString(5, branch_office.getEmail());
                getModelMain().getPSQLPreparedStatement().setString(6, branch_office.getPhone_number());
                getModelMain().getPSQLPreparedStatement().setString(7, branch_office.getCity());
                getModelMain().getPSQLPreparedStatement().setString(8, branch_office.getState());
                
                InsertBranchOfficeManagers();
                
                
            }
            else {
                branch_office = (BranchOffice)getModelMain().getTransferible_object();
                getModelMain().PSQLPrepareTransactionStatement("UPDATE sucursales SET numero = ?, colonia = ?, codigo_postal = ?, email = ?, telefono = ?, ciudad = ?, estado = ? WHERE sucursalid = ?;");
                getModelMain().getPSQLPreparedStatement().setString(1, branch_office.getNumber());
                getModelMain().getPSQLPreparedStatement().setString(2, branch_office.getSuburb());
                getModelMain().getPSQLPreparedStatement().setString(3, branch_office.getPost_address());
                getModelMain().getPSQLPreparedStatement().setString(4, branch_office.getEmail());
                getModelMain().getPSQLPreparedStatement().setString(5, branch_office.getPhone_number());
                getModelMain().getPSQLPreparedStatement().setString(6, branch_office.getCity());
                getModelMain().getPSQLPreparedStatement().setString(7, branch_office.getState());
                getModelMain().getPSQLPreparedStatement().setString(8, branch_office.getId());
                
                
            }
            getModelMain().PSQLExecuteUpdatePS();
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: A problem has ocurred while obtaining the managers data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
    }
    
    public ObservableList<User> ObtainManagersData() {
        try {
            if(getModelMain().getTransferible_object() == null) {
                getModelMain().PSQLPrepareStatement("SELECT * FROM Managers;");
                getModelMain().PSQLExecuteQueryPS();

                while (getModelMain().getPSQLResult_Set().next()) {
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("curp"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("numero_seguro"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("numero_interior"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("rfc"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("tipo"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("sucursalid"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("activo_usuario"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("estado"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("ciudad"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("email"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("codigo_postal"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("numero_exterior"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("colonia"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("calle"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("telefono"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("apellido_materno"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("apellido_paterno"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("nombre"));
                    manager_data.push(getModelMain().getPSQLResult_Set().getString("usuarioid"));
                    managers_data.add(new User(manager_data, getModelMain().getPSQLResult_Set().getBytes("contraseña")));
                
                }
            }
            else {
                branch_office = (BranchOffice)getModelMain().getTransferible_object();
                getModelMain().PSQLPrepareStatement("SELECT usuarioid FROM gerentes_sucursal WHERE sucursalid = ? ORDER BY gensucid DESC;");
                getModelMain().getPSQLPreparedStatement().setString(1, branch_office.getId());
                getModelMain().PSQLExecuteQueryPS();
                
                while(getModelMain().getPSQLResult_Set().next()) {
                    getModelMain().PSQLPrepareStatement("SELECT * FROM Managers WHERE usuarioid = ?;");
                    getModelMain().getPSQLPreparedStatement().setString(1, getModelMain().getPSQLResult_Set().getString("usuarioid"));
                    getModelMain().PSQLExecuteQueryPS_2();
                    
                    while(getModelMain().getPSQLResult_Set_2().next()) {
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("curp"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("numero_seguro"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("numero_interior"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("rfc"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("tipo"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("sucursalid"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("activo_usuario"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("estado"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("ciudad"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("email"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("codigo_postal"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("numero_exterior"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("colonia"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("calle"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("telefono"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("apellido_materno"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("apellido_paterno"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("nombre"));
                        manager_data.push(getModelMain().getPSQLResult_Set_2().getString("usuarioid"));
                        managers_data.add(new User(manager_data, getModelMain().getPSQLResult_Set_2().getBytes("contraseña")));
                    }
                    
                }
                
            }
            
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: A problem has ocurred while obtaining the managers data: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
        return managers_data;
    }
    
    public void InsertBranchOfficeManagers() {
        try {  
            for (int x = 0; !managers_data.isEmpty(); x++) {
                getModelMain().PSQLPrepareStatement("INSERT INTO gerentes_sucursal(gensucid, sucursalid, usuarioid) VALUES(?, ?, ?);");
                getModelMain().getPSQLPreparedStatement().setString(1, branch_office.GenerateNewBranchOfficeManagerId());
                getModelMain().getPSQLPreparedStatement().setString(2, branch_office.getId());
                getModelMain().getPSQLPreparedStatement().setString(3, managers_data.get(x).getId());
                getModelMain().PSQLExecuteUpdatePS();
            }
        }
        catch(SQLException e) {
            getModelMain().getAlert(1).setHeaderText("Error 000: A problem has ocurred while assigning the new manager: " + e);
            getModelMain().getAlert(1).showAndWait();
        }
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
    public ObservableList<User> getAssignedManagers() {
        return assigned_managers;
    }
    
    public void setAssignedManagers(User selected_manager) {
        if(assigned_managers.contains(selected_manager)) {
            System.out.println("Manager Already Assigned");
        }
        else {
            assigned_managers.add(selected_manager);
            getModelMain().getAlert(2).setHeaderText("El Usuario " + selected_manager.getFull_name() + " con clave " + selected_manager.getId() + "\nha sido asignado exitosamente.");
            getModelMain().getAlert(2).showAndWait();
        }
    }
    
    public ObservableList<User> getManagersData() {
        return managers_data;
    }
    
    public BranchOffice getBranchOffice() {
        return branch_office;
    }
   
}
