

//This Starts OpenGL & Creates a window
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

class start
{
    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback   keyCallback;

    private long window;   
    int WIDTH = 1280;
    int HEIGHT = 896;
    
    GameLoop game = new GameLoop();
 
	public void run() 
	{		 
        try 
        {
            init();
            loop();
            glfwDestroyWindow(window);
            keyCallback.release();
        } 
        finally 
        {
            glfwTerminate();
            errorCallback.release();
        }
	}
	
	private void init() //openglstart
	{
        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        if ( glfwInit() != GL11.GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");
 
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE); 
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); 
 
        window = glfwCreateWindow(WIDTH, HEIGHT, "Embankment", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
 
        glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() 
        {
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                    glfwSetWindowShouldClose(window, GL_TRUE);
            }
        });

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos
        (
            window,
            (vidmode.getWidth() - WIDTH) / 2,
            (vidmode.getHeight() - HEIGHT) / 2
        );

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
        GL.createCapabilities();
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        
        game.load();
    }
	
    private void loop() //renderloop
    {
    	
    	 while ( glfwWindowShouldClose(window)  == GL_FALSE) 
        {
            glClear(GL_COLOR_BUFFER_BIT); 
            game.update();
            game.draw();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    } 
    
    
    
}


