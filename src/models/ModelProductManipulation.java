package models;

/**
 *
 * @author azaelmglw
 */

public class ModelProductManipulation {
    private final ModelMain model_main;
    
    public ModelProductManipulation(ModelMain model_main) {
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain() {
        return model_main;
    }
    
}
