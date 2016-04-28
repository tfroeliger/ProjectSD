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
public class BoutonRectangle extends JButton implements MouseListener{
  private int clicCount;
  private Rectangle[] rectangleTab = new Rectangle[5];
  private int rectangleCount;

  public BoutonRectangle(String str){
    super(str);
    this.clicCount = 0;
    this.rectangleCount = 0;
    this.rectangleTab = new Rectangle[5];
    int i = 0;
    for (i=0;i<5;i++)
    {
    	rectangleTab[i] = new Rectangle();
    }
    this.setEnabled(false);
    this.addMouseListener(this);
  }

  public void mouseClicked(MouseEvent event) {
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
	if (rectangleCount<5)
	{
	if (clicCount==0)
	{
		rectangleTab[rectangleCount] = new Rectangle(new Point(x,y));
		clicCount++;
	}
	else if (clicCount==1)
	{
		rectangleTab[rectangleCount].add(new Point (x,y));
		clicCount = 0;
		rectangleCount++;
	}
}
}
  
public void draw(Graphics g){
	if (rectangleCount>0)
	{
	int i =0;
	for (i=0;i<rectangleCount;i++)
	{
	g.drawRect(rectangleTab[i].x, rectangleTab[i].y, rectangleTab[i].width, rectangleTab[i].height);
	}
}
}
}