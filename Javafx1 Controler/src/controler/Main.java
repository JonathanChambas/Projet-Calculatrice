package controler;

import model.CalculatorModel;
import view.CalculatorGUI;

public class Main {

	public static void main(String[] args) 
		{
			CalculatorModel model = new CalculatorModel();
			CalculatorGUI view = new CalculatorGUI();
	 
			new CalculatorControler(model,view);
		}
	 
	}

