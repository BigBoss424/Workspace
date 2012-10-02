//  This utility class holds sorting and searching routines  
public class SortSearchUtil
{
	//  Selection sort for an array of integers _______________
	public static void selectionSort(int[] array)
	{
		int curPos, indexSmallest, start;
		int temp;
		for (start = 0; start < array.length - 1; start++)
		{
			indexSmallest = start;
			for (curPos = start + 1; curPos < array.length; curPos++)
			{
				if (array[indexSmallest] > array[curPos])
				{
					indexSmallest = curPos;
				}
			} // end for
			temp = array[start];
			array[start] = array[indexSmallest];
			array[indexSmallest] = temp;
		} // end for       
	}

	//  Selection sort for an array of strings _______________
	public static void selectionSort(String[] array)
	{
		int current, indexSmallest, start;
		String temp;
		for (start = 0; start < array.length - 1; start++)
		{
			indexSmallest = start;
			for (current = start + 1; current < array.length; current++)
			{
				if (array[current].compareTo(array[indexSmallest]) < 0)
				{
					indexSmallest = current;
				}
			} // end for
			temp = array[indexSmallest];
			array[indexSmallest] = array[start];
			array[start] = temp;
		} // end for       
	}


	//  Selection sort for an array of objects _______________

	@SuppressWarnings("unchecked")
	public static void selectionSort(Comparable[] array)
	{
		int curPos, indexSmallest, start;
		Comparable temp;
		for (start = 0; start < array.length - 1; start++)
		{
			indexSmallest = start;
			for (curPos = start + 1; curPos < array.length; curPos++)
			{
				if (array[indexSmallest].compareTo(array[curPos]) > 0)
				{
					indexSmallest = curPos;
				}
			} // end for
			temp = array[start];
			array[start] = array[indexSmallest];
			array[indexSmallest] = temp;
		} // end for       
	}

	// ___________________________________________________

	public static void insertionSort(int[] array)
	{
		for (int index = 1; index < array.length; index++)
		{
			int key = array[index];
			int position = index;

			while (position > 0 && key < array[position - 1])
			{
				array[position] = array[position - 1];
				position--;

			} // end while...

			array[position] = key;
		} // end for...
	}

	// ___________________________________________________

	public static void insertionSort(double[] array)
	{
		for (int index = 1; index < array.length; index++)
		{
			double key = array[index];
			int position = index;

			while (position > 0 && key < array[position - 1])
			{
				array[position] = array[position - 1];
				position--;

			} // end while...

			array[position] = key;
		} // end for...
	} 

	// ________________________________________________________

	public static void insertionSort(String[] array)
	{
		for (int index = 1; index < array.length; index++)
		{
			String key = array[index];
			int position = index;

			while (position > 0 && key.compareTo(array[position - 1]) < 1)
			{
				array[position] = array[position - 1];
				position--;

			} // end while...

			array[position] = key;
		} // end for...
	} // end main...




	// ___________________________________________________   	
	public static boolean linearSearch(int[] array, int target)
	{

		for (int x = 0; x < array.length; x++)
		{
			if (array[x]== target)
			{
				return true;
			}
		}

		return false;

	}
	
	
	
	
	
	
	
	
	
	
	// ___________________________________________________   	
	public static boolean linearSearch(double[] array, double target)
	{

		for (int x = 0; x < array.length; x++)
		{
			if (array[x]== target)
			{
				return true;
			}
		}

		return false;

	}


	// ___________________________________________________   	
	public static boolean binarySearch(int[] array, int target)
	{
		int high = array.length -1;
		int low = 0;
		int mid = 0;
		boolean found = false;
		do
		{
			mid = (low + high) / 2;
			if(array[mid] < target)
			{
				low = mid + 1;
			}
			else if (array[mid] > target)
			{
				high = mid - 1;
			}        
			else
			{
				found = true;
			}
		} while (!found && low <= high);
		return found;
	}

	// ___________________________________________________   	
	public static boolean binarySearch(double[] array, double target)
	{
		int high = array.length - 1;
		int low = 0;
		int mid = 0;
		boolean found = false;
		do
		{
			mid = (low + high) / 2;
			if(array[mid] < target)
			{
				low = mid + 1;
			}
			else if (array[mid] > target)
				high = mid - 1;
			else
				found = true;
		} while (!found && low <= high);
		return found;
	}
	
	public static boolean binarySearch(Comparable[] array, Comparable target)
	{
		int high = array.length -1;
		int low = 0;
		int mid = 0;
		boolean found = false;
		do
		{
			mid = (low + high) / 2;
			if(array[mid].compareTo(target) < 0)
			{
				low = mid + 1;
			}
			else if (array[mid].compareTo(target)  > 0)
			{
				high = mid - 1;
			}        
			else
			{
				found = true;
			}
		} while (!found && low <= high);
		return found;
	}

} // end class...

