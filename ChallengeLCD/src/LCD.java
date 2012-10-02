
public class LCD {

	
	public static void main(String[] args) {
		
		String value = "12345";
		
		String[] lines = new String[7];
		
		for (int i = 0; i < lines.length; i++)
		{
			lines[i] = "";
		}
		
		for (char ch : value.toCharArray()) 
		{
			switch (ch)
			{
				case '1':
					lines[0] += "   ";
					lines[1] += " | ";
					lines[2] += " | ";
					lines[3] += "   ";
					lines[4] += "   ";
					lines[5] += " | ";
					lines[6] += " | ";
					lines[7] += " | ";
					
					
		}
		
	}
	}
}
