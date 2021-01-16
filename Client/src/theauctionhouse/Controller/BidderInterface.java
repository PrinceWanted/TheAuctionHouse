package theauctionhouse.Controller;

import theauctionhouse.BidSession;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BidderInterface extends Remote {

    public String getName() throws RemoteException;

    public void bid(int bidprice, BidSession bs) throws RemoteException;

    public void regToRoom(BidSession bs) throws RemoteException;

    public void viewProductList() throws RemoteException;

    public int login(String name, String pass) throws RemoteException;

}
