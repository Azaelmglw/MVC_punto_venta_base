package aux_classes;

import java.sql.SQLException;
import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;

import models.ModelMain;

/**
 *
 * @author azaelmglw
 */

public class BranchOffice {
    private SimpleStringProperty id;
    private SimpleStringProperty number = new SimpleStringProperty();
    private SimpleStringProperty suburb = new SimpleStringProperty();
    private SimpleStringProperty post_address = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();
    private SimpleStringProperty phone_number = new SimpleStringProperty();
    private SimpleStringProperty city = new SimpleStringProperty();
    private SimpleStringProperty state = new SimpleStringProperty();
    private SimpleStringProperty active = new SimpleStringProperty();
    
    private ModelMain model_main;
    
    public BranchOffice(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public BranchOffice(Stack<String> branch_office_data) {
        this.id  = new SimpleStringProperty(branch_office_data.pop());
        this.number = new SimpleStringProperty(branch_office_data.pop());
        this.suburb = new SimpleStringProperty(branch_office_data.pop());
        this.post_address = new SimpleStringProperty(branch_office_data.pop());
        this.email = new SimpleStringProperty(branch_office_data.pop());
        this.phone_number = new SimpleStringProperty(branch_office_data.pop());
        this.city = new SimpleStringProperty(branch_office_data.pop());
        this.state = new SimpleStringProperty(branch_office_data.pop());
        this.active = new SimpleStringProperty(branch_office_data.pop());
    }  
   
    public String GenerateNewBranchOfficeId() {
        String new_branch_office_id = "";
        int aux_generator;
        try {
            model_main.PSQLPrepareStatement("SELECT sucursalid FROM sucursales ORDER BY sucursalid ASC;");
            model_main.PSQLExecuteQueryPS();
            model_main.getPSQLResult_Set().last();
            
            for(int x = 2; x < model_main.getPSQLResult_Set().getString("sucursalid").length(); x ++) {
                new_branch_office_id += model_main.getPSQLResult_Set().getString("sucursalid").charAt(x);
            }
            aux_generator = Integer.parseInt(new_branch_office_id) + 1;
            new_branch_office_id = "SU" + "" + aux_generator;
            
            System.out.println(new_branch_office_id);
        }
        catch(SQLException e) {
            model_main.getAlert(1).setHeaderText("Error 000: A problem has ocurred while generating the new branch office id: " + e);
            model_main.getAlert(1).showAndWait();
        }
        return new_branch_office_id;
    }
    
    public String GenerateNewBranchOfficeManagerId() {
        String new_branch_office_manager_id = "";
        int aux_generator;
        try {
            model_main.PSQLPrepareTransactionStatement("SELECT gensucid FROM gerentes_sucursal ORDER BY gensucid ASC;");
            model_main.PSQLExecuteTransactionQueryPS();
            model_main.getPSQLResult_Set().first();

            for (int x = 2; x < model_main.getPSQLResult_Set().getString("gensucid").length(); x++) {
                new_branch_office_manager_id += model_main.getPSQLResult_Set().getString("gensucid").charAt(x);
            }
            aux_generator = Integer.parseInt(new_branch_office_manager_id) + 1;
            new_branch_office_manager_id = "GS" + "" + aux_generator;

            System.out.println(new_branch_office_manager_id);
        }
        catch(SQLException e) {
            model_main.getAlert(1).setHeaderText("Error 000: A problem has ocurred while generating the new branch office id: " + e);
            model_main.getAlert(1).showAndWait();
        }
        return new_branch_office_manager_id;
    }
    
    /*public void AssignManagerToNewBranchOffice(User selected_user) {
        try {
            
            model_main.PSQLPrepareStatement("INSERT INTO gerentes_sucursal(gensucid, sucursalid, usuarioid) VALUES(?, ?, ?);");
            model_main.getPSQLPreparedStatement().setString(1, GenerateNewBranchOfficeManagerId(model_main));
            model_main.getPSQLPreparedStatement().setString(2, GenerateNewBranchOfficeId());
            model_main.getPSQLPreparedStatement().setString(3, selected_user.getId());
            model_main.PSQLExecuteUpdatePS();
            
            
        }
        catch(SQLException e) {
            model_main.getAlert(1).setHeaderText("Error 000: A problem has ocurred while assigning the new manager: " + e);
            model_main.getAlert(1).showAndWait();
        }
    }*/

    public String getId() {
        return id.get();
    }
    
    public void setId(String id) {
        if(this.id == null) {
            this.id = new SimpleStringProperty(id);
        }
        else {
            System.out.println("Already defined an Id for the branch_office");
        }
    }

    public String getNumber() {
        return number.get();
    }
    
    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getSuburb() {
        return suburb.get();
    }
    
    public void setSuburb(String suburb) {
        this.suburb.set(suburb);
    }

    public String getPost_address() {
        return post_address.get();
    }
    
    public void setPost_address(String post_address) {
        this.post_address.set(post_address);
    }

    public String getEmail() {
        return email.get();
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone_number() {
        return phone_number.get();
    }
    
    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getCity() {
        return city.get();
    }
    
    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }
    
    public void setState(String state) {
        this.state.set(state);
    }

    public String getActive() {
        return active.get();
    }
    
    public void setActive(String active) {
        this.active.set(active);
    }
    
}


