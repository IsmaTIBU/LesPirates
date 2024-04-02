package Jeu;

public class Joueur {
	private String nom;
    private int positionJoueur = 0;
    private int vie = 5;
    private String couleur;
    private int toursImmo = 0;

	public Joueur(String nom, String couleur) {
		this.nom = nom;
		this.couleur=couleur;
	}

	public String getNom() {
		return nom;
	}
	
	public String getCouleur() {
		return couleur;
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
	
	public int getToursImmo() {
        return toursImmo;
    }
	
	public void setToursImmo(int immobiliseTurnos) {
        this.toursImmo = immobiliseTurnos;
    }
	
	public void decrementerImmo() {
        if (toursImmo > 0) {
        	toursImmo--;
        }
    }
}
