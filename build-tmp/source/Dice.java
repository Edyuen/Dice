import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {


Die firstDie;
public void setup()
{
	size(600,600);
	noLoop();
}
public void draw()
{
	int total=0;
	background(0);
	for (int i = 57; i<=500; i=i+70){
			for (int j = 40; j<=500; j=j+70){
	
	firstDie = new Die(i,j);
	firstDie.show();
	total=total+ firstDie.numDots;
	
}
}
	fill(255);
	textSize(28);
	text("Sum:"+ total, 300, 550);
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{


	int numDots, myX, myY, kolor;
	int r, g, b;
	Die(int x, int y) //constructor
	{
		roll();
		kolor=(int)(Math.random()*3+1);
		myX=x;
		myY=y;
		r=0;
		g=0;
		b=0;
	}
	public void roll()
	{
		numDots=(int)(Math.random()*6+1);
	}
	public void show()
	{
		
		
		stroke(0);
		fill(255);
		fill(PApplet.parseInt(random(256+100)),PApplet.parseInt(random(256+100)),PApplet.parseInt(random(256+100)));
		int sizee=60;
		rect(myX,myY,sizee,sizee,18);
		if (numDots==1){
			fill(0);
			ellipse(myX+30, myY+30, 13,13);
		}
		if (numDots==2){
			fill(0);
			ellipse(myX+20, myY+25,13,13);
			ellipse(myX+40, myY+35,13,13);
		}

		if (numDots==3){
			fill(0);
			ellipse(myX+20, myY+25,13,13);
			ellipse(myX+40, myY+25,13,13);
			ellipse(myX+30, myY+38,13,13);
		}
		if (numDots==4){
			fill(0);
			ellipse(myX+20, myY+22,13,13);
			ellipse(myX+40, myY+22,13,13);
			ellipse(myX+20, myY+40,13,13);
			ellipse(myX+40, myY+40,13,13);

		}
		if (numDots==5){
			fill(0);
			ellipse(myX+18, myY+20,13,13);
			ellipse(myX+42, myY+20,13,13);
			ellipse(myX+18, myY+42,13,13);
			ellipse(myX+42, myY+42,13,13);
			ellipse(myX+30, myY+30,13,13);
}
		if (numDots==6){
			fill(0);
			ellipse(myX+20, myY+15,13,13);
			ellipse(myX+40, myY+15,13,13);
			ellipse(myX+20, myY+30,13,13);
			ellipse(myX+40, myY+30,13,13);
			ellipse(myX+20, myY+45,13,13);
			ellipse(myX+40, myY+45,13,13);

		}
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
