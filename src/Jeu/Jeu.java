package Jeu;

import java.util.Scanner;

public class Jeu {
    public void partie() {
        Des des = new Des();
        Affichage aff = new Affichage();
        Plateau plat = new Plateau();
        Joueur zipi = new Joueur("Billy", "BLEU");
        Joueur zape = new Joueur("Mandy", "VERT");
        Scanner scanner = new Scanner(System.in);
        Joueur[] joueurs = {zipi, zape};

        plat.rajouterCaseSpe(2, new VentFavo());
        plat.rajouterCaseSpe(6, new Canon());
        aff.affPlateau(plat, joueurs);
        boolean jeuFini = false;
        
        do {
            for (Joueur joueurActu : joueurs) {
                Joueur joueurAdv = (joueurActu == joueurs[0]) ? joueurs[1] : joueurs[0];

                if (joueurActu.getToursImmo() > 0) {
                    aff.affichEtourdi(joueurActu);
                    joueurActu.decrementerImmo();
                    continue;
                }
                
                aff.affichVie(joueurActu);
                aff.affichDebut(joueurActu.getNom(), joueurActu.getCouleur());
                scanner.nextLine();

                int[] resul = des.lancerDes();
                int avance = resul[0] + resul[1];

                plat.avanceJoueur(joueurActu, avance);
                aff.affichDes(joueurActu, resul);
                aff.affPlateau(plat, joueurs);
                plat.gestionCasesSpe(joueurActu, joueurAdv, aff);
                
                if (joueurActu.getVie() <= 0 || joueurAdv.getVie() <= 0) {
                    Joueur gagnant = joueurActu.getVie() > 0 ? joueurActu : joueurAdv;
                    aff.affichMort(gagnant == joueurActu ? joueurAdv : joueurActu, gagnant);
                    aff.affichFin(gagnant.getNom(), gagnant.getCouleur());
                    jeuFini = true;
                    break;
                }

                if (plat.verifGagnant(joueurActu)) {
                    aff.affichFin(joueurActu.getNom(), joueurActu.getCouleur());
                    jeuFini = true;
                    break;
                }
            }
        } while (!jeuFini);

        scanner.close();
    }
}


