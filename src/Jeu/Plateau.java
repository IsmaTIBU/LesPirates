package Jeu;

public class Plateau {
	int[] nbCases;

    public Plateau() {
        this.nbCases = new int[31];
        for (int i = 0; i < nbCases.length; i++) {
            nbCases[i] = i;
        }
    }
    
    public int getNombreDeCases() {
        return nbCases.length;
    }
}
