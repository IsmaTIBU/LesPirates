package Jeu;

import java.util.Scanner;

public class Jeu {
	public static void main(String[] args) {
		Des des = new Des();
		Joueur zipi = new Joueur("Zipi");
		Joueur zape = new Joueur("Zape");
		Joueur[] joueurs = {zipi, zape};
		Affichage aff = new Affichage();
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
                joueur.avanceJoueur(avance);
                gagnant = joueur.verifGagnant();
                if (gagnant) {
                    aff.affichFin(joueur.getNom());
                    break;
                }
            }
        }
		scanner.close();
	}
}
