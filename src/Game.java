import processing.core.*;//import processing library

import java.util.ArrayList;

import de.bezier.data.sql.*;//import database library


public class Game extends PApplet {

	int answer1,answer2,answer3,answer4;
	int healthb=-50;
	int wealthb=-50;
	int happyb=-50; 
	int ageb=-20;
	int qnumber=0;
	
	String anystring="no answer selected";
	
	Player player = new Player(this, healthb, wealthb, happyb, ageb);
	
	//Questions[] myQuestionArray = new Questions[5];
	ArrayList<Questions> myQuestionList = new ArrayList<Questions>();
	public Questions q1;// = myQuestionList.get(qnumber);
	
	public void setup()
	{
		background(0);
		size(401,601);
		
		MySQL msql = new MySQL(this,"localhost","oop questions","Rob","1234");//Database setup
		
		if ( msql.connect() )//Database connection
	    {
	    	msql.query("SELECT * FROM questions");
	    	
	    	while (msql.next())
	        {
	    		
	    		 String questiontxt = msql.getString("Q1");
	    		 String a1 = msql.getString("A1");
	    		 String a2 = msql.getString("A2");
	    		 String a3 = msql.getString("A3");
	             String a4 = msql.getString("A4");
	             
	             //myQuestionList<> = new Questions(this,questiontxt,a1,a2,a3,a4);
	             myQuestionList.add(new Questions(this,questiontxt,a1,a2,a3,a4));
	             //text(questiontxt,300,300);
	        }
	    }
		else
		{
			text("Database failed to connect",150,300);
		}
	}
	
	public void draw()
	{
		
		dobackground();//Draws background before main draw begins
		player.display();//Display player stats
		player.upHealth(1);
		//player.upWealth(1);
		//player.upHappy(1);
		//player.upAge(1);
		
		q1 = myQuestionList.get(qnumber);
		q1.qdisplay();
		
		text(qnumber,200,300);
		text(myQuestionList.size(),200,350);
		text(anystring,200,375);
		
		if(qnumber<myQuestionList.size()-1){
			if(q1.answered==true)
			{
				qnumber++;
			}
		}
		
	}
	
	public void mouseClicked(){
		if(mouseX >0 && mouseX<400 && mouseY>400 && mouseY<450)
		{
			fill(0);
			rect(0,400,400,50);
			anystring="you clicked a";
			q1.answered=true;
		}
		if(mouseX >0 && mouseX<400 && mouseY>450 && mouseY<500)
		{
			fill(0);
			rect(0,450,400,50);
			anystring="you clicked b";
			q1.answered=true;
			
		}
		if(mouseX >0 && mouseX<400 && mouseY>500 && mouseY<550)
		{
			fill(0);
			rect(0,500,400,50);
			anystring="you clicked c";
			q1.answered=true;
		}
		if(mouseX >0 && mouseX<400 && mouseY>550 && mouseY<600)
		{
			fill(0);
			rect(0,550,400,50);
			anystring="you clicked d";
			q1.answered=true;
		}
		
	}
	
	public void dobackground(){
		//Code to draw background rectangles for positioning
		
		//Pros bar rect
		fill(0,250,0);
		rect(0,0,100,200);
		
		//Cons bar rect
		fill(250,0,0);
		rect(300,0,100,200);
		
		//Resource bar rects
		fill(0,0,0);//Sets background of bars to black
		stroke(0);
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
//for(int i=0; i < myQuestionList.size();i++){
//myQuestionList.qdisplay();


