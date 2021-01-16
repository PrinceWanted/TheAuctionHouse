
package theauctionhouse;

import theauctionhouse.Controller.ModeratorInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Moderator extends User implements ModeratorInterface, Serializable {
    private static Moderator instance;
    private ArrayList<Product> pendingProducts = new ArrayList<Product>();


    private Moderator() throws RemoteException {
        pendingProducts = new ArrayList<Product>();
    }

    public ArrayList<Product> getPendingProducts() {
        return pendingProducts;
    }

    public static Moderator getInstance() throws RemoteException {
        if (instance == null) {
            instance = new Moderator();
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
    public int login(String name, String pass) throws RemoteException {
        if (name.equals(this.getUname()) && pass.equals(this.getUpass())) {

            return this.getuID();
        } else
            System.err.println("Wrong Credentials");
        return 0;
    }
}
