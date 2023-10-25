package controler;

import java.util.List;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import model.CalculatorModel;
import view.CalculatorGUI;

public class CalculatorControler implements CalculatorControlerInterface {
	
	private CalculatorModel model;
	private CalculatorGUI view;
	
	CalculatorControler(CalculatorModel model, CalculatorGUI view) {
		
		this.model = model;
		this.view = view;

	}
	
	public void actionperformed(ActionEvent e) {
		
		Button bouton = (Button) e.getSource();
		String textebouton = bouton.getText();
		
		if (textebouton.equals("+"))  {
			model.add();
		}
		else if (textebouton.equals("-")) {
			model.substract();
		}
		else if (textebouton.equals("*")) {
			model.multiply();
		}
		else if (textebouton.equals("/")) {
			model.divide();
		}
		else if (textebouton.equals("+/-")) {
			model.opposite();
		}
		else if (textebouton.equals("Invert elem") {
			model.swap();
		}
		else if (textebouton.equals("Vider Pile")) {
			model.clear();
		}
		else if (textebouton.equals("C") {
			model.supprimer();
		}
		else if (textebouton.equals("<-")) {
			model.del();
		}
		else if (textebouton.equals("Del elem")) {
			model.drop();
		}
		else { // le bouton correspond à un chiffre 
			model.setAccu(textebouton);
		}
		
	}

	@Override
	public void changer_valeur(String accu) {
		view.changer_valeur(model.accu);
		
	}


}
