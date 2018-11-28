package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Product {
    protected SimpleStringProperty id;
    protected SimpleStringProperty name;
    protected SimpleStringProperty type;
    protected SimpleStringProperty brand;
    protected SimpleStringProperty sale_price;
    protected SimpleStringProperty meassurement_unit;
    protected SimpleStringProperty active;
    
    public Product(Stack<String> product_data){
        this.id = new SimpleStringProperty(product_data.pop());
        this.name = new SimpleStringProperty(product_data.pop());
        this.type = new SimpleStringProperty(product_data.pop());
        this.brand = new SimpleStringProperty(product_data.pop());
        this.sale_price = new SimpleStringProperty(product_data.pop());
        this.meassurement_unit = new SimpleStringProperty(product_data.pop());
        this.active = new SimpleStringProperty(product_data.pop());
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getSale_price() {
        return sale_price.get();
    }

    public void setSale_price(String sale_price) {
        this.sale_price.set(sale_price);
    }

    public String getMeassurement_unit() {
        return meassurement_unit.get();
    }

    public void setMeassurement_unit(String meassurement_unit) {
        this.meassurement_unit.set(meassurement_unit);
    }

    public String getActive() {
        return active.get();
    }

    public void setActive(String active) {
        this.active.set(active);
    }
}
