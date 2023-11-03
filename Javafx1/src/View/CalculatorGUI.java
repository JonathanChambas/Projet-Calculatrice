package View;

import Controler.CalculatorControler;
import Model.CalculatorModel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CalculatorGUI {
	
	Label t3 = new Label("");
	Label t2 = new Label("");
	Label t1 = new Label("0");
	
	CalculatorModel CM = new CalculatorModel(this);
	CalculatorControler CC = new CalculatorControler(this,CM);
	
	public CalculatorGUI(Stage st) {
	
		Pane root = new Pane();
		Scene scene = new Scene(root, 500, 500);
		root.setStyle("-fx-background-color:#ecf6fb;");
		st.setTitle("Calculatrice");
		st.setScene(scene);
		st.setOnCloseRequest(event -> {
			st.close();
		});

		double l = 81;
		double h = 47;

		t1.relocate(80, 85);
		t1.setPrefSize(369, 43);
		t1.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t1.setAlignment(Pos.CENTER);

		t2.relocate(80, 50);
		t2.setPrefSize(369, 43);
		t2.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t2.setAlignment(Pos.CENTER);
		
		t3.relocate(80, 15);
		t3.setPrefSize(369, 43);
		t3.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t3.setAlignment(Pos.CENTER);
		
		Bouton bouton1 = new Bouton("1", l, h, 80, 128);	

		Bouton bouton2 = new Bouton("2", l, h, 171, 128);

		Bouton bouton3 = new Bouton("3", l, h, 262, 128);

		Bouton bouton4 = new Bouton("4", l, h, 80, 186);

		Bouton bouton5 = new Bouton("5", l, h, 171, 186);

		Bouton bouton6 = new Bouton("6", l, h, 262, 186);

		Bouton bouton7 = new Bouton("7", l, h, 80, 244);

		Bouton bouton8 = new Bouton("8", l, h, 171, 244);

		Bouton bouton9 = new Bouton("9", l, h, 262, 244);

		Bouton bouton10 = new Bouton("0", l, h, 80, 298);

		Bouton bouton11 = new Bouton("Enter", 2*l + 10, h, 171, 356);

		Bouton bouton12 = new Bouton(".", l, h, 171, 298);

		Bouton bouton13 = new Bouton("+", l, h, 368, 186);

		Bouton bouton14 = new Bouton("-", l, h, 368, 244);

		Bouton bouton15 = new Bouton("*", l, h, 368, 298);

		Bouton bouton16 = new Bouton("/", l, h, 368, 356);

		Bouton bouton17 = new Bouton("+/-", l, h, 262, 298);

		Bouton bouton18 = new Bouton("<-", l, h, 368, 128);

		Bouton bouton19 = new Bouton("C", l, h, 80, 356);
		
		Bouton bouton20 = new Bouton("Vider Pile", l, h, 80, 414);
		
		Bouton bouton21 = new Bouton("Invert elem", l, h, 171, 414);
		
		Bouton bouton22 = new Bouton("Del elem", l, h, 262, 414);
		
		Bouton bouton23 = new Bouton("Afficher pile", l, h, 368, 414);
		
		CC.def_action_bouton(bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10,bouton11,bouton12,bouton13,bouton14,bouton15,bouton16,bouton17,bouton18,bouton19,bouton20,bouton21,bouton22,bouton23);
		
		root.getChildren().addAll(t1,t2,t3);
		root.getChildren().addAll(bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10,bouton11,bouton12,bouton13,bouton14,bouton15,bouton16,bouton17,bouton18,bouton19);
		root.getChildren().addAll(bouton20,bouton21,bouton22,bouton23);
		st.show();

	}

	public void changer_affichage() {
		if (CM.getAccu() != null) {
			t3.setText(t2.getText());
			t2.setText(t1.getText());
			t1.setText("0");
			CM.push();
		}
	}

	public void changer_valeur(String accu) {
		t1.setText(accu);
	}
	
    public void star() {
    	
    	Stage primaryStage = new Stage();
        primaryStage.setTitle("Pile");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        Label label = new Label(CM.getMemory());
        layout.getChildren().add(label);

        primaryStage.show();
    }
}
