package theauctionhouse;

import theauctionhouse.Controller.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;


public class RMIClient {

    public static void main(String[] args) throws RemoteException {


      //  Moderator Mod= Moderator.getInstance();
        int CurrentUserID;
        int userType;
        String username, password;


        Scanner sc = new Scanner(System.in);

        try {


            System.out.println("Username:");
            username = sc.nextLine();
            System.out.println("password:");
            password = sc.nextLine();

            System.out.println("Please insert user type :");
            System.out.println("1-seller 2-Bidder 3-Moderator");
            userType = sc.nextInt();


            Registry registry = LocateRegistry.getRegistry(1099);


            switch (userType) {

                case 1:
                    SellerInterface seller = (SellerInterface) registry.lookup("Sellerinterface");

                    CurrentUserID = seller.login(username, password);
                    //CurrentUserID = bidder.login("Mahmoud", "pass");
                    //System.out.println(CurrentUserID);

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
                        S.setBalance(seller.loginBlanace(username, password));

                    }
                    System.out.println(S.getUname());
                    System.out.println(S.getGender());
                    System.out.println(S.getuID());
                    System.out.println(S.getUpass());

                    break;
                case 2:
                    BidderInterface bidder = (BidderInterface) registry.lookup("Binterface");

                    CurrentUserID = bidder.login(username, password);
                    Bidder B = new Bidder();
                    if (CurrentUserID != 0) {


                        //cant send a whole user due to proxy error
                        // so sending user data one by one
                        B.setuID(bidder.login(username, password));
                        B.setUname(bidder.loginUname(username, password));
                        B.setUpass(bidder.loginUpass(username, password));
                        B.setGender(bidder.loginUgender(username, password));
                        B.setUpass(bidder.loginUpass(username, password));
                        B.setUname(bidder.loginUname(username, password));
                        B.setUpass(bidder.loginUpass(username, password));
                        B.setUmail(bidder.loginUmail(username, password));
                        B.setUage(bidder.loginUage(username, password));
                        B.setUaddress(bidder.loginUaddress(username, password));
                        B.setUnumber(bidder.loginUnumber(username, password));
                        B.setBalance(bidder.loginBlanace(username, password));


                    }
                    System.out.println(B.getUname());
                    System.out.println(B.getGender());
                    System.out.println(B.getuID());
                    System.out.println(B.getUpass());
                    break;
                case 3:

                    System.out.println("HI im case 3");
                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

}
