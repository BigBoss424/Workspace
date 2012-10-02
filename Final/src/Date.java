/*
*	Stephen Hoerner	
*	CSCD 210
*	5/21/12
*/

class Date implements Comparable<Date> {

	private Day day;
	private Month month;
	private Year year;

	public static boolean isValid(String value) {
		String[] parts = value.split("/");

		if (parts.length < 3)
			return false;
		
		// parse the elements
		int month = Integer.parseInt(parts[0]);
		int day   = Integer.parseInt(parts[1]);
		int year  = Integer.parseInt(parts[2]);

		// do some contradiction tests
		if (!Year.isValid(year)) {
			return false;
		}
		if (!Month.isValid(month)) {
			return false;
		}
		if (!Day.isValid(month, day, year)) {
			return false;
		}

		return true;

	}

	public Date() {
		this("1/1/1970");
	}

	public Date(String value) {
		String[] parts = value.split("/");

		// parse the elements
		int month = Integer.parseInt(parts[0]);
		int day   = Integer.parseInt(parts[1]);
		int year  = Integer.parseInt(parts[2]);

		this.year  = new Year(year);
		this.month = new Month(month);
		this.day   = new Day(day);
	}

	public void set(String value) {
		if (isValid(value)) {
			String[] parts = value.split("/");

			// parse the elements
			int month = Integer.parseInt(parts[0]);
			int day   = Integer.parseInt(parts[1]);
			int year  = Integer.parseInt(parts[2]);

			this.year  = new Year(year);
			this.month = new Month(month);
			this.day   = new Day(day);
		}
	}

	public String get() {
		return this.month + "/" + this.day + "/" + this.year;
	}

	@Override
	public String toString() {
		// this finds the simple julian day
		int weekday;
		int dayCount = 1;

		for (int i = 1; i < this.month.get(); i++) {
			dayCount += monthLength(i);
		}

		dayCount += this.day.get();

		// this finds the day of the month
		weekday = (this.year.get() - 1) / 4;
		weekday = this.year.get() + weekday + dayCount - 2;
		weekday = weekday % 7;

		return Day.getName(weekday) + ", " + this.month.getName() + " " + this.day + " " + this.year;
	}

	@Override
	public boolean equals(Object other) {
		// check that they're the right class
		if (other.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
			// check value
			Date that = (Date)other;
			return (this.month.equals(that.month) && this.day.equals(that.day) && this.year.equals(that.year));
		}
		return false;
	}

	public int compareTo(Date that) {
		// verbose yet simple
		// compares from greatest to least values

		if (this.year.get() > that.year.get())
			return 1;
		else if (this.year.get() < that.year.get())
			return -1;
		else if (this.month.get() > that.month.get())
			return 1;
		else if (this.month.get() < that.month.get())
			return -1;
		else if (this.day.get() > that.day.get())
			return 1;
		else if (this.day.get() < that.day.get())
			return -1;
		else
			return 0;
	}

	private int monthLength(int month) {
		int[] monthLength = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// this checks to see if it was February, if it 
		// was a leap year, and if it was a centennial year 
		if (month == 2 && this.year.get() % 4 == 0 && (this.year.get() % 100 != 0 || this.year.get() % 400 == 0)) {
			monthLength[2]++;
		}

		return monthLength[month - 1];
	}

}