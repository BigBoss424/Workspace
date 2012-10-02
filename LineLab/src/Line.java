

/*
*	Stephen Hoerner	
*	CSCD 210
*	5/28/12
*/

import java.io.Serializable;

public class Line implements Serializable
{
	Point p1;
	Point p2;

	String color = "Black";
	int width = 1;
	
	public static boolean validateLine(int x1, int y1, int x2, int y2)
	{
		return Point.validatePoint(x1, y1) && Point.validatePoint(x2, y2);
	}
	
	public Line()
	{
		this(0, 0, 0, 0);
	}
	
	public Line(int x1, int y1, int x2, int y2)
	{
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}
	
	public Line(int x1, int y1, int x2, int y2, String color, int width)
	{
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.color = color;
		this.width = width;
	}
	
	private double getLength() {
		// use the distance formula
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2)+ Math.pow(p2.getY() - p1.getY(),2));
	}
	
	@Override
	public String toString() {
		return "[ " + this.p1.toString() + ", " + this.p2.toString() + " ] Length: " + String.format("%.2f", getLength()) + ", Color: " + this.color + ", Width: " + this.width;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Line that;
		
		if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName()))
		{
			that = (Line)obj;
			if (that.p1.equals(this.p1) && that.p2.equals(this.p2) || that.p1.equals(this.p2) && that.p2.equals(this.p1))
			{
				if (that.width == this.width && that.color.equals(this.color))
				{
					return true;
				}
			}
		}
		return false;
	}
}
