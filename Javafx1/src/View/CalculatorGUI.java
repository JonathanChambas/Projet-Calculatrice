package View;

import Model.CalculatorModel;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CalculatorGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	static CalculatorModel CM = new CalculatorModel();
	static Label t3 = new Label("");
	static Label t2 = new Label("");
	static Label t1 = new Label("0");

	public void start(Stage st) {
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
		
		Button bouton1 = new Button("1");
		bouton1.relocate(80,128);
		bouton1.setPrefSize(l, h);
		bouton1.setOnAction(e -> {CM.setAccu("1");});

		Button bouton2 = new Button("2");
		bouton2.relocate(171,128);
		bouton2.setPrefSize(l, h);
		bouton2.setOnAction(e -> {CM.setAccu("2");});

		Button bouton3 = new Button("3");
		bouton3.relocate(262,128);
		bouton3.setPrefSize(l, h);
		bouton3.setOnAction(e -> {CM.setAccu("3");});

		Button bouton4 = new Button("4");
		bouton4.relocate(80,186);
		bouton4.setPrefSize(l, h);
		bouton4.setOnAction(e -> {CM.setAccu("4");});

		Button bouton5 = new Button("5");
		bouton5.relocate(171,186);
		bouton5.setPrefSize(l, h);
		bouton5.setOnAction(e -> {CM.setAccu("5");});

		Button bouton6 = new Button("6");
		bouton6.relocate(262,186);
		bouton6.setPrefSize(l, h);
		bouton6.setOnAction(e -> {CM.setAccu("6");});

		Button bouton7 = new Button("7");
		bouton7.relocate(80,244);
		bouton7.setPrefSize(l, h);
		bouton7.setOnAction(e -> {CM.setAccu("7");});

		Button bouton8 = new Button("8");
		bouton8.relocate(171,244);
		bouton8.setPrefSize(l, h);
		bouton8.setOnAction(e -> {CM.setAccu("8");});

		Button bouton9 = new Button("9");
		bouton9.relocate(262,244);
		bouton9.setPrefSize(l, h);
		bouton9.setOnAction(e -> {CM.setAccu("9");});

		Button bouton10 = new Button("0");
		bouton10.relocate(80,298);
		bouton10.setPrefSize(l, h);
		bouton10.setOnAction(e -> {CM.setAccu("0");});

		Button bouton11 = new Button("Enter");
		bouton11.relocate(171,356);
		bouton11.setPrefSize(2*l+10, h);
		bouton11.setOnAction(e -> {changer_affichage();});

		Button bouton12 = new Button(".");
		bouton12.relocate(171,298);
		bouton12.setPrefSize(l, h);
		bouton12.setOnAction(e -> {CM.setAccu(".");});

		Button bouton13 = new Button("+");
		bouton13.relocate(368,186);
		bouton13.setPrefSize(l, h);
		bouton13.setOnAction(e -> {CM.setAccu("+");});

		Button bouton14 = new Button("-");
		bouton14.relocate(368,244);
		bouton14.setPrefSize(l, h);
		bouton14.setOnAction(e -> {CM.setAccu("-");});

		Button bouton15 = new Button("*");
		bouton15.relocate(368,298);
		bouton15.setPrefSize(l, h);
		bouton15.setOnAction(e -> {CM.setAccu("*");});

		Button bouton16 = new Button("/");
		bouton16.relocate(368,356);
		bouton16.setPrefSize(l, h);
		bouton16.setOnAction(e -> {CM.setAccu("/");});

		Button bouton17 = new Button("+/-");
		bouton17.relocate(262,298);
		bouton17.setPrefSize(l, h);
		bouton17.setOnAction(e -> {CM.opposite();});

		Button bouton18 = new Button("<-");
		bouton18.relocate(368,128);
		bouton18.setPrefSize(l, h);
		bouton18.setOnAction(e -> {CM.del();});

		Button bouton19 = new Button("C");
		bouton19.relocate(80,356);
		bouton19.setPrefSize(l, h);
		bouton19.setOnAction(e -> {CM.supprimer();});
		
		Button bouton20 = new Button("Vider Pile");
		bouton20.relocate(80,414);
		bouton20.setPrefSize(l, h);
		bouton20.setOnAction(e -> {CM.clear();});
		
		Button bouton21 = new Button("Invert elem");
		bouton21.relocate(171,414);
		bouton21.setPrefSize(l, h);
		bouton21.setOnAction(e -> {CM.swap();});
		
		Button bouton22 = new Button("Del elem");
		bouton22.relocate(262,414);
		bouton22.setPrefSize(l, h);
		bouton22.setOnAction(e -> {CM.drop();});
		
		Button bouton23 = new Button("Afficher pile");
		bouton23.relocate(262,414);
		bouton23.setPrefSize(l, h);
		bouton23.setOnAction(e -> {star();});

		root.getChildren().addAll(t1,t2,t3);
		root.getChildren().addAll(bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10,bouton11,bouton12,bouton13,bouton14,bouton15,bouton16,bouton17,bouton18,bouton19);
		root.getChildren().addAll(bouton20,bouton21,bouton22,bouton23);
		st.show();

	}

	public static void changer_affichage() {
		if (CM.getAccu() != null) {
			t3.setText(t2.getText());
			t2.setText(t1.getText());
			t1.setText("0");
			CM.push();
		}
	}

	public static void changer_valeur(String accu) {
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
