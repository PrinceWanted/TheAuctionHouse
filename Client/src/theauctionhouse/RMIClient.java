package theauctionhouse;

import theauctionhouse.Controller.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;


public class RMIClient {

    public static void main(String[] args) throws RemoteException {

        ArrayList<Seller> allSellersRetriever;
        ArrayList<Bidder> allBiddersRetriever;
        Moderator Mod;

        int CurrentUserID;

        try {

            Registry registry = LocateRegistry.getRegistry(1099);
            SellerInterface seller = (SellerInterface) registry.lookup("Sellerinterface");



            CurrentUserID = seller.login("1", "1");
            System.out.println(CurrentUserID);





          //  allSellersRetriever = Seller.





        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }


}
