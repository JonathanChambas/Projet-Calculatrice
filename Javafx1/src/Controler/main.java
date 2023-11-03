package Controler;

import View.CalculatorGUI; 
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application{
    private Stage st;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage st) throws Exception {
    	CalculatorGUI CG = new CalculatorGUI(st);
    }
}