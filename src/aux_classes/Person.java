package aux_classes;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Person {
    private SimpleStringProperty id;
    private SimpleStringProperty first_name;
    private SimpleStringProperty middle_name;
    private SimpleStringProperty last_name;
    private SimpleStringProperty phone_number;
    private SimpleStringProperty street;
    private SimpleStringProperty suburb;
    private SimpleStringProperty external_number;
    private SimpleStringProperty post_address;
    private SimpleStringProperty email;
    private SimpleStringProperty city;
    private SimpleStringProperty state;
    private SimpleStringProperty active;
    
    public Person(ArrayList<String> person_data){
        this.id = new SimpleStringProperty(person_data.get(0));
        this.first_name = new SimpleStringProperty(person_data.get(1));
        this.middle_name = new SimpleStringProperty(person_data.get(2));
        this.last_name = new SimpleStringProperty(person_data.get(3));
        this.phone_number = new SimpleStringProperty(person_data.get(4));
        this.street = new SimpleStringProperty(person_data.get(5));
        this.suburb = new SimpleStringProperty(person_data.get(6));
        this.external_number = new SimpleStringProperty(person_data.get(7));
        this.post_address = new SimpleStringProperty(person_data.get(8));
        this.email = new SimpleStringProperty(person_data.get(9));
        this.city = new SimpleStringProperty(person_data.get(10));
        this.state = new SimpleStringProperty(person_data.get(11));
        this.active = new SimpleStringProperty(person_data.get(12));
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return first_name.get();
    }

    public void setFirstName(String first_name) {
        this.first_name.set(first_name);
    }

    public String getMiddleName() {
        return middle_name.get();
    }

    public void setMiddleName(String middle_name) {
        this.middle_name.set(middle_name);
    }

    public String getLastName() {
        return last_name.get();
    }

    public void setLastName(String last_name) {
        this.last_name.set(last_name);
    }

    public String getPhoneNumber() {
        return phone_number.get();
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getSuburb() {
        return suburb.get();
    }

    public void setSuburb(String suburb) {
        this.suburb.set(suburb);
    }

    public String getExternalNumber() {
        return external_number.get();
    }

    public void setExternal_number(String external_number) {
        this.external_number.set(external_number);
    }

    public String getPostAddress() {
        return post_address.get();
    }

    public void setPostAddress(String post_address) {
        this.post_address.set(post_address);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getActive() {
        return active.get();
    }

    public void setActive(String active) {
        this.active.set(active);
    }    
}