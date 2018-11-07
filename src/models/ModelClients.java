package models;

/**
 *
 * @author azaelmglw
 */

public class ModelClients {
    private final ModelMain model_main;
    
    public ModelClients(ModelMain model_main){
        this.model_main = model_main;  
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
