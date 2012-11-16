
public class LinkedList
{
	private Node head;
	private int count = 0;

	private static Random rand = new Random();

	public LinkedList(int size)
	{
		generateList(size);
	}

	public void generateList(int size)
	{
		if (size < 0)
			throw new InvalidArgumentException("List cannot contain a negative amount of elements.");

		clear();

		for (int i = 0; i < size; i++)
		{
			add(Int(rand.nextInt(100)));
		}
	}

	public void add(Int val)
	{
		// TODO add sort-insertion code
		
		Node n = head;

		while (n != null && n.next != null)
		{
			n = n.next;
		}

		n.next = new Node(val);
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

	public int deleteValue(Int val)
	{
		Node n = head;
		int c = 0;

		while (n != null && n.next != null)
		{
			if (n.next.data == val)
			{
				n.next = n.next.next;
				c++;
				this.count--;
			}

			n = n.next;
		}

		return count;
	}

	public void clear()
	{
		head = null;
	}

	public void printReversed()
	{
		printReversed(head);
	}

	public void printEvens()
	{
		printNth(2);
	}

	public void printNth(int n)
	{
		Node n = head;
		int c = 0;

		while (n != null)
		{
			c++;

			if (c % 2 == 0)
				System.out.println(n);

			n = n.next;
		}
	}

	private void printReversed(Node n)
	{
		if (head == null)
			return;

		printReversed(n.next);
		System.out.println(n);
	}

	private class Node
	{
		public Int data;
		public Node next;

		public Node(Int data)
		{
			this(data, null);
		}
		public Node(Int data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
}
