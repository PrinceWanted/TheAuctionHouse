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
            System.out.println("Bidder server is ready!!");

            //Moderator
            ModeratorInterface modIterface = Moderator.getInstance();
            reg.bind("ModInterface", modIterface);
            System.out.println(" Moderator server is ready!!");

            //seller
            SellerInterface Sellerinterface = new Seller();
            reg.bind("Sellerinterface", Sellerinterface);
            System.out.println("Seller server is ready!!");

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
