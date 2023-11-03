package View;

import javafx.scene.control.Button;

public class Bouton extends Button {
	
    public Bouton(String text, double width, double height, int x, int y) {
        super(text);
        setPrefSize(width, height);
        setLayoutX(x);
        setLayoutY(y);
        }
    
}
