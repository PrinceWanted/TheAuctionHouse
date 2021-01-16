package theauctionhouse.Controller;


import theauctionhouse.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SellerInterface extends Remote {

    public SellerDTO getDTO() throws RemoteException;

    public void returnDTO(SellerDTO d) throws RemoteException;

    public void postProduct(Product r) throws RemoteException;
    public ArrayList<Product> getPostedProducts() throws RemoteException;

    public int login(String name, String pass) throws RemoteException;

    public String loginUname(String name, String pass) throws RemoteException;

    public String loginUpass(String name, String pass) throws RemoteException;

    public String loginUmail(String name, String pass) throws RemoteException;

    public int loginUage(String name, String pass) throws RemoteException;

    public String loginUgender(String name, String pass) throws RemoteException;

    public String loginUaddress(String name, String pass) throws RemoteException;

    public int loginUnumber(String name, String pass) throws RemoteException;

    public float loginBlanace(String name, String pass) throws RemoteException;

}
