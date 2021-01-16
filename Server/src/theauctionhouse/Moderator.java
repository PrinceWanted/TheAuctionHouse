
package theauctionhouse;

import theauctionhouse.Controller.ModeratorInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Moderator extends User implements ModeratorInterface, Serializable {
    private static Moderator instance;
    private ArrayList<Product> pendingProducts = new ArrayList<Product>();


    private Moderator(String name,String pass) throws RemoteException {
        this.setUname(name);
        this.setUpass(pass);
        pendingProducts = new ArrayList<Product>();
    }

    public ArrayList<Product> getPendingProducts() {
        return pendingProducts;
    }

    public static Moderator getInstance() throws RemoteException {
        if (instance == null) {
            instance = new Moderator("Ameer","123");
        }
        return instance;
    }

    @Override
    public String getName() throws RemoteException {
        return this.getUname();
    }

    @Override
    public void RemoveProduct(BidSession bs) throws RemoteException {

        if (bs.getAvailable())
            bs.setAvailable(false);
        else System.out.println("Product is not available");

    }

    @Override
    public void BanSeller(String mail) throws RemoteException {

        DB db = new DB();
        db.BanSeller(mail);
    }

    @Override
    public void BanBidder(String mail) throws RemoteException {

        DB db = new DB();
        db.BanBidder(mail);
    }

    @Override
    public int login(String name, String pass) throws RemoteException {
        if (name.equals(this.getUname()) && pass.equals(this.getUpass())) {

            return this.getuID();
        } else
            System.err.println("Wrong Credentials");
        return 0;
    }

    @Override
    public String loginUname(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getUname();
        } else
            System.err.println("Wrong Credentials.");
        return null;
    }

    @Override
    public String loginUpass(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getUpass();
        } else
            System.err.println("Wrong Credentials.");
        return null;
    }

    @Override
    public String loginUmail(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getUmail();
        } else
            System.err.println("Wrong Credentials.");
        return null;
    }

    @Override
    public int loginUage(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getUage();
        } else
            System.err.println("Wrong Credentials.");

        return 0;
    }

    @Override
    public String loginUgender(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getGender();
        } else
            System.err.println("Wrong Credentials.");
        return null;
    }

    @Override
    public String loginUaddress(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getUaddress();
        } else
            System.err.println("Wrong Credentials.");
        return null;
    }

    @Override
    public int loginUnumber(String name, String pass) throws RemoteException {
        DB db = new DB();
        db.retrieveModerator();

        if (db.retrieveModerator().getUname().equals(name) && db.retrieveModerator().getUpass().equals(pass)) {
            System.out.println("Logged in!");
            return db.retrieveModerator().getUnumber();
        } else
            System.err.println("Wrong Credentials.");
        return 0;
    }

}
