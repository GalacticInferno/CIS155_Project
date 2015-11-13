/**
 * 
 */

/**
 * @author Cody
 *
 */
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
	
	public void debugInt2(Integer x, Integer y)
	{
		if(debug)
			System.out.println(x + ":" + y);
	}
}
