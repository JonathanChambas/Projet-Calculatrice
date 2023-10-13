package Model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	Stack<Double> memory = new Stack<Double>();
	double accu;
	
	public void add() {
		double x = memory.pop();
		double y = memory.pop();
		memory.push(x+y);
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
		// TODO Auto-generated method stub
		
	}

	public void push() {
		memory.push(accu);		
	}

	public void pop() {
		
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
