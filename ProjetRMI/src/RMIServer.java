import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RMISecurityManager;


public class RMIServer extends UnicastRemoteObject implements Service {

	private static final long serialVersionUID = 2674880711467464646L;
	protected RMIServer() throws RemoteException{
		super();
	}
	public String getInformation() throws RemoteException {
		System.out.println("Invocation de la méthode getInformation()");
		return "bonjour";
	}
}
