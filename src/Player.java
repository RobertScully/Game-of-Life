import processing.core.*;

public class Player{
	
	PApplet parent;//Parent PApplet that i will render onto
	
	int correctb, wrongb;// happyb;
	int answeredb=0;
	
	
	Player(PApplet p, int cb, int wb){
		parent=p;
		correctb=cb;
		wrongb=wb;
		//happyb=hab;,int hab
	}

	public void display(){
		//Display stats of character in bars
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
		/*
		//Displays happiness bar status
		parent.fill(127, 255, 0);//Colour happiness bar
		parent.rect(200,200,50,happyb*-1);//Draw happiness bar rect with height = to current value of happiness
		parent.fill(0,0,0);
		parent.text(happyb,220,200);//Prints value of bar
		*/
		//Displays age bar status
		parent.fill(255, 140, 0);//Colour age bar
		parent.rect(250,200,50,answeredb*-10);//Draw age bar rect with height = to current value of age
		parent.fill(0,0,0);
		parent.text(answeredb,270,200);//Prints value of bar
		
	}
	
	public void upHealth(int val){
		if(correctb>=0)
		{
			correctb=correctb+val;  //Increases correct bar by val
		}
	}
	public void upWealth(int val){
		if(wrongb>=0)
		{
			wrongb=wrongb+val; //Increases wrong bar by val
		}
	}
	/*
	public void upHappy(int val){
		if(happyb>=0)
		{
		happyb=happyb+val; // Increases happiness by val
		}
	}
	*/
	public void upAnswered(int val){
		answeredb=answeredb+val;//Increase answered bar by val
	}
	
	
}
