package theauctionhouse;

import java.rmi.Remote;

public interface ModeratorInterface extends Remote {

    public void AcceptAuctionReq(Product p);
}
