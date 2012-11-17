import java.util.Random;

public class LinkedList
{
	private Node head;
	private int count = 0;
	
	private static Random rand = new Random();

	public LinkedList()
	{
		// pass...
	}

	public LinkedList(int size)
	{
		generateList(size);
	}

	public int length()
	{
		return count;
	}
	
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
		this.count++;
	}

	public void print()
	{
		Node n = head;

		while (n != null)
		{
			System.out.println(n);
			n = n.next;
		}
	}

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
				this.count--;
			}

			n = n.next;
		}

		return c;
	}

	public void clear()
	{
		head = null;
	}

	public void printReversed()
	{
		printReversed(head);
	}

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

	public void printNth(int offset)
	{
		if (offset <= 0)
			throw new IllegalArgumentException("Lowest possible number is 1.");
		
		Node n = head;
		int c = 0;

		while (n != null)
		{
			c++;

			if (c % offset == 0)
				System.out.println(n);

			n = n.next;
		}
	}

	private void printReversed(Node n)
	{	
		if (n == null)
			return;

		printReversed(n.next);
		System.out.println(n);
	}

	private class Node
	{
		public Integer data;
		public Node next;

		public Node(Integer data)
		{
			this(data, null);
		}
		public Node(Integer data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		@Override
		public String toString()
		{
			return data.toString();
		}
	}
}
