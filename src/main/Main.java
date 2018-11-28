package main;

import models.*;
import controllers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

/**
 *
 * @author azaelmglw
 */

public class Main extends Application{
    
    public static void main(String oamg[]) {  
        Application.launch(oamg);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            ArrayList<FXMLLoader> loaders_list = new ArrayList<>(20);
            ArrayList<Object> models_list = new ArrayList<>(20);
            ArrayList<Object> controllers_list = new ArrayList<>(20);
            
            // FXML Loaders Declaration.
            FXMLLoader loader_main = new FXMLLoader(getClass().getResource("ViewMain.fxml"));
            FXMLLoader loader_main_menu =  new FXMLLoader(getClass().getResource("ViewMainMenu.fxml"));
            FXMLLoader loader_console_menu = new FXMLLoader(getClass().getResource("ViewConsoleMenu.fxml"));
            FXMLLoader loader_terminal_menu = new FXMLLoader(getClass().getResource("ViewTerminalMenu.fxml"));
            
            FXMLLoader loader_branch_offices = new FXMLLoader(getClass().getResource("ViewBranchOffices.fxml"));
            FXMLLoader loader_providers = new FXMLLoader(getClass().getResource("ViewProviders.fxml"));
            FXMLLoader loader_users = new FXMLLoader(getClass().getResource("ViewUsers.fxml"));
            FXMLLoader loader_clients = new FXMLLoader(getClass().getResource("ViewClients.fxml"));
            FXMLLoader loader_products = new FXMLLoader(getClass().getResource("ViewProducts.fxml"));
            FXMLLoader loader_discounts = new FXMLLoader(getClass().getResource("ViewDiscounts.fxml"));
            FXMLLoader loader_purchases = new FXMLLoader(getClass().getResource("ViewPurchases.fxml"));
            FXMLLoader loader_sales = new FXMLLoader(getClass().getResource("ViewSales.fxml"));
            FXMLLoader loader_reports = new FXMLLoader(getClass().getResource("ViewReports.fxml"));
            //loader_stock -> uses loader_products.
            FXMLLoader loader_new_sale = new FXMLLoader(getClass().getResource("ViewNewSale.fxml"));
            FXMLLoader loader_new_purchase = new FXMLLoader(getClass().getResource("ViewNewPurchase.fxml"));
            
            FXMLLoader loader_branch_office_manipulation = new FXMLLoader(getClass().getResource("ViewBranchOfficeManipulation.fxml"));
            FXMLLoader loader_provider_manipulation = new FXMLLoader(getClass().getResource("ViewProviderManipulation.fxml"));
            FXMLLoader loader_user_manipulation = new FXMLLoader(getClass().getResource("ViewUserManipulation.fxml"));
            FXMLLoader loader_client_manipulation = new FXMLLoader(getClass().getResource("ViewClientManipulation.fxml"));
            FXMLLoader loader_product_manipulation = new FXMLLoader(getClass().getResource("ViewProductManipulation.fxml"));
            FXMLLoader loader_accumulated_discount_manipulation = new FXMLLoader(getClass().getResource("ViewAccumulatedDiscountManipulation.fxml"));
            FXMLLoader loader_seasonal_discount_manipulation = new FXMLLoader(getClass().getResource("ViewSeasonalDiscountManipulation.fxml"));
            
            
            loaders_list.add(0, loader_main);
            loaders_list.add(1, loader_main_menu);
            loaders_list.add(2, loader_console_menu);
            loaders_list.add(3, loader_terminal_menu);
            loaders_list.add(4, loader_branch_offices);
            loaders_list.add(5, loader_providers);
            loaders_list.add(6, loader_users);
            loaders_list.add(7, loader_clients);
            loaders_list.add(8, loader_products);
            loaders_list.add(9, loader_discounts);
            loaders_list.add(10, loader_purchases);
            loaders_list.add(11, loader_sales);
            loaders_list.add(12, loader_reports);
            loaders_list.add(13, loader_new_sale);
            loaders_list.add(14, loader_new_purchase);
            
            loaders_list.add(15, loader_branch_office_manipulation);
            loaders_list.add(16, loader_provider_manipulation);
            loaders_list.add(17, loader_user_manipulation);
            loaders_list.add(18, loader_client_manipulation);
            loaders_list.add(19, loader_product_manipulation);
            loaders_list.add(20, loader_accumulated_discount_manipulation);
            loaders_list.add(21, loader_seasonal_discount_manipulation);
            
                                    
            /*  To maintain an MVC structure and avoid performance issues due to infinite instantiation, 
            each one of the application Models, Controllers, Parents and Scenes have been instanced in 
            this exact class and method.*/
            
            /*  In order to be able to get the <<model_main>> which contains the <<primaryStage>> in the Controllers
            and allow the modification of it's <<root>> (switching views), the Controller of each respective 
            <<.fxml>> file needs to be declared outside of itself and before the <<load()>> method is called 
            or it's build will fail.*/
            
            /*  Models array list position:
            [0] -> model_main                               |   [1] -> model_main_menu                  |   [2] -> model_console_menu                       |   
            [3] -> model_terminal_menu                      |   [4] -> model_branch_offices             |   [5] -> model_providers                          |   
            [6] -> model_users                              |   [7] -> model_clients                    |   [8] -> model_products                           |   
            [9] -> model_discounts                          |   [10] -> model_purchases                 |   [11] -> model_sales                             |
            [12] -> model_reports                           |   [13] -> model_new_sale                  |   [14] -> model_new_purchase                      |   
            [15] -> model_branch_office_manipulation        |   [16] -> model_provider_manipulation     |   [17] -> model_user_manipulation                 |   
            [18] -> model_client_manipulation               |   [19] -> model_product_manipulation      |   [20] -> model_accumulated_discount_manipulation |
            [21] -> model_seasonal_discount_manipulation    |
            */
            
            /*  Controllers array list position:
            [0] -> controller_main                          |   [1] -> controller_main_menu             |   [2] -> controller_console_menu                  |   
            [3] -> controller_terminal_menu                 |   [4] -> controller_branch_offices        |   [5] -> controller_providers                     |   
            [6] -> controller_users                         |   [7] -> controller_clients               |   [8] -> controller_products                      |   
            [9] -> controller_discounts                     |   [10] -> controller_purchases            |   [11] -> controller_sales                        |
            [12] -> controller_reports                      |
            */
            
            ModelMain model_main = new ModelMain(primaryStage);
            models_list.add(0, model_main);
            ControllerMain controller_main = new ControllerMain(model_main);
            loader_main.setController(controller_main);
            controllers_list.add(0, controller_main);
            
            ModelMainMenu model_main_menu = new ModelMainMenu(model_main);
            models_list.add(1, model_main_menu);
            ControllerMainMenu controller_main_menu = new ControllerMainMenu(models_list, controllers_list);
            loader_main_menu.setController(controller_main_menu);
            controllers_list.add(1, controller_main_menu);
            
            ModelConsoleMenu model_console_menu = new  ModelConsoleMenu(model_main);
            models_list.add(2, model_console_menu);
            ControllerConsoleMenu controller_console_menu = new ControllerConsoleMenu(models_list, controllers_list);
            loader_console_menu.setController(controller_console_menu);
            controllers_list.add(2, controller_console_menu);
            
            ModelTerminalMenu model_terminal_menu = new ModelTerminalMenu(model_main);
            models_list.add(3, model_terminal_menu);
            ControllerTerminalMenu controller_terminal_menu = new ControllerTerminalMenu(models_list, controllers_list);
            loader_terminal_menu.setController(controller_terminal_menu);
            controllers_list.add(3, controller_terminal_menu);
            
            ModelBranchOffices model_branch_offices = new ModelBranchOffices(model_main);
            models_list.add(4, model_branch_offices);
            ControllerBranchOffices controller_branch_offices = new ControllerBranchOffices(models_list, controllers_list);
            loader_branch_offices.setController(controller_branch_offices);
            controllers_list.add(4, controller_branch_offices);
            
            ModelProviders model_providers = new ModelProviders(model_main);
            models_list.add(5, model_providers);
            ControllerProviders controller_providers = new ControllerProviders(models_list, controllers_list);
            loader_providers.setController(controller_providers);
            controllers_list.add(5, controller_providers);
            
            ModelUsers model_users = new ModelUsers(model_main);
            models_list.add(6, model_users);
            ControllerUsers controller_users = new ControllerUsers(models_list, controllers_list);
            loader_users.setController(controller_users);
            controllers_list.add(6, controller_users);
            
            ModelClients model_clients = new ModelClients(model_main);
            models_list.add(7, model_clients);
            ControllerClients controller_clients = new ControllerClients(models_list, controllers_list);
            loader_clients.setController(controller_clients);
            controllers_list.add(7, controller_clients);
            
            ModelProducts model_products = new ModelProducts(model_main);
            models_list.add(8, model_products);
            ControllerProducts controller_products = new ControllerProducts(models_list, controllers_list);
            loader_products.setController(controller_products);
            controllers_list.add(8, controller_products);
            
            ModelDiscounts model_discounts = new ModelDiscounts(model_main);
            models_list.add(9, model_discounts);
            ControllerDiscounts controller_discounts = new ControllerDiscounts(models_list, controllers_list);
            loader_discounts.setController(controller_discounts);
            controllers_list.add(9, controller_discounts);
            
            ModelPurchases model_purchases = new ModelPurchases(model_main);
            models_list.add(10, model_purchases);
            ControllerPurchases controller_purchases = new ControllerPurchases(models_list, controllers_list);
            loader_purchases.setController(controller_purchases);
            controllers_list.add(10, controller_purchases);
            
            ModelSales model_sales = new ModelSales(model_main);
            models_list.add(11, model_sales);
            ControllerSales controller_sales = new ControllerSales(models_list, controllers_list);
            loader_sales.setController(controller_sales);
            controllers_list.add(11, controller_sales);
            
            ModelReports model_reports = new ModelReports(model_main);
            models_list.add(12, model_reports);
            ControllerReports controller_reports = new ControllerReports(models_list, controllers_list);
            loader_reports.setController(controller_reports);
            controllers_list.add(12, controller_reports);
            
            //ModelStock -> uses ModelProducts.
            
            ModelNewSale model_new_sale = new ModelNewSale(model_main);
            models_list.add(13, model_new_sale);
            ControllerNewSale controller_new_sale = new ControllerNewSale(models_list, controllers_list);
            loader_new_sale.setController(controller_new_sale);
            controllers_list.add(13, controller_new_sale);
            
            ModelNewPurchase model_new_purchase = new ModelNewPurchase(model_main);
            models_list.add(14, model_new_purchase);
            ControllerNewPurchase controller_new_purchase = new ControllerNewPurchase(models_list, controllers_list);
            loader_new_purchase.setController(controller_new_purchase);
            controllers_list.add(14, controller_new_purchase);
            
            ModelBranchOfficeManipulation model_branch_office_manipulation = new ModelBranchOfficeManipulation(model_main);
            models_list.add(15, model_branch_office_manipulation);
            ControllerBranchOfficeManipulation controller_branch_office_manipulation = new ControllerBranchOfficeManipulation(models_list, controllers_list);
            loader_branch_office_manipulation.setController(controller_branch_office_manipulation);
            controllers_list.add(15, controller_branch_office_manipulation);
            
            ModelProviderManipulation model_provider_manipulation = new ModelProviderManipulation(model_main);
            models_list.add(16, model_provider_manipulation);
            ControllerProviderManipulation controller_provider_manipulation = new ControllerProviderManipulation(models_list, controllers_list);
            loader_provider_manipulation.setController(controller_provider_manipulation);
            controllers_list.add(16, controller_provider_manipulation);
            
            ModelUserManipulation model_user_manipulation = new ModelUserManipulation(model_main);
            models_list.add(17, model_user_manipulation);
            ControllerUserManipulation controller_user_manipulation = new ControllerUserManipulation(models_list, controllers_list);
            loader_user_manipulation.setController(controller_user_manipulation);
            controllers_list.add(17, controller_user_manipulation);
            
            ModelClientManipulation model_client_manipulation = new ModelClientManipulation(model_main);
            models_list.add(18, model_client_manipulation);
            ControllerClientManipulation controller_client_manipulation = new ControllerClientManipulation(models_list, controllers_list);
            loader_client_manipulation.setController(controller_client_manipulation);
            controllers_list.add(18, controller_client_manipulation);
            
            ModelProductManipulation model_product_manipulation = new ModelProductManipulation(model_main);
            models_list.add(19, model_product_manipulation);
            ControllerProductManipulation controller_product_manipulation = new ControllerProductManipulation(models_list, controllers_list);
            loader_product_manipulation.setController(controller_product_manipulation);
            controllers_list.add(19, controller_product_manipulation);
            
            ModelAccumulatedDiscountManipulation model_accumulated_discount_manipulation = new ModelAccumulatedDiscountManipulation(model_main);
            models_list.add(20, model_accumulated_discount_manipulation);
            ControllerAccumulatedDiscountManipulation controller_accumulated_discount_manipulation = new ControllerAccumulatedDiscountManipulation(models_list, controllers_list);
            loader_accumulated_discount_manipulation.setController(controller_accumulated_discount_manipulation);
            controllers_list.add(20, controller_accumulated_discount_manipulation);
            
            ModelSeasonalDiscountManipulation model_seasonal_discount_manipulation = new ModelSeasonalDiscountManipulation(model_main);
            models_list.add(21, model_seasonal_discount_manipulation);
            ControllerSeasonalDiscountManipulation controller_seasonal_discount_manipulation = new ControllerSeasonalDiscountManipulation(models_list, controllers_list);
            loader_seasonal_discount_manipulation.setController(controller_seasonal_discount_manipulation);
            controllers_list.add(21, controller_seasonal_discount_manipulation);
            
            
            //  UI Bools Declaration.
            BooleanProperty main_bool = new SimpleBooleanProperty(false);
            BooleanProperty main_menu_bool = new SimpleBooleanProperty(false);
            BooleanProperty console_menu_bool = new SimpleBooleanProperty(false);
            BooleanProperty terminal_menu_bool = new SimpleBooleanProperty(false);
            BooleanProperty branch_offices_bool = new SimpleBooleanProperty(false);
            BooleanProperty providers_bool = new SimpleBooleanProperty(false);
            BooleanProperty users_bool = new SimpleBooleanProperty(false);
            BooleanProperty clients_bool = new SimpleBooleanProperty(false);
            BooleanProperty products_bool = new SimpleBooleanProperty(false);
            BooleanProperty discounts_bool = new SimpleBooleanProperty(false);
            BooleanProperty purchases_bool = new SimpleBooleanProperty(false);
            BooleanProperty sales_bool = new SimpleBooleanProperty(false);
            BooleanProperty branch_office_manipulation_bool = new SimpleBooleanProperty(false);
            
            /*  There are some events that would've unefficient to link to a button or some of the other basic
            controls, in this case, we want to load the different tables data without the need of a button and that's why
            we use <<BooleanProperties>> that can then be put into a listener which will fire an event whenever
            the value of the Property is changed.
            This way we can manage by code the exact moment when we want to load the mayority of these tables data.*/
            
            //  UI Bools Assignation.
            model_main.setUI_Bool(0, main_bool);
            model_main.setUI_Bool(1, main_menu_bool);
            model_main.setUI_Bool(2, console_menu_bool);
            model_main.setUI_Bool(3, terminal_menu_bool);
            model_main.setUI_Bool(4, branch_offices_bool);
            model_main.setUI_Bool(5, providers_bool);
            model_main.setUI_Bool(6, users_bool);
            model_main.setUI_Bool(7, clients_bool);
            model_main.setUI_Bool(8, products_bool);
            model_main.setUI_Bool(9, discounts_bool);
            model_main.setUI_Bool(10, purchases_bool);
            model_main.setUI_Bool(11, sales_bool);
            model_main.setUI_Bool(12, branch_office_manipulation_bool);

            
            //  Parents Declaration.
            Parent main = (Parent)loader_main.load();
            Parent main_menu = (Parent)loader_main_menu.load();
            Parent console_menu = (Parent)loader_console_menu.load();
            Parent terminal_menu = (Parent)loader_terminal_menu.load();
            
            Parent branch_offices = (Parent)loader_branch_offices.load();
            Parent providers = (Parent)loader_providers.load();
            Parent users = (Parent)loader_users.load();
            Parent clients = (Parent)loader_clients.load();
            Parent products = (Parent)loader_products.load();
            Parent discounts = (Parent)loader_discounts.load();
            Parent purchases = (Parent)loader_purchases.load();
            Parent sales = (Parent)loader_sales.load();
            Parent reports = (Parent)loader_reports.load();
            //Parent stock -> uses Parent products.
            Parent new_sale = (Parent)loader_new_sale.load();
            Parent new_purchase = (Parent)loader_new_purchase.load();
            
            Parent branch_office_manipulation = (Parent)loader_branch_office_manipulation.load();
            Parent provider_manipulation = (Parent)loader_provider_manipulation.load();
            Parent user_manipulation = (Parent)loader_user_manipulation.load();
            Parent client_manipulation = (Parent)loader_client_manipulation.load();
            Parent product_manipulation = (Parent)loader_product_manipulation.load();
            Parent accumulated_discount_manipulation = (Parent)loader_accumulated_discount_manipulation.load();
            Parent seasonal_discount_manipulation = (Parent)loader_seasonal_discount_manipulation.load();
            
            
            /*  Once all the Parent variables are declared, the <<model_main>> needs to receive the reference 
            for each one trough it's <<set()>> method, making available all the Parents to the Controllers.*/
            
            //  Parents Assignation.
            model_main.setParent(0, main);
            model_main.setParent(1, main_menu);
            model_main.setParent(2, console_menu);
            model_main.setParent(3, terminal_menu);
            
            model_main.setParent(4, branch_offices);
            model_main.setParent(5, providers);
            model_main.setParent(6, users);
            model_main.setParent(7, clients);
            model_main.setParent(8, products);
            model_main.setParent(9, discounts);
            model_main.setParent(10, purchases);
            model_main.setParent(11, sales);
            model_main.setParent(12, reports);
            model_main.setParent(13, new_sale);
            model_main.setParent(14, new_purchase);
            
            model_main.setParent(15, branch_office_manipulation);
            model_main.setParent(16, provider_manipulation);
            model_main.setParent(17, user_manipulation);
            model_main.setParent(18, client_manipulation);
            model_main.setParent(19, product_manipulation);
            model_main.setParent(20, accumulated_discount_manipulation);
            model_main.setParent(21, seasonal_discount_manipulation);
           
            
            //  Scenes Declaration.
            Scene main_scene = new Scene(main, 800, 768);
                 
            
            //  Unary Operators Declaration.
            UnaryOperator<TextFormatter.Change> login_username_filter = c -> {
                if(!c.getText().matches("[A-Z 0-9]") || c.isDeleted()) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()){
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> login_user_password_filter = c -> {
                if(!c.getText().matches("\\w") || c.isDeleted()){
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()){
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> branch_office_number_filter = c -> {
                if(!c.getText().matches("\\d") || c.isDeleted() || c.getControlText().length() > 2){
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()){
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> suburb_filter = c -> {
                if(!c.getText().matches("\\w") && !c.getText().matches("\\s") || c.isDeleted() || c.getControlText().length() > 24) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()) {
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> post_address_filter = c -> {
                if(!c.getText().matches("\\d")  || c.isDeleted() || c.getControlText().length() > 4) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()) {
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> email_filter = c -> {
                System.out.println(c.getControlText());
                if(!c.getText().matches("[A-Za-z0-9@.-_]") || c.isDeleted() || c.getControlText().length() > 29) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()) {
                    return c;
                }
                return c;
            };
            

            UnaryOperator<TextFormatter.Change> phone_number_filter = c -> {
                if(!c.getText().matches("[\\d]") || c.isDeleted() || c.getControlText().length() > 9) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()) {
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> city_filter = c -> {
                if(!c.getText().matches("[\\w]") && !c.getText().matches("[\\s]") || c.isDeleted() || c.getControlText().length() > 19) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()) {
                    return c;
                }
                return c;
            };
            
            UnaryOperator<TextFormatter.Change> state_filter = c -> {
                if(!c.getText().matches("[\\w]") && !c.getText().matches("[\\s]") || c.isDeleted() || c.getControlText().length() > 20) {
                    c.setText("");
                    return c;
                }
                else if(c.getText().isEmpty()) {
                    return c;
                }
                return c;
            };
            
            
            //  Text Formatters Declaration.
            TextFormatter<String> username_formatter = new TextFormatter<>(login_username_filter);
            TextFormatter<String> user_password_formatter = new TextFormatter<>(login_user_password_filter);
            TextFormatter<String> branch_office_number_formatter = new TextFormatter<>(branch_office_number_filter);
            TextFormatter<String> suburb_formatter = new TextFormatter<>(suburb_filter);
            TextFormatter<String> post_address_formatter = new TextFormatter<>(post_address_filter);
            TextFormatter<String> email_formatter = new TextFormatter<>(email_filter);
            TextFormatter<String> phone_number_formatter = new TextFormatter<>(phone_number_filter);
            TextFormatter<String> city_formatter = new TextFormatter<>(city_filter);
            TextFormatter<String> state_formatter = new TextFormatter<>(state_filter);
            
            
            
            //  Text Formatters Assignation.
            model_main.setTextFormatter(0, username_formatter);
            model_main.setTextFormatter(1, user_password_formatter);
            model_main.setTextFormatter(2, branch_office_number_formatter);
            model_main.setTextFormatter(3, suburb_formatter);
            model_main.setTextFormatter(4, post_address_formatter);
            model_main.setTextFormatter(5, email_formatter);
            model_main.setTextFormatter(6, phone_number_formatter);
            model_main.setTextFormatter(7, city_formatter);
            model_main.setTextFormatter(8, state_formatter);
            
            //  Alerts Declaration.
            Alert confirmation_alert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation_alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
            
            Alert error_alert = new Alert(Alert.AlertType.ERROR);
            error_alert.setTitle("Something went wrong");
            
            Alert information_alert = new Alert(Alert.AlertType.INFORMATION);
            information_alert.setTitle("ACME FX_v0.1");
            
            //  Alerts Assignation.
            model_main.setAlert(0, confirmation_alert);
            model_main.setAlert(1, error_alert);
            model_main.setAlert(2, information_alert);
            
            /*  Only the <<main>> UI is set in this method, all of the other manipulations of <<primaryStage>>
            need to be declared in it's respective Controllers.*/
            primaryStage.setTitle("ACME FX_v0.1");
            primaryStage.setScene(main_scene);
            primaryStage.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
