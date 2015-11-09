
//Used to makes 32x32px Orange Cursor

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.lwjgl.opengl.GL11;

public class Cursor_O
{
	int texture[] = new int[3];
	
	public int x;
    public int y;
    public int sizex;
    public int sizey;
    public int keyPressed = 0;
    public int moveSpeed = 32;
	public int yTop = 16;
	public int yBottom = 864;
	public int xLeft = 16;
	public int xRight = 1248;
	
	
	public Cursor_O(int x1 , int y1 , int sizex1, int sizey1)
	{
		x = x1;
    	y = y1;
    	sizex = sizex1;
    	sizey = sizey1;
		load();
	}
	
	public void load()
	{
		texture = bitmapobjectstextures.Cursor_O_tex;
	}
	
	public void update(int key)
	{
		/*
		 * KEY MAPP
		 * 0 = no key pressed
		 * 84 = T
		 * 72 = H
		 * 71 = G
		 * 70 = F
		 * 82 = R
		 * 89 = Y
		 */
		keyPressed = key;
		switch(keyPressed){
		case 0:
			break;
		case 84:
			if (y > yTop) {
				y -= moveSpeed;
			}
			break;
		case 72:
			if (x < xRight) {
				x += moveSpeed;
			}
			break;
		case 71:
			if (y<yBottom){
				y += moveSpeed;
			}
			break;
		case 70:
			if(x>xLeft){
				x -= moveSpeed;
			}
			break;
		case 82:
			break;
		case 89:
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