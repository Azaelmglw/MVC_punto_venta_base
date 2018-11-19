package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Sale extends Transaction {
    private SimpleStringProperty  branch_office_id;
    private SimpleStringProperty  client_name;
    private SimpleStringProperty  saved_total;
    
    public Sale(Stack<String> sale_data) {
        super(sale_data);
        this.branch_office_id = new SimpleStringProperty(sale_data.pop());
        this.client_name = new SimpleStringProperty(sale_data.pop());
        this.saved_total = new SimpleStringProperty(sale_data.pop());
    }

    public String getBranch_office_id() {
        return branch_office_id.get();
    }

    public void setBranch_office_id(String branch_office_id) {
        this.branch_office_id.set(branch_office_id);
    }

    public String getClient_name() {
        return client_name.get();
    }

    public void setClient_name(String client_id) {
        this.client_name.set(client_id);
    }

    public String getSaved_total() {
        return saved_total.get();
    }

    public void setSaved_total(String saved_total) {
        this.saved_total.set(saved_total);
    }
    
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getUser_id() {
        return user_id.get();
    }

    public void setUser_id(String user_id) {
        this.user_id.set(user_id);
    }

    public String getUser_name() {
        return user_name.get();
    }

    public void setUser_name(String user_name) {
        this.user_name.set(user_name);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getSubtotal() {
        return subtotal.get();
    }

    public void setSubtotal(String subtotal) {
        this.subtotal.set(subtotal);
    }

    public String getIva() {
        return iva.get();
    }

    public void setIva(String iva) {
        this.iva.set(iva);
    }

    public String getTotal() {
        return total.get();
    }

    public void setTotal(String total) {
        this.total.set(total);
    }
}
