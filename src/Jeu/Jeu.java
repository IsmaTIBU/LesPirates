package Jeu;
import java.util.Scanner;

public class Jeu {
	public static void main(String[] args) {
		Des des = new Des();
		Plateau plateau = new Plateau();
		Joueur joueur = new Joueur("Solal");
		Affichage aff = new Affichage();
		Scanner scanner = new Scanner(System.in);
		
		while (joueur.caseJoueur() != plateau.nbCases[30]) {
			aff.affichCase();
			System.out.println("Appuyer sur ENTER pour lancer les dés");
            scanner.nextLine();
			des.lancerDes();
			joueur.caseJoueur();
		}
		scanner.close();
	}
}
