package theauctionhouse;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIserver {


    public static void main(String[] args) throws RemoteException {


        Seller s = new Seller(1350);
        Seller plsWork = new Seller(1,"hassan","pass","mail",32,"Male","hamada street",011232321,50);
        DB database = new DB();
        database.insertSeller(plsWork);


        try {

            //Bidder
            BidderInterface Binterface = new Bidder();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.bind("Binterface", Binterface);
            System.out.println("Bidder server is ready!!");


            //Moderator
            ModeratorInterface modIterface = Moderator.getInstance();

            reg.bind("ModInterface", modIterface);
            System.out.println(" Moderator server is ready!!");

            //seller
            SellerInterface Sellerinterface = plsWork;

            reg.bind("Sellerinterface", Sellerinterface);
            System.out.println("Seller server is ready!!");


        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
