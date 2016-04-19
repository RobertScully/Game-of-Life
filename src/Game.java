import processing.core.*;//import processing library
import java.util.ArrayList;//Import array list functionality
import de.bezier.data.sql.*;//import library for accessing mysql database


public class Game extends PApplet {

	String answer1,answer2,answer3,answer4;
	
	String results;
	
	String[] resArray1=new String[3];
	String[] resArray2=new String[3];
	String[] resArray3=new String[3];
	String[] resArray4=new String[3];
	
	int qnumber=0;
	
	float chanceofdeath=random(1000);
	float increment=0.002f;
	
	
	String anystring="no answer selected";
	
	Player player = new Player(this, 50, 50, 50);
	public Questions q1;
	
	ArrayList<Questions> myQuestionList = new ArrayList<Questions>();
	
	
	public void setup()
	{
		background(2, 75, 127);
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
			//fill(246, 177, 85);
			text("Database failed to connect",150,300);
			
		}
	}
	
	public void draw()
	{
		dobackground();//Draws background continuously
		mouseHover();//Changes colour of answers when mouse is over each box
		
		player.display();//Display player stats
		
		q1 = myQuestionList.get(qnumber);
		q1.qdisplay();//Displays bars

		fill(246, 177, 85);
		text("Question number:",135,220);
		text(qnumber+1,235,220);

		text(myQuestionList.size(),200,350);//Shows total questions for error checking

	
		
		if(qnumber<myQuestionList.size()-1){
			if(q1.answered==true)
			{
				qnumber++;
				player.upAge(1);
				
				
			}
		}
		
		fill(246, 177, 85);
		text(chanceofdeath,200,300);
		fill(96, 237, 37);
		text(increment,200,400);
	
	}
	
	
	public void dobackground(){
		//Code to draw background rectangles for positioning
		//Resource bar rects
		fill(23, 56, 67);;//Sets background of bars to black
		stroke(0);
		rect(100,0,50,200);//Health
		rect(150,0,50,200);//Wealth
		rect(200,0,50,200);//Happiness
		rect(250,0,50,200);//Age 
		
		//Question rect
		stroke(0);
		noStroke();
		fill(2, 75, 127);//colour light grey
		rect(0,200,400,200);//Middle rect for questions
		
		//Question answers outline rects
		fill(23, 56, 67);//
		stroke(0);//
		rect(0,400,400,50,15);//Question 1 rect
		rect(0,450,400,50,15);//Question 2 rect
		rect(0,500,400,50,15);//Question 3 rect
		rect(0,550,400,50,15);//Question 4 rect
	}
	
	
	//Code for running as java application instead of applet
	public static void main(String args[]){
		PApplet.main(new String[] {"--present","Game"});
	}
	
	
	public void mouseClicked(){
		if(mouseX >0 && mouseX<400 && mouseY>400 && mouseY<450)
		{
			increment=increment+increment/3;
			chanceofdeath=random(100000);
			player.upAge(1);
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
			rect(0,400,400,50,15);
		}
		if(mouseX >0 && mouseX<400 && mouseY>450 && mouseY<500)
		{
			fill(0);
			rect(0,450,400,50,15);
			
		}
		if(mouseX >0 && mouseX<400 && mouseY>500 && mouseY<550)
		{
			fill(0);
			rect(0,500,400,50,15);
		}
		if(mouseX >0 && mouseX<400 && mouseY>550 && mouseY<600)
		{
			fill(0);
			rect(0,550,400,50,15);
		}
	}
}


