package Controler;

import java.util.List;

import View.Bouton;
import Model.CalculatorModel;
import View.CalculatorGUI;

public class CalculatorControler implements CalculatorControlerInterface {
    private CalculatorModel CM;
    private CalculatorGUI CG;

    public CalculatorControler(CalculatorGUI calculatorGUI,CalculatorModel calculatorModel) {
    	this.CG = calculatorGUI;
    	this.CM = calculatorModel;
    }

    public void operation(char s) {
        if (s == '+') {
        	CM.add();
        }
        if (s == '-') {
        	CM.substract();
        }
        if (s == '*') {
        	CM.multiply();
        }
        if (s == '/') {
        	CM.divide();
        }
    }
    
    public void def_action_bouton(Bouton bouton1, Bouton bouton2, Bouton bouton3, Bouton bouton4, Bouton bouton5, Bouton bouton6, Bouton bouton7, Bouton bouton8, Bouton bouton9, Bouton bouton10, Bouton bouton11, Bouton bouton12, Bouton bouton13, Bouton bouton14, Bouton bouton15, Bouton bouton16, Bouton bouton17, Bouton bouton18, Bouton bouton19, Bouton bouton20, Bouton bouton21, Bouton bouton22, Bouton bouton23) {
    	bouton1.setOnAction(e -> {CM.setAccu("1");});	
		bouton2.setOnAction(e -> {CM.setAccu("2");});
		bouton3.setOnAction(e -> {CM.setAccu("3");});
		bouton4.setOnAction(e -> {CM.setAccu("4");});
		bouton5.setOnAction(e -> {CM.setAccu("5");});
		bouton6.setOnAction(e -> {CM.setAccu("6");});
		bouton7.setOnAction(e -> {CM.setAccu("7");});
		bouton8.setOnAction(e -> {CM.setAccu("8");});
		bouton9.setOnAction(e -> {CM.setAccu("9");});
		bouton10.setOnAction(e -> {CM.setAccu("0");});
		bouton11.setOnAction(e -> {CG.changer_affichage();});
		bouton12.setOnAction(e -> {CM.setAccu(".");});
		bouton13.setOnAction(e -> {CM.setAccu("+");});
		bouton14.setOnAction(e -> {CM.setAccu("-");});
		bouton15.setOnAction(e -> {CM.setAccu("*");});
		bouton16.setOnAction(e -> {CM.setAccu("/");});
		bouton17.setOnAction(e -> {CM.opposite();});
		bouton18.setOnAction(e -> {CM.del();});
		bouton19.setOnAction(e -> {CM.supprimer();});
		bouton20.setOnAction(e -> {CM.clear();});
		bouton21.setOnAction(e -> {CM.swap();});		
		bouton22.setOnAction(e -> {CM.drop();});		
		bouton23.setOnAction(e -> {CG.star();});
    }
    
    @Override
    public void change(String accu) {
        // TODO Auto-generated method stub
    }

    @Override
    public void change(List<Double> stackData) {
        // TODO Auto-generated method stub
    }
}
