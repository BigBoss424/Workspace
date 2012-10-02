
/**
 * @author Stephen Hoerner
 *
 */

// Address: a simple street address, capable of being found by mailmen
public class Address implements Comparable<Address>
{	
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address(String street, String other)
	{
		int x;
		this.street = street;
		
		x = other.indexOf(",");
		this.city = other.substring(0, x).trim();
		
		x += 2;
		this.state = other.substring(x, x + 2).trim();
		
		x = other.indexOf("  ");
		this.zip = other.substring(x).trim();
	}
	
	public int compareTo(Address that)
	{
		return (this.zip.compareTo(that.zip) == 0) ? this.street.compareTo(that.street) : this.zip.compareTo(that.zip);
	}
	
	@Override
	public String toString()
	{
		return this.street + "\n" + this.city + ", " + this.state + "  " + this.zip;
	}
}
