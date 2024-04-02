package Jeu;

import java.util.Random;
import java.util.HashMap;
import CasesSpe.*;

public class Plateau {
	private int[] nbCases;
	private HashMap<Integer, Cases> casillasEspeciales;

	public Plateau() {
	    this.nbCases = new int[30];
	    this.casillasEspeciales = new HashMap<>();
	    for (int i = 0; i < nbCases.length; i++) {
	        nbCases[i] = i + 1;
	    }
	}

	
	public Cases getCasillaEspecial(int position) {
	    return casillasEspeciales.get(position);
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

	public void rajouterCasillaEspecial(int quantite, Cases casilla) {
	    Random rand = new Random();
	    int compteur = 0;
	    while (compteur < quantite) {
	        int position = rand.nextInt((29 - 2) + 1) + 2;
	        if (!casillasEspeciales.containsKey(position)) {
	            casillasEspeciales.put(position, casilla);
	            compteur++;
	        }
	    }
	}

	
	public void appliquerEffetCasillaEspecial(Joueur joueurActu, Joueur joueurAdv) {
	    Cases casilla = casillasEspeciales.get(joueurActu.getPositionJoueur());
	    if (casilla != null) {
	        if (casilla instanceof VentFavo) {
	            ((VentFavo) casilla).appliquerEffet(joueurActu,null);
	        } else if (casilla instanceof Canon) {
	            ((Canon) casilla).appliquerEffet(joueurActu, joueurAdv);
	        }
	    }
	}



}
