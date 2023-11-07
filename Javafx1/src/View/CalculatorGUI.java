package View;

import Controler.CalculatorControler;
import Model.CalculatorModel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
	
	CalculatorModel CM = new CalculatorModel(this);
	CalculatorControler CC = new CalculatorControler(this,CM);
	
	//On crée les 3 zones de texte
	Label t1 = new Label("0");
	Label t2 = new Label("");
	Label t3 = new Label("");
	Label t4 = new Label("");
	
	public CalculatorGUI(Stage st) { //st correspond à la fenêtre principale de l'application
	
		Pane root = new Pane(); //root est un container
		//on définit ensuite une scène contenant le container principal puis on l'associe en tant que scène de l'application
		Scene scene = new Scene(root, 500, 500); 
		root.setStyle("-fx-background-color:#ecf6fb;");
		st.setTitle("Calculatrice");
		st.setScene(scene);
		st.setOnCloseRequest(event -> {
			st.close();
		});
		
		// On paramètre la position, la taille et le style des labels
		t1.relocate(80, 110);
		t1.setPrefSize(369, 43);
		t1.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t1.setAlignment(Pos.CENTER);

		t2.relocate(80, 75);
		t2.setPrefSize(369, 43);
		t2.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t2.setAlignment(Pos.CENTER);
		
		t3.relocate(80, 40);
		t3.setPrefSize(369, 43);
		t3.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t3.setAlignment(Pos.CENTER);
		
		t4.relocate(80, 5);
		t4.setPrefSize(369, 43);
		t4.setStyle("-fx-background-radius: 10px; -fx-background-color: white; -fx-padding: 5px; -fx-max-height: 5px;-fx-border-color: gray;-fx-border-radius: 10px;");
		t4.setAlignment(Pos.CENTER);
		
		//On définit les dimensions des boutons
		double l = 81;
		double h = 47;

		//On crée tous les boutons 
		Bouton bouton1 = new Bouton("1", l, h, 80, 150);	

		Bouton bouton2 = new Bouton("2", l, h, 171, 150);

		Bouton bouton3 = new Bouton("3", l, h, 262, 150);

		Bouton bouton4 = new Bouton("4", l, h, 80, 208);

		Bouton bouton5 = new Bouton("5", l, h, 171, 208);

		Bouton bouton6 = new Bouton("6", l, h, 262, 208);

		Bouton bouton7 = new Bouton("7", l, h, 80, 264);

		Bouton bouton8 = new Bouton("8", l, h, 171, 264);

		Bouton bouton9 = new Bouton("9", l, h, 262, 264);

		Bouton bouton10 = new Bouton("0", l, h, 80, 322);

		Bouton bouton11 = new Bouton("Enter", 2*l + 10, h, 171, 377);

		Bouton bouton12 = new Bouton(".", l, h, 171, 322);

		Bouton bouton13 = new Bouton("+", l, h, 368, 208);

		Bouton bouton14 = new Bouton("-", l, h, 368, 266);

		Bouton bouton15 = new Bouton("*", l, h, 368, 320);

		Bouton bouton16 = new Bouton("/", l, h, 368, 377);

		Bouton bouton17 = new Bouton("+/-", l, h, 262, 322);

		Bouton bouton18 = new Bouton("<-", l, h, 368, 150);

		Bouton bouton19 = new Bouton("C", l, h, 80, 377);
		
		Bouton bouton20 = new Bouton("Vider Pile", l, h, 80, 436);
		
		Bouton bouton21 = new Bouton("Swap", l, h, 171, 436);
		
		Bouton bouton22 = new Bouton("Del elem", l, h, 262, 436);
		
		Bouton bouton23 = new Bouton("Afficher pile", l, h, 368, 436);
		
		CC.def_action_bouton(bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10,bouton11,bouton12,bouton13,bouton14,bouton15,bouton16,bouton17,bouton18,bouton19,bouton20,bouton21,bouton22,bouton23);
		
		//On ajoute les composants (labels et boutons) en tant que composants enfants du container st 
		root.getChildren().addAll(t1,t2,t3, t4);
		root.getChildren().addAll(bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10,bouton11,bouton12,bouton13,bouton14,bouton15,bouton16,bouton17,bouton18,bouton19);
		root.getChildren().addAll(bouton20,bouton21,bouton22,bouton23);
		st.show();

	}

	public void affiche() { //Cette méthode permet de mettre à jour l'affichage de la calculatrice
		if (CM.getAccu().matches(".*[-+*/].*") && !CM.getAccu().matches(".*\\d.*")) { //Si on effectue une opération
			t4.setText(t2.getText()); //Le dernier nombre rentré dans la pile est affiché sur la 4ème barre de texte
			t3.setText(t1.getText()); //L'opérateur est inscrit sur la 3ème barre de texte
			t2.setText("" + CM.pop()); //Le résultat est affiché sur la seconde barre de texte
		}
		else if (CM.getAccu() != null) {  //Sinon, lorsque accu n'est pas nul
			t4.setText(t3.getText()); //La 4ème barre de texte récupère l'information de la 3ème barre
			t3.setText(t2.getText()); //La 3ème celle de la seconde
			t2.setText(t1.getText()); //La seconde celle de la première
		}
		t1.setText("0"); //On affiche 0 sur la première barre de texte
	}

	public void changer_valeur(String accu) { //Cette méthode permet notamment d'afficher les messages d'erreur sur la calculatrice
		t1.setText(accu); //Sur la première barre de texte uniquement
	}
	
    public void afficher_pile() { //Cette méthode permet l'affichage d'une nouvelle fenêtre montrant le contenu de la pile
    	
    	Stage primaryStage = new Stage(); //Création de la fenêtre
        primaryStage.setTitle("Pile");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 200); //On choisit la taille de la fenêtre
        primaryStage.setScene(scene); 

        Label label = new Label(CM.getMemory()); //Création d'un label contenant la pile 
        layout.getChildren().add(label); //Ajout de la pile au layout afin de l'afficher sur la fenêtre

        primaryStage.show(); //Affichage de la fenêtre
    }
}
