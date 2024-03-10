package Jeu;

public class Joueur {
	String nom;
	Plateau plateau = new Plateau();
	Cases cases = new Cases();
	Des des = new Des();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public int verifSomme(int nbInit, int valDes) {
		int somme = nbInit + valDes;
		int lim = plateau.getNombreDeCases() - 1;
		int recul = 0;

		if (somme > (lim)) {
			recul = (somme - lim);
		}
		return recul;
	}

	public void avanceJoueur(int avance) {
		int recul = verifSomme(cases.getNumCase(), avance);
		if (recul == 0) {
			cases.avanceCase(avance);
		} else {
			cases.reculeCase(recul);
		}
	}

	public int caseJoueur() {
		return cases.getNumCase();
	}

	public boolean verifGagnant() {
        return this.cases.getNumCase() >= 30;
    }
}
