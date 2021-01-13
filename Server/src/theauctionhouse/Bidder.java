
package theauctionhouse;


import java.rmi.RemoteException;

public class Bidder extends User implements BidderInterface {
    public int balance;

    public Bidder() throws RemoteException {
    }

    public Bidder(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber) throws RemoteException{
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber);
    }

    public Bidder(int balance) throws RemoteException {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public void bid(int bidprice, BidSession bs)throws RemoteException {
    }
    @Override
    public void regToRoom(BidSession bs) throws RemoteException{
    }
    @Override
    public void viewProductList() throws RemoteException{
    }


}
