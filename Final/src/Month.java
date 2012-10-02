/*
*	Stephen Hoerner	
*	CSCD 210
*	5/21/12
*/

class Month {

	private int value;

	public static boolean isValid(int value) {
		if (value >= 1 && value <= 12) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Month(int value) {
		this.value = value;
	}

	public void set(int value) {
		this.value = value;
	}
	public int get() {
		return this.value;
	}

	public String getName() {
		// returns the name corresponding to the day of the week (1-7)
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		return months[value - 1];
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	@Override
	public boolean equals(Object other) {
		// check that they're the right class
		if (other.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
			// check value
			Month that = (Month)other;
			return (this.value == that.value);
		}
		return false;
	}

}