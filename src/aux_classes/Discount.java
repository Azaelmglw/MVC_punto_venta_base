package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Discount {
    protected SimpleStringProperty id;
    protected SimpleStringProperty name;
    protected SimpleStringProperty applied_percentage;
    protected SimpleStringProperty type;
    
    public Discount(Stack<String> discount_data) {
        this.id = new SimpleStringProperty(discount_data.pop());
        this.name = new SimpleStringProperty(discount_data.pop());
        this.applied_percentage = new SimpleStringProperty(discount_data.pop());
        this.type = new SimpleStringProperty(discount_data.pop());
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

    public String getApplied_percentage() {
        return applied_percentage.get();
    }

    public void setApplied_percentage(String applied_percentage) {
        this.applied_percentage.set(applied_percentage);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
