package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Seller extends User implements Serializable {

    private float balance;
    private ArrayList<Product> postedProducts;

    public Seller() throws RemoteException {
    }

    public Seller(float balance) throws RemoteException {
        this.balance = balance;

    }

    public Seller(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, float balance) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber);
        this.balance = balance;
        postedProducts = new ArrayList<Product>();
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public ArrayList<Product> getPostedProducts() {
        return postedProducts;
    }

    public void setPostedProducts(ArrayList<Product> postedProducts) {
        this.postedProducts = postedProducts;
    }


}
