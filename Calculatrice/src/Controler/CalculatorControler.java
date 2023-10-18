package Controler;

import java.util.List;

import Model.CalculatorModel;

public class CalculatorControler implements CalculatorControlerInterface {

	
	CalculatorModel calculatorModel = new CalculatorModel();
	public void operation(char s) {
		if (s=='+') {calculatorModel.add();}
		if (s=='-') {calculatorModel.substract();}
		if (s=='*') {calculatorModel.multiply();}
		if (s=='/') {calculatorModel.divide();}
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
