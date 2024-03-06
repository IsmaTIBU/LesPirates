package Jeu;
import java.util.Random;

public class Des {
	Random random = new Random();
    int de1 = random.nextInt(6) + 1;
    int de2 = random.nextInt(6) + 1;
    int somme = de1 + de2;
    
    public int lancerDes() {
    	return somme;
    }
    
}
