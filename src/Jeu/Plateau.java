package Jeu;

import java.util.Random;
import java.util.HashMap;

public class Plateau {
	private int[] nbCases;
	private HashMap<Integer, Cases> casesSpes;

	public Plateau() {
		this.nbCases = new int[30];
		this.casesSpes = new HashMap<>();
		for (int i = 0; i < nbCases.length; i++) {
			nbCases[i] = i + 1;
		}
	}

	public Cases getCaseSpe(int position) {
		return casesSpes.get(position);
	}

	public int[] getNbCases() {
		return nbCases;
	}

	public int verifSomme(int nbInit, int valDes) {
		int somme = nbInit + valDes;
		int lim = nbCases.length;
		int recul = 0;

		if (somme > (lim)) {
			recul = (somme - lim);
		}
		return recul;
	}

	public boolean verifGagnant(Joueur joueur) {
		return joueur.getPositionJoueur() == nbCases.length;
	}

	public boolean verifMort(Joueur joueur) {
		return joueur.getVie() <= 0;
	}

	public void avanceJoueur(Joueur joueur, int avance) {
		int positionJoueur = joueur.getPositionJoueur();
		int recul = verifSomme(joueur.getPositionJoueur(), avance);
		if (recul == 0) {
			positionJoueur += avance;
		} else {
			positionJoueur = 30 - recul;
		}
		joueur.setPositionJoueur(positionJoueur);
	}

	public void rajouterCaseSpe(int quantite, Cases casilla) {
		Random rand = new Random();
		int compteur = 0;
		while (compteur < quantite) {
			int position = rand.nextInt((29 - 2) + 1) + 2;
			if (!casesSpes.containsKey(position)) {
				casesSpes.put(position, casilla);
				compteur++;
			}
		}
	}

	public void appliquerEffetCaseSpe(Joueur joueurActu, Joueur joueurAdv) {
	    Cases cases = casesSpes.get(joueurActu.getPositionJoueur());
	    if (cases != null) {
	        if (cases instanceof VentFavo) {
	            ((VentFavo) cases).appliquerEffet(joueurActu, joueurAdv);
	        } else if (cases instanceof Canon) {
	            ((Canon) cases).appliquerEffet(joueurActu, joueurAdv);
	        } else if (cases instanceof Rhum) {
	            ((Rhum) cases).appliquerEffet(joueurActu, joueurAdv);
	        }
	    }
	}


	public void gestionCasesSpe(Joueur joueurActu, Joueur joueurAdv, Affichage aff) {
		int positionActuelle = joueurActu.getPositionJoueur();
		Cases caseSpe = getCaseSpe(positionActuelle);
		if (caseSpe != null && joueurActu.getVie() > 0) {
			appliquerEffetCaseSpe(joueurActu, joueurAdv);
			if (caseSpe instanceof Canon) {
				if (joueurActu.getPositionJoueur() > joueurAdv.getPositionJoueur()) {
					aff.affichCanonAvant(joueurActu, joueurAdv);
				} else {
					aff.affichCanonDerr(joueurActu, joueurAdv);
				}
			} else if (caseSpe instanceof VentFavo) {
				aff.affichVentFavo(joueurActu);
				aff.affichCase(joueurActu);
			}else if(caseSpe instanceof Rhum) {
				aff.affichRhum(joueurActu);
				aff.affichCase(joueurActu);
			}
		}
	}

}
