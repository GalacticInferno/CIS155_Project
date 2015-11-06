import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;

import de.matthiasmann.twl.utils.PNGDecoder;
import de.matthiasmann.twl.utils.PNGDecoder.Format;

class bitmapobjectstextures
{
	public static int B_tex[] = new int[3];
	public static int Black_tex[] = new int[3];
	public static int Boat_ai_tex[] = new int[3];
	public static int Build_B_tex[] = new int[3];
	public static int Build_O_tex[] = new int[3];
	public static int Build_R_tex[] = new int[3];
	public static int Cannon_B_tex[] = new int[3];
	public static int Cannon_N_tex[] = new int[3];
	public static int Cannon_O_tex[] = new int[3];
	public static int Cannon_R_tex[] = new int[3];
	public static int Castle_B_tex[] = new int[3];
	public static int Castle_N_tex[] = new int[3];
	public static int Castle_O_tex[] = new int[3];
	public static int Castle_R_tex[] = new int[3];
	public static int Cursor_B_tex[] = new int[3];
	public static int Cursor_O_tex[] = new int[3];
	public static int Cursor_R_tex[] = new int[3];
	public static int R_tex[] = new int[3];
	public static int O_tex[] = new int[3];
	public static int Wall_B_tex[] = new int[3];
	public static int Wall_D_tex[] = new int[3];
	public static int Wall_N_tex[] = new int[3];
	public static int Wall_O_tex[] = new int[3];
	public static int Wall_R_tex[] = new int[3];
	public static int Wall_tex[] = new int[3];
	public static int World_tex[] = new int[3];
	public static int Ball_tex[] = new int[3];
	public static int Cannonball_N_tex[] = new int[3];
	public static int Cannonball_B_tex[] = new int[3];
	public static int Cannonball_O_tex[] = new int[3];
	public static int Cannonball_R_tex[] = new int[3];
}

class loadtextures
{
	public static  int[] load(String name) 
    {
        int[] twh = new int[3];
        ByteBuffer buf = null;
        int tWidth = 0;
        int tHeight = 0;

        try 
        {
            // Open the PNG file as an InputStream
            InputStream in = new FileInputStream("src/res/" + name + ".png");
            // Link the PNG decoder to this stream
            PNGDecoder decoder = new PNGDecoder(in);

            // Get the width and height of the texture
            tWidth = decoder.getWidth();
            tHeight = decoder.getHeight();
            twh[1] = tWidth;
            twh[2] = tHeight;   

            // Decode the PNG file in a ByteBuffer
            buf = ByteBuffer.allocateDirect(
                    4 * decoder.getWidth() * decoder.getHeight());
            decoder.decode(buf, decoder.getWidth() * 4, Format.RGBA);
            buf.flip();

            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }

        // Create a new texture object in memory and bind it
        int texId = GL11.glGenTextures();
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texId);

        // All RGB bytes are aligned to each other and each component is 1 byte
        GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);

        // Create a new texture object in memory and bind it    
        // Upload the texture data and generate mip maps (for scaling)
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, tWidth, tHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buf);
        GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D);

        // Setup the ST coordinate system
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);

        // Setup what to do when the texture has to be scaled
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
        twh[0] = texId;
        return twh;
    }
}

