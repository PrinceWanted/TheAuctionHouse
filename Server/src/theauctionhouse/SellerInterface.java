package theauctionhouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SellerInterface extends Remote {
    public int getuID()  throws RemoteException;

    public void setID(int uID)  throws RemoteException;

    public String getName()  throws RemoteException;

    public void setName(String uname)  throws RemoteException;

    public String getPass()  throws RemoteException;

    public void setPass(String upass)  throws RemoteException;

    public String getEmail()  throws RemoteException;

    public void setEmail(String umail)  throws RemoteException;

    public int getAge()  throws RemoteException;

    public void setAge(int uage)  throws RemoteException;

    public String getGender()  throws RemoteException;

    public void setGender(String gender)  throws RemoteException;

    public String getAddress()  throws RemoteException;

    public void setAddress(String uaddress)  throws RemoteException;

    public int getNumber()  throws RemoteException;

    public void setUnumber(int unumber)  throws RemoteException;

    public SellerDTO getDTO() throws RemoteException;

    public void returnDTO(SellerDTO d) throws RemoteException;
}
