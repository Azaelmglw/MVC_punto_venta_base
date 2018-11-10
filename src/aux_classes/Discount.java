package aux_classes;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Discount {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty applied_percentage;
    private SimpleStringProperty type;
    
    public Discount(ArrayList<String> discount_data) {
        this.id = new SimpleStringProperty(discount_data.get(0));
        this.name = new SimpleStringProperty(discount_data.get(1));
        this.applied_percentage = new SimpleStringProperty(discount_data.get(2));
        this.type = new SimpleStringProperty(discount_data.get(3));
        
    }
}
