package Jeu;

public class Joueur {
	private String nom;
	private int positionJoueur=0;;
	private int vie=5;

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public int getVie(){
		return this.vie;
	}
	
	public void setVie(int vie){
		this.vie=vie;
	}
	
	public int getPositionJoueur() {
		return this.positionJoueur;
	}
	
	public void setPositionJoueur(int position) {
        this.positionJoueur = position;
    }
}
