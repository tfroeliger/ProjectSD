import java.awt.Point;
import java.rmi.*;

public interface Service extends Remote
{
	public String getInformation() throws RemoteException;
	public Point getClick(Point P) throws RemoteException;
}
