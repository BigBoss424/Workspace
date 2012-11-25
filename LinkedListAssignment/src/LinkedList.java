
import java.util.Random;

/**
 * Primary class for the LinkedList project
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

public class LinkedList
{
	private Node head;
	private int size = 0;
	
	private static Random rand = new Random();
	
	/**
	 * Initializes the list with new values.
	 * 
	 * @param size 	number of values to add
	 */
	public void generateList(int size)
	{
		if (size < 0)
			throw new IllegalArgumentException("List cannot contain a negative amount of elements.");

		clear();

		for (int i = 0; i < size; i++)
		{
			add(new Integer(rand.nextInt(100)));
		}
	}

	/**
	 * Adds an Integer to the list. Automatically
	 * places it in sorted order.
	 * 
	 * @param val	data to add
	 */
	public void add(Integer val)
	{
		Node n = head;
		
		// special case
		if (head == null)
		{
			head = new Node(val);
		}
		
		// take head node into account for sort insertion
		else if (val.compareTo(head.data) < 0)
		{
			head = new Node(val, head);
		}
		else
		{
			// stop when we've found a good spot or reach the end
			while (n != null && n.next != null)
			{
				if (val.compareTo(n.next.data) < 0)
					break;
				
				n = n.next;
			}
	
			n.next = new Node(val, n.next);
		}
		this.size++;
	}

	/**
	 * Print in normal order
	 */
	public void print()
	{
		Node n = head;

		while (n != null)
		{
			System.out.println(n);
			n = n.next;
		}
	}

	/**
	 * Print in reversed order
	 */
	public void printReversed()
	{
		printReversed(head);
	}
	
	/**
	 * Inner recursive function for printing in reverse
	 * @param n	reference to current node
	 */
	private void printReversed(Node n)
	{	
		if (n == null)
			return;

		printReversed(n.next);
		System.out.println(n);
	}

	/**
	 * Print the 'Nth' nodes
	 * @param offset the 'N'
	 */
	public void printNth(int offset)
	{
		if (offset < 1)
			throw new IllegalArgumentException("Lowest possible number is 1.");
		
		Node n = head;
		int c = 0;

		while (n != null)
		{
			if (c % offset == 0)
				System.out.println(n);

			c++;
			n = n.next;
		}
	}
	
	/**
	 * Places all even values into a new LinkedList object.
	 * @return	the new LinkedList
	 */
	public LinkedList getEvens()
	{
		LinkedList result = new LinkedList();
		Node n = head;

		while (n != null)
		{
			if (n.data % 2 == 0)
				result.add(n.data);

			n = n.next;
		}
		
		return result;
	}
	
	/**
	 * Deletes all occurrences of a value
	 * @param val	value to search for
	 * @return	number of values deleted
	 */
	public int deleteValue(Integer val)
	{
		Node n = head;
		int c = 0;

		while (n != null && n.next != null)
		{
			if (n.next.data.equals(val))
			{
				n.next = n.next.next;
				c++;
				this.size--;
			}
			else
				n = n.next;
		}

		return c;
	}

	/**
	 * Clears the list
	 */
	public void clear()
	{
		head = null;
		size = 0;
	}

	/**
	 * Gets the number of elements in the LinkedList
	 * @return	the size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Nested class for the spectacular Node objects
	 */
	private class Node
	{
		public Integer data;
		public Node next;

		/**
		 * Constructor
		 * @param data	value of the node
		 */
		public Node(Integer data)
		{
			this(data, null);
		}
		
		/**
		 * Constructor
		 * @param data	value of the node
		 * @param next	pointer to the next node
		 */
		public Node(Integer data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		/**
		 * toString()!
		 */
		@Override
		public String toString()
		{
			return data.toString();
		}
	}
}
