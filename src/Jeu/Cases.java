package Jeu;

public abstract class Cases {
    private int deplacement;
    private int coeurs;
    
    public Cases(int deplacement, int coeurs) {
        this.deplacement = deplacement;
        this.coeurs = coeurs;
    }
    
    public int getDeplacement() {
        return deplacement;
    }
    
    public int getCoeurs() {
        return coeurs;
    }

    public abstract void appliquerEffet(Joueur joueur1,Joueur joueur2);
}
