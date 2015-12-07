
//This Defines the Drawn objects, first time load objects, and contains game run code.

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import java.util.Random;
import java.util.ArrayList;
import org.lwjgl.glfw.GLFWKeyCallback;


public class GameLoop
{	
	//Game parameters

	private boolean startGame = true;
	private boolean first = true;
	private boolean blueFailed = false;
	private boolean redFailed = false;
	private boolean orangeFailed = false;
	
	private double lastTime;
	private double deltaTime;
	private double accumTime = 0;
	private int currentRound = 0;

	static public boolean cannonPhase = false;
	static public boolean battlePhase = false;
	static public boolean buildPhase = false;
	static public boolean endGame = false;
	
	Cannonball_create cannonball_create;
	// creates input as a KeyEvent class
	//private int keyPressed = 0;
	
	// TIMING MOVEMENT for ALL players 
	// NOTE HERE: player moves every 0.1 second -- change movSpeed to change movement speed (for all players)
	int  movSpeed = 100;
	long startTime_P1_move;
	long endTime_P1_move = System.currentTimeMillis();
	long startTime_P2_move;
	long endTime_P2_move = System.currentTimeMillis();
	long startTime_P3_move;
	long endTime_P3_move = System.currentTimeMillis();
	// TIMING rotation of WALLs for ALL players (uses the same value for movement speed) NOTE: can be changed by adding a new int value.
	long startTime_P1_rotate;
	long endTime_P1_rotate = System.currentTimeMillis();
	long startTime_P2_rotate;
	long endTime_P2_rotate = System.currentTimeMillis();
	long startTime_P3_rotate;
	long endTime_P3_rotate = System.currentTimeMillis();
	
	//Makes space on top of screen for Highscores
	public static int underBanner = 96;
	
	// TIMING CANNONBALL
	long startTime_P1_ball;
	long endTime_P1_ball = System.currentTimeMillis();
	long startTime_P2_ball;
	long endTime_P2_ball = System.currentTimeMillis();
	long startTime_P3_ball;
	long endTime_P3_ball = System.currentTimeMillis();
	// Count cannon - > needed to prevent updating the destination of the cannon ball
	int countBall_B = 0;
	int countBall_R = 0;
	int countBall_O = 0;
	int getBallCount = 0;
	// how fast the cannon balls are created. ( shots per time).
	int ballCreation = 2500;
	// Main Background
	ArrayList<Banner> Banner = new ArrayList<Banner>();

	// Wall variables
	boolean wallActive = false;
	// random generator
	Random rmdGen = new Random();

	//Main Background
	public ArrayList<World> World = new ArrayList<World>();
	
	//ALL WALL LISTS---
	//Blue Wall
	public static ArrayList<Wall_B> Wal_B = new ArrayList<Wall_B>();
	//Red Wall
	public static ArrayList<Wall_R> Wal_R = new ArrayList<Wall_R>();
	//Orange Wall
	public static ArrayList<Wall_O> Wal_O = new ArrayList<Wall_O>();
	//Black Wall
	public static ArrayList<Wall_N> Wal_N = new ArrayList<Wall_N>();
	//Destroyed Wall
	public static ArrayList<Wall_D> Wal_D = new ArrayList<Wall_D>();
	
	//All CURSORS---
	//Blue Cursor
	public static ArrayList<Cursor_B> Cur_B = new ArrayList<Cursor_B>();
	//Red Cursor
	public static ArrayList<Cursor_R> Cur_R = new ArrayList<Cursor_R>();
	//Orange Cursor
	public static ArrayList<Cursor_O> Cur_O = new ArrayList<Cursor_O>();
	//Blue Build Cursor
	public static ArrayList<Build_B> Bil_B = new ArrayList<Build_B>();
	//Red Build Cursor
	public static ArrayList<Build_R> Bil_R = new ArrayList<Build_R>();
	//Orange Build Cursor
	public static ArrayList<Build_O> Bil_O = new ArrayList<Build_O>();
	
	//ALL CASTLE LISTS---
	//Blue Castles
	public static ArrayList<Castle_B> Cas_B = new ArrayList<Castle_B>();
	//Red Castles
	public static ArrayList<Castle_R> Cas_R = new ArrayList<Castle_R>();
	//Orange Castles
	public static ArrayList<Castle_O> Cas_O = new ArrayList<Castle_O>();
	//Black Castles
	public static ArrayList<Castle_N> Cas_N = new ArrayList<Castle_N>();
	//Boat
	public static ArrayList<Boat_ai> Boat = new ArrayList<Boat_ai>();
	
	//ALL CANNON LIST---
	//Blue Cannon

	public static ArrayList<Cannon_B> Can_B = new ArrayList<Cannon_B>();
	//Red Cannon
	public static ArrayList<Cannon_R> Can_R = new ArrayList<Cannon_R>();
	//Orange Cannon
	public static ArrayList<Cannon_O> Can_O = new ArrayList<Cannon_O>();
	//Black Cannon
	public static ArrayList<Cannon_N> Can_N = new ArrayList<Cannon_N>();


	
	//FLAT COLOURS---
	//Blue
	public static ArrayList<B> Blue = new ArrayList<B>();
	//Red
	public static ArrayList<R> Red = new ArrayList<R>();
	//Orange
	public static ArrayList<O> Orange = new ArrayList<O>();
	//Black
	public static ArrayList<Black> Black = new ArrayList<Black>();
	
	//Cannon balls
	public static ArrayList<Ball> Ball = new ArrayList<Ball>();
	public static ArrayList<Cannonball_N> Cannonball_N = new ArrayList<Cannonball_N>();
	public static ArrayList<Cannonball_B> Cannonball_B = new ArrayList<Cannonball_B>();
	public static ArrayList<Cannonball_O> Cannonball_O = new ArrayList<Cannonball_O>();
	public static ArrayList<Cannonball_R> Cannonball_R = new ArrayList<Cannonball_R>();
	
	public GameLoop()
	{
		lastTime = (double) System.currentTimeMillis() / 1000.0;
	}
	
	private void loadtex()
	{
		bitmapobjectstextures.Banner_tex = loadtextures.load("Banner");
		bitmapobjectstextures.B_tex = loadtextures.load("B");
		bitmapobjectstextures.Ball_tex = loadtextures.load("Ball");
		bitmapobjectstextures.Cannonball_N_tex = loadtextures.load("Cannonball_N");
		bitmapobjectstextures.Cannonball_B_tex = loadtextures.load("Cannonball_B");
		bitmapobjectstextures.Cannonball_O_tex = loadtextures.load("Cannonball_O");
		bitmapobjectstextures.Cannonball_R_tex = loadtextures.load("Cannonball_R");
		bitmapobjectstextures.Black_tex = loadtextures.load("Black");
		bitmapobjectstextures.Boat_ai_tex = loadtextures.load("Boat_ai");
		bitmapobjectstextures.Build_B_tex = loadtextures.load("Build_B");
		bitmapobjectstextures.Build_O_tex = loadtextures.load("Build_O");
		bitmapobjectstextures.Build_R_tex = loadtextures.load("Build_R");
		bitmapobjectstextures.Cannon_B_tex = loadtextures.load("Cannon_B");
		bitmapobjectstextures.Cannon_N_tex = loadtextures.load("Cannon_N");
		bitmapobjectstextures.Cannon_O_tex = loadtextures.load("Cannon_O");
		bitmapobjectstextures.Cannon_R_tex = loadtextures.load("Cannon_R");
		bitmapobjectstextures.Castle_B_tex = loadtextures.load("Castle_B");
		bitmapobjectstextures.Castle_N_tex = loadtextures.load("Castle_N");
		bitmapobjectstextures.Castle_O_tex = loadtextures.load("Castle_O");
		bitmapobjectstextures.Castle_R_tex = loadtextures.load("Castle_R");
		bitmapobjectstextures.Cursor_B_tex = loadtextures.load("Cursor_B");
		bitmapobjectstextures.Cursor_O_tex = loadtextures.load("Cursor_O");
		bitmapobjectstextures.Cursor_R_tex = loadtextures.load("Cursor_R");
		bitmapobjectstextures.R_tex = loadtextures.load("R");
		bitmapobjectstextures.O_tex = loadtextures.load("O");
		bitmapobjectstextures.Wall_B_tex = loadtextures.load("Wall_B");
		bitmapobjectstextures.Wall_D_tex = loadtextures.load("Wall_D");
		bitmapobjectstextures.Wall_N_tex = loadtextures.load("Wall_N");
		bitmapobjectstextures.Wall_O_tex = loadtextures.load("Wall_O");
		bitmapobjectstextures.Wall_R_tex = loadtextures.load("Wall_R");
		bitmapobjectstextures.Wall_tex = loadtextures.load("Wall_B");
		bitmapobjectstextures.World_tex = loadtextures.load("World");
	}
	
	public void load()
	{
		loadtex();
		
		//All items here will be run once at start
		//                    X Y
		Banner.add(new Banner(0,0,0,0));
		World.add(new World(0, 0 + underBanner, 0, 0));
		
		Cas_B.add(new Castle_B(128, 160 + underBanner, 0, 0));
		Cas_R.add(new Castle_R(1088, 160 + underBanner, 0, 0));
		Cas_O.add(new Castle_O(544, 640 + underBanner, 0, 0));
		
		//Cursors
		Cur_B.add(new Cursor_B(128, 160 + underBanner, 0, 0));
		Cur_R.add(new Cursor_R(1088, 160 + underBanner, 0, 0));
		Cur_O.add(new Cursor_O(544, 640 + underBanner, 0, 0));
	}

	public void draw()
	{
		
		// Last Drawn Item in list is top...	
		for(int i = 0; i<World.size(); i++)
		{
			World.get(i).draw();
		}
		//Draw all Blue Walls in list
		for(int i = 0; i<Wal_B.size(); i++)
		{
			Wal_B.get(i).draw();
		}
		//Draw all Red Walls in list
		for(int i = 0; i<Wal_R.size(); i++)
		{
			Wal_R.get(i).draw();
		}
		//Draw all Orange Walls in list
		for(int i = 0; i<Wal_O.size(); i++)
		{
			Wal_O.get(i).draw();
		}
		//Draw all Black Walls in list
		for(int i = 0; i<Wal_N.size(); i++)
		{
			Wal_N.get(i).draw();
		}
		//Draw all Broken Walls in list
		for(int i = 0; i<Wal_D.size(); i++)
		{
			Wal_D.get(i).draw();
		}
		
		for(int i = 0; i<Blue.size(); i++)
		{
			Blue.get(i).draw();
		}
		for(int i = 0; i<Red.size(); i++)
		{
			Red.get(i).draw();
		}
		for(int i = 0; i<Orange.size(); i++)
		{
			Orange.get(i).draw();
		}
		for(int i = 0; i<Black.size(); i++)
		{
			Black.get(i).draw();
		}
		
		//Draw all Boats in list
		for(int i = 0; i<Boat.size(); i++)
		{
			Boat.get(i).draw();
		}
		//Draw all Blue Cannon in list
		for(int i = 0; i<Can_B.size(); i++)
		{
			Can_B.get(i).draw();
		}
		//Draw all Red Cannon in list
		for(int i = 0; i<Can_R.size(); i++)
		{
			Can_R.get(i).draw();
		}
		//Draw all Orange Cannon in list
		for(int i = 0; i<Can_O.size(); i++)
		{
			Can_O.get(i).draw();
		}
		//Draw all Black Cannon in list
		for(int i = 0; i<Can_N.size(); i++)
		{
			Can_N.get(i).draw();
		}
		
		//Draw all Blue Castles in list
		for(int i = 0; i<Cas_B.size(); i++)
		{
			Cas_B.get(i).draw();
		}
		//Draw all Red Castles in list
		for(int i = 0; i<Cas_R.size(); i++)
		{
			Cas_R.get(i).draw();
		}
		//Draw all Orange Castles in list
		for(int i = 0; i<Cas_O.size(); i++)
		{
			Cas_O.get(i).draw();
		}
		//Draw all Black Castles in list
		for(int i = 0; i<Cas_N.size(); i++)
		{
			Cas_N.get(i).draw();
		}
		
		//CURSORS ALWAYS LAST SO THEY WILL BE ON TOP
		for(int i = 0; i<Cur_B.size(); i++)
		{
			Cur_B.get(i).draw();
		}
		for(int i = 0; i<Cur_R.size(); i++)
		{
			Cur_R.get(i).draw();
		}
		for(int i = 0; i<Cur_O.size(); i++)
		{
			Cur_O.get(i).draw();
		}
		for(int i = 0; i<Bil_B.size(); i++)
		{
			Bil_B.get(i).draw();
		}
		for(int i = 0; i<Bil_R.size(); i++)
		{
			Bil_R.get(i).draw();
		}
		for(int i = 0; i<Bil_O.size(); i++)
		{
			Bil_O.get(i).draw();
		}
		// Banner
		for(int i = 0; i<Banner.size(); i++)
		{
			Banner.get(i).draw();
		}
		
		//cannon balls must also be on top
		for(int i = 0; i<Ball.size(); i++)
		{
			Ball.get(i).draw();
		}
		for(int i = 0; i<Cannonball_N.size(); i++)
		{
			Cannonball_N.get(i).draw();
		}	
		for(int i = 0; i<Cannonball_B.size(); i++)
		{
			Cannonball_B.get(i).draw();
		}
		for(int i = 0; i<Cannonball_O.size(); i++)
		{
			Cannonball_O.get(i).draw();
		}
		for(int i = 0; i<Cannonball_R.size(); i++)
		{
			Cannonball_R.get(i).draw();
		}

	}
	// ---------------------------------- GAME LOOP --------------------------------------
	//Put All game code here!!!
	public void update(long window)
	{	
		FloodFill ff = new FloodFill();
		Debug debug = new Debug();

		initWall iw = new initWall();
		cleaning clean = new cleaning();;
		

		// Delta time used to calculate seconds
		double currentTime = (double)System.currentTimeMillis() / 1000.0;
		deltaTime =   currentTime - lastTime;
		lastTime =  currentTime;
		
		accumTime += deltaTime;

		
		debug.debugDoubleWithString(accumTime, "accumTime:");
		debug.debugDoubleWithString(deltaTime, "deltaTime:");
		//----------------Start----------------------------//
		if(startGame)
		{	
			// on the first run through
				// draw the first walls
				// claim the first zones
				// start count down
			if(first)
			{
				System.out.println("Starting...5");
				
				iw.wallCas(Cas_B.get(0).x, Cas_B.get(0).y, 1);
				iw.wallCas(Cas_R.get(0).x, Cas_B.get(0).y, 2);
				iw.wallCas(Cas_O.get(0).x, Cas_O.get(0).y, 3);
				
				ff.floodFill();
				
				first = false;
			}
				
			if(accumTime > 2 && accumTime < 2.1)
				System.out.println("Starting...4");
			if(accumTime > 3 && accumTime < 3.1)
				System.out.println("Starting...3");
			if(accumTime > 4 && accumTime < 4.1)
				System.out.println("Starting...2");
			if(accumTime > 5 && accumTime < 5.1)
				System.out.println("Starting...1");
			if(accumTime > 5.1 && accumTime < 5.2)
			{
				System.out.println("START!");
				startGame = false;
			}
		}	
		
		//-------------------Cannon Place------------------------------//
		
		if(accumTime > 5 && accumTime < 20)
		{
			
			if(accumTime > 5 && accumTime < 5.1) 
			{
				System.out.println("Ready the Cannons!");
				Cur_B.get(0).setX(128);
				Cur_B.get(0).setY(160 + underBanner);
				Cur_R.get(0).setX(1088);
				Cur_R.get(0).setY(160 + underBanner);
				Cur_O.get(0).setX(544);
				Cur_O.get(0).setY(640 + underBanner);
				ff.floodOnce = false;
			}
			if(accumTime > 5.1 && accumTime < 5.2) {
				if (ff.floodOnce == false) {
					ff.floodFill();
					ff.floodBlue = true;
					ff.floodOrange = true;
					ff.floodRed = true;
				}
			}
			// update up game parameters.
			cannonPhase = true;
			startGame = false;
			battlePhase = false;
			buildPhase = false;
			endGame = false;
			
			keyInput(window);
			CannonPlace.checkCannon_collision();

		}
		
		//--------------------Battle Phase-----------------------------//
		
		if(accumTime > 20 && accumTime < 35)
		{
			// update up game parameters.
			cannonPhase = false;
			startGame = false;
			battlePhase = true;
			buildPhase = false;
			endGame = false;
			
			// get start time for timing shooting. 
			Cannonball_create.startTime_P1_ball = System.currentTimeMillis();
			Cannonball_create.startTime_P2_ball = System.currentTimeMillis();
			Cannonball_create.startTime_P3_ball = System.currentTimeMillis();
			
			// cannon shooting 
			cannonShot();
			System.out.println("Fire!");
		}
		
		//--------------------Cleaning---------------------------------//
		
		if(accumTime > 35 && accumTime < 36)
		{
			// Removes randomly selected walls and destrpyed walls
			clean.clean();
		}
				
		//--------------------Wall Build-------------------------------//
		
		if(accumTime > 36 && accumTime < 66)
		{	
			if(accumTime > 36 && accumTime < 36.01) {
				System.out.println("Repair the Walls!");
				Cur_B.get(0).setX(128);
				Cur_B.get(0).setY(160 + underBanner);
				Cur_R.get(0).setX(1088);
				Cur_R.get(0).setY(160 + underBanner);
				Cur_O.get(0).setX(544);
				Cur_O.get(0).setY(640 + underBanner);
				RmdBuild.rmd_wall_B();
				RmdBuild.rmd_wall_R();
				RmdBuild.rmd_wall_O();
				
				if (ff.floodOnce == false) 
				{
					ff.floodFill();
					ff.floodBlue = true;
					ff.floodOrange = true;
					ff.floodRed = true;
				} 
			}
			if(accumTime > 36.1 && accumTime < 36.2) {
				if (ff.floodOnce == false) {
					ff.floodFill();
					ff.floodBlue = true;
					ff.floodOrange = true;
					ff.floodRed = true;
				}
			}
			
			
			// update up game parameters.
			cannonPhase = false;
			startGame = false;
			battlePhase = false;
			buildPhase = true;
			endGame = false;
			
			//keyInput(window); // scan for input
			// checks if wall can be build
			// blue
			PlaceWall.checkForWall_B();
			PlaceWall.checkForCannon_B();
			PlaceWall.checkForCastle_B();
			// red
			PlaceWall.checkForWall_R();
			PlaceWall.checkForCannon_R();
			PlaceWall.checkForCastle_R();
			// orange
			PlaceWall.checkForWall_O();
			PlaceWall.checkForCannon_O();
			PlaceWall.checkForCastle_O();
			
			ff.floodFill();
		}
		
		// Checks to see if any players have failed to reclaim their areas
		if(accumTime > 66 && accumTime < 67)
		{
			if(Blue.isEmpty())
			{
				debug.debugString("Blue Empty");
				blueFailed = true;
			}
			if(Red.isEmpty())
			{
				debug.debugString("Red Empty");
				redFailed = true;
			}
			if(Orange.isEmpty())
			{
				debug.debugString("Orange Empty");
				orangeFailed = true;
			}
		}
		
		debug.debugLong(System.currentTimeMillis());;
		
		//---------------------End Game--------------------------------//
		// Failure Conditions
		if((blueFailed && redFailed && orangeFailed)|| (blueFailed && redFailed) || (blueFailed && orangeFailed) || (redFailed && orangeFailed) || (currentRound == 10))
		{
			// if time runs out or no one was able to block in their castles
			// everyone loses
			if((currentRound == 10) || (blueFailed && redFailed && orangeFailed))
				System.out.println("Game Over: Everyone Loses");
			
			// if Orange wins
			if((blueFailed && redFailed))
			{
				System.out.println("Orange Wins!");
				
				Cas_B.clear();
				Wal_B.clear();
				Blue.clear();
				Cur_B.clear();
				Can_B.clear();
				
				Cas_R.clear();
				Wal_R.clear();
				Red.clear();
				Cur_R.clear();
				Can_R.clear();
			}
			
			// if red wins
			if((blueFailed && orangeFailed))
			{
				System.out.println("Red Wins!");
				
				Cas_B.clear();
				Wal_B.clear();
				Blue.clear();
				Cur_B.clear();
				Can_B.clear();
				
				Cas_O.clear();
				Wal_O.clear();
				Orange.clear();
				Cur_O.clear();
				Can_O.clear();
			}
			
			// if blue wins
			if((redFailed && orangeFailed))
			{
				System.out.println("Blue Wins!");
				
				Cas_R.clear();
				Wal_R.clear();
				Red.clear();
				Cur_R.clear();
				Can_R.clear();
				
				Cas_O.clear();
				Wal_O.clear();
				Orange.clear();
				Cur_O.clear();
				Can_O.clear();
			}
			
		}else
		{
			// If failure Conditions are not met
			if (accumTime > 67)
			{
				accumTime = 0;
				currentRound++;
				
				accumTime = 0;
				cannonPhase = false;
				startGame = false;
				battlePhase = false;
				buildPhase = false;
				endGame = false;
				// remove build
				RmdBuild.remove_Build();
			}		
			//ff.floodFill();
		}
		
		debug.debugString("Quit");
		debug.debugLong(System.currentTimeMillis());;
	}
	
// -------------------------------------- END OF GAME LOOP ---------------------------------
// Scan input for all Players.
void keyInput(long window) {
	final GLFWKeyCallback   key_Callback;
	glfwSetKeyCallback(window, key_Callback = new GLFWKeyCallback() 
    {
        public void invoke(long window, int key, int scancode, int action, int mods) {
        	// PLAYER ONE
        	// move up
            if ( key == GLFW_KEY_W && action == GLFW_PRESS ) 
            {
            	startTime_P1_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P1_move < startTime_P1_move) 
            	{    
	            	Cur_B.get(0).update(key);
	            	endTime_P1_move = System.currentTimeMillis();
            	}
            }
            // move right
             if ( key == GLFW_KEY_D && action == GLFW_PRESS )
             {    
            	startTime_P1_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P1_move < startTime_P1_move) 
            	{
	            	Cur_B.get(0).update(key);
	            	endTime_P1_move = System.currentTimeMillis();
	            	
            	}
        	}
             // move down
             if ( key == GLFW_KEY_S && action == GLFW_PRESS ) 
             {    
            	startTime_P1_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P1_move < startTime_P1_move) 
            	{
	            	Cur_B.get(0).update(key);
	            	endTime_P1_move = System.currentTimeMillis();
            	}
            }
             //move left
             if ( key == GLFW_KEY_A && action == GLFW_PRESS )
             {     
            	startTime_P1_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P1_move < startTime_P1_move) 
            	{	
	            	Cur_B.get(0).update(key);
	            	endTime_P1_move = System.currentTimeMillis();
            	}
            }
          // Rotate the WALL uses different timer than movement. -->> rotate while moving NOTE: (not implemented)
            if ( key == GLFW_KEY_Q && action == GLFW_PRESS )
            { 
            		startTime_P1_rotate = System.currentTimeMillis();
            		
            		if (movSpeed+endTime_P1_rotate < startTime_P1_rotate) 
            		{
		            	Cur_B.get(0).update(key);
		            	RotateBil.rotate_B();
		            	endTime_P1_rotate = System.currentTimeMillis();
            		}
	            
            }
            // E for placing WALL is not timed and therefore can be placed at any time.
            if ( key == GLFW_KEY_E && action == GLFW_PRESS )
            { 
            		if(buildPhase) {
            			PlaceWall.placewall_B();
            			Cur_B.get(0).update(key);
            		}
            		 if(cannonPhase) {
            			 CannonPlace.placeCannon_B();
            		 }
            		// rmd_wall_B();
            		 //placewall_B();
	            	//Cur_B.get(0).update(key);
            }
            
            // IF KEY IS RELEASED NOTE: this might needs adjustment -->> more testing
            if ( key != GLFW_KEY_W /*&& action == GLFW_RELEASE*/ ) 
            {
            	Cur_B.get(0).update(0);
            }
            if ( key != GLFW_KEY_D /*&& action == GLFW_RELEASE */)
            {
            	Cur_B.get(0).update(0);
        	}
            if ( key != GLFW_KEY_S /*&& action == GLFW_RELEASE */) 
            {
            	Cur_B.get(0).update(0);
            }
            if ( key != GLFW_KEY_A /*&& action == GLFW_RELEASE*/ )
            {
            	Cur_B.get(0).update(0);
            }
            if ( key == GLFW_KEY_Q && action == GLFW_RELEASE )
            {
            	Cur_B.get(0).update(0);
            }
            if ( key == GLFW_KEY_E && action == GLFW_RELEASE )
            {
            	Cur_B.get(0).update(0);
            } // END OF PLAYER ONE
            
            // PLAYER 2
            // move up
            if ( key == GLFW_KEY_T && action == GLFW_PRESS ) 
            {
            	startTime_P2_move = System.currentTimeMillis();
            	if (movSpeed+endTime_P2_move < startTime_P2_move) 
            	{
	            	Cur_O.get(0).update(key);
	            	endTime_P2_move = System.currentTimeMillis();
            	}
            }
            // move right
             if ( key == GLFW_KEY_H && action == GLFW_PRESS )
             {
            	startTime_P2_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P2_move < startTime_P2_move) 
            	{
	            	Cur_O.get(0).update(key);
	            	endTime_P2_move = System.currentTimeMillis();
	            	
            	}
        	}
             // move down
             if ( key == GLFW_KEY_G && action == GLFW_PRESS ) 
             {
            	startTime_P2_move = System.currentTimeMillis();   
            	
            	if (movSpeed+endTime_P2_move < startTime_P2_move) 
            	{
	            	Cur_O.get(0).update(key);
	            	endTime_P2_move = System.currentTimeMillis();
            	}
            }
             // move left
             if ( key == GLFW_KEY_F && action == GLFW_PRESS )
             {
            	startTime_P2_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P2_move < startTime_P2_move) 
            	{	       
	            	Cur_O.get(0).update(key);
	            	endTime_P2_move = System.currentTimeMillis();
            	}
            }
            // Rotate the WALL uses different timer than movement.
            if ( key == GLFW_KEY_R && action == GLFW_PRESS )
            { 	
            		startTime_P2_rotate = System.currentTimeMillis();
            		
            		if (movSpeed+endTime_P2_rotate < startTime_P2_rotate) 
            		{
            			RotateBil.rotate_O();
		            	Cur_O.get(0).update(key);
		            	endTime_P2_rotate = System.currentTimeMillis();
            		}
	            
            }
            // Y for placing WALL is not timed and therefore can be placed at any time.
            if ( key == GLFW_KEY_Y && action == GLFW_PRESS )
            { 
            	if(buildPhase) {
            		PlaceWall.placewall_O();
            		Cur_O.get(0).update(key);
            	}
            	 if(cannonPhase) {
        			 CannonPlace.placeCannon_O();
        		 }
	            	//Cur_O.get(0).update(key);
            }
            
            // IF KEY IS RELEASED --> NOTE: adjustment might be needed
            if ( key != GLFW_KEY_T /*&& action == GLFW_RELEASE*/ ) 
            {
            	Cur_O.get(0).update(0);
            }
            if ( key != GLFW_KEY_H /*&& action == GLFW_RELEASE */)
            {
            	Cur_O.get(0).update(0);
        	}
            if ( key != GLFW_KEY_G /*&& action == GLFW_RELEASE */) 
            {
            	Cur_O.get(0).update(0);
            }
            if ( key != GLFW_KEY_F /*&& action == GLFW_RELEASE*/ )
            {
            	Cur_O.get(0).update(0);
            }
            if ( key == GLFW_KEY_R && action == GLFW_RELEASE )
            {
            	Cur_O.get(0).update(0);
            }
            if ( key == GLFW_KEY_Y && action == GLFW_RELEASE )
            {      
            	
            	Cur_O.get(0).update(0);
            }// END OF PLAYER TWO
            
            // player 3
            // move up
            if ( key == GLFW_KEY_I && action == GLFW_PRESS )  
            {
            	startTime_P3_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P3_move < startTime_P3_move) 
            	{
	            	Cur_R.get(0).update(key);	           
	            	endTime_P3_move = System.currentTimeMillis();
            	}
            }
            //move right
             if ( key == GLFW_KEY_L && action == GLFW_PRESS )
             {  
            	startTime_P3_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P3_move < startTime_P3_move) 
            	{
	            	Cur_R.get(0).update(key);	            	
	            	endTime_P3_move = System.currentTimeMillis();
	            	
            	}
        	}
             //move down
             if ( key == GLFW_KEY_K && action == GLFW_PRESS ) 
             { 
            	startTime_P3_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P3_move < startTime_P3_move) 
            	{
	            	Cur_R.get(0).update(key);	            	
	            	endTime_P3_move = System.currentTimeMillis();
            	}
            }
             // move left
             if ( key == GLFW_KEY_J && action == GLFW_PRESS )
             {  
            	startTime_P3_move = System.currentTimeMillis();
            	
            	if (movSpeed+endTime_P3_move < startTime_P3_move) 
            	{	
	            	Cur_R.get(0).update(key);	            	
	            	endTime_P3_move = System.currentTimeMillis();
            	}
            }
             // Rotate the WALL uses different timer than movement.
            if ( key == GLFW_KEY_U && action == GLFW_PRESS )
            {             	
            		startTime_P3_rotate = System.currentTimeMillis();
            		
            		if (movSpeed+endTime_P3_rotate < startTime_P3_rotate) 
            		{
            			RotateBil.rotate_R();
		            	Cur_R.get(0).update(key);
		            	endTime_P3_rotate = System.currentTimeMillis();
            		}
	            
            }
            // E for placing WALL is not timed and therefore can be placed at any time.
            if ( key == GLFW_KEY_O && action == GLFW_PRESS )
            { 
            	if (buildPhase) {
            		PlaceWall.placewall_R();
            		Cur_R.get(0).update(key);
            	}
            	 if(cannonPhase) {
        			 CannonPlace.placeCannon_R();
        		 }
	            	//Cur_R.get(0).update(key);
            }
            
            // IF KEY IS RELEASED SAME as player 1 & 2
            if ( key != GLFW_KEY_I /*&& action == GLFW_RELEASE*/ ) 
            {
            	Cur_R.get(0).update(0);
            }
            if ( key != GLFW_KEY_L /*&& action == GLFW_RELEASE */)
            {            	
            	Cur_R.get(0).update(0);                 	
        	}
            if ( key != GLFW_KEY_K /*&& action == GLFW_RELEASE */) 
            {            	
            	Cur_R.get(0).update(0);
            }
            if ( key != GLFW_KEY_J /*&& action == GLFW_RELEASE*/ )
            {            	
            	Cur_R.get(0).update(0);
            }
            if ( key == GLFW_KEY_U && action == GLFW_RELEASE )
            {            	
            	Cur_R.get(0).update(0);
            }
            if ( key == GLFW_KEY_O && action == GLFW_RELEASE )
            {            	
            	Cur_R.get(0).update(0);
            } // END OF PLAYER THREE
            
            
            
            
            //TEMP FIX FOR CLOSING THE WINDOW --- my key inputs disabled the ESC button in openglstartfile.java
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) // only needed for playerOne!
                glfwSetWindowShouldClose(window, GL_TRUE);
        } // end of invoke keyevents
        	
    });
}



public void cannonShot() 
{
	//------BLUE-----------
			Cannonball_create.cannonball_B(Can_B.size());   // counts and creates blue cannon and shots to destination (destination is set by player cursor)
		
			// updates the cannonball array for BLUE
			for (int i = 0; i < Cannonball_B.size() ; i++)
			{
				Cannonball_B.get(i).update();
				//System.out.println("xSpeed: " + Cannonball_B.get(i).xSpeed);
			}
			// removes the blue ball when target is hit
			Cannonball_create.cannonball_B_remove(Cannonball_B.size());
			//-------------END BLUE-----------
			
			//-----------------------RED-----------
			Cannonball_create.cannonball_R(Can_R.size());   // counts and creates red cannon and shots to destination (destination is set by player cursor)
			// updates the cannonball array for red
			for (int i = 0; i < Cannonball_R.size() ; i++)
			{
				Cannonball_R.get(i).update();
			}
			// removes the red ball when target is hit
			Cannonball_create.cannonball_R_remove(Cannonball_R.size());
			//----------------------END RED----------
			
			//--------------ORANGE------
			Cannonball_create.cannonball_O(Can_O.size());   // counts and creates orange cannon and shots to destination (destination is set by player cursor)
			// updates the cannonball array for orange
			for (int i = 0; i < Cannonball_O.size() ; i++)
			{
				Cannonball_O.get(i).update();
			}
			// removes the orange ball when target is hit
			Cannonball_create.cannonball_O_remove(Cannonball_O.size());
			//-----------END ORANGE -------
}

void checkMov() {
	if ( Cur_B.get(0).getX() < Cur_B.get(0).yTop )
	{
		if (Bil_B.size() > 0) {
			
		}
	}
}
}
