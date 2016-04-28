import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 

import javax.imageio.ImageIO;
import javax.swing.JButton;
  
@SuppressWarnings("serial")
public class BoutonTriangle extends JButton implements MouseListener{
  private int clicCount;
  private Polygon[] polyTab = new Polygon[5];
  private int triangleCount;

  public BoutonTriangle(String str){
    super(str);
    this.clicCount = 0;
    this.triangleCount = 0;
    int i;
    for(i=0;i<5;i++)
    {
    	polyTab[i] = new Polygon();
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
		if (triangleCount<5)
		{
		if (clicCount==0)
		{
			polyTab[triangleCount].addPoint(x,y);
			clicCount++;
		}
		else if (clicCount==1)
		{
			polyTab[triangleCount].addPoint(x,y);
			clicCount++;
		}
		else if (clicCount==2)
		{
			polyTab[triangleCount].addPoint(x,y);
			clicCount=0;
			triangleCount++;
		}
	}
	}
  public void draw(Graphics g){
		if (triangleCount>0)
		{
		int i =0;
		for (i=0;i<triangleCount;i++)
		{
		g.drawPolygon(polyTab[i]);
		}
	}
	}
}