package models;

/**
 *
 * @author azaelmglw
 */

public class ModelPurchases {
    private final ModelMain model_main;
    
    public ModelPurchases(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
