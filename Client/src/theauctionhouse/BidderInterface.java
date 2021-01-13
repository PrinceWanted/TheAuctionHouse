package theauctionhouse;

import java.rmi.Remote;

public interface BidderInterface extends Remote {

    public void bid(int bidprice, BidSession bs);
    public void regToRoom(BidSession bs);
    public void viewProductList();

}
