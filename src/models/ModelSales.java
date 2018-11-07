package models;

/**
 *
 * @author azaelmglw
 */

public class ModelSales {
    private final ModelMain model_main;
    
    public ModelSales(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
