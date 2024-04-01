package Jeu;

import java.util.Scanner;
import CasesSpe.*;

public class Jeu {
	public static void main(String[] args) {
		Des des = new Des();
		Affichage aff = new Affichage();
		Plateau plat = new Plateau();
		Joueur zipi = new Joueur("Billy");
		Joueur zape = new Joueur("Mandy");
		Cases ventFavo = new VentFavo();
		Cases canon = new Canon();
		Scanner scanner = new Scanner(System.in);

		Joueur[] joueurs = { zipi, zape };

		plat.rajouterCaseCanon(0);
		plat.rajouterCaseVentFavo(10);

		boolean jeuFini = false;

		while (!jeuFini) {
			for (Joueur joueurActu : joueurs) {
				Joueur joueurAdv = (joueurActu == joueurs[0]) ? joueurs[1] : joueurs[0];
				aff.affPlateau(plat, joueurs);
				aff.affichVie(joueurActu);
				aff.affichDebut(joueurActu.getNom());
				scanner.nextLine();

				int[] resul = des.lancerDes();
				int avance = resul[0] + resul[1];

				plat.avanceJoueur(joueurActu, avance);
				aff.affichDes(joueurActu, resul);

				if (plat.verifCaseCanon(joueurActu.getPositionJoueur())) {
					canon.appliquerEffet(joueurActu, joueurAdv);
					aff.affichCase(joueurActu);
				}

				if (plat.verifCaseVentFavo(joueurActu.getPositionJoueur())) {
					ventFavo.appliquerEffet(joueurActu, null);
					aff.affichVentFavorable(joueurActu);
					aff.affichCase(joueurActu);
				}

				if (plat.verifGagnant(joueurActu)) {
					aff.affichFin(joueurActu.getNom());
					jeuFini = true;
					break;
				}

				if (plat.verifMort(joueurActu)) {
					aff.affichFin(joueurAdv.getNom());
					jeuFini = true;
					break;
				}
			}
		}

		scanner.close();
	}
}