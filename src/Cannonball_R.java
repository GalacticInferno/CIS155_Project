import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.GL11;

public class Cannonball_R 
{
	int texture[] = new int[3];
	
	public int x;
    public int y;
    public int sizex;
    public int sizey;
    public int destination_x;
    public int destination_y;
	
	public Cannonball_R (int x1 , int y1 , int sizex1, int sizey1)
	{
		x = x1;
    	y = y1;
    	sizex = sizex1;
    	sizey = sizey1;
		load();
	}
	
	public void load()
	{
		texture = bitmapobjectstextures.Cannonball_R_tex;
	}
	
	public void update()
	{
		// moving speed NOTE: NEEDS SOME WORK
		if ( x < destination_x /*&& y < destination_y*/) 
		{
			x += 1;
			//y += 1;
		}
		if ( x > destination_x /*&& y > destination_y*/) 
		{
			x -= 1;
			//y -=1;
		}
		if ( y < destination_y) 
		{
			y += 1;
		}
		if ( y > destination_y) 
		{
			y -= 1;
		} 
	}
	public int getX() 
	{
		return x;
	}
	public int getY() 
	{
		return y;
	}
	public int getDestiX() 
	{
		return destination_x;
	}
	public int getDestiY() 
	{
		return destination_y;
	}
	// set x location of cannon
		public void setX(int setX) 
		{
			x = setX;
		}
		// set y location of cannon
		public void setY(int setY) 
		{
			y = setY;
		}
		public void setDestinationX(int setDestiX)
		{
			destination_x = setDestiX;
		}
		public void setDestinationY(int setDestiY)
		{
			destination_y = setDestiY;
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
