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
	    Cases casilla = casesSpes.get(joueurActu.getPositionJoueur());
	    if (casilla != null) {
	        if (casilla instanceof VentFavo) {
	            ((VentFavo) casilla).appliquerEffet(joueurActu,null);
	        } else if (casilla instanceof Canon) {
	            ((Canon) casilla).appliquerEffet(joueurActu, joueurAdv);
	        }
	    }
	}
	
	public void gestionCasesSpe(Joueur joueurActu, Joueur joueurAdv, Affichage aff) {
	    int positionActuelle = joueurActu.getPositionJoueur();
	    Cases casillaEspecial = getCaseSpe(positionActuelle);
	    if (casillaEspecial != null && joueurActu.getVie() > 0) {
	        appliquerEffetCaseSpe(joueurActu, joueurAdv);
	        if (casillaEspecial instanceof Canon) {
	            if (joueurActu.getPositionJoueur() > joueurAdv.getPositionJoueur()) {
	                aff.affichCanonAvant(joueurActu, joueurAdv);
	            } else {
	                aff.affichCanonDerr(joueurActu, joueurAdv);
	            }
	        } else if (casillaEspecial instanceof VentFavo) {
	            aff.affichVentFavorable(joueurActu);
	            aff.affichCase(joueurActu);
	        }
	    }
	}



}
