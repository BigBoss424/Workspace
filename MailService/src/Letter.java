
/**
 * @author Stephen Hoerner
 *
 */

import java.text.DecimalFormat;

// Letter: contains the data you'd find on the outside of a letter -- no content, but to/from addresses and whatnot
public class Letter implements Comparable<Letter>
{
	private String toName;
	private Address toAddr;
	private String fromName;
	private Address fromAddr;
	private double weight;
	
	public Letter(String toName, String toAddr, String fromName, String fromAddr, double weight)
	{
		int x;		 
		this.toName = toName;
		this.fromName = fromName;
		
		x = toAddr.indexOf("\n");
		this.toAddr = new Address(toAddr.substring(0, x), toAddr.substring(x));
		
		x = fromAddr.indexOf("\n");
		this.fromAddr = new Address(fromAddr.substring(0, x), fromAddr.substring(x));
		
		this.weight = weight;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	@Override
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#.##");
		String result;
		String indent = "                    ";
		
		
		result = "----------------------------------------------------------------------------\n";
		
		// formatting preparation for "from" address
		String firstLine = "From: " + this.fromName;
		String price = "$" + df.format(getPostage(this.weight));
		firstLine += repeat(" ", 76 - firstLine.length() - price.length()) + price;
		
		// add "from" details
		result += firstLine + "\n";
		result += this.fromAddr.toString();
		
		// formatting preparation for "to" address
		String address = this.toAddr.toString();
		int x = address.indexOf("\n");
		
		// add "to" details
		result +=  "\n\n" + indent + this.toName + "\n";
		result += indent + address.substring(0, x).trim() + "\n";
		result += indent + address.substring(x + 1).trim() + "\n";
		
		result += "----------------------------------------------------------------------------";
		
		
		return result;
	}
	
	//	acquired from RosettaCode — http://rosettacode.org/wiki/Repeat_a_string#Java
	
	public static String repeat(String str, int times)
	{
		return new String(new char[times]).replace("\0", str);
	}
	
	public int compareTo(Letter that)
	{
		return this.toAddr.compareTo(that.toAddr);
	}
	
	public static double getPostage(double weight)
	{
		return weight * 0.46;
	}
}