package Jeu;

public class Joueur {
	private String nom;
	private int position = 0;

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public int getPosition() {
		return position;
	}

	public void avanceCase(int num) {
		position += num;
	}

	public void reculeCase(int num) {
		position = 30 - num;
	}
}
