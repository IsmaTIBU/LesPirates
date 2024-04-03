package Jeu;

public class VentFavo extends Cases {
	public VentFavo() {
		super(10, 0);
	}

	@Override
	public void appliquerEffet(Joueur joueur1, Joueur joueur2) {
	    int avance = getDeplacement();
	    int positionJoueur = joueur1.getPositionJoueur();
	    positionJoueur += avance;
	    if (positionJoueur > 30) {
	        int exceso = positionJoueur - 30;
	        positionJoueur = 30 - exceso;
	    }
	    joueur1.setPositionJoueur(positionJoueur);
	}

}
