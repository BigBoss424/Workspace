/*
*	Stephen Hoerner	
*	CSCD 210
*	5/21/12
*/

class Day {

	private int value;

	public static boolean isValid(int month, int day, int year) {

		int[] monthLength = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// this checks to see if it was February, if it 
		// was a leap year, and if it was a centennial year 
		if (month == 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			monthLength[1]++;
		}

		// check for validity
		if (day > 0 && day <= monthLength[month - 1]) {
			return true;
		}
		else {
			return false;
		}

	}

	public Day(int value) {
		this.value = value;
	}

	public void set(int value) {
		this.value = value;
	}
	public int get() {
		return this.value;
	}

	public static String getName(int num) {
		// returns the name corresponding to the day of the week (1-7)
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		return days[num];
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
			Day that = (Day)other;
			return (this.value == that.value);
		}
		return false;
	}

}