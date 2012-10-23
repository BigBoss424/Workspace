
public abstract class LongInteger
{
	long val;
	
	public LongInteger(long value)
	{
		val = value;
	}
	
	public LongInteger add(LongInteger other)
	{
		return createObject(other, val + other.val);
	}
	
	public LongInteger subtract(LongInteger other)
	{
		return createObject(other, val - other.val);
	}
	
	public LongInteger multiply(LongInteger other)
	{
		return createObject(other, val * other.val);
	}
	
	public LongInteger divide(LongInteger other)
	{
		return createObject(other, val / other.val);
	}
	
	public void setValue(long value)
	{
		val = value;
	}
	
	public long getValue()
	{
		return val;
	}
	
	private LongInteger createObject(LongInteger other, long value)
	{
		switch (other.getClass().getSimpleName())
		{
			case "BinaryInteger":
				return new BinaryInteger(String.valueOf(value));
			
			case "OctalInteger":
				return new OctalInteger(String.valueOf(value));
				
			case "HexInteger":
				return new HexInteger(String.valueOf(value));
				
			default:
				return new DecInteger(String.valueOf(value));
		}
	}
}
