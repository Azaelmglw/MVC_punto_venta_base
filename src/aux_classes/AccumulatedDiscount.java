package aux_classes;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class AccumulatedDiscount extends Discount {
    private SimpleStringProperty accumulated_discount_id;
    private SimpleStringProperty accumulation_flag;
    private SimpleStringProperty active;
    
    public AccumulatedDiscount(ArrayList<String> accumulated_discount_data) {
        super(accumulated_discount_data);
        this.accumulated_discount_id = new SimpleStringProperty(accumulated_discount_data.get(4));
        this.accumulation_flag = new SimpleStringProperty(accumulated_discount_data.get(5));
        this.active = new SimpleStringProperty(accumulated_discount_data.get(6));
    }
    
}
