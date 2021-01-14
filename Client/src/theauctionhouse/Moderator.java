
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
    public void RemoveProduct(BidSession bs, int ProductID) throws RemoteException {

        for (BiddingRoom room : bs.getRoomList()) {

            if (room.getBiddingProd().getID() == ProductID) {
                bs.getRoomList().remove(room);
            }else System.out.println("Product not found.");

        }

    }
}
