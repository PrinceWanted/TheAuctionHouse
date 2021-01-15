package theauctionhouse;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {

    public static void main(String[] args) throws RemoteException {


        try {
            String username, password, type;

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your Credentials");


            System.out.print("User type:");
            type = sc.nextLine();

            System.out.print("Username:");
            username = sc.nextLine();

            System.out.print("Password:");
            password = sc.nextLine();

            Registry registry = LocateRegistry.getRegistry(1099);
            SellerInterface s = (SellerInterface) registry.lookup("Sellerinterface");


           //Seller B= new Seller();
         //   B= s.login(username,password);

        //    System.out.println(B.getUname());

            System.out.println(s.login(username,password).getUname());

            switch (type) {

                case "Bidder":


                     registry = LocateRegistry.getRegistry(1099);
                    BidderInterface BidInterface = (BidderInterface) registry.lookup("Binterface");


                    /*
                   Bidder B = new Bidder();

                   B =  BidInterface.login("ahmed","pass");

                    System.out.println(B.getUname());
                   // BidInterface = BidInterface.login(username,password);

                    //BidInterface =B;

/*
                    BidSession b = new BidSession();
                    BidderInterface BidInterface = (BidderInterface) registry.lookup("Binterface");


                    BidInterface.regToRoom(b);

*/

                case "Seller":


                case "Moderator":

            }


/*
            SellerInterface seller = (SellerInterface) registry.lookup("Sellerinterface");
            SellerDTO sellertest = seller.getDTO();
            System.out.println(sellertest.getName());
            System.out.println(sellertest.getPass());
            System.out.println(sellertest.getAge());
            System.out.println(sellertest.getGender() +"\n");

            seller.postProduct(new Product(1,"some product","This is a good product",5000));


            sellertest.setName("Another Name");
            sellertest.getPostedProducts().add(new Product(1,"some product","This is a good product",5000));
            seller.returnDTO(sellertest);
            System.out.println("Testing the data from server after updating it from client \n");
            SellerDTO dsd = seller.getDTO();
            System.out.println(dsd.getName());
            System.out.println(dsd.getPostedProducts().get(0).getName());
*/




        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }


}
