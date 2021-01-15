package theauctionhouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserInterface extends Remote {

    public User login (String name,String pass) throws RemoteException;


}
