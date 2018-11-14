package models;

/**
 *
 * @author azaelmglw
 */

public class ModelConsoleMenu {
    private final ModelMain model_main;
    
    public ModelConsoleMenu(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}