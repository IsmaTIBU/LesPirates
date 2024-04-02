package Jeu;

public class Canon extends Cases {
    public Canon() {
        super(0, 3);
    }

    @Override
    public void appliquerEffet(Joueur jouActu, Joueur jouAdv) {
        if (jouAdv != null) {
            if(jouActu.getPositionJoueur() < jouAdv.getPositionJoueur()) {
                jouActu.setPositionJoueur(jouAdv.getPositionJoueur());
            } else if(jouActu.getPositionJoueur() >= jouAdv.getPositionJoueur()) {
                jouAdv.setVie(jouAdv.getVie() - getCoeurs());
                jouAdv.setToursImmo(2);
            }
        }
    }
}
