package Jeu;

public class Canon extends Cases {
    public Canon() {
        super(0, 2);
    }

    @Override
    public void appliquerEffet(Joueur jouActu, Joueur jouAdv) {
        if (jouAdv != null) {
            if (jouAdv.getPositionJoueur() > jouActu.getPositionJoueur()) {
                // Atacar al adversario que está adelante
                jouAdv.setVie(jouAdv.getVie() - getCoeurs());
                jouAdv.setToursImmo(2);
            } else {
                // Si el adversario está atrás o en la misma posición, avanzo hacia él
                jouActu.setPositionJoueur(jouAdv.getPositionJoueur());
            }
        }
    }
}