import java.net.InetAddress;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {

public static void main(String[] args) throws AWTException {
try {
LocateRegistry.createRegistry(1099);
//MyJFrame fenetre = new MyJFrame();
//fenetre.initFrame();
System.out.println("Mise en place du Security Manager ...");
if (System.getSecurityManager() == null) {
System.setSecurityManager(new RMISecurityManager());
}

RMIServer rmiserver = new RMIServer();

String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ProjetRMI";
System.out.println("Enregistrement de l'objet avec l'url : " + url);
Naming.rebind(url, rmiserver);
 
System.out.println("Serveur lancé");
} catch (RemoteException e) {
e.printStackTrace();
} catch (MalformedURLException e) {
e.printStackTrace();
} catch (UnknownHostException e) {
e.printStackTrace();
}
}
}