package models;

/**
 *
 * @author azaelmglw
 */

public class ModelUsers {
    private final ModelMain model_main;
    
    public ModelUsers(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
