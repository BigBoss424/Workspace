/*
*	Stephen Hoerner	
*	CSCD 210
*	5/21/12
*/

class Year {

	private int value;

	public static boolean isValid(int value) {
		if (value > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public Year(int value) {
		this.value = value;
	}

	public void set(int value) {
		this.value = value;
	}
	public int get() {
		return this.value;
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
			Year that = (Year)other;
			return (this.value == that.value);
		}
		return false;
	}

}