package Jeu;


public class Affichage {
	private final String ANSI_RESET = "\u001B[0m";
	private final String ANSI_BLUE = "\u001B[34m";
	private final String ANSI_GREEN = "\u001B[32m";
	private final String ANSI_YELLOW = "\u001B[33m";
	private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_ORANGE = "\u001b[38;5;208m";

	private String getColorizedName(String name, String colorCode) {
		String color;
		switch (colorCode.toUpperCase()) {
		case "BLEU":
			color = ANSI_BLUE;
			break;
		case "VERT":
			color = ANSI_GREEN;
			break;
		default:
			color = ANSI_RESET;
		}
		return color + name + ANSI_RESET;
	}

	public void affichDebut(String nom, String couleur) {
		System.out.println("À ton tour, " + getColorizedName(nom, couleur) + " appuye sur ENTER pour lancer les dés");
	}

	public void affichFin(String nom, String couleur) {
		System.out.println(ANSI_ORANGE+"Felicitations, c'est "+ANSI_RESET + getColorizedName(nom, couleur)+ANSI_ORANGE + " qui a gagné"+ANSI_RESET);
	}

	public void affichDes(Joueur joueur, int[] des) {
		if(joueur.getPositionJoueur()!=30) {
		System.out.println("T'as sorti un " + des[0] + " et un " + des[1] + ", t'es à la case "
				+ joueur.getPositionJoueur() + "\n");
		}else {
			System.out.println(ANSI_ORANGE+"T'as sorti un " + des[0] + " et un " + des[1] + ", t'es à la case "
					+ joueur.getPositionJoueur()+ ANSI_RESET + "\n");
		}
	}

	public void affichCase(Joueur joueur) {
		int numCase = joueur.getPositionJoueur();
		System.out.println(
				getColorizedName(joueur.getNom(), joueur.getCouleur()) + " t'es maintenant à la case " + numCase);
	}

	public void affichCanonAvant(Joueur jouActu, Joueur jouAdv) {
		if (jouAdv != null) {
			System.out.println(getColorizedName(jouActu.getNom(), jouActu.getCouleur()) + " lance un coup de boulet à "
					+ getColorizedName(jouAdv.getNom(), jouAdv.getCouleur()));
		}
	}

	public void affichEtourdi(Joueur joueur) {
		System.out.println("Désolé " + getColorizedName(joueur.getNom(), joueur.getCouleur())
				+ " à cause du coup de boulé t'es étourdi, tu seras pret(e) en " + joueur.getToursImmo() + " tours");
	}

	public void affichCanonDerr(Joueur jouActu, Joueur jouAdv) {
		if (jouAdv != null) {
			System.out.println(getColorizedName(jouActu.getNom(), jouActu.getCouleur()) + " se lance contre "
					+ getColorizedName(jouAdv.getNom(), jouAdv.getCouleur()));
			affichCase(jouActu);
		}
	}

	public void affichMort(Joueur joueur1, Joueur joueur2) {
		System.out.println("Désolé " + getColorizedName(joueur1.getNom(), joueur1.getCouleur()) + ", ils te restent "
				+ ANSI_RED + 0 + ANSI_RESET + " coueurs, " + getColorizedName(joueur2.getNom(), joueur2.getCouleur())
				+ " t'as tué");
	}

	public void affichVentFavo(Joueur joueur) {
		System.out.println(getColorizedName(joueur.getNom(), joueur.getCouleur())
				+ " t'as eu de la chance, t'avance de 10 cases!");
	}

	public void affichVie(Joueur joueur) {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("T'as " + ANSI_RED + joueur.getVie() + ANSI_RESET + " coueurs réstants");
	}

	public void affPlateau(Plateau plat, Joueur[] joueurs) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				int index = i * 5 + j + 1;
				String symbol = actuCase(plat, joueurs, index, index);
				System.out.print(symbol);
			}
			System.out.println();
		}
		System.out.println();
	}

	private String actuCase(Plateau plat, Joueur[] joueurs, int index, int cellNumber) {
	    boolean player1Here = joueurs[0].getPositionJoueur() == index;
	    boolean player2Here = joueurs[1].getPositionJoueur() == index;
	    
	    // Si ambos jugadores están en la misma casilla
	    if (player1Here && player2Here) {
	        String player1Color = joueurs[0].getCouleur().equals("BLEU") ? ANSI_BLUE : ANSI_GREEN;
	        String player2Color = joueurs[1].getCouleur().equals("BLEU") ? ANSI_BLUE : ANSI_GREEN;
	        return player1Color + "[X" + ANSI_RESET + player2Color + "X]" + ANSI_RESET + "     ";
	    }
	    
	    // Para un solo jugador en la casilla
	    for (Joueur joueur : joueurs) {
	        if (joueur.getPositionJoueur() == index) {
	            String color = joueur.getCouleur().equals("BLEU") ? ANSI_BLUE : ANSI_GREEN;
	            return color + "[X]" + ANSI_RESET + "     ";
	        }
	    }
	    
	    // Para casillas especiales
	    if (plat.getCaseSpe(index) instanceof VentFavo) {
	        return ANSI_YELLOW + "[V]" + ANSI_RESET + "     ";
	    } else if (plat.getCaseSpe(index) instanceof Canon) {
	        return ANSI_RED + "[C]" + ANSI_RESET + "     ";
	    }
	    
	    // Casilla vacía con número
	    return String.format("[%2d]", cellNumber) + "\t";
	}


}
