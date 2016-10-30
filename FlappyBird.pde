PImage flap;

Bird bob = new Bird();
Bars b1 = new Bars();

public void setup()
{
	size(800,800);
	flap = loadImage("https://tctechcrunch2011.files.wordpress.com/2014/07/flappybird_topic.png?fit=1%2C1");
	background(0);
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
	if(get((int)bob.myX+45,(int)bob.myY+45)!= color(50,50,255))
		{
			noLoop();
			background(0);
			text("GAME OVER",400,400);
		}
	else if(get((int)bob.myX,(int)bob.myY+45)!= color(50,50,255))
		{
			noLoop();
			background(0);
			text("GAME OVER",400,400);
		}
	else if(get((int)bob.myX,(int)bob.myY)!= color(50,50,255))
	{
		noLoop();
		background(0);
		text("GAME OVER",400,400);
	}
	else if(get((int)bob.myX +45,(int)bob.myY)!= color(50,50,255))
		{
			noLoop();
			background(0);
			text("GAME OVER",400,400);
		}
	else
	{
		redraw();
	}
	text("myY is: "+ bob.myY,700,20);

}

public void mousePressed()
{
	
	bob.myY= bob.myY - 75;
	bob.accelerate = 0.0;

	
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
		myX = 200.0;
		myY = 400.0;
		accelerate = 0.0;
	}
	public void setX(int x){myX = x;}  
	public int getX(){return (int)myX;}   
	public void setY(int y){myY = y;}   
	public int getY(){return (int)myY;}   

//move function
	public void move()
	{
		//CHANGE THE SPEED 
		accelerate = accelerate + 0.05;
		myY = myY + accelerate;
	}

//show function
	public void show()
	{
		image(flap, (int)myX,(int)myY,50,50);
		
		

	 
	}
}

public class Bars
{
	private int x,y,width1,length1,col;

	public Bars()
	{
		y = 0;
		x = 600;
		width1 = 30;
		length1 = (int)(Math.random()*415)+60;
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
		noStroke();
		//top bar
		rect(x,y,width1,length1);

		//bottom bar
		rect(x,length1+150,width1,800);
	}
}









