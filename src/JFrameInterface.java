import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.rmi.*;
import java.awt.*;

// interface de MyJFrame

public interface JFrameInterface extends Remote {
	
	 //public void initFrame() throws RemoteException, AWTException;
	 //public void ajoutBouton() throws RemoteException;
	 //public void actionPerformed(ActionEvent arg0) throws RemoteException;
	// public void mouseClicked(MouseEvent event) throws RemoteException;
	 //public void paintComponent(Graphics g) throws RemoteException;
	 public void mouseClicked(MouseEvent event);
	 
	 

}
