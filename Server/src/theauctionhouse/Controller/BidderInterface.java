package theauctionhouse.Controller;

import theauctionhouse.*;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BidderInterface extends Remote {

    public String getName() throws RemoteException;

    public void bid(int bidprice, BidSession bs) throws RemoteException;

    public void regToRoom(BidSession bs) throws RemoteException;

    public void viewProductList() throws RemoteException;

    public int login(String name, String pass) throws RemoteException;

    public String loginUname(String name, String pass) throws RemoteException;

    public String loginUpass(String name, String pass) throws RemoteException;

    public String loginUmail(String name, String pass) throws RemoteException;

    public int loginUage(String name, String pass) throws RemoteException;

    public String loginUgender(String name, String pass) throws RemoteException;

    public String loginUaddress(String name, String pass) throws RemoteException;

    public int loginUnumber(String name, String pass) throws RemoteException;

    public int loginBlanace(String name, String pass) throws RemoteException;


}
