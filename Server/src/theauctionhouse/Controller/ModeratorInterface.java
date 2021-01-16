package theauctionhouse.Controller;

import theauctionhouse.*;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ModeratorInterface extends Remote {

    public String getName() throws RemoteException;

    public void RemoveProduct(BidSession bs) throws RemoteException;

    public int login(String name, String pass) throws RemoteException;
}
