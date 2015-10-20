/* What: 			Holds the values in which the play window is created
 * Class created: 	2015-10-20 by Cody Beaty
 * Edit(s):				
 * Notes: 			
*/
import java.awt.*;
import javax.swing.*;

public class EmbankmentPanel extends JPanel
{
	// Window Dimensions
	final int WIDTH = 1280;
	final int LENGTH = 896;
	
	// Constructor for Embankment Panel
	public EmbankmentPanel()
	{
		// Sets the background color
		setBackground(Color.BLACK);
		// Sets the dimensions for the window
		setPreferredSize(new Dimension(WIDTH, LENGTH));
	}
}
