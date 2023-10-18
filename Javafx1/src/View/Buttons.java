package View;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Buttons {
		

	Button btAdd = new Button("+");
	Button btSubstract = new Button("-");
	Button btMultiply = new Button("×");
	Button btDivide = new Button("/");
	Button btEnter = new Button("Enter");
	

	//clavier
	GridPane gp = new GridPane();
	for (int i=0; i<3; i++) {
		Button b = new Button();
		gp.add(b, i, 1);
	}
	}

