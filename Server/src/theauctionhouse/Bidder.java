
package theauctionhouse;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Bidder extends User implements BidderInterface, Serializable {
    public int balance;

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


    @Override
    public void bid(int bidprice, BidSession bs) throws RemoteException {

        if (bs.getRoom().getHighestPrice() < bidprice) {
            bs.getRoom().setHighestPrice(bidprice);
            bs.getRoom().setHighestBidder(this);
        } else System.out.println("Bid price is too low.");

    }

    @Override
    public void regToRoom(BidSession bs) throws RemoteException {
        bs.getBiddersList().add(this);
    }

    @Override
    public void viewProductList() throws RemoteException {

        //insert database function? -on it!
        DB db = new DB();
        ArrayList<Product> products = db.getALlProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString()); //print for now cause pre-GUI and testing purposes
        }
    }


}
