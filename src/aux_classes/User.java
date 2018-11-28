package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class User extends Person {
    private SimpleStringProperty branch_office_id;
    private SimpleStringProperty type;
    private SimpleStringProperty rfc;
    private SimpleStringProperty internal_number;
    private SimpleStringProperty insurance_number;
    private SimpleStringProperty curp;
    private byte[] password;
     
    public User(Stack<String> user_data, byte[] password) {
        super(user_data);
        this.branch_office_id = new SimpleStringProperty(user_data.pop());
        this.type = new SimpleStringProperty(user_data.pop());
        this.rfc = new SimpleStringProperty(user_data.pop());
        this.internal_number = new SimpleStringProperty(user_data.pop());
        this.insurance_number = new SimpleStringProperty(user_data.pop());
        this.curp = new SimpleStringProperty(user_data.pop());
        this.password = password;
    }    

    public String getBranch_office_id(){
        return this.branch_office_id.get();
    }
    
    public void setBranch_office_id(String branch_office_id){
        this.branch_office_id.set(branch_office_id);
    }
    
    public String getType(){
        return this.type.get();
    }
    
    public void setType(String type){
        this.type.set(type);
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
    
    public String getInsurance_number(){
        return this.insurance_number.get();
    }
    
    public void setInsurance_number(String insurance_number){
        this.external_number.set(insurance_number);
    }
    
    public String getCurp(){
        return this.curp.get();
    }
    
    public void setCurp(String curp){
        this.curp.set(curp);
    }
    
    public byte[] getPassword(){
        return this.password;
    }
    
    public void setPassword(byte[] password){
        this.password = password;
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

    public String getPost_address() {
        return this.post_address.get();
    }

    public void setPost_address(String post_address) {
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
