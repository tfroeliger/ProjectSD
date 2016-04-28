package sdproject;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MyJFrame extends JFrame implements ActionListener{
	private JFrame fenetre ;
	private MyRobot robot;
	private Handlerclass handler;
	private JPanel jpanel1;
	public BoutonTriangle boutonTriangle;
	public BoutonRectangle boutonRectangle;
	public BoutonCercle boutonCercle;
	public Panneau panel;
	
  public static void main(String[] args) throws Exception {

	  MyJFrame w = new MyJFrame();
	  w.initFrame();
	  w.robot.centrageSouris(w.fenetre);
	  w.robot.deplacementSouris(w.fenetre,100,200);
    
  }
  
  public void initFrame() throws AWTException{
	  fenetre = new JFrame();
	  robot = new MyRobot();
	  jpanel1 = new JPanel();
	  boutonTriangle = (new BoutonTriangle("Bouton triangle"));
	  boutonRectangle = (new BoutonRectangle("Bouton rectangle"));
	  boutonCercle = (new BoutonCercle("Bouton cercle"));
	  panel = new Panneau();
	   
	   
	  
	  
	  fenetre.setTitle("SD Project");
	  fenetre.setOpacity((float) 1.0);
	  fenetre.setSize(1200, 800);
	  fenetre.setLocationRelativeTo(null);
	  fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  fenetre.setContentPane(panel);
	  fenetre.setAlwaysOnTop(true);
	  fenetre.setVisible(true);
	    
	  handler = this.new Handlerclass();
	  fenetre.addMouseListener(handler);
	  fenetre.addMouseMotionListener(handler);
	  ajoutBouton();
  }

  public void ajoutBouton() {
	  jpanel1.setLayout(new BoxLayout(jpanel1, BoxLayout.LINE_AXIS));
	    //A l'ouest
	  jpanel1.add(boutonTriangle);
	  jpanel1.add(boutonCercle);
	  jpanel1.add(boutonRectangle);
	  boutonTriangle.addActionListener(this);
	  boutonCercle.addActionListener(this);
	  boutonRectangle.addActionListener(this);
	  
	  jpanel1.setVisible(true);
	  fenetre.getContentPane().add(jpanel1, BorderLayout.NORTH);;
  }
  
  public void actionPerformed(ActionEvent arg0) {
	  if(arg0.getSource() == boutonTriangle)
	  {
		  System.out.println("Bouton azeaze clicked");
		  boutonTriangle.setEnabled(true);
		  boutonCercle.setEnabled(false);
		  boutonRectangle.setEnabled(false);
	  }

	  if(arg0.getSource() == boutonCercle)
	  {
		  System.out.println("Bouton boutonCercle clicked");
		  boutonTriangle.setEnabled(false);
		  boutonCercle.setEnabled(true);
		  boutonRectangle.setEnabled(false);
	  }
	  if(arg0.getSource() == boutonRectangle)
	  {
		  System.out.println("Bouton boutonRectangle clicked");
		  boutonTriangle.setEnabled(false);
		  boutonCercle.setEnabled(false);
		  boutonRectangle.setEnabled(true);
	  }
	}
  
  private class Handlerclass implements MouseListener, MouseMotionListener {
	  //MouseListener Event
	  public void mouseClicked(MouseEvent event){
		  int x = event.getX();
		  int y = event.getY();
		  	  
		 System.out.println(String.format("Clicked at %d , %d ",x,y));
		  if (boutonRectangle.isEnabled()==true)
		  {
			  System.out.println("Add point rectangle");
			  boutonRectangle.addPoint(x, y);
			  panel.repaint();
		  }
		  else if (boutonTriangle.isEnabled()==true)
		  {
			  System.out.println("Add point triangle");
			  boutonTriangle.addPoint(x, y);
			  panel.repaint();
		  }
		  else if (boutonCercle.isEnabled()==true)
		  {
			  System.out.println("Add point cercle");
			  boutonCercle.addPoint(x, y);
			  panel.repaint();
		  }
	  }
	  
	  public void mousePressed(MouseEvent event){
		  fenetre.setTitle("press down the mouse");
	  }
	  
	  public void mouseReleased(MouseEvent event){
		  fenetre.setTitle("press released the mouse");
	  }
	  
	  public void mouseEntered(MouseEvent event){
		  fenetre.setTitle("Enter arena");
	  }
	  
	  public void mouseExited(MouseEvent event){
		  fenetre.setTitle("exit arena");
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
	    System.out.println("Je suis executee !");
	    boutonRectangle.draw(g);
	    boutonTriangle.draw(g);
	    boutonCercle.draw(g);
	  }               
	}

}
