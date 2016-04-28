package sdproject;
import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JFrame;

public class MyRobot {
private Robot robot;
public MyRobot () throws AWTException{
	robot = new Robot();
}

public void centrageSouris(JFrame fenetre){
	  //Centre la souris
	  int width = fenetre.getWidth()/2;
	  int height = fenetre.getHeight()/2;
	  Point p = fenetre.getLocationOnScreen();
	  robot.mouseMove(width+p.x, height+p.y);
	  
}

public void deplacementSouris(JFrame fenetre,int x,int y){
	  //Permet de déplacer la souris uniquement dans la fenêtre
	  int width = fenetre.getWidth();
	  int height = fenetre.getHeight();
	  Point p = fenetre.getLocationOnScreen();
	  if (x>=0 && x<= width && y>= 0 && y<= height)
	  {
		  robot.mouseMove(x+p.x,y+p.y);
	  }
	  
}

public void clicGauche(){
	robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
}

public void clicDroit(){
	robot.mousePress(InputEvent.BUTTON3_MASK);
    robot.mouseRelease(InputEvent.BUTTON3_MASK);
}

}
