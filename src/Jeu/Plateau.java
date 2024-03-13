package Jeu;

public class Plateau {
	private int[] nbCases;

	public Plateau() {
		this.nbCases = new int[30];
		for (int i = 0; i < nbCases.length; i++) {
			nbCases[i] = i;
		}
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
		return joueur.getPosition() == nbCases.length;
	}

	public void avanceJoueur(Joueur joueur, int avance) {
		int recul = verifSomme(joueur.getPosition(), avance);
		if (recul == 0) {
			joueur.avanceCase(avance);
		} else {
			joueur.reculeCase(recul);
		}
	}
}
