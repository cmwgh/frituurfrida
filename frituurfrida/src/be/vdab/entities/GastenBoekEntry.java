package be.vdab.entities;

import java.time.LocalDate;

public class GastenBoekEntry {
	private final long id;
	private final String naam;
	private final LocalDate datum;
	private final String bericht;
	public GastenBoekEntry(String naam, String bericht) {
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		}
		if (!isBerichtValid(bericht)) {
			throw new IllegalArgumentException();
		}
		this.id=0;
		this.naam=naam;
		this.datum=LocalDate.now();
		this.bericht=bericht;
	}
	public GastenBoekEntry(long id, String naam, LocalDate datum, String bericht){
		this.id=id;
		this.naam=naam;
		this.datum=datum;
		this.bericht=bericht;		
	}
	public static boolean isNaamValid(String naam) {
		return naam != null && !naam.isEmpty();
	}
	public static boolean isBerichtValid(String bericht) {
		return bericht != null && !bericht.isEmpty();
	}
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public String getBericht() {
		return bericht;
	}
}
