package Jeu;

import java.util.Scanner;
import CasesSpe.*;

public class Jeu {
    public static void main(String[] args) {
        Des des = new Des();
        Affichage aff = new Affichage();
        Plateau plat = new Plateau();
        Joueur zipi = new Joueur("Billy","BLEU");
        Joueur zape = new Joueur("Mandy","VERT");
        Scanner scanner = new Scanner(System.in);

        Joueur[] joueurs = {zipi, zape};

        plat.rajouterCasillaEspecial(5, new VentFavo());
        plat.rajouterCasillaEspecial(3, new Canon());

        boolean jeuFini = false;

        while (!jeuFini) {
            for (Joueur joueurActu : joueurs) {
                Joueur joueurAdv = (joueurActu == joueurs[0]) ? joueurs[1] : joueurs[0];
                aff.affPlateau(plat, joueurs);
                aff.affichVie(joueurActu);
                aff.affichDebut(joueurActu.getNom(),joueurActu.getCouleur());
                scanner.nextLine();

                int[] resul = des.lancerDes();
                int avance = resul[0] + resul[1];

                plat.avanceJoueur(joueurActu, avance);
                aff.affichDes(joueurActu, resul);
                plat.appliquerEffetCasillaEspecial(joueurActu, joueurAdv);

                Cases casillaEspecial = plat.getCasillaEspecial(joueurActu.getPositionJoueur());
                if (casillaEspecial instanceof VentFavo) {
                    aff.affichVentFavorable(joueurActu);
                    aff.affichCase(joueurActu);
                } else if (casillaEspecial instanceof Canon) {
                    aff.affichCanon(joueurActu, joueurAdv);
                    aff.affichCase(joueurActu);
                }

                if (plat.verifGagnant(joueurActu)) {
                    aff.affichFin(joueurActu.getNom());
                    jeuFini = true;
                    break;
                }

                if (plat.verifMort(joueurActu)) {
                    aff.affichFin(joueurAdv.getNom());
                    jeuFini = true;
                    break;
                }
            }
        }


        scanner.close();
    }
}
