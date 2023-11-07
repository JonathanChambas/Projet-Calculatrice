package Controler;

import View.Bouton;
import Model.CalculatorModel;
import View.CalculatorGUI;

public class CalculatorControler implements CalculatorControlerInterface {
    private CalculatorModel CM;
    private CalculatorGUI CG;

    public CalculatorControler(CalculatorGUI calculatorGUI,CalculatorModel calculatorModel) {
    	this.CG = calculatorGUI;
    	this.CM = calculatorModel;
    }
    
    public void def_action_bouton(Bouton bouton1, Bouton bouton2, Bouton bouton3, Bouton bouton4, Bouton bouton5, Bouton bouton6, Bouton bouton7, Bouton bouton8, Bouton bouton9, Bouton bouton10, Bouton bouton11, Bouton bouton12, Bouton bouton13, Bouton bouton14, Bouton bouton15, Bouton bouton16, Bouton bouton17, Bouton bouton18, Bouton bouton19, Bouton bouton20, Bouton bouton21, Bouton bouton22, Bouton bouton23) {
    	//par la méthode setOnAction, on associe un clic sur le bouton à la fonctionnalité correspondante dans Model
    	bouton1.setOnAction(e -> {CM.setAccu("1");});	//Les boutons 0 à 9 ajoute le chiffre à la fin de accu
		bouton2.setOnAction(e -> {CM.setAccu("2");});
		bouton3.setOnAction(e -> {CM.setAccu("3");});
		bouton4.setOnAction(e -> {CM.setAccu("4");});
		bouton5.setOnAction(e -> {CM.setAccu("5");});
		bouton6.setOnAction(e -> {CM.setAccu("6");});
		bouton7.setOnAction(e -> {CM.setAccu("7");});
		bouton8.setOnAction(e -> {CM.setAccu("8");});
		bouton9.setOnAction(e -> {CM.setAccu("9");});
		bouton10.setOnAction(e -> {CM.setAccu("0");});
		bouton11.setOnAction(e -> {CG.affiche();//Le bouton entrée fait appel à la fonction permettant de changer l'affichage
								   CM.push();});  //accu est alors rentré dans la pile avec la méthode push 
		 
		bouton12.setOnAction(e -> {CM.setAccu(".");}); //Le bouton 12 permet de mettre un "." pour représenter les nombres décimaux
		bouton13.setOnAction(e -> {
			if (CM.add()) {     //On commence par effectuer l'addition, si la fonction renvoie true
			   CM.setAccu("+"); //Alors l'addition s'est effectuée et on remplace accu par l'opérateur +
			   CG.affiche();//Afin que l'affichage soit modifié différemment lorsque accu est un opérateur plutot qu'un nombre
			   CM.push();}    //accu est alors rentré dans la pile
			else {
				CG.changer_valeur("Pas assez d'élément dans la pile");
				CM.push();
			}});
													 //Mais également entre par rapport au cas où l'addition n'a pas pu s'effectuer
		bouton14.setOnAction(e -> {if (CM.substract()) { //Cela fonctionne de la même manière pour les autres opérateurs
								   CM.setAccu("-");
								   CG.affiche();
								   CM.push();
								   }
								   else {
										CG.changer_valeur("Pas assez d'élément dans la pile");
									}});
		bouton15.setOnAction(e -> { if (CM.multiply()) { //Cela fonctionne de la même manière pour les autres opérateurs
			   							CM.setAccu("*");
			   							CG.affiche();
			   							CM.push();
			   							}
			   						else {
			   							CG.changer_valeur("Pas assez d'élément dans la pile");
			   						}});
		bouton16.setOnAction(e -> {	if (CM.divide()) { //Cela fonctionne de la même manière pour les autres opérateurs
										CM.setAccu("/");
										CG.affiche();
										CM.push();
										}});
		bouton17.setOnAction(e -> {CM.opposite();}); //Ce bouton permet de remplacer accu par son opposé
		bouton18.setOnAction(e -> {CM.del();}); //Ce bouton permet d'enlever un caractère de la chaine accu
		bouton19.setOnAction(e -> {CM.supprimer();}); //Ce bouton remplace accu par 0
		bouton20.setOnAction(e -> {CM.clear();}); //Ce bouton permet de vider la pile
		bouton21.setOnAction(e -> {CM.swap();}); //	Ce bouton permet d'intervertir les deux derniers éléments de la pile
		bouton22.setOnAction(e -> {CM.drop();}); //Ce bouton supprime le dernier élément de la pile 
		bouton23.setOnAction(e -> {CG.afficher_pile();}); //Ce bouton permet d'afficher la fenêtre affichant la pile
		
    }
    
    public double change(String accu) {
        return Double.valueOf(accu);
    }
    
}
