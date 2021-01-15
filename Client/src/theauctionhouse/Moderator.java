
package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Moderator extends User implements  Serializable {
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


}
