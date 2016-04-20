import processing.core.*;//import processing library
import java.util.ArrayList;//Import array list functionality
import de.bezier.data.sql.*;//import library for accessing mysql database


public class Game extends PApplet {

	String answer1,answer2,answer3,answer4;
	String results;
	
	//Defining 4 arrays for passing of variables from database to check whether an answer is correct or incorrect
	String[] resArray1=new String[2];
	String[] resArray2=new String[2];
	String[] resArray3=new String[2];
	String[] resArray4=new String[2];
	
	public int qnumber=0;//Int for tracking what number question currently being asked
	
	Player player = new Player(this, 0, 0);//Initializes player
	public Questions q1;
	
	ArrayList<Questions> myQuestionList = new ArrayList<Questions>();//Arraylist of questions used so questions can be dynamically added and removed
	
	
	public void setup()
	{
		background(2, 75, 127);
		size(401,601);
		
		MySQL msql = new MySQL(this,"localhost","oop questions","Rob","1234");//Database setup
		
		if ( msql.connect() )//Database connection
	    {
	    	msql.query("SELECT * FROM questions");//Query database for all questions from the questions table
	    	while (msql.next())//Cycle through each question in questions table
	        {
	    		 String questiontxt = msql.getString("Q1");//Gets contents of row at column Q1 and saves to questiontxt string
	    		 String a1 = msql.getString("A1");
	    		 String a2 = msql.getString("A2");
	    		 String a3 = msql.getString("A3");
	             String a4 = msql.getString("A4");
	             answer1 = msql.getString("A1RES");
	             answer2 = msql.getString("A2RES");
	             answer3 = msql.getString("A3RES");
	             answer4 = msql.getString("A4RES");
	            
	             myQuestionList.add(new Questions(this,questiontxt,a1,a2,a3,a4,answer1,answer2,answer3,answer4));//Adds new obkect to questionlist with contents filled from the database
	        }
	    }
		else//Error checking to detect if the database has been connected to successfully
		{
			text("Database failed to connect",150,300);
		}
		
	}
	
	public void draw()
	{
		dobackground();//Draws background continuously
		mouseHover();//Changes colour of answers when mouse is over each box
		
		player.display();//Display player stats
		
		q1 = myQuestionList.get(qnumber);//q1 is set to be filled with whatever list item qnumber is currently set to
		
		q1.qdisplay();//Displays current object in q1

		
		//If the question number is less than size of the array increment
		if(qnumber<myQuestionList.size()-1){
			if(q1.answered==true)
			{
				qnumber++;//increments qnumber so next question can be displayed
				player.upAnswered(1);//Increases bar that tracks how many questions have been answered
			}
		}

		fill(246, 177, 85);
		text("Question number:",135,220);//Displays current question number
		text(qnumber+1,235,220);//Displays qnumber+1 which will be the number the user is currently at
		
		if(qnumber+1==myQuestionList.size())//If qnumber is the same size as the total questions in the list shows completed screen with users results
		{
			fill(2, 75, 127);
			rect(0,200,400,200,15);
			fill(246, 177, 85);
			text("Congratulations you completed the quiz",20,250);
			text("You answered ",20,270);
			text(player.correctb,100,270);
			text("questions correctly",120,270);
		}
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
		fill(2, 75, 127);
		rect(0,200,400,200,15);//Middle rect for questions
	
		fill(23, 56, 67);
		rect(0,200,400,25,15);//Rect for containing the text which displays what question the user is currently on
		
		//Question answers outline rects
		fill(23, 56, 67);//
		stroke(0);//
		rect(0,400,400,50,15);//Question 1 rect
		rect(0,450,400,50,15);//Question 2 rect
		rect(0,500,400,50,15);//Question 3 rect
		rect(0,550,400,50,15);//Question 4 rect
	}

	
	public void mouseClicked(){
		if(mouseX >0 && mouseX<400 && mouseY>400 && mouseY<450)//Hit detection for if user clicks on first question box
		{
			results=q1.applyValues1();//Calls apply value function which returns current answer1 from questions object. Answer 1 is A1RES from the database
			q1.answered=true;//Sets answered bool to true so game will move on to the next question
			resArray1 = PApplet.split(results, ',');//Splits the contents of results into resArray1
			player.upCorrect(Integer.parseInt(resArray1[0]));//Changes the string at position 0 in resArray to an int. This int then becomes the value that upCorrect calls. If it is 1 upcorrectb will increase by 1 if it is 0 upcorrect does not increase
			player.upWrong(Integer.parseInt(resArray1[1]));//Changes the string at position 1 in resArray to an int. This int then becomes the value that upWrong calls. If it is 1 upwrongb will increase by 1 if it is 0 upwrongb does not increase
		}
		if(mouseX >0 && mouseX<400 && mouseY>450 && mouseY<500)
		{
			results=q1.applyValues2();
			q1.answered=true;
			resArray2 = PApplet.split(results, ',');
			player.upCorrect(Integer.parseInt(resArray2[0]));
			player.upWrong(Integer.parseInt(resArray2[1]));
			//player.upHappy(Integer.parseInt(resArray2[2]));
		}
		if(mouseX >0 && mouseX<400 && mouseY>500 && mouseY<550)
		{
			results=q1.applyValues3();
			q1.answered=true;
			resArray3 = PApplet.split(results, ',');
			player.upCorrect(Integer.parseInt(resArray3[0]));
			player.upWrong(Integer.parseInt(resArray3[1]));
		}
		if(mouseX >0 && mouseX<400 && mouseY>550 && mouseY<600)
		{
			results=q1.applyValues4();
			q1.answered=true;
			resArray4 = PApplet.split(results, ',');
			player.upCorrect(Integer.parseInt(resArray4[0]));
			player.upWrong(Integer.parseInt(resArray4[1]));
		}
	}
	//Changes colour of  question mouse is hovering over
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
	
	//Code for running as java application instead of applet
	public static void main(String args[]){
		PApplet.main(new String[] {"--present","Game"});
	}
}

