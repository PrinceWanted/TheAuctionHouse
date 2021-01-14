
package theauctionhouse;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Moderator extends User implements Serializable {
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


}
