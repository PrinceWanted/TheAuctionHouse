package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Seller extends User implements SellerInterface, Serializable {

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

    @Override
    public SellerDTO getDTO() throws RemoteException {
        SellerDTO a = new SellerDTO(super.getuID(), super.getUname(), super.getUpass(), super.getUmail(), super.getUage(), super.getGender(), super.getUaddress(), super.getUnumber(), getBalance(), postedProducts);
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

    @Override
    public void postProduct(Product r) throws RemoteException {
        Moderator.getInstance().getPendingProducts().add(r);
        this.getPostedProducts().add(r);
    }


    @Override
    public Seller login(String name, String pass) throws RemoteException {

        DB db= new DB();
        ArrayList<Seller> allseller= db.retrieveAllSeller();
        for (Seller seller : allseller) {
            System.out.println(seller.getUname());
            if (seller.getUname().equals(name)  && seller.getUpass().equals(pass) ) {
                System.out.println("Logged in!");
                return seller;
            }
            else {
                System.err.println("Wrong Credentials.");
            }
        }
  return null;
    }
}
