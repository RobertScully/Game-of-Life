import processing.core.*;//import processing library
import java.util.ArrayList;//Import array list functionality
import de.bezier.data.sql.*;//import database library


public class Game extends PApplet {

	
	String answer1,answer2,answer3,answer4;
	
	String results;
	
	String[] resArray1=new String[3];
	String[] resArray2=new String[3];
	String[] resArray3=new String[3];
	String[] resArray4=new String[3];
	
	int qnumber=0;
	
	String anystring="no answer selected";
	
	Player player = new Player(this, -50, -50, -50,-50);
	public Questions q1;
	
	ArrayList<Questions> myQuestionList = new ArrayList<Questions>();
	
	
	public void setup()
	{
		background(0);
		size(401,601);
		
		MySQL msql = new MySQL(this,"localhost","oop questions","Rob","1234");//Database setup
		
		if ( msql.connect() )//Database connection
	    {
	    	msql.query("SELECT * FROM questions");//Query database for all questions from the questions table
	    	while (msql.next())//Cycle through each question
	        {
	    		 String questiontxt = msql.getString("Q1");//Gets contents of current row at column Q1 and saves to questiontxt string
	    		 String a1 = msql.getString("A1");
	    		 String a2 = msql.getString("A2");
	    		 String a3 = msql.getString("A3");
	             String a4 = msql.getString("A4");
	             answer1 = msql.getString("A1RES");
	             answer2 = msql.getString("A2RES");
	             answer3 = msql.getString("A3RES");
	             answer4 = msql.getString("A4RES");
	            
	             myQuestionList.add(new Questions(this,questiontxt,a1,a2,a3,a4,answer1,answer2,answer3,answer4));
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
		mouseHover();//Changes colour of answers when mouse is over each box
		player.display();//Display player stats
		
		q1 = myQuestionList.get(qnumber);
		q1.qdisplay();//Displays bars
		
		//text("Question number: "qnumber,20,200);
		text(myQuestionList.size(),200,350);
		text(anystring,200,375);
		
		//text(answer4,200,475);
		
		if(qnumber<myQuestionList.size()-1){
			if(q1.answered==true)
			{
				qnumber++;
				//player.upAge(5);
			}
		}
		
		//text(player.wealthb,190,375);
		if(player.wealthb*-1<=0)
		{
			text("Your Dead",250,400);
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
	
	public void mouseClicked(){
		if(mouseX >0 && mouseX<400 && mouseY>400 && mouseY<450)
		{
			fill(0);
			rect(0,400,400,50);
			anystring="you clicked a";
			results=q1.applyValues1();
			q1.answered=true;
			resArray1 = PApplet.split(results, ',');
			player.upHealth(Integer.parseInt(resArray1[0]));
			player.upWealth(Integer.parseInt(resArray1[1]));
			player.upHappy(Integer.parseInt(resArray1[2]));
		}
		if(mouseX >0 && mouseX<400 && mouseY>450 && mouseY<500)
		{
			fill(0);
			rect(0,450,400,50);
			anystring="you clicked b";
			results=q1.applyValues2();
			q1.answered=true;
			resArray2 = PApplet.split(results, ',');
			player.upHealth(Integer.parseInt(resArray2[0]));
			player.upWealth(Integer.parseInt(resArray2[1]));
			player.upHappy(Integer.parseInt(resArray2[2]));
			
			
		}
		if(mouseX >0 && mouseX<400 && mouseY>500 && mouseY<550)
		{
			fill(0);
			rect(0,500,400,50);
			anystring="you clicked c";
			results=q1.applyValues3();
			q1.answered=true;
			resArray3 = PApplet.split(results, ',');
			player.upHealth(Integer.parseInt(resArray3[0]));
			player.upWealth(Integer.parseInt(resArray3[1]));
			player.upHappy(Integer.parseInt(resArray3[2]));
		}
		if(mouseX >0 && mouseX<400 && mouseY>550 && mouseY<600)
		{
			fill(0);
			rect(0,550,400,50);
			anystring="you clicked d";
			results=q1.applyValues4();
			q1.answered=true;
			resArray4 = PApplet.split(results, ',');
			player.upHealth(Integer.parseInt(resArray4[0]));
			player.upWealth(Integer.parseInt(resArray4[1]));
			player.upHappy(Integer.parseInt(resArray4[2]));
		}
		
	}
	
	public void mouseHover(){
		if(mouseX >0 && mouseX<400 && mouseY>400 && mouseY<450)
		{
			fill(0);
			rect(0,400,400,50);
		}
		if(mouseX >0 && mouseX<400 && mouseY>450 && mouseY<500)
		{
			fill(0);
			rect(0,450,400,50);
			
		}
		if(mouseX >0 && mouseX<400 && mouseY>500 && mouseY<550)
		{
			fill(0);
			rect(0,500,400,50);
		}
		if(mouseX >0 && mouseX<400 && mouseY>550 && mouseY<600)
		{
			fill(0);
			rect(0,550,400,50);
		}
	}
}


