package aux_classes;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Client extends Person {
    private final SimpleStringProperty discount_id;
    private final SimpleStringProperty rfc;
    private final SimpleStringProperty internal_number;
    private final SimpleStringProperty creation_date;
    private final SimpleStringProperty acumulated_total;
    
    public Client(ArrayList<String> client_data) {
        super(client_data);
        this.discount_id = new SimpleStringProperty(client_data.get(13));
        this.rfc = new SimpleStringProperty(client_data.get(14));
        this.internal_number = new SimpleStringProperty(client_data.get(15));
        this.creation_date = new SimpleStringProperty(client_data.get(16));
        this.acumulated_total = new SimpleStringProperty(client_data.get(17)); 
    }
    
}
