// Stephen Hoerner

public class HexInteger extends LongInteger
{
	public HexInteger(String value)
	{
		super(Long.parseLong(value, 16));
	}

	@Override
	public String toString()
	{
		return Long.toHexString(val) + " (hex)";
	}
}