
//Used to makes 32x32px Red Cursor

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.lwjgl.opengl.GL11;

public class Cursor_R
{
	int texture[] = new int[3];
	
	public int x;
    public int y;
    public int sizex;
    public int sizey;
    public int keyPressed;
    public int moveSpeed = 32;
	public int yTop = 16;
	public int yBottom = 864;
	public int xLeft = 16;
	public int xRight = 1248;
	
	
	public Cursor_R(int x1 , int y1 , int sizex1, int sizey1)
	{
		x = x1;
    	y = y1;
    	sizex = sizex1;
    	sizey = sizey1;
		load();
	}
	
	public void load()
	{
		texture = bitmapobjectstextures.Cursor_R_tex;
	}
	
	public void update(int key)
	{
		/*
		 * KEY MAPP
		 * 0 = no key pressed
		 * 73 = I
		 * 76 = L
		 * 75 = K
		 * 74 = J
		 * 85 = U
		 * 79 = O
		 */
		keyPressed = key;
		switch(keyPressed){
		case 0:
			break;
		case 73:
			if (y > yTop ) {
				if ( GameLoop.Bil_R.size() == 0) { // moves if no random wall exists
					y -= moveSpeed;
					for (int i =0; i < GameLoop.Bil_R.size(); i++)
	            	{
	            		GameLoop.Bil_R.get(i).update(key);
	            	}
				}
				else if (GameLoop.Bil_R.size() > 0)  // gets the location of random wall and tests if it would go over the border
				{
					if (GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getY() > yTop) {
						y -= moveSpeed;
						for (int i =0; i < GameLoop.Bil_R.size(); i++)
		            	{
		            		GameLoop.Bil_R.get(i).update(key);
		            	}
					}			
				}
			}
			break;
		case 76:
			if (x < xRight) {
				if ( GameLoop.Bil_R.size() == 0) { // moves if no random wall exists
					x += moveSpeed;
					for (int i =0; i < GameLoop.Bil_R.size(); i++)
	            	{
	            		GameLoop.Bil_R.get(i).update(key);
	            	}
				}
				else if (GameLoop.Bil_R.size() > 0)
				{
					if (GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getX() < xRight) { // gets the location of random wall and tests if it would go over the border
						x += moveSpeed;
						for (int i =0; i < GameLoop.Bil_R.size(); i++)
		            	{
		            		GameLoop.Bil_R.get(i).update(key);
		            	}
					}			
				}
			}
			break;
		case 75:
			if (y<yBottom){
				//y += moveSpeed;
				if ( GameLoop.Bil_R.size() == 0) { // moves if no random wall exists
					y += moveSpeed;
					for (int i =0; i < GameLoop.Bil_R.size(); i++)
	            	{
	            		GameLoop.Bil_R.get(i).update(key);
	            	}
				}
				else if (GameLoop.Bil_R.size() > 0)
				{
					if (GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getY() < yBottom) { // gets the location of random wall and tests if it would go over the border
						y += moveSpeed;
						for (int i =0; i < GameLoop.Bil_R.size(); i++)
		            	{
		            		GameLoop.Bil_R.get(i).update(key);
		            	}
					}			
				}
			}
			break;
		case 74:
			if(x>xLeft){
					if ( GameLoop.Bil_R.size() == 0) { // moves if no random wall exists
						x -= moveSpeed;
						for (int i =0; i < GameLoop.Bil_R.size(); i++)
		            	{
		            		GameLoop.Bil_O.get(i).update(key);
		            	}
					}
					else if (GameLoop.Bil_R.size() > 0)
					{
						if (GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getX() > xLeft) { // gets the location of random wall and tests if it would go over the border
							x -= moveSpeed;
							for (int i =0; i < GameLoop.Bil_R.size(); i++)
			            	{
			            		GameLoop.Bil_R.get(i).update(key);
			            	}
						}			
					}
			}
			break;
		case 85:
			break;
		case 79:
			break;
		
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void draw()
    {
    	square(x ,y ,sizex, sizey);
    }
    
	private void square(int x , int y , int sizex, int sizey)
    {
    	glBindTexture(GL11.GL_TEXTURE_2D, texture[0]);
    	
    	glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f((0 * sizex + x), (0 * sizey + y));
        glTexCoord2f(1, 0);
        glVertex2f((1 * sizex + x) + texture[1], (0 * sizey + y));
        glTexCoord2f(1, 1);
        glVertex2f((1 * sizex + x)+texture[1],(1 * sizey + y) + texture[2]);
        glTexCoord2f(0, 1);
        glVertex2f((0 * sizex + x), (1 * sizey + y) + texture[2]);
        glEnd();
	}
}