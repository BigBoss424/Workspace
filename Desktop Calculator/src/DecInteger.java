
// Stephen Hoerner

public class DecInteger extends LongInteger
{
	public DecInteger(String value)
	{
		super(Long.parseLong(value, 10));
	}
	
	public String toString()
	{
		return val + " (decimal)";
	}
}