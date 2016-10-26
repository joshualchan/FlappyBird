import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FlappyBird extends PApplet {

PImage flap;

Bird bob = new Bird();
Bars b1 = new Bars();

public void setup()
{
	
	flap = loadImage("https://tctechcrunch2011.files.wordpress.com/2014/07/flappybird_topic.png?fit=1%2C1");
}

public void draw()
{
	background(50,50,255);
	fill(0,255,0);
	rect(0,600,800,200);
	fill(255);

	bob.show();
	bob.move();
	b1.show();
	b1.move();

}

class Bird
{
	//variable declarations
	private double myX,myY;
	private boolean up;
	private double accelerate;

//constructor
	public Bird()  
	{
		// variable initializations
		myX = 200.0f;
		myY = 400.0f;
		accelerate = 0.0f;
	}

//move function
	public void move()
	{
		//CHANGE THE SPEED 
		if(mousePressed == true)
		{
			myY= myY - 15.0f;
			accelerate = 0.0f;
		}
		else
		{
			accelerate = accelerate + 0.05f;
			myY = myY + accelerate;
		}
	}

//show function
	public void show()
	{
		image(flap, (int)myX,(int)myY,50,50);
		
		if(get ((int)myX,(int)myY+50)== color(0,255,0))
		{
			noLoop();
			background(0);
			text("GAME OVER",400,400);
		}
		if(get ((int)myX,(int)myY-50)== color(0,255,0))
		{
			noLoop();
			background(0);
			text("GAME OVER",400,400);
		}

	}
}

public class Bars
{
	private int x,y,width1,length1,col;

	Bars()
	{
		y = 0;
		x = 600;
		width1 = 30;
		length1 = (int)(Math.random()*475);
		col = color(0,255,0);
	}
	public void move()
	{
		//MAKE BARS MOVE
		x --;
		if(x<0)
		{
			x = 800;
			length1 = (int)(Math.random()*475);
		}
	}
	public void show()
	{
		fill(col);
		//top bar
		rect(x,y,width1,length1);

		//bottom bar
		rect(x,length1+150,width1,800);
	}
}









  public void settings() { 	size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FlappyBird" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
