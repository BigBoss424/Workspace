// Stephen Hoerner

public class BinaryInteger extends LongInteger
{
	public BinaryInteger(String value)
	{
		super(Long.parseLong(value, 2));
	}

	@Override
	public String toString()
	{
		return Long.toBinaryString(val) + " (binary)";
	}
}