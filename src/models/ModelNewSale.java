package models;

/**
 *
 * @author azaelmglw
 */

public class ModelNewSale {
    private final ModelMain model_main;
    
    public ModelNewSale(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    
    }
    
}
