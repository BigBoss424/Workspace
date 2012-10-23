
public class BinaryInteger extends LongInteger
{
	public BinaryInteger(String value)
	{
		super(Long.parseLong(value, 2));
	}
}