
package theauctionhouse;

import theauctionhouse.Controller.BidderInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Bidder extends User implements BidderInterface, Serializable {

    private int balance;

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
    public String getName() throws RemoteException {
        return this.getUname();
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
    public String viewProductList() throws RemoteException {

        //insert database function? -on it!
        DB db = new DB();
        String list = "";
        ArrayList<Product> products = db.getALlProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString()); //print for now cause pre-GUI and testing purposes
            list += products.get(i).toString();
        }
        return list;
    }


    @Override
    public int login(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getuID();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

    @Override
    public String loginUname(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getUname();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public String loginUpass(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getUpass();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public String loginUmail(String name, String pass) throws RemoteException {

        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getUmail();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;

    }

    @Override
    public int loginUage(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getUage();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

    @Override
    public String loginUgender(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();
        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getGender();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public String loginUaddress(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getUaddress();
            } else
                System.err.println("Wrong Credentials.");
        }

        return null;
    }

    @Override
    public int loginUnumber(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getUnumber();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

    @Override
    public int loginBlanace(String name, String pass) throws RemoteException {
        DB db = new DB();
        ArrayList<Bidder> allBidders = db.retrieveAllBidders();

        for (Bidder bidder : allBidders) {

            if (bidder.getUname().equals(name) && bidder.getUpass().equals(pass)) {
                System.out.println("Logged in!");
                System.out.println(bidder.getUname());
                return bidder.getBalance();
            } else
                System.err.println("Wrong Credentials.");
        }

        return 0;
    }

}
