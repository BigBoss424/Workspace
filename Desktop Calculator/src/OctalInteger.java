// Stephen Hoerner

public class OctalInteger extends LongInteger
{
	public OctalInteger(String value)
	{
		super(Long.parseLong(value, 8));
	}

	@Override
	public String toString()
	{
		return Long.toOctalString(val) + " (octal)";
	}
}