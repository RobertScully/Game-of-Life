import processing.core.*;
import de.bezier.data.sql.*;


public class Game extends PApplet {
	
	String s1="lol";
	
	//int wealth=50;
	//String health="60";
	
	Player p1 = new Player(this,s1);
	Questions[] myCircleArray = new Questions[1];
	//Questions q1 = new Questions(this,"this is the text question text","this is a1",s1,"this is a3","this is a4" );
	
	
	public void setup(){
	
		background(0);
		size(401,601);
		
		MySQL msql = new MySQL(this,"localhost","oop questions","Rob","1234");
		
		if ( msql.connect() )
	    {
			int i=0;
			fill(255,0,0);
	    	rect(150,200,200,200);
	    	msql.query( "SELECT * FROM questions" );
	    	 while (msql.next())
	         {
	    		 String questiontxt = msql.getString("Q1");
	    		 String a1 = msql.getString("A1");
	    		 String a2 = msql.getString("A2");
	    		 String a3 = msql.getString("A3");
	             String a4 = msql.getString("A4");
	             
	             myCircleArray[i] = new Questions(this,questiontxt,a1,a2,a3,a4);
	             i++;
	             //text(questiontxt,300,300);
	         }
	    	
	    }
	    
	}
	
	public void draw()
	{
		//call various questions depending on time

		dobackground();
		p1.display();//Display player stats
		for(int i=0; i < myCircleArray.length;i++){
				myCircleArray[i].qdisplay();
			
			}
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


