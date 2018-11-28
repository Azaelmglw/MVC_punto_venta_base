package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Person {
    protected SimpleStringProperty id;
    protected SimpleStringProperty first_name;
    protected SimpleStringProperty middle_name;
    protected SimpleStringProperty last_name;
    protected SimpleStringProperty full_name;
    protected SimpleStringProperty phone_number;
    protected SimpleStringProperty street;
    protected SimpleStringProperty suburb;
    protected SimpleStringProperty external_number;
    protected SimpleStringProperty post_address;
    protected SimpleStringProperty email;
    protected SimpleStringProperty city;
    protected SimpleStringProperty state;
    protected SimpleStringProperty active;
    
    public Person(Stack<String> person_data){
        this.id = new SimpleStringProperty(person_data.pop());
        this.first_name = new SimpleStringProperty(person_data.pop());
        this.middle_name = new SimpleStringProperty(person_data.pop());
        this.last_name = new SimpleStringProperty(person_data.pop());
        this.full_name = new SimpleStringProperty(String.join(" ", first_name.get(), middle_name.get(), last_name.get()));
        this.phone_number = new SimpleStringProperty(person_data.pop());
        this.street = new SimpleStringProperty(person_data.pop());
        this.suburb = new SimpleStringProperty(person_data.pop());
        this.external_number = new SimpleStringProperty(person_data.pop());
        this.post_address = new SimpleStringProperty(person_data.pop());
        this.email = new SimpleStringProperty(person_data.pop());
        this.city = new SimpleStringProperty(person_data.pop());
        this.state = new SimpleStringProperty(person_data.pop());
        this.active = new SimpleStringProperty(person_data.pop());
    }
}