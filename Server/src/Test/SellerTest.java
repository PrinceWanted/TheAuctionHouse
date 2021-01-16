package Test;

import org.junit.jupiter.api.Test;
import theauctionhouse.*;
import theauctionhouse.Controller.SellerInterface;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    @Test
    void postProductTest() throws RemoteException {
        Product prod = new Product(99,"Ancient","Ancient artifact",999);
        ArrayList<Product> prods = new ArrayList<>();
        Seller sell = new Seller(999,prods);
        int BeforeSize = sell.getPostedProducts().size();
        int ModSize = Moderator.getInstance().getPendingProducts().size();
        sell.postProduct(prod);

        assertEquals(BeforeSize+1 ,sell.getPostedProducts().size());
        assertEquals(ModSize+1, Moderator.getInstance().getPendingProducts().size());
    }
//INCASE OF EMERGENCY UPDATE BALANCE
    @Test
    void bidTest()throws RemoteException{
        int biddingprice = 420;
        ArrayList<Bidder> freefolks = new ArrayList<>();
        Product prod = new Product(99,"Ancient","Ancient artifact",999);
        BiddingRoom br = new BiddingRoom(420,0,prod,420,null,0);
        Bidder boy = new Bidder(69,"Solja","DiamondMiner","Proxy@killme",42,"Unknown","Somewhere ST",69420,"Assassin",69420);
        BidSession bs = new BidSession(freefolks,br,true);
        boy.bid(biddingprice,bs);
        assertEquals(br.getHighestBidder(),boy);
        assertEquals(br.getHighestPrice(),biddingprice);
    }
    @Test
    void DTOTest()throws RemoteException{
        //GoodLuck
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            Seller se = new Seller(1, "hassan", "Pass", "Mail", 32, "Male", "Hamada Street", 011223, "Seller", 1322);
            SellerInterface sd = se;
            reg.bind("Sellerinterface", sd);
            SellerInterface seller = (SellerInterface) reg.lookup("Sellerinterface");
            SellerDTO  sdto = seller.getDTO();
            assertEquals(sdto.getName(),se.getUname());
        }catch (RemoteException | AlreadyBoundException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}