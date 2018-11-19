package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class TransactionDetail {
    private SimpleStringProperty product_id;
    private SimpleStringProperty product_name;
    private SimpleStringProperty product_quantity;
    private SimpleStringProperty price;
    private SimpleStringProperty total;
    
    
    public TransactionDetail(Stack<String> transaction_detail_data) {
        this.product_id = new SimpleStringProperty(transaction_detail_data.pop());
        this.product_name = new SimpleStringProperty(transaction_detail_data.pop());
        this.product_quantity = new SimpleStringProperty(transaction_detail_data.pop());
        this.price = new SimpleStringProperty(transaction_detail_data.pop());
        this.total = new SimpleStringProperty(transaction_detail_data.pop());
    }
    
    public String getProduct_id() {
        return product_id.get();
    }

    public void setProduct_id(String product_id) {
        this.product_id.set(product_id);
    }

    public String getProduct_name() {
        return product_name.get();
    }

    public void setProduct_name(String product_name) {
        this.product_name.set(product_name);
    }

    public String getProduct_quantity() {
        return product_quantity.get();
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity.set(product_quantity);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String sale_price) {
        this.price.set(sale_price);
    }

    public String getTotal() {
        return total.get();
    }

    public void setTotal(String total) {
        this.total.set(total);
    }
}
