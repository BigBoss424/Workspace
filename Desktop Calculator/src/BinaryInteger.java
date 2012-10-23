
// Stephen Hoerner

public class BinaryInteger extends LongInteger
{
	public BinaryInteger(String value)
	{
		super(Long.parseLong(value, 2));
	}
	
	public String toString()
	{
		return Long.toBinaryString(val) + " (binary)";
	}
}