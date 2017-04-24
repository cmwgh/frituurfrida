package be.vdab.entities;

import java.io.Serializable;

public class Deur implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean open;
	private boolean metFriet;
	public Deur(boolean metFriet) {
		this.metFriet = metFriet;
	}
	public void open() {
		open = true;
	}
	public boolean isOpen() {
		return open;
	}
	public boolean isMetFriet() {
		return metFriet;
	}
}
