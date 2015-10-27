/* What: 			Holds the values in which the play window is created
 * Class created: 	2015-10-20 by Cody Beaty
 * Edit(s):				
 * Notes: 			
*/
import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmbankmentPanel extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;

	private DrawCannonBall dcb = new DrawCannonBall();
	
	// Window Dimensions
	final int WIDTH = 1280;
	final int LENGTH = 896;
	
	// Constructor for Embankment Panel
	public EmbankmentPanel()
	{	
		System.out.println("Panel...");
		// Sets the background color
		setBackground(Color.BLACK);
		// Sets the dimensions for the window
		setPreferredSize(new Dimension(WIDTH, LENGTH));	
		addMouseListener(this);
	}

	// Currently a temporary holder for the creation of cannonballs
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("mouseClicked...");
		
		Graphics g = this.getGraphics();
		dcb.drawCircle(e.getX(), e.getY(), g);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
