package View;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CalculatorGUI extends javafx.scene.Scene {
	
	BorderPane borderPane = new BorderPane();

	Button btAdd = new Button("+");
	Button btSubstract = new Button("-");
	Button btMultiply = new Button("×");
	Button btDivide = new Button("/");
	Button btEnter = new Button("Enter");
	

	//clavier
	GridPane gp = new GridPane();
	for (int l=0; l<3; l++) { //parcours des lignes
		for (int c=0; c<3; c++) { // parcours des colonnes
			Button b = new Button();
			gp.add(b, c, l);
	}
		}
	borderPane.setBottom(gp);
	
	String accu;
	}
}
