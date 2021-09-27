package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MedalManager {

	private List<Country> countries;
	private String TEST_COUNTRIES_FILE = "data/TestCountries.txt";

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
	
	/*
	 * Sorts countries by total podium from highest to lowest and then by name.
	 */
	public void sortBySelectionSort() {
		
//		int pos = 0;
//		
//		while(pos < countries.size()) {
//			
//			Country max = countries.size();
//			
//			for(int i = pos + 1; i < countries.size(); i++) {
//				
//				if(countries.get(i).getTotalGold() > max.getTotalGold()) {
//					
//					Country temp = countries.get(i);
//					countries.set(i, max);
//					max = temp;
//					
//				} else if(countries.get(i).getTotalSilver() > max.getTotalSilver()) {
//					
//					Country temp = countries.get(i);
//					countries.set(i, max);
//					max = temp;
//					
//				} else if(countries.get(i).getfBronze() > max.getTotalBronze()) {
//					
//					Country temp = countries.get(i);
//					countries.set(i, max);
//					max = temp;
//				}
//			}
//			
//			countries.set(pos, max);
//			pos++;
		
		int pos = 0;
		
		while(pos < countries.size()) {
			
			Country min = countries.get(pos);
			
			for(int i = pos + 1; i < countries.size(); i++) {
				
				if(countries.get(i).getTotalGold() < min.getTotalGold()) {
					
					Country temp = countries.get(i);
					countries.set(i, min);
					min = temp;
					
//					printArray();
				}
			}
			
			countries.set(pos, min);
			pos++;
		}
	}
	
	/*
	 * Sorts countries by total podium from highest to lowest and then by name.
	 */
	public void sortByInsertionSort() {
		
		int j;
		Country aux;

		for(int i = 1; i < countries.size(); i++) {

//			aux = array[i];
			aux = countries.get(i);
			j = i - 1;

			while(j >= 0 && aux.getTotalGold() < countries.get(i).getTotalGold()) {

				countries.set(j + 1, countries.get(j));
				j--;
			}

			countries.set(j + 1 , aux);
		}
	}
	
	public String printTotals() {
		
		String s = "";
		
		for(int i = 0; i < countries.size(); i++) {
			
			s += countries.get(i).totalMedals() + "\n";
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
	
	public List<Country> importData() throws IOException {
		
		List<Country> list = new ArrayList<Country>();
		
		BufferedReader br = new BufferedReader(new FileReader(TEST_COUNTRIES_FILE));
		String line = br.readLine();
		
		while(line != null) {
			
			String [] countries = line.split("\n");
			
			for(int i = 0; i < countries.length; i++) {
				
				String [] parts = countries[i].split(";");
				
				int mGold = Integer.parseInt(parts[1]);
				int mSilver = Integer.parseInt(parts[2]);
				int mBronze = Integer.parseInt(parts[3]);
				int fGold = Integer.parseInt(parts[4]);
				int fSilver = Integer.parseInt(parts[5]);
				int fBronze = Integer.parseInt(parts[6]);
				
				Country c = new Country(parts[0], mGold, mSilver, mBronze, fGold, fSilver, fBronze);
				list.add(c);
				line = br.readLine();
			}
		}
		
		br.close();
		
		return list;
		
//		return result;

//		countries.removeAll(countries);
//
//		BufferedReader br = new BufferedReader(new FileReader(TEST_COUNTRIES_FILE));
//		String line = br.readLine();
//
//		while(line != null) {
//
//			String [] countries = line.split("\n");
//
//			for(int i = 0; i < countries.length; i++) {
//
//				String [] data = countries[i].split(";");
//
//				int mGold = Integer.parseInt(data[1]);
//				int mSilver = Integer.parseInt(data[2]);
//				int mBronze = Integer.parseInt(data[3]);
//				int fGold = Integer.parseInt(data[4]);
//				int fSilver = Integer.parseInt(data[5]);
//				int fBronze = Integer.parseInt(data[6]);
//
//				Country c = new Country(data[0], mGold, mSilver, mBronze, fGold, fSilver, fBronze);
//
//				addCountry(c);
//			}
//
//			br.close();
//		}
	}
	
	public String listToText(List<Country> list) {
		
		String line = "";
		
		for(int i = 0; i < list.size(); i++) {
			
			String name = list.get(i).getName();
			int mGold = list.get(i).getmGold();
			int mSilver = list.get(i).getmSilver();
			int mBronze = list.get(i).getmBronze();
			int fGold = list.get(i).getfGold();
			int fSilver = list.get(i).getfSilver();
			int fBronze = list.get(i).getfBronze();
			
			line += name + ";" + mGold + ";" + mSilver + ";" + mBronze + ";" + fGold + ";" + fSilver + ";" + fBronze + "\n";
		}
		
		return line;
	}
}
