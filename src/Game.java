import processing.core.*;

public class Game extends PApplet {
	String s1="lol";
	
	//int wealth=50;
	//String health="60";
	
	Player p1 = new Player(this,s1);
	Questions q1 = new Questions(this,"this is the text question text","this is a1",s1,"this is a3","this is a4" );
	
	
	public void setup(){
		background(0);
		
	}
	
	public void settings(){
		size(401,601);
	}
	
	public void draw()
	{
		//call various questions depending on time
		
		dobackground();
		p1.display();//Display player stats
		q1.qdisplay();
		
	}
	
	public void dobackground(){

		//Pros bar rect
		fill(0,250,0);
		rect(0,0,100,200);
		//Cons bar rect
		
		fill(250,0,0);
		rect(300,0,100,200);
		
		//Resource bar rects
		fill(0,0,0);//Sets background of bars to black
		stroke(255);
		rect(100,0,50,200);//Health
		rect(150,0,50,200);//Wealth
		rect(200,0,50,200);//Happiness
		rect(250,0,50,200);//Age 
		
		//Question rect
		stroke(0);
		fill(100,100,100);//colour light grey
		rect(0,200,400,200);//Middle rect for questions
		
		//Question answers outline rects
		fill(200,200,200);//fill dark grey
		stroke(0);//
		rect(0,400,400,50);//Question 1 rect
		rect(0,450,400,50);//Question 2 rect
		rect(0,500,400,50);//Question 3 rect
		rect(0,550,400,50);//Question 4 rect
	}
	
	//Code for running as java application instead of applet
	public static void main(String args[]){
		PApplet.main(new String[] {"--present","Game"});
	}
}


