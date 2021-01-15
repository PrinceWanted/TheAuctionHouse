
package theauctionhouse;

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
    public void RemoveProduct(BidSession bs) throws RemoteException {

        if (bs.getAvailable())
            bs.setAvailable(false);
        else System.out.println("Product is not available");

    }

    @Override
    public Moderator login(String name, String pass) throws RemoteException {
        if (name == this.getUname() && pass == this.getUpass()) {

            return this;
        } else
            System.err.println("Wrong Credentials");
        return null;
    }
}
