package Jeu;

public class Cases {
	Des des=new Des();
	int numCase=0;
	
	public int getNumCase() {
		return numCase;
	}
	
	public void avanceCase(int num) {
        this.numCase += num;
    }
	
	public void reculeCase(int num) {
	    this.numCase = 30 - num;
	}
}
