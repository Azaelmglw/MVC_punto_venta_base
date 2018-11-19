package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Client extends Person {
    private SimpleStringProperty discount_id;
    private SimpleStringProperty rfc;
    private SimpleStringProperty internal_number;
    private SimpleStringProperty creation_date;
    private SimpleStringProperty accumulated_total;
    
    public Client(Stack<String> client_data) {
        super(client_data);
        this.discount_id = new SimpleStringProperty(client_data.pop());
        this.rfc = new SimpleStringProperty(client_data.pop());
        this.internal_number = new SimpleStringProperty(client_data.pop());
        this.creation_date = new SimpleStringProperty(client_data.pop());
        this.accumulated_total = new SimpleStringProperty(client_data.pop()); 
    }
    
    public String getDiscount_id(){
        return this.discount_id.get();
    }
    
    public void setDiscount_id(String discount_id){
        this.discount_id.set(discount_id);
    }
    
    public String getRfc(){
        return this.rfc.get();
    }
    
    public void setRfc(String rfc){
        this.rfc.set(rfc);
    }
    
    public String getInternal_number(){
        return this.internal_number.get();
    }
    
    public void setInternal_number(String internal_number){
        this.internal_number.set(internal_number);
    }
    
    public String getCreation_date(){
        return this.creation_date.get();
    }
    
    public void setCreation_date(String creation_date){
        this.creation_date.set(creation_date);
    }
    
    public String getAccumulated_total(){
        return this.accumulated_total.get();
    }
    
    public void setAccumulated_total(String accumulated_total){
        this.accumulated_total.set(accumulated_total);
    }
    
    public String getId() {
        return this.id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getFirst_name() {
        return this.first_name.get();
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getMiddle_name() {
        return this.middle_name.get();
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name.set(middle_name);
    }

    public String getLast_name() {
        return this.last_name.get();
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }
    
    public String getFull_name(){
        return this.full_name.get();
    }

    public String getPhone_number() {
        return this.phone_number.get();
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getStreet() {
        return this.street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getSuburb() {
        return this.suburb.get();
    }

    public void setSuburb(String suburb) {
        this.suburb.set(suburb);
    }

    public String getExternal_number() {
        return this.external_number.get();
    }

    public void setExternal_number(String external_number) {
        this.external_number.set(external_number);
    }

    public String getPostAddress() {
        return this.post_address.get();
    }

    public void setPostAddress(String post_address) {
        this.post_address.set(post_address);
    }

    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCity() {
        return this.city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return this.state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getActive() {
        return this.active.get();
    }

    public void setActive(String active) {
        this.active.set(active);
    } 
}
