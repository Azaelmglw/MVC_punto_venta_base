package models;

/**
 *
 * @author azaelmglw
 */

public class ModelNewPurchase {
    private final ModelMain model_main;
    
    public ModelNewPurchase(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
}
    
