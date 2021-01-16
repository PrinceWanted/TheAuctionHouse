
package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;


public class Bidder extends User implements Serializable {

    private int balance;


    public Bidder() throws RemoteException {
    }

    public Bidder(int balance) throws RemoteException {
        this.balance = balance;
    }

    public Bidder(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, String type, int balance) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber, type);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
