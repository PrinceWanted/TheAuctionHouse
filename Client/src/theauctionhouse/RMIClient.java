package theauctionhouse;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) throws RemoteException {

        try {

            Registry registry = LocateRegistry.getRegistry(1099);
            BidderInterface BidInterface = (BidderInterface)registry.lookup("Binterface");
            System.out.println(BidInterface.add(68,1));



        } catch (Exception e){

            System.err.println("Exception occurred");
        }


    }


}
