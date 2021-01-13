package theauctionhouse;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) throws RemoteException {

        try {

           // BidSession b=new BidSession();

            Registry registry = LocateRegistry.getRegistry(1099);
            BidderInterface BidInterface = (BidderInterface)registry.lookup("Binterface");


//                BidInterface.regToRoom(b);



        } catch (Exception e){

            System.err.println("Exception occurred");
        }


    }


}
