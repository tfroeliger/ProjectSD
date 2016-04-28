package sdproject;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MyJFrame {
	private JFrame fenetre ;
	private MyRobot robot;
	private Handlerclass handler;
  public static void main(String[] args) throws Exception {

	  MyJFrame w = new MyJFrame();
	  w.initFrame();
	  w.robot.centrageSouris(w.fenetre);
	  w.robot.deplacementSouris(w.fenetre,123,189);
    
  }
  
  public void initFrame() throws AWTException{
	  fenetre = new JFrame();
	  robot = new MyRobot();
	  
	  fenetre.setTitle("SD Project");
	  fenetre.setOpacity((float) 1.0);
	  fenetre.setSize(1200, 800);
	  fenetre.setLocationRelativeTo(null);
	  fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  fenetre.setContentPane(new Panneau());
	  fenetre.setVisible(true);
	    
	  handler = this.new Handlerclass();
	  fenetre.addMouseListener(handler);
	  fenetre.addMouseMotionListener(handler);
  }
  
  private class Handlerclass implements MouseListener, MouseMotionListener {
	  //MouseListener Event
	  public void mouseClicked(MouseEvent event){
		  fenetre.setTitle(String.format("Clicked at %d , %d ",event.getX(),event.getY()));
	  }
	  
	  public void mousePressed(MouseEvent event){
		  fenetre.setTitle("press down the mouse");
	  }
	  
	  public void mouseReleased(MouseEvent event){
		  fenetre.setTitle("press released the mouse");
	  }
	  
	  public void mouseEntered(MouseEvent event){
		  fenetre.setTitle("Enter arena");
		  fenetre.getContentPane().setBackground( Color.red ); 
	  }
	  
	  public void mouseExited(MouseEvent event){
		  fenetre.setTitle("exit arena");
		  fenetre.getContentPane().setBackground( Color.white ); 
	  }
	  //MouseMotionListener Event 
	  
	  public void mouseDragged(MouseEvent event){
		  fenetre.setTitle("Dragging mouse");
	  }
	  
	  public void mouseMoved(MouseEvent event){
		  fenetre.setTitle("You move the mouse");
	  }
  }
  
  public class Panneau extends JPanel { 
	  public void paintComponent(Graphics g){
	    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
	    System.out.println("Je suis exécutée !"); 
	    g.fillOval(20, 20, 75, 75);
	  }               
	}

}
