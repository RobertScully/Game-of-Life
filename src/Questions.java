import processing.core.*;

public class Questions{
	PApplet player;

	String questiontxt;
	String a1,a2,a3,a4;
	
	
	
	Questions(PApplet p, String qt,String text1,String text2,String text3,String text4){
		player=p;
		questiontxt=qt;
		a1=text1;
		a2=text2;
		a3=text3;
		a4=text4;
	}
	public void qdisplay(){
		player.text(questiontxt, 200,300);
		player.text(a1,120, 420);
		player.text(a2,120, 470);
		player.text(a3,120, 520);
		player.text(a4,120, 570);
	

		
	}
	
}
