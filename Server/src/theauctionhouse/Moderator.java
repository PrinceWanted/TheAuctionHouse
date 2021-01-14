
package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Moderator extends User implements ModeratorInterface, Serializable {
    private static Moderator instance;
    ArrayList<String> pendingProducts = new ArrayList<String>();

    private Moderator() throws RemoteException {

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
}
