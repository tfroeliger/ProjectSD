package sdproject;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 

import javax.imageio.ImageIO;
import javax.swing.JButton;
  
@SuppressWarnings("serial")
public class BoutonCercle extends JButton implements MouseListener{
  private String name;
  private int clicCount;
  private int cercleCount;
  private int size;
  private Point[] cercleTab = new Point[5];

  public BoutonCercle(String str){
    super(str);
    this.name = str;
    this.clicCount = 0;
    this.size = 100;
    int i;
    for(i=0;i<5;i++)
    {
    	cercleTab[i] = new Point();
    }
    
    
    this.setEnabled(false);
    this.addMouseListener(this);
  }

  public void mouseClicked(MouseEvent event) {
    //Inutile d'utiliser cette méthode ici
	  this.setEnabled(true);
  }

  public void mouseEntered(MouseEvent event) {

  }

  public void mouseExited(MouseEvent event) {
  }

  public void mousePressed(MouseEvent event) {

  }
 
  public void mouseReleased(MouseEvent event) {
     
}
  
  public void addPoint(int x,int y){
		if (cercleCount<5)
		{
			cercleTab[cercleCount].x = x;
			cercleTab[cercleCount].y = y;
			cercleCount++;

	}
  }
public void draw(Graphics g){
			if (cercleCount>0)
			{
			int i =0;
			for (i=0;i<cercleCount;i++)
			{
			g.drawOval(cercleTab[i].x-size, cercleTab[i].y-size,size*2,size*2);
			}
			}
}
}
		