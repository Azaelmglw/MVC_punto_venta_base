package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class BranchOffice {
    private SimpleStringProperty id;
    private SimpleStringProperty number;
    private SimpleStringProperty suburb;
    private SimpleStringProperty post_address;
    private SimpleStringProperty email;
    private SimpleStringProperty phone_number;
    private SimpleStringProperty city;
    private SimpleStringProperty state;
    private SimpleStringProperty active;
    
    public BranchOffice(Stack<String> branch_office_data) {
        this.id  = new SimpleStringProperty(branch_office_data.pop());
        this.number = new SimpleStringProperty(branch_office_data.pop());
        this.suburb = new SimpleStringProperty(branch_office_data.pop());
        this.post_address = new SimpleStringProperty(branch_office_data.pop());
        this.email = new SimpleStringProperty(branch_office_data.pop());
        this.phone_number = new SimpleStringProperty(branch_office_data.pop());
        this.city = new SimpleStringProperty(branch_office_data.pop());
        this.state = new SimpleStringProperty(branch_office_data.pop());
        this.active = new SimpleStringProperty(branch_office_data.pop());
    }  

    public String getId() {
        return id.get();
    }

    public String getNumber() {
        return number.get();
    }

    public String getSuburb() {
        return suburb.get();
    }

    public String getPost_address() {
        return post_address.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPhone_number() {
        return phone_number.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getState() {
        return state.get();
    }

    public String getActive() {
        return active.get();
    }
    
}


