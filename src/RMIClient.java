import java.net.InetAddress;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.rmi.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
 
public class RMIClient {
	
public static void main(String[] args) throws AWTException, RemoteException{
System.out.println("Lancement du client");
MyJFrame fenetre = new MyJFrame();
fenetre.initFrame();
Point monpoint = fenetre.P;

//if (System.getSecurityManager() == null) {
//System.setSecurityManager(new RMISecurityManager());
//}
try {
Remote r = Naming.lookup("rmi://"+ InetAddress.getLocalHost().getHostAddress() + "/ProjetRMI");
System.out.println(r);
if (r instanceof RMIServer) {
	((RMIServer) r).getClick(monpoint);
	//handler = new Handlerclass();
//((JFrameInterface) r).mouseClicked();
}
} catch (MalformedURLException e) {
e.printStackTrace();
} catch (RemoteException e) {
e.printStackTrace();
} catch (NotBoundException e) {
e.printStackTrace();
}
catch (UnknownHostException e) {
e.printStackTrace();
}
/*catch (AWTException e) {
e.printStackTrace();
}*/
System.out.println("Fin du client");
}
}