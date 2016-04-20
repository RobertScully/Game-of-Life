import processing.core.*;

public class Player{
	
	PApplet parent;//Parent PApplet that i will render onto
	
	int correctb, wrongb;
	int answeredb=0;
	
	
	Player(PApplet p, int cb, int wb){//Player Constructor
		parent=p;
		correctb=cb;
		wrongb=wb;
	}

	public void display(){
		//Display stats of answered questions in bars
		//Displays Correct answers bar
		parent.fill(127, 255, 0);//Colour correctbar
		parent.rect(100,200,50,correctb*-10);//Draw correctbar rect with height = to current value of health *10 for size
		parent.fill(0,0,0);
		parent.text(correctb,120,200);//Prints value of bar
		
		//Displays Wrong answers bar
		parent.fill(220, 20, 60);//Colour wrongbar
		parent.rect(150,200,50,wrongb*-10);	//Draw wrongbar rect with height = to current value of wealth			
		parent.fill(0,0,0);
		parent.text(wrongb,170,200);//Prints value of bar
		
		//Displays bar with number of questions answered status
		parent.fill(255, 140, 0);//Colour questions answered bar
		parent.rect(250,200,50,answeredb*-10);//Draw questions answered bar rect with height = to current value of age
		parent.fill(0,0,0);
		parent.text(answeredb,270,200);//Prints value of bar
		
	}
	
	public void upCorrect(int val){
		correctb=correctb+val;  //Increases correctb by val
	}
	public void upWrong(int val){
		wrongb=wrongb+val; //Increases wrongb by val
	}
	public void upAnswered(int val){
		answeredb=answeredb+val;//Increase answeredb by val
	}
	
	
}
