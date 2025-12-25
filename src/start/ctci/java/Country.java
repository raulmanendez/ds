package start.ctci.java;

import java.util.List;

public class Country {
	
	public String getContinent() {
		return null;
	}
	
	public int getPopulation() {
		return 0;
	}
	
	int getPopulation(List<Country> countries, String continent) {	
		return countries.stream().filter(it -> it.getContinent().equals(continent))
		.map(it -> it.getPopulation())
		.reduce(0,(a,b) -> a+b);
	}
}
