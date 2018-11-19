
package aux_classes;

import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author azaelmglw
 */

public class ProductStock {
    private SimpleStringProperty branch_office_id;
    private SimpleStringProperty stock;
    
    public ProductStock(Stack<String> product_stock_data){
        this.branch_office_id = new SimpleStringProperty(product_stock_data.pop());
        this.stock = new SimpleStringProperty(product_stock_data.pop());
    }

    public String getBranch_office_id() {
        return branch_office_id.get();
    }

    public void setBranch_office_id(String branch_office_id) {
        this.branch_office_id.set(branch_office_id);
    }

    public String getStock() {
        return stock.get();
    }

    public void setStock(String stock) {
        this.stock.set(stock);
    }  
}
