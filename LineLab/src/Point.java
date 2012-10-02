
/*
*	Stephen Hoerner	
*	CSCD 210
*	5/28/12
*/

import java.io.Serializable;

public class Point implements Serializable {
	
	private int x;
	private int y;
	
	public static boolean validatePoint(int x, int y)
	{
		return x >= 0 && y >= 0;
	}
	
	public Point() {
		this(0,0);
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString()
	{
		return "(" + this.x + ", " + this.y + ")";
	}
	
	@Override	
	public boolean equals(Object obj)
	{
		Point that;
		
		if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName()))
		{
			that = (Point)obj;
			if (that.x == this.x && that.y == this.y)
			{
				return true;
			}
		}
		return false;
	}
}
