import processing.core.*;

public class Player{
	
	PApplet parent;//Parent PApplet that i will render onto
	
	int healthb, wealthb, happyb, ageb;

	Player(PApplet p, int heb, int wb, int hab,int age){
		parent=p;
		healthb=heb;
		wealthb=wb;
		happyb=hab;
		ageb=age;
	}

	public void display(){
		//display stats of character in bars
		//Displays health bar status
		parent.fill(255,0,0);//Colour healthbar
		parent.rect(100,200,50,healthb);
		parent.fill(0,0,0);
		parent.text(healthb*-1,120,200);
		//Displays wealth bar status
		parent.fill(0,255,0);//Colour wealthbar
		parent.rect(150,200,50,wealthb);				
		parent.fill(0,0,0);
		parent.text(wealthb*-1,170,200);
		//Displays happiness bar status
		parent.fill(0,0,255);//Colour happiness bar
		parent.rect(200,200,50,happyb);
		parent.fill(0,0,0);
		parent.text(happyb*-1,220,200);
		//Displays age bar status
		parent.fill(255,255,255);//Colour age bar
		parent.rect(250,200,50,ageb);
		parent.fill(0,0,0);
		parent.text(ageb*-1,270,200);//Prints status of bar
	}
	
	public void upHealth(int val){
		if(healthb*-1>=0)
		{
			healthb=healthb-val;  //Increases healthiness
		}
	}
	public void upWealth(int val){
		if(wealthb*-1>0)
		{
			wealthb=wealthb-val;
		}
	}
	public void upHappy(int val){
		happyb=happyb-val;
	}
	public void upAge(int val){
		ageb=ageb-val;//Increase age by 1
	}
	
}
