package Jeu;

public class Affichage {

	public void affichDebut(String nom) {
		System.out.println("À ton tour, "+nom+" appuye sur ENTER pour lancer les dés");
	}

	public void affichFin(String nom) {
		System.out.println("Felicitations, c'est " + nom + " qui a gagné");
	}

	public void affichDes(Joueur joueur,int[] des) {
		System.out.println("T'as sorti un " + des[0] + " et un " + des[1] +", t'es à la case "+joueur.getPositionJoueur()+ "\n");
	}

	public void affichCase(Joueur joueur) {
		int numCase = joueur.getPositionJoueur();

		if (numCase == 0) {
			System.out.println(joueur.getNom() + " t'es à la case initiale.");
		} else {
			System.out.println(joueur.getNom() + " t'es à la case " + numCase);
		}
	}
	
	public void affichCanon(Joueur jouActu, Joueur jouAdv) {
	    if (jouAdv != null) {
	        if (jouActu.getPositionJoueur() < jouAdv.getPositionJoueur()) {
	            System.out.println(jouActu.getNom() + " se lance contre " + jouAdv.getNom());
	        } else if (jouActu.getPositionJoueur() >= jouAdv.getPositionJoueur()) {
	            System.out.println(jouActu.getNom() + " lance un coup de boulet à " + jouAdv.getNom());
	        }
	    }
	}

	
	public void affichVentFavorable(Joueur joueur) {
		System.out.println(joueur.getNom()+" t'as eu de la chance, t'avance de 10 cases!");
	}
	
	public void affichVie(Joueur joueur) {
	    final String ANSI_RED = "\u001B[31m";
	    final String ANSI_RESET = "\u001B[0m";
	    System.out.println("T'as " + ANSI_RED + joueur.getVie() + ANSI_RESET + " coueurs réstants");
	}


	public void affPlateau(Plateau plat, Joueur[] joueurs) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        int index = 0;

        System.out.println("------------------------------------");
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                boolean isPlayerPosition = false;
                for (Joueur joueur : joueurs) {
                    if (index == joueur.getPositionJoueur()-1) {
                        System.out.print((joueur == joueurs[0] ? ANSI_BLUE : ANSI_GREEN) + "[X]\t" + ANSI_RESET);
                        isPlayerPosition = true;
                        break;
                    }
                }
                if (!isPlayerPosition) {
                    if (plat.getCasesCanon().containsKey(index)) {
                        System.out.print(ANSI_RED + "[C]\t" + ANSI_RESET);
                    } else if (plat.getCasesVentFavo().containsKey(index)) {
                        System.out.print(ANSI_YELLOW + "[V]\t" + ANSI_RESET);
                    } else {
                        System.out.print("[" + (index+1) + "]\t");
                    }
                }
                index++;
            }
            System.out.println("");
        }
        System.out.println("\n");
    }


}
