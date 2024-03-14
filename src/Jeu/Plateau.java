package Jeu;

public class Plateau {
	private int[] nbCases;
	private int positionJoueur=0;
	
	public Plateau() {
		this.nbCases = new int[30];
		for (int i = 0; i < nbCases.length; i++) {
			nbCases[i] = i;
		}
	}
	
	public int getPositionJoueur() {
		return positionJoueur;
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
		return getPositionJoueur() == nbCases.length;
	}

	public void avanceJoueur(Joueur joueur, int avance) {
		positionJoueur = getPositionJoueur();
		int recul = verifSomme(getPositionJoueur(), avance);
		if (recul == 0) {
			positionJoueur += avance;
		} else {
			positionJoueur = 30 - recul;
		}
	}
}
