package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class Transaction {
    protected SimpleStringProperty id;
    protected SimpleStringProperty user_id;
    protected SimpleStringProperty user_name;
    protected SimpleStringProperty date;
    protected SimpleStringProperty subtotal;
    protected SimpleStringProperty iva;
    protected SimpleStringProperty total;
    
    public Transaction(Stack<String> transaction_data){
        this.id = new SimpleStringProperty(transaction_data.pop());
        this.user_id = new SimpleStringProperty(transaction_data.pop());
        this.user_name = new SimpleStringProperty(transaction_data.pop());
        this.date = new SimpleStringProperty(transaction_data.pop());
        this.subtotal = new SimpleStringProperty(transaction_data.pop());
        this.iva = new SimpleStringProperty(transaction_data.pop());
        this.total = new SimpleStringProperty(transaction_data.pop());
    }
}
