package models;

/**
 *
 * @author azaelmglw
 */

public class ModelClientManipulation {
    private final ModelMain model_main;
    
    public ModelClientManipulation(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
}
