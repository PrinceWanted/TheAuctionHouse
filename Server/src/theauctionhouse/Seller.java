package theauctionhouse;

import theauctionhouse.Controller.SellerInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.util.ArrayList;

public class Seller extends User implements SellerInterface, Serializable {

    private float balance;
    private ArrayList<Product> postedProducts;


    public Seller() throws RemoteException {
    }

    public Seller(int i, String hassan, String pass, String mail, int i1, String male, String hamada_street, int i2, int i3) throws RemoteException {
    }

    public Seller(float balance) throws RemoteException {
        this.balance = balance;

    }

    public Seller(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, String type, float balance) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber, type);
        this.balance = balance;
        postedProducts = new ArrayList<Product>();
    }

    public Seller(int port) throws RemoteException {
        super(port);
    }

    public Seller(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    public Seller(float balance, ArrayList<Product> postedProducts) throws RemoteException {
        this.balance = balance;
        this.postedProducts = postedProducts;

    }

    public Seller(int uID, String uname, String upass, String umail, int uage, String gender, String uaddress, int unumber, String type, float balance, ArrayList<Product> postedProducts) throws RemoteException {
        super(uID, uname, upass, umail, uage, gender, uaddress, unumber, type);
        this.balance = balance;
        this.postedProducts = postedProducts;

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
        DB db = new DB();
        db.insertProduct(r);
    }

    @Override
    public int login(String name, String pass) throws RemoteException {

        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getuID();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

    @Override
    public String loginUname(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getUname();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public String loginUpass(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getUpass();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public String loginUmail(String name, String pass) throws RemoteException {

        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getUmail();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;

    }

    @Override
    public int loginUage(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getUage();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

    @Override
    public String loginUgender(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getGender();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public String loginUaddress(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getUaddress();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public int loginUnumber(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getUnumber();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

    @Override
    public float loginBlanace(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Seller> allseller = db.retrieveAllSeller();

        for (Seller seller : allseller) {

            if (seller.getUname().equals(name) && seller.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(seller.getUname());
                return seller.getBalance();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }


}
