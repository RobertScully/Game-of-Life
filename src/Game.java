import processing.core.*;

public class Game extends PApplet {
	public void setup(){
		background(0);
		rectMode(CENTER);
		
		//Pros bar rect
		fill(0,250,0);
		rect(50,100,100,200);
		//Cons bar rect
		fill(250,0,0);
		rect(350,100,100,200);
		
		//Resource bar rects
		fill(0,0,0);//Sets background of bars to black
		stroke(255);
		rect(125,100,50,200);//Health
		rect(175,100,50,200);//Wealth
		rect(225,100,50,200);//Happiness
		rect(275,100,50,200);//Age 
		
		//Question rect
		stroke(0);
		fill(100,100,100);//colour light grey
		rect(width/2,height/2,400,200);//Middle rect for questions
		
		//Question answers outline rects
		fill(200,200,200);//fill dark grey
		stroke(0);//
		rect(width/2,425,400,50);//Question 1 rect
		rect(width/2,475,400,50);//Question 2 rect
		rect(width/2,525,400,50);//Question 3 rect
		rect(width/2,575,400,50);//Question 4 rect
	}
	
	public void settings(){
		size(401,601);
	}
	
	public void draw()
	{
		//call various questions depending on time
	
		
	}
	
	
	//Code for running as java application instead of applet
	public static void main(String args[]){
		PApplet.main(new String[] {"--present","Game"});
	}
}


