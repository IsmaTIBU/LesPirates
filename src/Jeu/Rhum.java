package Jeu;

public class Rhum extends Cases {
	public Rhum() {
		super(3, 2);
	}

	@Override
	public void appliquerEffet(Joueur joueur1, Joueur joueur2) {
		// Retroceder siempre
		int nuevaPos = joueur1.getPositionJoueur() - getDeplacement();
		if (nuevaPos < 0) {
			nuevaPos = 0;
		}
		joueur1.setPositionJoueur(nuevaPos);

		int vidaActual = joueur1.getVie();
		int nuevaVida = vidaActual + getCoeurs();
		if (nuevaVida > 5) {
			nuevaVida = 5; // Máximo 5 corazones
		}
		joueur1.setVie(nuevaVida);
	}
}