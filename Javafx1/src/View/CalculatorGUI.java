package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {

	public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage st) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500);
        st.setScene(scene);
        st.setOnCloseRequest(event -> {
            st.close();
        });
        
        double l = 81;
        double h = 47;

		Button bouton1 = new Button("1");
		bouton1.relocate(80,128);
		bouton1.setPrefSize(l, h);
		
		Button bouton2 = new Button("2");
		bouton2.relocate(171,128);
		bouton2.setPrefSize(l, h);
		
		Button bouton3 = new Button("3");
		bouton3.relocate(262,128);
		bouton3.setPrefSize(l, h);
		
		
		Button bouton4 = new Button("4");
		bouton4.relocate(80,186);
		bouton4.setPrefSize(l, h);
		
		Button bouton5 = new Button("5");
		bouton5.relocate(171,186);
		bouton5.setPrefSize(l, h);
		
		Button bouton6 = new Button("6");
		bouton6.relocate(262,186);
		bouton6.setPrefSize(l, h);
		
		Button bouton7 = new Button("7");
		bouton7.relocate(80,244);
		bouton7.setPrefSize(l, h);
		
		Button bouton8 = new Button("8");
		bouton8.relocate(171,244);
		bouton8.setPrefSize(l, h);
		
		Button bouton9 = new Button("9");
		bouton9.relocate(262,244);
		bouton9.setPrefSize(l, h);
		
		Button bouton10 = new Button("0");
		bouton10.relocate(80,298);
		bouton10.setPrefSize(l, h);
		
		Button bouton11 = new Button("Enter");
		bouton11.relocate(368,356);
		bouton11.setPrefSize(l, h);
		
		Button bouton12 = new Button(",");
		bouton12.relocate(171,298);
		bouton12.setPrefSize(l, h);
		
		Button bouton13 = new Button("+");
		bouton13.relocate(368,128);
		bouton13.setPrefSize(l, h);
		
		Button bouton14 = new Button("-");
		bouton14.relocate(368,186);
		bouton14.setPrefSize(l, h);
		
		Button bouton15 = new Button("*");
		bouton15.relocate(368,244);
		bouton15.setPrefSize(l, h);
		
		Button bouton16 = new Button("/");
		bouton16.relocate(368,298);
		bouton16.setPrefSize(l, h);
		
		Button bouton17 = new Button("+/-");
		bouton17.relocate(262,298);
		bouton17.setPrefSize(l, h);
		
		TextField t1 = new TextField();
		t1.relocate(80, 60);
		t1.setPrefSize(369, 43);
		
		TextField t2 = new TextField();
		t2.relocate(80, 11);
		t2.setPrefSize(369, 43);
		root.getChildren().addAll(t1,t2);
		root.getChildren().addAll(bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10,bouton11,bouton12,bouton13,bouton14,bouton15,bouton16,bouton17);
		st.show();
	}
	
	

}
