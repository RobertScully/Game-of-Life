import processing.core.*;

public class Player{
	
	PApplet parent;//Parent PApplet that i will render onto
	
	int healthb, wealthb, happyb;
	int ageb=20;
	
	
	Player(PApplet p, int heb, int wb, int hab){
		parent=p;
		healthb=heb;
		wealthb=wb;
		happyb=hab;
	}

	public void display(){
		//Display stats of character in bars
		//Displays health bar status
		parent.fill(220, 20, 60);//Colour healthbar
		parent.rect(100,200,50,healthb*-1);
		parent.fill(0,0,0);
		parent.text(healthb,120,200);
		
		//Displays wealth bar status
		parent.fill(255, 215, 0);//Colour wealthbar
		parent.rect(150,200,50,wealthb*-1);				
		parent.fill(0,0,0);
		parent.text(wealthb,170,200);
		
		//Displays happiness bar status
		parent.fill(127, 255, 0);//Colour happiness bar
		parent.rect(200,200,50,happyb*-1);
		parent.fill(0,0,0);
		parent.text(happyb,220,200);
		
		//Displays age bar status
		parent.fill(255, 140, 0);//Colour age bar
		parent.rect(250,200,50,ageb*-1);
		parent.fill(0,0,0);
		parent.text(ageb,270,200);//Prints status of bar
	}
	
	public void upHealth(int val){
		if(healthb>=0)
		{
			healthb=healthb+val;  //Increases healthiness
		}
	}
	public void upWealth(int val){
		if(wealthb>0)
		{
			wealthb=wealthb+val;
		}
	}
	public void upHappy(int val){
		if(happyb>=0)
		{
		happyb=happyb+val;
		}
	}
	public void upAge(int val){
		ageb=ageb+val;//Increase age by 1
	}
	
}
