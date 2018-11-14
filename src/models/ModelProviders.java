package models;

/**
 *
 * @author azaelmglw
 */

public class ModelProviders {
    private final ModelMain model_main;
    
    public ModelProviders(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}