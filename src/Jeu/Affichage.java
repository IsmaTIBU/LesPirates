package Jeu;

public class Affichage {
	Des des = new Des();
	Plateau plateau=new Plateau();
	Cases cases = new Cases();

	public void affichDes() {
		System.out.println(des.lancerDes());
	}
	
	public void affichCase() {
		if(cases.getNumCase()==plateau.nbCases[0]) {
			System.out.println("Vous etes à la case initiale.");
		}else if(cases.getNumCase()==plateau.nbCases[30]) {
			System.out.println("Vous avez arriver finalement à la dernière case!!");
		}else{
			System.out.println("Vous etes à la case "+cases.getNumCase());
		}
	}
}
