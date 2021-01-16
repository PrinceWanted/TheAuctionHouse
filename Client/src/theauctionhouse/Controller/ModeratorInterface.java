package theauctionhouse.Controller;

import theauctionhouse.*;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ModeratorInterface extends Remote {

    public String getName() throws RemoteException;

    public void RemoveProduct(int bs) throws RemoteException;

    public void BanSeller(String mail) throws RemoteException;

    public void BanBidder(String mail) throws RemoteException;

    public int login(String name, String pass) throws RemoteException;

    public String loginUname(String name, String pass) throws RemoteException;

    public String loginUpass(String name, String pass) throws RemoteException;

    public String loginUmail(String name, String pass) throws RemoteException;

    public int loginUage(String name, String pass) throws RemoteException;

    public String loginUgender(String name, String pass) throws RemoteException;

    public String loginUaddress(String name, String pass) throws RemoteException;

    public int loginUnumber(String name, String pass) throws RemoteException;


}
