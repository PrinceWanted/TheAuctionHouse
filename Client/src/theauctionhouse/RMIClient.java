package theauctionhouse;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) throws RemoteException {

        try {

           // BidSession b=new BidSession();

            Registry registry = LocateRegistry.getRegistry(1099);
            //BidderInterface BidInterface = (BidderInterface)registry.lookup("Binterface");
            SellerInterface seller = (SellerInterface) registry.lookup("Sellerinterface");
            SellerDTO sellertest = seller.getDTO();
            System.out.println(sellertest.getName());
            System.out.println(sellertest.getPass());
            System.out.println(sellertest.getAge());
            System.out.println(sellertest.getGender());

            sellertest.setName("Another Name");
            sellertest.getPostedProducts().add(new Product(1,"some product","This is a good product",5000));
            seller.returnDTO(sellertest);

            SellerDTO dsd = seller.getDTO();
            System.out.println(dsd.getName());
            System.out.println(dsd.getPostedProducts().get(0).getName());







//                BidInterface.regToRoom(b);



        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }


    }


}
