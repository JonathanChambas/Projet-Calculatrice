package Controler;

import model.CalculatorModel;

public class CalculatorControler implements CalculatorControlerInterface {

	
	CalculatorModel calculatorModel = new CalculatorModel();
	public void operation(char s) {
		if (s=='+') {calculatorModel.add();}
		if (s=='-') {calculatorModel.substract();}
		if (s=='*') {calculatorModel.multiply();}
		if (s=='/') {calculatorModel.divide();}
	}
}
