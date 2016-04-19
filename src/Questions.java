import processing.core.*;

public class Questions{
	PApplet parent;
	boolean answered=false;
	String questiontxt, a1,a2,a3,a4;
	
	
	
	Questions(PApplet p, String qt,String text1,String text2,String text3,String text4){
		parent=p;
		questiontxt=qt;
		a1=text1;
		a2=text2;
		a3=text3;
		a4=text4;
	}
	
	public void qdisplay(){
		parent.text(questiontxt, 20,250);
		parent.text(a1,20, 420);
		parent.text(a2,20, 470);
		parent.text(a3,20, 520);
		parent.text(a4,20, 570);
	}
	
}
