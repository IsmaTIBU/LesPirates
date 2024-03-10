package Jeu;

public class Affichage {
	Des des = new Des();
	Plateau plateau=new Plateau();
	Cases cases = new Cases();

	public void affichDebut() {
		System.out.println("À ton tour, appuye sur ENTER pour lancer les dés");
	}
	
	public void affichFin(String nom) {
		System.out.println("Felicitations, c'est "+nom+" qui a gagné");
	}
	
	public void affichDes(int[] des) {
        System.out.println("T'as sorti un " + des[0] + " et un " + des[1]+"\n");
    }
	
	public void affichCase(Joueur joueur) {
        int numCase = joueur.caseJoueur();

        if(numCase == 0) {
            System.out.println(joueur.getNom()+" t'es à la case initiale.");
        } else if(numCase == 30) {
            System.out.println(joueur.getNom()+" t'es finalement arrivé à la dernière case!!");
        } else {
            System.out.println(joueur.getNom()+" t'es à la case " + numCase);
        }
    }
}
