package Jeu;

import java.util.Scanner;

public class Jeu {
	public static void main(String[] args) {
		Des des = new Des();
		Affichage aff = new Affichage();
		Plateau plat = new Plateau();
		Joueur zipi = new Joueur("Solal");
		Joueur zape = new Joueur("Ismael");

		Joueur[] joueurs = { zipi, zape };

		Scanner scanner = new Scanner(System.in);

		boolean gagnant = false;

		while (!gagnant) {
			for (Joueur joueur : joueurs) {
				aff.affichCase(joueur);
				aff.affichDebut();
				scanner.nextLine();
				int[] resultats = des.lancerDes();
				aff.affichDes(resultats);
				int avance = resultats[0] + resultats[1];
				plat.avanceJoueur(joueur, avance);
				gagnant = plat.verifGagnant(joueur);
				if (gagnant) {
					aff.affichFin(joueur.getNom());
					break;
				}
			}
		}
		scanner.close();
	}
}