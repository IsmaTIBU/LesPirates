package Jeu;

public class Joueur {
	String nom;
	Plateau plateau=new Plateau();
	Cases cases=new Cases();
	Des des=new Des();
	
	public Joueur (String nom) {
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int caseJoueur() {
		return cases.getNumCase()+des.lancerDes();
	}
}
