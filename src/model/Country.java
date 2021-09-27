package model;

public class Country {

	private String name;
	private int mGold, mSilver, mBronze, fGold, fSilver, fBronze;
	
	public Country(String name, int mGold, int mSilver, int mBronze, int fGold, int fSilver, int fBronze) {
		super();
		this.name = name;
		this.mGold = mGold;
		this.mSilver = mSilver;
		this.mBronze = mBronze;
		this.fGold = fGold;
		this.fSilver = fSilver;
		this.fBronze = fBronze;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getmGold() {
		return mGold;
	}

	public void setmGold(int mGold) {
		this.mGold = mGold;
	}

	public int getmSilver() {
		return mSilver;
	}

	public void setmSilver(int mSilver) {
		this.mSilver = mSilver;
	}

	public int getmBronze() {
		return mBronze;
	}

	public void setmBronze(int mBronze) {
		this.mBronze = mBronze;
	}

	public int getfGold() {
		return fGold;
	}

	public void setfGold(int fGold) {
		this.fGold = fGold;
	}

	public int getfSilver() {
		return fSilver;
	}

	public void setfSilver(int fSilver) {
		this.fSilver = fSilver;
	}

	public int getfBronze() {
		return fBronze;
	}

	public void setfBronze(int fBronze) {
		this.fBronze = fBronze;
	}
	
	public int getTotalGold() {
		
		return mGold + fGold;
	}
	
	public int getTotalSilver() {
		
		return mSilver + fSilver;
	}
	
	public int getTotalBronze() {
		
		return mBronze + fBronze;
	}
	
	public String maleAndName() {
		
		return getName() + ": " + getmGold() + " " + getmSilver() + " " + getmBronze();
	}
	
	public String femaleAndName() {
		
		return getName() + ": " + getfGold() + " " + getfSilver() + " " + getfBronze();
	}
	
	public String totalMedals() {
		
		return getName() + ": " + getTotalGold() + " " + getTotalSilver() + " " + getTotalBronze();
	}
	
	@Override	
	public String toString() {

//		return "Name: " + getName() + 
//				"\nmG: " + getmGold() + " mS: " + getmSilver() + " mB: " + getmBronze() + 
//				"\nfG: " + getfGold() + " fS: " + getfSilver() + " fB: " + getfBronze() + "\n";
		
		return getName() + ": " + getmGold() + " " + getmSilver() + " " + getmBronze() + "; " + 
		getfGold() + " " + getfSilver() + " " + getfBronze();
	}
}