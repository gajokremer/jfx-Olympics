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
	
	/*
	 * Sorts countries by male podium from highest to lowest and then by name.
	 */
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
	
	
	/*
	 * Sorts countries by female from lowest to highest and then by name.
	 */
	public void sortByFemalePodiumAndName() {

		Comparator<Country> femalePodiumAndNameComparator = new Comparator<Country>() {

//			@Override
//			public int compare(Country c1, Country c2) {
//
//				return Integer.compare(c1.getfGold(), c2.getfGold());
//			}

			@Override
			public int compare(Country c1, Country c2) {
				
				if(c1.getfGold() > c2.getfGold()) {

					return 1;

				} else if(c1.getfGold() < c2.getfGold()) {

					return -1;

				} else if(c1.getfSilver() > c2.getfSilver()) {

					return 1;

				} else if(c1.getfSilver() < c2.getfSilver()) {

					return -1;
					
				} else if(c1.getfBronze() > c2.getfBronze()) {

					return 1;

				} else if(c1.getfBronze() < c2.getfBronze()) {

					return -1;

				} else {

					return c1.getName().compareTo(c2.getName());
				}
			}
		};

		Collections.sort(countries, femalePodiumAndNameComparator);
	}
	
	public String printFemaleAndName() {
		
		String s = "";
		
		for(int i = 0; i < countries.size(); i++) {
			
			s += countries.get(i).femaleAndName() + "\n";
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
