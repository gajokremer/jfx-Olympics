package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public void removeAllCountries() {
		
		countries.removeAll(countries);
	}
	
	public void sortByMalePodiumAndName() {
		
		Comparator<Country> s1 = new MalePodiumAndNameComparator();
		Collections.sort(countries, s1);
	}
	
	public String printMaleAndName() {
		
		String s = "";
		
		for(int i = 0; i < countries.size(); i++) {
			
			s += countries.get(i).maleAndName() + "\n";
		}
		
		return s;
	}
	
	public String printArray() {
		
		String s = "";
		
		for(int i = 0; i < countries.size(); i++) {
			
			s += countries.get(i).toString() + "\n";
		}
		
		return s;
	}
	
}
