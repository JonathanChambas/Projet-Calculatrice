package Model;

import View.CalculatorGUI;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> memory = new Stack<Double>();
    private String accu;
    String var;
    private CalculatorGUI CG; 

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
        if (accu == null || accu.substring(0, 1).equals("0")) {
            accu = s;
        } 
        else if (accu.contains(".") && s.equals(".")) { }
        else {
            accu = accu + s;
        }
        CG.changer_valeur(accu); 
    }


	public void add() {
		if (memory.empty() == false) {
			double x = memory.pop();
			if (memory.empty() == false) {
				double y = memory.pop();
				memory.push(x+y);
			}
			else { 
				memory.push(x);
			}
		} 
	}

	public void substract() {
		if (memory.empty() == false) {
			double x = memory.pop();
			if (memory.empty() == false) {
				double y = memory.pop();
				memory.push(x-y);
			}
			else { 
				memory.push(x);
			}
		} 	
	}

	public void multiply() {
		if (memory.empty() == false) {
			double x = memory.pop();
			if (memory.empty() == false) {
				double y = memory.pop();
				memory.push(x*y);
			}
			else { 
				memory.push(x);
			}
		} 		
	}

	public void divide() {
		if (memory.empty() == false) {
			double x = memory.pop();
			if (x == 0) {
			memory.push(x);
			}
			else if (memory.empty() == false) {
				double y = memory.pop();
				memory.push(y/x);
			}
			else {
				memory.push(x);
			}
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
		if (accu.matches(".*[-+*/].*") && !accu.matches(".*\\d.*") ) {
			accu = "" + pop();
		}
		else if (accu.equals(".")) {
			memory.push(0.);
		}
		else {
			memory.push(Double.valueOf(accu));
		}
		accu = "0";		
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
