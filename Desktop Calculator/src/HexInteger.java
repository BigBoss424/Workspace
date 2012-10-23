
public class HexInteger extends LongInteger
{
	public HexInteger(String value)
	{
		super(Long.parseLong(value, 16));
	}
}