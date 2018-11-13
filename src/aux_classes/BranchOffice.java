package aux_classes;

import java.util.Stack;
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
    
    public BranchOffice(Stack<String> branch_office_data) {
        this.id  = new SimpleStringProperty(branch_office_data.pop());
        this.external_number = new SimpleStringProperty(branch_office_data.pop());
        this.suburb = new SimpleStringProperty(branch_office_data.pop());
        this.post_address = new SimpleStringProperty(branch_office_data.pop());
        this.email = new SimpleStringProperty(branch_office_data.pop());
        this.phone_number = new SimpleStringProperty(branch_office_data.pop());
        this.city = new SimpleStringProperty(branch_office_data.pop());
        this.state = new SimpleStringProperty(branch_office_data.pop());
        this.active = new SimpleStringProperty(branch_office_data.pop());
    }  
}
