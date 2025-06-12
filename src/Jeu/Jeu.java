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
		Joueur[] joueurs = { zipi, zape };

		// 🔧 CORREGIDO: Usar el nuevo método que crea instancias separadas
		plat.rajouterCaseSpe(2, VentFavo.class);
		plat.rajouterCaseSpe(5, Canon.class);
		plat.rajouterCaseSpe(2, Rhum.class);

		aff.affPlateau(plat, joueurs);
		boolean jeuFini = false;

		do {
			for (Joueur joueurActu : joueurs) {
				Joueur joueurAdv = (joueurActu == joueurs[0]) ? joueurs[1] : joueurs[0];

				// 🔧 CORREGIDO: Verificar condiciones de fin antes del turno
				if (joueurActu.getVie() <= 0) {
					aff.affichMort(joueurActu, joueurAdv);
					aff.affichFin(joueurAdv.getNom(), joueurAdv.getCouleur());
					jeuFini = true;
					break;
				}

				if (plat.verifGagnant(joueurActu)) {
					aff.affichFin(joueurActu.getNom(), joueurActu.getCouleur());
					jeuFini = true;
					break;
				}

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

				// 🔧 CORREGIDO: Verificar condiciones de fin después del turno
				if (joueurActu.getVie() <= 0) {
					aff.affichMort(joueurActu, joueurAdv);
					aff.affichFin(joueurAdv.getNom(), joueurAdv.getCouleur());
					jeuFini = true;
					break;
				}

				if (joueurAdv.getVie() <= 0) {
					aff.affichMort(joueurAdv, joueurActu);
					aff.affichFin(joueurActu.getNom(), joueurActu.getCouleur());
					jeuFini = true;
					break;
				}

				if (plat.verifGagnant(joueurActu)) {
					aff.affichFin(joueurActu.getNom(), joueurActu.getCouleur());
					jeuFini = true;
					break;
				}
			}
		} while (!jeuFini);

		scanner.close();
	}
}