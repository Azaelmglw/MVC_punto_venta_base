package models;

/**
 *
 * @author azaelmglw
 */

public class ModelSeasonalDiscountManipulation {
    private final ModelMain model_main;
    
    public ModelSeasonalDiscountManipulation(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
}
