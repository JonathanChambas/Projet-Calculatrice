package Model;

import View.CalculatorGUI;
import javafx.scene.control.Label;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> memory = new Stack<Double>();
    private String accu;
    String var;
    private CalculatorGUI CG; // Add a reference to CalculatorGUI

    // Constructor that takes a CalculatorGUI instance
    public CalculatorModel(CalculatorGUI calculatorGUI) {
        this.CG = calculatorGUI;
    }
	
	public String getAccu() {
		return accu;
	}
	
	public String getMemory() {
		return memory.toString();
	}

	public void setAccu(String s) {
        if (accu == null) {
            accu = s;
        } else if (accu.substring(0, 1).equals("0")) {
            accu = s;
        } else if (accu.contains(".") && s.equals(".")) {
        } else {
            accu = accu + s;
        }
        CG.changer_valeur(accu); // Use the instance to call the method
    }


	public void add() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x+y); 
	}

	public void substract() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x-y);		
	}

	public void multiply() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x*y);		
	}

	public void divide() {
		double x = memory.pop();
		if (x == 0) {
			memory.push(x);
		}
		else {
			double y = memory.pop();
			memory.push(y/x);
		}
	}

	public void opposite() {
		if (accu.substring(0,1).equals("-")) {
			accu = accu.substring(1, accu.length());
		}
		else {
			accu = "-" + accu;
		}
		CG.changer_valeur(accu);
	}

	public void push() {
		if (accu.equals("+")) {
			add();
			accu = null;
			var = memory.pop().toString();
			if (var.substring(var.length()-2,var.length()).equals(".0")) {
				var = var.substring(0,var.length()-2);
			}
			setAccu(var);
		}
		else if (accu.equals("-")) {
			substract();
			accu = null;
			var = memory.pop().toString();
			if (var.substring(var.length()-2,var.length()).equals(".0")) {
				var = var.substring(0,var.length()-2);
			}
			setAccu(var);
		}
		else if (accu.equals("/")) {
			divide();
			accu = null;
			var = memory.pop().toString();
			if (var.substring(var.length()-2,var.length()).equals(".0")) {
				var = var.substring(0,var.length()-2);
			}
			setAccu(var);
		}
		else if (accu.equals("*")) {
			multiply();
			accu = null;
			var = memory.pop().toString();
			if (var.substring(var.length()-2,var.length()).equals(".0")) {
				var = var.substring(0,var.length()-2);
			}
			setAccu(var);
		}
		else if (accu.equals(".")) {
			memory.push(0.);
		}
		else {
			memory.push(Double.valueOf(accu));
			accu = "0";
		}
		
	}

	public double pop() {
		try {
			return memory.peek();
		}
		catch (EmptyStackException e) { ;
		return Double.NaN;
		}
	}

	public void drop() {
		try {
			memory.pop();
		}
		catch (EmptyStackException e) {}	
	}

	public void swap() {
		if (memory.empty() == false) {
			double x = memory.pop();
			if (memory.empty() == false) {
				double y = memory.pop();
				memory.push(x);
				memory.push(y);
			}
			else {
				memory.push(x);
			}
		}
	}

	public void clear() {
		while (memory.empty() == false) {
			memory.pop();
		}
	}

	public void del() {
		if (accu.length() > 1) {
			accu = accu.substring(0,accu.length()-1);
		}
		else if (accu.length() == 1) {
			accu = "0";
		}
		CG.changer_valeur(accu);
	}

	public void supprimer() {
		accu = "0";
		CG.changer_valeur(accu);
	}

}
