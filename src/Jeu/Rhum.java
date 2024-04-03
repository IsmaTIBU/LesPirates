package Jeu;

public class Rhum extends Cases{
	public Rhum() {
		super(3,2);
	}
	
	public void appliquerEffet(Joueur joueur1, Joueur joueur2) {
		joueur1.setPositionJoueur(joueur1.getPositionJoueur() - getDeplacement());
		joueur1.setVie(joueur1.getVie()+getCoeurs());
	}
}
