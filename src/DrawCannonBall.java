/* What: 			Draws the "Cannonballs" onto screen
 * Class created: 	2015-10-27 by Cody Beaty
 * Edit(s):				
 * Notes:			Created on mouse is only temporary untill we get the Keys working
*/

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class DrawCannonBall extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	final int PIXELSMALL = 16;
	final int PIXELOFFSET = 8;
	
	int x, y;
	
	public void drawCircle(int x, int y, Graphics g)
	{
		System.out.println("X: " + x + " Y: " + y);
		
		// Draws a "Brown Cannonball" at the point in which the mouse clicks
		g.setColor(Color.ORANGE.darker());
		// PXELOFFSET is used to center the circle on the point of the mouse click
		g.fillOval(x - PIXELOFFSET, y - PIXELOFFSET, PIXELSMALL, PIXELSMALL);
		g.drawOval(x - PIXELOFFSET, y - PIXELOFFSET, PIXELSMALL, PIXELSMALL);
		
	}	
}
