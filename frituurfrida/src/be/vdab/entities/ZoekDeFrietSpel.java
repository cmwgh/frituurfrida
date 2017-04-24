package be.vdab.entities;

import java.io.Serializable;
import java.util.Random;

public class ZoekDeFrietSpel implements Serializable {
	private static final long serialVersionUID = 1l;
	private static final int AANTAL_DEUREN = 7;
	private final Deur[] deuren = new Deur[AANTAL_DEUREN];
	public ZoekDeFrietSpel() {
			int indexMetFriet = new Random().nextInt(AANTAL_DEUREN);
			for (int index = 0; index != AANTAL_DEUREN; index++) {
				deuren[index] = new Deur(index == indexMetFriet);
			}
	}
	public void openDeur(int index) {
		deuren[index].open();
	}
	public Deur[] getDeuren() {
		return deuren;
	}
}
	
