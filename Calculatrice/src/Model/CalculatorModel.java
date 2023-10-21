package Model;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	Stack<Double> memory = new Stack<Double>();
	double accu;
	
	public void add() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x+y); // faire avec accu toutes les méthodes
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
		double y = memory.pop();
		memory.push(x/y);		
	}

	public void opposite() {
		accu = -accu;		
	}

	public void push() {
		memory.push(accu);		
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

}
