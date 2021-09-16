package model;

import java.util.ArrayList;
import java.util.List;

public class MedalManager {

	private List<Country> countries;

	public MedalManager() {
		
		countries = new ArrayList<>();
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public boolean addCountry(Country c) {
		
		if(countries.add(c)) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
}
