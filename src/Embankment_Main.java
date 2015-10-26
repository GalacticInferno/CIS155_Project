/* What: 			Creates the play window in which Embankment will be played in
 * Class created: 	2015-10-20 by Cody Beaty
 * Edit(s):				
 * Notes: 			The main class that will startup (for now at least) & will display the
 * 			game window
*/
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Embankment_Main
{
	
	public static void main(String[] args) 
	{
		System.out.println("Starting...");
		
		int x = 0, y = 0;
		
		System.out.println("JFrame...");
		// Sets the title of the frame as Embankment
		JFrame frame = new JFrame ("Embankment");
		// Sets the close operation to a safe setting of EXIT ON CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		EmbankmentPanel panel = new EmbankmentPanel();
		frame.getContentPane().add(panel);
		
		// Automatically resizes window if components don't fit
		frame.pack();
		// Shows or hides the panel depending on if its true or false
		frame.setVisible(true);		
	}
}
