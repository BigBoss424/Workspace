
public class LinkedList
{
	private Node head;

	public LinkedList(int size)
	{

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
		int count = 0;

		while (n != null && n.next != null)
		{
			if (n.next.data == val)
			{
				n.next = n.next.next;
				count++;
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
		int count = 0;

		while (n != null)
		{
			count++;

			if (count % 2 == 0)
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
