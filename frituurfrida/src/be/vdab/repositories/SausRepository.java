package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

public class SausRepository {
	private static final Map<Long, Saus> Sauzen = new ConcurrentHashMap<>();
	static {
		Sauzen.put(3L, new Saus(3, "cocktail", Arrays.asList("mayonaise", "ketchup", "cognac")));
		Sauzen.put(6L, new Saus(6, "mayonaise", Arrays.asList("ei", "mosterd")));
		Sauzen.put(7L, new Saus(7, "mosterd", Arrays.asList("mosterd", "azijn", "witte wijn")));
		Sauzen.put(12L, new Saus(12, "tartare", Arrays.asList("mayonaise", "augurk", "tabasco")));
		Sauzen.put(44L, new Saus(44, "vinaigrette", Arrays.asList("olijfolie", "mosterd", "azijn")));
	}
	public List<Saus> findAll() {
		return new ArrayList<>(Sauzen.values());
	}
}