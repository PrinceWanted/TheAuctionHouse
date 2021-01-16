package theauctionhouse;

import theauctionhouse.Controller.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIserver {


    public static void main(String[] args) throws RemoteException {

        DB database = new DB();


        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            //Bidder
            BidderInterface Binterface = new Bidder();
            reg.bind("Binterface", Binterface);

            //Moderator
            ModeratorInterface modIterface = Moderator.getInstance();
            reg.bind("ModInterface", modIterface);

            //seller
            SellerInterface Sellerinterface = new Seller();
            reg.bind("Sellerinterface", Sellerinterface);
            System.out.println("Server is ready!!");

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
