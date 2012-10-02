/*
*	Stephen Hoerner	
*	CSCD 210
*	5/19/12
*/

class SortSearchUtil {

	public static void selectionSort(int[] ara) {
		int temp;
		int min = 0;

		for (int i = 0; i < ara.length - 1; i++) {
			min = i;

			for (int k = i; k < ara.length; k++) {
				if (ara[k] < ara[min]) {
					min = k;
				}
			}

			temp     = ara[i];
			ara[i]   = ara[min];
			ara[min] = temp;
		}
	}

	public static void selectionSort(double[] ara) {
		double temp;
		int min = 0;

		for (int i = 0; i < ara.length - 1; i++) {
			min = i;

			for (int k = i; k < ara.length; k++) {
				if (ara[k] < ara[min]) {
					min = k;
				}
			}

			temp     = ara[i];
			ara[i]   = ara[min];
			ara[min] = temp;
		}
	}

	public static void selectionSort(Comparable[] ara) {
		Comparable temp;
		int min = 0;

		for (int i = 0; i < ara.length - 1; i++) {
			min = i;

			for (int k = i; k < ara.length; k++) {
				if (ara[k].compareTo(ara[min]) < 0) {
					min = k;
				}
			}

			temp     = ara[i];
			ara[i]   = ara[min];
			ara[min] = temp;
		}
	}

	// Insertion Sort
	public static void insertionSort(int[] ara) {
		for (int i = 1; i < ara.length; i++) {
			int key = ara[i];
			int position = i;
			while (position > 0 && key < ara[position - 1]) {
				ara[position] = ara[position - 1];
				position--;
			}
			ara[position] = key;
		}
	}

	public static void insertionSort(double[] ara) {
		for (int i = 1; i < ara.length; i++) {
			double key = ara[i];
			int position = i;
			while (position > 0 && key < ara[position - 1]) {
				ara[position] = ara[position - 1];
				position--;
			}
			ara[position] = key;
		}
	}

	public static void insertionSort(Comparable[] ara) {
		for (int i = 1; i < ara.length; i++) {
			Comparable key = ara[i];
			int position = i;
			while (position > 0 && key.compareTo(ara[position - 1]) < 0) {
				ara[position] = ara[position - 1];
				position--;
			}
			ara[position] = key;
		}
	}

	// Binary Search. Note: the array values MUST be in order.
	public static int binarySearch(int[] ara, int target) {
		int low  = 0;
		int mid  = 0;
		int high = ara.length - 1;

		while (high > low) {
			mid = (high + low) / 2;

			if (target > ara[mid]) {
				low = mid + 1;
			}
			else if (target < ara[mid]) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearch(double[] ara, double target) {
		int low  = 0;
		int mid  = 0;
		int high = ara.length - 1;

		while (high > low) {
			mid = (high + low) / 2;

			if (target > ara[mid]) {
				low = mid + 1;
			}
			else if (target < ara[mid]) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearch(Comparable[] ara, Comparable target) {
		int low  = 0;
		int mid  = 0;
		int high = ara.length - 1;

		while (high > low) {
			mid = (high + low) / 2;

			if (target.compareTo(ara[mid]) > 0) {
				low = mid + 1;
			}
			else if (target.compareTo(ara[mid]) < 0) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}