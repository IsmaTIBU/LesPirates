package Jeu;

import java.util.Scanner;
import CasesSpe.*;

public class Jeu {
    public static void main(String[] args) {
        Des des = new Des();
        Affichage aff = new Affichage();
        Plateau plat = new Plateau();
        Joueur zipi = new Joueur("Billy", "BLEU");
        Joueur zape = new Joueur("Mandy", "VERT");
        Scanner scanner = new Scanner(System.in);

        Joueur[] joueurs = {zipi, zape};

        plat.rajouterCasillaEspecial(0, new VentFavo());
        plat.rajouterCasillaEspecial(15, new Canon());

        boolean jeuFini = false;
        aff.affPlateau(plat, joueurs);
        while (!jeuFini) {
        	for (Joueur joueurActu : joueurs) {
                Joueur joueurAdv = (joueurActu == joueurs[0]) ? joueurs[1] : joueurs[0];
                
                if (joueurActu.getVie() <= 0) {
                    aff.affichMort(joueurAdv, joueurActu);
                    jeuFini = true;
                    aff.affichFin(joueurAdv.getNom());
                    break;
                }
                
                aff.affichVie(joueurActu);
                aff.affichDebut(joueurActu.getNom(), joueurActu.getCouleur());
                scanner.nextLine();

                int[] resul = des.lancerDes();
                int avance = resul[0] + resul[1];

                plat.avanceJoueur(joueurActu, avance);
                aff.affichDes(joueurActu, resul);
                aff.affPlateau(plat, joueurs);

                int positionAvantEffet = joueurActu.getPositionJoueur();
                Cases casillaEspecial = plat.getCasillaEspecial(positionAvantEffet);

                if (casillaEspecial != null && joueurActu.getVie()>0) {
                    plat.appliquerEffetCasillaEspecial(joueurActu, joueurAdv);

                    if (casillaEspecial instanceof Canon) {
                        if (joueurActu.getPositionJoueur() > joueurAdv.getPositionJoueur()) {
                            aff.affichCanonAvant(joueurActu, joueurAdv);
                        } else {
                        	aff.affichCanonDerr(joueurActu, joueurAdv);
                        }
                    } else if (casillaEspecial instanceof VentFavo) {
                        aff.affichVentFavorable(joueurActu);
                        aff.affichCase(joueurActu);
                    }
                }


                
                if (joueurActu.getVie() <= 0) {
                    aff.affichMort(joueurAdv, joueurActu);
                    jeuFini = true;
                    aff.affichFin(joueurAdv.getNom());
                    break;
                }

                if (plat.verifGagnant(joueurActu)) {
                    aff.affichFin(joueurActu.getNom());
                    jeuFini = true;
                    break;
                }
            }
        }

        scanner.close();
    }
}

