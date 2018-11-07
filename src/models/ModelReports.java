
package models;

/**
 *
 * @author azaelmglw
 */

public class ModelReports {
    private final ModelMain model_main;
    
    public ModelReports(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public ModelMain getModelMain(){
        return model_main;
    }
    
}
