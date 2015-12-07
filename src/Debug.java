// Created by Cody Beaty
// Allows for universal Debugging based on True/False
// Would like to expand this class further for other projects
public class Debug 
{
	private boolean debug = false;
	
	public void debugString(String s)
	{
		if(debug)
			System.out.println(s);
	}
	
	public void debugInt(Integer x)
	{
		if(debug)
			System.out.println(x);
	}
	
	public void debugLong(Long x)
	{
		if(debug)
			System.out.println(x);
	}
	
	public void debugInt2(Integer x, Integer y)
	{
		if(debug)
			System.out.println(x + ":" + y);
	}
	
	public void debugDouble(Double x)
	{
		if(debug)
			System.out.println(x);
	}
	
	public void debugDoubleWithString(Double x, String s)
	{
		if(debug)
			System.out.println(s + x);
	}
	
	public void debugIntegerWithString(Integer x, String s)
	{
		if(debug)
			System.out.println(s + x);
	}
}
