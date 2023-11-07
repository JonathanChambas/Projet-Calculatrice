package Model;

import View.CalculatorGUI;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> memory = new Stack<Double>();
    private String accu;
    private CalculatorGUI CG; 

    public CalculatorModel(CalculatorGUI calculatorGUI) {
        this.CG = calculatorGUI;
    }
	
	public String getAccu() { //Création d'un getter pour obtenir la valeur de accu
		return accu;
	}
	
	public String getMemory() { //Création d'un getter pour obtenir la pile memory 
		return memory.toString(); //Pour pouvoir l'afficher, on la passe en String
	}

	public void setAccu(String s) { //Création d'un setter pour modifier accu
        if (accu == null || accu.substring(0, 1).equals("0") ) { //Si accu est null ou vaut 0 
            accu = s; //On remplace accu par la valeur demandé
        } 
        else if (accu.contains(".") && s.equals(".")) { } //Si accu possède déjà un point et qu'on souhaite rajouter un . dans 
        //l'expression de accu, on ne fait rien
        else { 
            accu = accu + s; //Sinon on ajoute la valeur demandé à la suite de accu
        }
        CG.changer_valeur(accu); //Dès qu'accu est modifié, on change l'affichage de la calculatrice
    }


	public boolean add() {
		if (memory.empty() == false) { //Si la pile n'est pas vide
			double x = drop(); //On récupère le dernier élément de la pile
			if (memory.empty() == false) { //Si elle n'est toujours pas vide après avoir retiré le dernier élément de la pile
				double y = drop(); //On en récupère un deuxième
				memory.push(x+y); //Et on met dans la pile le résultat
				return true; //Les return true et false permettent de savoir quoi afficher sur la pile depuis le controler
			}
			else { //Si la pile ne possède qu'un élément
				memory.push(x); //On le remet dans la pile
				return false;
			}
		} 
		else { //Si la pile ne possède pas d'élément
			accu = "0"; //accu redevient égale à 0 au lieu d'être égal à l'opérateur
			return false;
		}
	}

	public boolean substract() {
		if (memory.empty() == false) { //De la même manière que pour l'addition
			double x = drop();
			if (memory.empty() == false) {
				double y = drop();
				memory.push(x-y); //On effectue la soustraction si la pile contient deux éléments
				return true;
			}
			else { 
				memory.push(x); //Si elle n'en contient qu'un, on le remet dans la pile
				return false;
			}
		} 	
		else {
			accu = "0";; //Sinon, accu redevient égale à 0
			return false;
		}
	}

	public boolean multiply() { //De la même manière pour la multiplication
		if (memory.empty() == false) {
			double x = drop();
			if (memory.empty() == false) {
				double y = drop();
				memory.push(x*y);
				return true;
			}
			else { 
				memory.push(x);
				return false;
			}
		} 	
		else {
			accu = "0";
			return false;
		}
	}

	public boolean divide() { //De la même manière pour la division, sauf que les messages sont modifiés depuis le modèle (pour la division par 0 notamment)
		if (memory.empty() == false) { 
			double x = drop();
			if (x == 0) { //Sauf si le premier élément qu'on retire de la pile est égal à 0
				memory.push(x); //On remet le 0 dans la pile
				accu = "0"; //accu redevient égal à 0 au lieu d'être égal à l'opérateur
				CG.changer_valeur("Division par 0 interdite"); //On écrit sur la calculatrice que la division par 0 n'est pas possible
				return false;
			}
			else if (memory.empty() == false) {
				double y = drop();
				memory.push(y/x);
				return true;
			}
			else {
				memory.push(x);
				CG.changer_valeur("Pas assez d'élément dans la pile");
				return false;
			}
		}
		else {
			accu = "0";
			CG.changer_valeur("Pas assez d'élément dans la pile");
			return false;
		}
	}

	public void opposite() { 
		if (accu.substring(0,1).equals("-")) { //On regarde si le premier élément du String accu est un "-"
			accu = accu.substring(1, accu.length()); //Si c'est le cas, on garde tous les éléments qui composent le String accu sauf le "-"
		}
		else { //Sinon
			accu = "-" + accu; //On ajoute un "-" devant accu
		}
		CG.changer_valeur(accu); //On affiche la nouvelle valeur de accu
	}

	public void push() { 
		if (accu.matches(".*[-+*/].*") && !accu.matches(".*\\d.*") ) { //Si accu contient des opérateurs dans son expression
			accu = "0"; //Accu devient égal au dernier élément de la pile (c'est-à-dire le résultat des opérations effectuées)
		}
		else if (accu.equals(".")) { //Si accu ne contient qu'un .
			memory.push(0.); //On push 0 dans la pile
		}
		else if (accu.matches("\\d*[-+*/]+")) {//Dans le cas où on appuierait sur des chiffres puis un opérateur sans avoir push le nombre dans la pile
			accu = "0";//On appliquerait l'opération au lieu d'obtenir une erreur sur la console
		} 
		else { //Sinon
			memory.push(Double.valueOf(accu)); //On push la valeur de accu dans la pile une fois convertie en double
		}
		accu = "0";	//accu redevient égal à 0
	}

	public double pop() { //Méthode permettant d'obtenir le dernier élément de la pile sans le retirer
		try {
			return memory.peek(); //On essaye d'afficher le dernier élément de la pile
		}
		catch (EmptyStackException e) { ; //Sinon on catch l'exception
		return Double.NaN; //Et on retourne le double NaN
		}
	}

	public double drop() { //Méthode permettant d'enlever le dernier élément de la pile
		try {
			return memory.pop(); //On essaye d'enlever et de retourner le dernier élément de la pile
		}
		catch (EmptyStackException e) {
			return Double.NaN;//Sinon l'exception est catch et on renvoie le double NaN
		} 
	}

	public void swap() { //Méthode permettant d'intervertir la position des deux derniers éléments de la pile
		if (memory.empty() == false) { //Si la pile n'est pas vide
			double x = drop(); //x prend la valeur du dernier élément
			if (memory.empty() == false) { //Si après avoir retiré un élément, la pile n'est toujours pas vide
				double y = drop(); //y prend la valeur du dernier élément
				memory.push(x); //On push d'abord x dans la pile
				memory.push(y); //Puis ensuite y
			}
			else {
				memory.push(x); //Si la pile ne contient qu'un élément, il est remis dans la pile
			}
		}
	}

	public void clear() { //Méthode permettant de vider la pile
		while (memory.empty() == false) { //Tant que la pile n'est pas vide
			drop(); //On retire le dernier élément de la pile
		}
	}

	public void del() { //Méthode permettant de supprimer un élément de la chaine de caractère accu
		if (accu.length() > 1) { //Si accu contient plus d'un élément dans sa chaine de caractère
			accu = accu.substring(0,accu.length()-1); //On retire le dernier élément
		}
		else if (accu.length() == 1) { //Si accu ne contient qu'un élément dans sa chaine de caractère
			accu = "0"; //accu devient égale à 0
		}
		CG.changer_valeur(accu); //On modifie l'affichage
	}

	public void supprimer() { //Méthode permettant de supprimer toute la chaine de caractère accu
		accu = "0"; //accu devient égal à 0
		CG.changer_valeur(accu); //On modifie l'affichage
	}

}
