package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class SeasonalDiscount extends Discount {
    private SimpleStringProperty seasonal_discount_id;
    private SimpleStringProperty initiation_date;
    private SimpleStringProperty expiration_date;
    
    public SeasonalDiscount(Stack<String> seasonal_discount_data){
        super(seasonal_discount_data);
        this.seasonal_discount_id = new SimpleStringProperty(seasonal_discount_data.get(4));
        this.initiation_date = new SimpleStringProperty(seasonal_discount_data.get(5));
        this.expiration_date = new SimpleStringProperty(seasonal_discount_data.get(6));
    }
    
}
