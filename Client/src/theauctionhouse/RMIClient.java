package theauctionhouse;

import theauctionhouse.Controller.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;


public class RMIClient {

    public static void main(String[] args) throws RemoteException {

//        ArrayList<Seller> allSellersRetriever;
//        ArrayList<Bidder> allBiddersRetriever;
//        Moderator Mod;
        int CurrentUserID;

        try {

            Registry registry = LocateRegistry.getRegistry(1099);
            SellerInterface seller = (SellerInterface) registry.lookup("Sellerinterface");
            //BidderInterface bidder = (BidderInterface) registry.lookup("Binterface");

            CurrentUserID = seller.login("1", "1");
            //CurrentUserID = bidder.login("Mahmoud", "pass");
            System.out.println(CurrentUserID);

//            allSellersRetriever = seller.getAllsellers();
//
//
//            Seller CurrentSeller = null;
//            for (Seller sel : allSellersRetriever) {
//                if (sel.getuID() == CurrentUserID) {
//                    CurrentSeller = sel;
//                }
//            }
//            if (CurrentSeller == null) {
//                System.err.println("Client login Error!");
//            }


        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println(e);
        }


    }


}
