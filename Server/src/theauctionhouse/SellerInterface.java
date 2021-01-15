package theauctionhouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SellerInterface extends Remote {


    public SellerDTO getDTO() throws RemoteException;

    public void returnDTO(SellerDTO d) throws RemoteException;

    public void postProduct(Product r) throws RemoteException;
    public Seller login(String name, String pass) throws RemoteException;
}
