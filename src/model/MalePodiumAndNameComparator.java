package model;

import java.util.Comparator;

public class MalePodiumAndNameComparator implements Comparator<Country> {

	@Override
	public int compare(Country c1, Country c2) {

		if(c1.getmGold() < c2.getmGold()) {

			return 1;

		} else if(c1.getmGold() > c2.getmGold()) {

			return -1;

		} else if(c1.getmSilver() < c2.getmSilver()) {

			return 1;

		} else if(c1.getmSilver() > c2.getmSilver()) {

			return -1;
			
		} else if(c1.getmBronze() < c2.getmBronze()) {

			return 1;

		} else if(c1.getmBronze() > c2.getmBronze()) {

			return -1;

		} else {

			return c1.getName().compareTo(c2.getName());
		}
		
//		else {
//
//			return c1.getmSilver()compareTo(c2.getmSilver());
//		}

	}

}
