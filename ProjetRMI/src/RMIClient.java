import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
 
public class RMIClient {
	
public static void main(String[] args) {
System.out.println("Lancement du client");
if (System.getSecurityManager() == null) {
System.setSecurityManager(new RMISecurityManager());
}
try {
Remote r = Naming.lookup("rmi://"+ InetAddress.getLocalHost().getHostAddress() + "/ProjetRMI");
System.out.println(r);
if (r instanceof Service) {
String s = ((Service) r).getInformation();
System.out.println("chaine renvoyee = " + s);
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
System.out.println("Fin du client");
}
}