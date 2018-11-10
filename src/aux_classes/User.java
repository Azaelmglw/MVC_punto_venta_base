package aux_classes;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class User extends Person {
    private final SimpleStringProperty branch_office_id;
    private final SimpleStringProperty type;
    private final SimpleStringProperty rfc;
    private final SimpleStringProperty internal_number;
    private final SimpleStringProperty insurance_number;
    private final SimpleStringProperty curp;
    private final byte[] password;
    
    public User(ArrayList<String> user_data, byte[] password) {
        super(user_data);
        this.branch_office_id = new SimpleStringProperty(user_data.get(13));
        this.type = new SimpleStringProperty(user_data.get(14));
        this.rfc = new SimpleStringProperty(user_data.get(15));
        this.internal_number = new SimpleStringProperty(user_data.get(16));
        this.insurance_number = new SimpleStringProperty(user_data.get(17));
        this.curp = new SimpleStringProperty(user_data.get(18));
        this.password = password;
    }    
}
