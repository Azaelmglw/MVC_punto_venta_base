package models;

/**
 *
 * @author azaelmglw
 */

public class ModelTerminalMenu {
    private final ModelMain model_main;
    
    public ModelTerminalMenu(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
