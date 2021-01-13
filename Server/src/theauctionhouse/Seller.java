package theauctionhouse;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Seller extends User implements SellerInterface {

    private float balance;
    private ArrayList<Product> postedProducts;

    public Seller() throws RemoteException {
    }

    public Seller(float balance) throws RemoteException {
        this.balance = balance;

    }

    public Seller(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, float balance, ArrayList<Product> postedProducts) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber);
        this.balance = balance;
        this.postedProducts = postedProducts;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public SellerDTO getDTO() throws RemoteException {
        return null;
    }

    @Override
    public void returnDTO(SellerDTO d) throws RemoteException {

    }
}
