package model;

public class Country {

	private String name;
	private String mGold, mSilver, mBronze, fGold, fSilver, fBronze;
	
	public Country(String name, String mGold, String mSilver, String mBronze, String fGold, String fSilver, String fBronze) {
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

	public String getmGold() {
		return mGold;
	}

	public void setmGold(String mGold) {
		this.mGold = mGold;
	}

	public String getmSilver() {
		return mSilver;
	}

	public void setmSilver(String mSilver) {
		this.mSilver = mSilver;
	}

	public String getmBronze() {
		return mBronze;
	}

	public void setmBronze(String mBronze) {
		this.mBronze = mBronze;
	}

	public String getfGold() {
		return fGold;
	}

	public void setfGold(String fGold) {
		this.fGold = fGold;
	}

	public String getfSilver() {
		return fSilver;
	}

	public void setfSilver(String fSilver) {
		this.fSilver = fSilver;
	}

	public String getfBronze() {
		return fBronze;
	}

	public void setfBronze(String fBronze) {
		this.fBronze = fBronze;
	}
	
	@Override	
	public String toString() {

		return "Name: " + getName() + 
				"\nmG: " + getmGold() + " mS: " + getmSilver() + " mB: " + getmBronze() + 
				"\nfG: " + getfGold() + " fS: " + getfSilver() + " fB: " + getfBronze() + "\n";
	}
}