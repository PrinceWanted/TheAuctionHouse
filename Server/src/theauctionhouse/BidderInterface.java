package theauctionhouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BidderInterface extends Remote {

    public void bid(int bidprice, BidSession bs) throws RemoteException;
    public void regToRoom(BidSession bs) throws RemoteException;
    public void viewProductList() throws RemoteException;

}
