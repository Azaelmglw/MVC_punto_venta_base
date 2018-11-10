package aux_classes;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class BranchOffice {
    private SimpleStringProperty id;
    private SimpleStringProperty external_number;
    private SimpleStringProperty suburb;
    private SimpleStringProperty post_address;
    private SimpleStringProperty email;
    private SimpleStringProperty phone_number;
    private SimpleStringProperty city;
    private SimpleStringProperty state;
    private SimpleStringProperty active;
    
    public BranchOffice(ArrayList<String> branch_office_data) {
        this.id  = new SimpleStringProperty(branch_office_data.get(0));
        this.external_number = new SimpleStringProperty(branch_office_data.get(1));
        this.suburb = new SimpleStringProperty(branch_office_data.get(2));
        this.post_address = new SimpleStringProperty(branch_office_data.get(3));
        this.email = new SimpleStringProperty(branch_office_data.get(4));
        this.phone_number = new SimpleStringProperty(branch_office_data.get(5));
        this.city = new SimpleStringProperty(branch_office_data.get(6));
        this.state = new SimpleStringProperty(branch_office_data.get(7));
        this.active = new SimpleStringProperty(branch_office_data.get(8));
    }
}
