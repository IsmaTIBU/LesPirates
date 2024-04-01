package Jeu;

import java.util.Random;
import java.util.HashMap;
import CasesSpe.*;

public class Plateau {
	private int[] nbCases;
	private HashMap<Integer, Boolean> casesCanon;
	private HashMap<Integer, VentFavo> casesVentFavo;

	public Plateau() {
	    this.nbCases = new int[30];
	    this.casesCanon = new HashMap<>();
	    this.casesVentFavo = new HashMap<>();
	    for (int i = 0; i < nbCases.length; i++) {
	        nbCases[i] = i + 1;
	    }
	}


	public int[] getNbCases() {
		return nbCases;
	}

	public HashMap<Integer, Boolean> getCasesCanon() {
		return casesCanon;
	}

	public HashMap<Integer, VentFavo> getCasesVentFavo() {
		return casesVentFavo;
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

	public void rajouterCaseCanon(int quantite) {
	    Random rand = new Random();
	    int compteur = 0;
	    while (compteur < quantite) {
	        int position = 1 + rand.nextInt(nbCases.length - 1); // Rango ajustado
	        if (caseDispo(position)) {
	            casesCanon.put(position, true);
	            compteur++;
	        }
	    }
	}

	public void rajouterCaseVentFavo(int quantite) {
	    Random rand = new Random();
	    int compteur = 0;
	    while (compteur < quantite) {
	        int position = rand.nextInt(nbCases.length-1); // Rango ajustado
	        if (caseDispo(position) && !casesVentFavo.containsKey(position)) {
	            casesVentFavo.put(position, new VentFavo());
	            compteur++;
	        }
	    }
	}


	public boolean caseDispo(int position) {
		return !casesCanon.containsKey(position) && !casesVentFavo.containsKey(position);
	}

	public boolean verifCaseCanon(int posicion) {
		return casesCanon.containsKey(posicion) && casesCanon.get(posicion);
	}

	public boolean verifCaseVentFavo(int position) {
		return casesVentFavo.containsKey(position);
	}

}
