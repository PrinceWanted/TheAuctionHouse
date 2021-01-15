package theauctionhouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ModeratorInterface extends Remote,UserInterface {

    public void RemoveProduct(BidSession bs) throws RemoteException;
}
