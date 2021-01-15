package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Seller extends User implements  Serializable {

    private float balance;
    private ArrayList<Product> postedProducts;
    private ArrayList<Seller> SellerList;

    public Seller(int i, String hassan, String pass, String mail, int i1, String male, String hamada_street, int i2, int i3) throws RemoteException {
    }

    public Seller(float balance) throws RemoteException {
        this.balance = balance;

    }


    public Seller(float balance, ArrayList<Product> postedProducts, ArrayList<Seller> sellerList) throws RemoteException {
        this.balance = balance;
        this.postedProducts = postedProducts;
        SellerList = sellerList;
    }

    public Seller(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, String type, float balance, ArrayList<Product> postedProducts, ArrayList<Seller> sellerList) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber, type);
        this.balance = balance;
        this.postedProducts = postedProducts;
        SellerList = sellerList;
    }

    public ArrayList<Seller> getSellerList() {
        return SellerList;
    }

    public void setSellerList(ArrayList<Seller> sellerList) {
        SellerList = sellerList;
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
