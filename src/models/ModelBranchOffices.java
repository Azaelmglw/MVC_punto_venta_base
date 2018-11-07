package models;

/**
 *
 * @author azaelmglw
 */

public class ModelBranchOffices {
    private final ModelMain model_main;
    
    public ModelBranchOffices(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
