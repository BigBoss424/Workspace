
public class OctalInteger extends LongInteger
{
	public OctalInteger(String value)
	{
		super(Long.parseLong(value, 8));
	}
}