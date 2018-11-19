package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Purchase extends Transaction {
    private SimpleStringProperty branch_office_id;
    private SimpleStringProperty provider_id;
    private SimpleStringProperty brand;
    
    public Purchase(Stack<String> purchase_data) {
        super(purchase_data);
        this.branch_office_id = new SimpleStringProperty(purchase_data.pop());
        this.provider_id = new SimpleStringProperty(purchase_data.pop());
        this.brand = new SimpleStringProperty(purchase_data.pop());
    }

    public String getBranch_office_id() {
        return branch_office_id.get();
    }

    public void setBranch_office_id(String branch_office_id) {
        this.branch_office_id.set(branch_office_id);
    }

    public String getProvider_id() {
        return provider_id.get();
    }

    public void setProvider_id(String provider_id) {
        this.provider_id.set(provider_id);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
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
