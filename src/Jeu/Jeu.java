package Jeu;

import java.util.Scanner;

public class Jeu {
	public void partie() {
		Des des = new Des();
        Affichage aff = new Affichage();
        Plateau plat = new Plateau();
        Joueur zipi = new Joueur("Billy", "BLEU");
        Joueur zape = new Joueur("Mandy", "VERT");
        Scanner scanner = new Scanner(System.in);
        Joueur[] joueurs = {zipi, zape};
		
		plat.rajouterCaseSpe(2, new VentFavo());
		plat.rajouterCaseSpe(5, new Canon());
		plat.rajouterCaseSpe(2, new Rhum());

		aff.affPlateau(plat, joueurs);
		boolean jeuFini = false;

		do {
			for (Joueur joueurActu : joueurs) {
				Joueur joueurAdv = (joueurActu == joueurs[0]) ? joueurs[1] : joueurs[0];

				if (joueurActu.getToursImmo() > 0) {
					aff.affichEtourdi(joueurActu);
					joueurActu.decrementerImmo();
				} else {
					aff.affichVie(joueurActu);
					aff.affichDebut(joueurActu.getNom(), joueurActu.getCouleur());
					scanner.nextLine();

					int[] resul = des.lancerDes();
					int avance = resul[0] + resul[1];

					plat.avanceJoueur(joueurActu, avance);
					aff.affichDes(joueurActu, resul);
					plat.gestionCasesSpe(joueurActu, joueurAdv, aff);
					aff.affPlateau(plat, joueurs);
				}

				if (joueurActu.getVie() <= 0 || joueurAdv.getVie() <= 0 || plat.verifGagnant(joueurActu)) {
					jeuFini = true;
					Joueur gagnant = joueurActu.getVie() > 0 ? joueurActu : joueurAdv;
					aff.affichMort(gagnant == joueurActu ? joueurAdv : joueurActu, gagnant);
					aff.affichFin(gagnant.getNom(), gagnant.getCouleur());
					break;
				}
			}
		} while (!jeuFini);

		scanner.close();
	}

}