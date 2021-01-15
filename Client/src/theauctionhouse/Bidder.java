
package theauctionhouse;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Bidder extends User implements Serializable {
    private ArrayList<Bidder> BidderList;
    private int balance;


    public Bidder() throws RemoteException {
    }

    public Bidder(int balance) throws RemoteException {
        this.balance = balance;
    }

    public Bidder(ArrayList<Bidder> bidderList, int balance) throws RemoteException {
        BidderList = bidderList;
        this.balance = balance;
    }

    public Bidder(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, String type, ArrayList<Bidder> bidderList, int balance) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber, type);
        BidderList = bidderList;
        this.balance = balance;
    }

    public ArrayList<Bidder> getBidderList() {
        return BidderList;
    }

    public void setBidderList(ArrayList<Bidder> bidderList) {
        BidderList = bidderList;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



}
