import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class DrawCannonBall extends JFrame implements ActionListener, MouseListener 
{
	int x, y;
	
	public void drawCircle(int x, int y)
	{
		System.out.println("X: " + x + " Y: " + y);
		
		Graphics g = this.getGraphics();
		g.drawOval(x, y, 100, 100);
		g.setColor(Color.CYAN);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("Draw...");
		
		x = e.getX();
		y = e.getY();
		
		drawCircle(x,y);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
