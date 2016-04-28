import java.rmi.*;

public interface Service extends Remote
{
	public String getInformation() throws RemoteException;
}
