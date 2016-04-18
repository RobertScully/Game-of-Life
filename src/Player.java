import processing.core.*;

public class Player{
	
	PApplet player;//Parent PApplet that i will render onto
	
	String stringy;
	//String health;

	
	Player(PApplet p,String s){
		player=p;
		stringy=s;
		//health=h;
		//player.text(" ",h);
	}

	
	int health=50;
	
	//int hp = player.int(health);
	
	
	
	
	
	
	public void display(){
		//display stats of character
		
		int healthbar=health*-2;//Flips bar so it increases in size upwards
		
		Float wealth=50.0f;//Initializes wealth bar to half size
		Float wealthbar=wealth*-2f;//Flips bar so it increases in size upwards
		
		Float happy=50.0f;//Initializes Happy bar to half size
		Float happybar=happy*-2f;//Flips bar so it increases in size upwards
		
		Float age=50.0f;//Initializes Age bar to half size
		Float agebar=age*-2f;//Flips bar so it increases in size upwards
		
		player.fill(255,0,0);//Colour healthbar
		player.rect(100,200,50,healthbar);
		player.fill(0,255,0);//Colour wealthbar
		player.rect(150,200,50,wealthbar);
		player.fill(0,0,255);//Colour happiness bar
		player.rect(200,200,50,happybar);
		player.fill(255,255,255);//Colour age bar
		player.rect(250,200,50,agebar);
		
		//player.text(health, 200,300);
		
	}
	
	public void upHealth(int val){
		health=health+val;
		
	}
	
	/*
	public float getHB(){
		return HB;
	}
	
	public void setHB(float HB){
		this.HB=HB;
	}
	*/
}
