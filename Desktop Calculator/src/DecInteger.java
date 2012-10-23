
public class DecInteger extends LongInteger
{
	public DecInteger(String value)
	{
		super(Long.parseLong(value, 10));
	}
}