package models;

/**
 *
 * @author azaelmglw
 */

public class ModelDiscounts {
    private final ModelMain model_main;
    
    public ModelDiscounts(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
