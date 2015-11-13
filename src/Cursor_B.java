

//Used to makes 32x32px Blue Cursor

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.lwjgl.opengl.GL11;

public class Cursor_B
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
	public int wallX;
	public int wallY;
	
	public Cursor_B(int x1 , int y1 , int sizex1, int sizey1)
	{
		x = x1;
    	y = y1;
    	sizex = sizex1;
    	sizey = sizey1;
		load();
	}
	
	public void load()
	{
		texture = bitmapobjectstextures.Cursor_B_tex;
	}
	
	public void update(int key)
	{
		/*
		 * KEY MAPP
		 * 0 = no key pressed
		 * 87 = W
		 * 68 = d
		 * 83 = s
		 * 65 = a
		 * 81 = q
		 * 69 = e
		 */
		keyPressed = key;
			switch(keyPressed){
			case 0:
				break;
			case 87:
				if (y > yTop ) {
					if ( GameLoop.Bil_B.size() == 0) { // moves if no random wall exists
						y -= moveSpeed;
						for (int i =0; i < GameLoop.Bil_B.size(); i++)
		            	{
		            		GameLoop.Bil_B.get(i).update(key);
		            	}
					}
					else if (GameLoop.Bil_B.size() > 0)  // gets the location of random wall and tests if it would go over the border
					{
						if (GameLoop.Bil_B.get(GameLoop.Bil_B.size()-2).getY() > yTop) {
							y -= moveSpeed;
							for (int i =0; i < GameLoop.Bil_B.size(); i++)
			            	{
			            		GameLoop.Bil_B.get(i).update(key);
			            	}
						}			
					}
				}
				break;
			case 68:
				if (x < xRight) {
					if ( GameLoop.Bil_B.size() == 0) { // moves if no random wall exists
						x += moveSpeed;
						for (int i =0; i < GameLoop.Bil_B.size(); i++)
		            	{
		            		GameLoop.Bil_B.get(i).update(key);
		            	}
					}
					else if (GameLoop.Bil_B.size() > 0)
					{
						if (GameLoop.Bil_B.get(GameLoop.Bil_B.size()-2).getX() < xRight) { // gets the location of random wall and tests if it would go over the border
							x += moveSpeed;
							for (int i =0; i < GameLoop.Bil_B.size(); i++)
			            	{
			            		GameLoop.Bil_B.get(i).update(key);
			            	}
						}			
					}
				}
				break;
			case 83:
				if (y<yBottom){
					//y += moveSpeed;
					if ( GameLoop.Bil_B.size() == 0) { // moves if no random wall exists
						y += moveSpeed;
						for (int i =0; i < GameLoop.Bil_B.size(); i++)
		            	{
		            		GameLoop.Bil_B.get(i).update(key);
		            	}
					}
					else if (GameLoop.Bil_B.size() > 0)
					{
						if (GameLoop.Bil_B.get(GameLoop.Bil_B.size()-2).getY() < yBottom) { // gets the location of random wall and tests if it would go over the border
							y += moveSpeed;
							for (int i =0; i < GameLoop.Bil_B.size(); i++)
			            	{
			            		GameLoop.Bil_B.get(i).update(key);
			            	}
						}			
					}
				}
				break;
			case 65:
				if(x>xLeft){
						if ( GameLoop.Bil_B.size() == 0) { // moves if no random wall exists
							x -= moveSpeed;
							for (int i =0; i < GameLoop.Bil_B.size(); i++)
			            	{
			            		GameLoop.Bil_B.get(i).update(key);
			            	}
						}
						else if (GameLoop.Bil_B.size() > 0)
						{
							if (GameLoop.Bil_B.get(GameLoop.Bil_B.size()-2).getX() > xLeft) { // gets the location of random wall and tests if it would go over the border
								x -= moveSpeed;
								for (int i =0; i < GameLoop.Bil_B.size(); i++)
				            	{
				            		GameLoop.Bil_B.get(i).update(key);
				            	}
							}			
						}
				}
				break;
			case 81:
				break;
			case 69:
				break;
			
			}
	} 
	
	public void draw()
    {
    	square(x ,y ,sizex, sizey);
    }
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setWallX(int x) {
		wallX = x;
	}
public void setWallY(int y) {
		wallY = y;
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