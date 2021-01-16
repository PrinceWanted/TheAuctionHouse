package theauctionhouse;

import theauctionhouse.Controller.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;


public class RMIClient {

    public static void main(String[] args) throws RemoteException {


        Moderator Mod;
        int CurrentUserID;

        String username, password;

        Scanner sc = new Scanner(System.in);

        try {


            System.out.println("Username:");
            username = sc.nextLine();
            System.out.println("password:");
            password = sc.nextLine();
            Registry registry = LocateRegistry.getRegistry(1099);
            SellerInterface seller = (SellerInterface) registry.lookup("Sellerinterface");
            //BidderInterface bidder = (BidderInterface) registry.lookup("Binterface");


            CurrentUserID = seller.login("1", "1");
            //CurrentUserID = bidder.login("Mahmoud", "pass");
            System.out.println(CurrentUserID);

            Seller S = new Seller();
            if (CurrentUserID != 0) {
                //cant send a whole user due to proxy error
                // so sending user data one by one
                S.setuID(seller.login(username, password));
                S.setUname(seller.loginUname(username, password));
                S.setUpass(seller.loginUpass(username, password));
                S.setGender(seller.loginUgender(username, password));
                S.setUpass(seller.loginUpass(username, password));
                S.setUname(seller.loginUname(username, password));
                S.setUpass(seller.loginUpass(username, password));
                S.setUmail(seller.loginUmail(username, password));
                S.setUage(seller.loginUage(username, password));
                S.setUaddress(seller.loginUaddress(username, password));
                S.setUnumber(seller.loginUnumber(username, password));
                S.setBalance(seller.loginBlanace(username,password));
            }

            System.out.println(S.getUname());
            System.out.println(S.getGender());
            System.out.println(S.getuID());
            System.out.println(S.getUpass());

/*
            Seller CurrentSeller = null;
            for (Seller sel : allSellersRetriever) {
                if (sel.getuID() == CurrentUserID) {
                    CurrentSeller.setUname(sel.getUname());
                }
            }
            if (CurrentSeller == null) {
                System.err.println("Client login Error!");
            }
            System.out.println(CurrentSeller.getUname());

*/
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }


}
