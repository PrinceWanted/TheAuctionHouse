package theauctionhouse.Controller;


import theauctionhouse.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SellerInterface extends Remote {

    public SellerDTO getDTO() throws RemoteException;

    public void returnDTO(SellerDTO d) throws RemoteException;

    public void postProduct(Product r) throws RemoteException;

    public int login(String name, String pass) throws RemoteException;

    public ArrayList<Seller> getAllsellers()throws RemoteException;
}
