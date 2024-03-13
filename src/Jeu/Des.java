package Jeu;
import java.util.Random;

public class Des {
	Random random = new Random();
    
	public int[] lancerDes() {
        int de1 = random.nextInt(6) + 1;
        int de2 = random.nextInt(6) + 1;
        return new int[]{de1, de2};
    }
    
}
