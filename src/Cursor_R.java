
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
			if (y > 16) {
				y -= 32;
			}
			break;
		case 76:
			if (x < 1248) {
				x += 32;
			}
			break;
		case 75:
			if (y<864){
				y += 32;
			}
			break;
		case 74:
			if(x>16){
				x -= 32;
			}
			break;
		case 85:
			break;
		case 79:
			break;
		
		}
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