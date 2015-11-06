
//This Defines the Drawn objects, first time load objects, and contains game run code.

import java.util.ArrayList;


public class GameLoop 
{
	//Main Background
	ArrayList<World> World = new ArrayList<World>();
	
	//ALL WALL LISTS---
	//Blue Wall
	ArrayList<Wall_B> Wal_B = new ArrayList<Wall_B>();
	//Red Wall
	ArrayList<Wall_R> Wal_R = new ArrayList<Wall_R>();
	//Orange Wall
	ArrayList<Wall_O> Wal_O = new ArrayList<Wall_O>();
	//Black Wall
	ArrayList<Wall_N> Wal_N = new ArrayList<Wall_N>();
	//Destroyed Wall
	ArrayList<Wall_D> Wal_D = new ArrayList<Wall_D>();
	
	//All CURSORS---
	//Blue Cursor
	ArrayList<Cursor_B> Cur_B = new ArrayList<Cursor_B>();
	//Red Cursor
	ArrayList<Cursor_R> Cur_R = new ArrayList<Cursor_R>();
	//Orange Cursor
	ArrayList<Cursor_O> Cur_O = new ArrayList<Cursor_O>();
	//Blue Build Cursor
	ArrayList<Build_B> Bil_B = new ArrayList<Build_B>();
	//Red Build Cursor
	ArrayList<Build_R> Bil_R = new ArrayList<Build_R>();
	//Orange Build Cursor
	ArrayList<Build_O> Bil_O = new ArrayList<Build_O>();
	
	//ALL CASTLE LISTS---
	//Blue Castles
	ArrayList<Castle_B> Cas_B = new ArrayList<Castle_B>();
	//Red Castles
	ArrayList<Castle_R> Cas_R = new ArrayList<Castle_R>();
	//Orange Castles
	ArrayList<Castle_O> Cas_O = new ArrayList<Castle_O>();
	//Black Castles
	ArrayList<Castle_N> Cas_N = new ArrayList<Castle_N>();
	//Boat
	ArrayList<Boat_ai> Boat = new ArrayList<Boat_ai>();
	
	//ALL CANNON LIST---
	//Blue Cannon
	ArrayList<Cannon_B> Can_B = new ArrayList<Cannon_B>();
	//Red Cannon
	ArrayList<Cannon_R> Can_R = new ArrayList<Cannon_R>();
	//Orange Cannon
	ArrayList<Cannon_O> Can_O = new ArrayList<Cannon_O>();
	//Black Cannon
	ArrayList<Cannon_N> Can_N = new ArrayList<Cannon_N>();
	
	//FLAT COLOURS---
	//Blue
	ArrayList<B> Blue = new ArrayList<B>();
	//Red
	ArrayList<R> Red = new ArrayList<R>();
	//Orange
	ArrayList<O> Orange = new ArrayList<O>();
	//Black
	ArrayList<Black> Black = new ArrayList<Black>();
	
	//Cannon balls
	ArrayList<Ball> Ball = new ArrayList<Ball>();
	ArrayList<Cannonball_N> Cannonball_N = new ArrayList<Cannonball_N>();
	ArrayList<Cannonball_B> Cannonball_B = new ArrayList<Cannonball_B>();
	ArrayList<Cannonball_O> Cannonball_O = new ArrayList<Cannonball_O>();
	ArrayList<Cannonball_R> Cannonball_R = new ArrayList<Cannonball_R>();
	
	private void loadtex()
	{
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
		World.add(new World(0, 0, 0, 0));
		Wal_B.add(new Wall_B(0, 64, 0, 0));
		Wal_R.add(new Wall_R(32, 64, 0, 0));
		Wal_O.add(new Wall_O(64, 64, 0, 0));
		Wal_N.add(new Wall_N(96, 64, 0, 0));
		Wal_D.add(new Wall_D(128, 64, 0, 0));
		Cas_B.add(new Castle_B(0, 0, 0, 0));
		Cas_R.add(new Castle_R(64, 0, 0, 0));
		Cas_O.add(new Castle_O(128, 0, 0, 0));
		Cas_N.add(new Castle_N(192, 0, 0, 0));
		Can_B.add(new Cannon_B(256, 0, 0, 0));
		Can_R.add(new Cannon_R(320, 0, 0, 0));
		Can_O.add(new Cannon_O(384, 0, 0, 0));
		Can_N.add(new Cannon_N(448, 0, 0, 0));
		Boat.add(new Boat_ai(512, 0, 0, 0));
		Blue.add(new B(352, 64, 0, 0));
		Red.add(new R(384, 64, 0, 0));
		Orange.add(new O(416, 64, 0, 0));
		Black.add(new Black(448, 64, 0, 0));
		
		//Cursors
		Cur_B.add(new Cursor_B(160, 64, 0, 0));
		Cur_R.add(new Cursor_R(192, 64, 0, 0));
		Cur_O.add(new Cursor_O(224, 64, 0, 0));
		Bil_B.add(new Build_B(256, 64, 0, 0));
		Bil_R.add(new Build_R(288, 64, 0, 0));
		Bil_O.add(new Build_O(320, 64, 0, 0));
		Ball.add(new Ball(480, 64, 0, 0));
		Cannonball_N.add(new Cannonball_N(480, 64, 0, 0));
		Cannonball_B.add(new Cannonball_B(480, 64, 0, 0));
		Cannonball_O.add(new Cannonball_O(480, 64, 0, 0));
		Cannonball_R.add(new Cannonball_R(480, 64, 0, 0));
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
	
	public void update()
	{	
		//Put All game code here!!!
		
		
		Cannonball_N.add(new Cannonball_N(96, 96, 1, 1));
		Cannonball_N.remove(0);
		Cannonball_B.add(new Cannonball_B(0, 96, 1, 1));
		Cannonball_B.remove(0);
		Cannonball_O.add(new Cannonball_O(64, 96, 1, 1));
		Cannonball_O.remove(0);
		Cannonball_R.add(new Cannonball_R(32, 96, 1, 1));
		Cannonball_R.remove(0);
	}
}
