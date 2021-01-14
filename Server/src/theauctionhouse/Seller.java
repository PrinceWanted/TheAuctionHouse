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

    @Override
    public SellerDTO getDTO() throws RemoteException {
        SellerDTO a = new SellerDTO(super.getuID(), super.getUname(), super.getUpass(), super.getUmail() ,super.getUage() ,super.getGender() ,super.getUaddress() ,super.getUnumber(),getBalance(),postedProducts);
        return a;
    }

    @Override
    public void returnDTO(SellerDTO d) throws RemoteException {
        super.setuID(d.getID());
        super.setUname(d.getName());
        super.setUpass(d.getPass());
        super.setUmail(d.getMail());
        super.setUage(d.getAge());
        super.setGender(d.getGender());
        super.setUaddress(d.getAddress());
        super.setUnumber(d.getNumber());
        setBalance(d.getBalance());
        setPostedProducts(d.getPostedProducts());
    }
}
