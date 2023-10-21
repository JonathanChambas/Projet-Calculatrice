package Model;

import View.CalculatorGUI;
import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	public Stack<Double> memory = new Stack<Double>();
	private String accu;

	public String getAccu() {
		return accu;
	}

	public void setAccu(String s) {
		if (accu == null) {
			accu = s;
		}
		else if (accu.substring(0,1).equals("0")) {
			accu = s;
		}
		else if (accu.contains(".") && s.equals(".")) {}			
		else {
			accu = accu + s;
		}
		CalculatorGUI.changer_valeur(accu);
	}

	public void add() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x+y); // faire avec accu toutes les méthodes
	}

	public void subtract() {
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
		double y = memory.pop();
		memory.push(x/y);		
	}

	public void opposite() {
		if (accu.substring(0,1).equals("-")) {
			accu = accu.substring(1, accu.length());
		}
		else {
			accu = "-" + accu;
		}
		CalculatorGUI.changer_valeur(accu);
	}

	public void push() {
		if (accu.equals("+")) {
			add();
			accu = null;
			setAccu(memory.pop().toString());
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
		memory.pop();		
	}

	public void swap() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x);
		memory.push(y);
	}

	public void clear() {
		while (memory.empty() == false) {
			memory.pop();
		}
	}

	public void del() {
		if (accu.length() != 0) {
			accu = accu.substring(0,accu.length()-1);
			CalculatorGUI.changer_valeur(accu);
		}
	}

	public void supprimer() {
		accu = accu.substring(accu.length());
		CalculatorGUI.changer_valeur(accu);
	}

}
