package theauctionhouse;

import java.util.ArrayList;

public class BidSession {


    private Bidder highestBidder;
    private BiddingRoom BidRoom;
    private Seller seller;
    private Product biddingProd;
    private ArrayList<Bidder> BiddersList;


    public BidSession(Bidder highestBidder, BiddingRoom bidRoom, Seller seller, Product biddingProd, ArrayList<Bidder> biddersList) {
        this.highestBidder = highestBidder;
        BidRoom = bidRoom;
        this.seller = seller;
        this.biddingProd = biddingProd;
        BiddersList = biddersList;
    }


    public Bidder getHighestBidder() {
        return highestBidder;
    }

    public void setHighestBidder(Bidder highestBidder) {
        this.highestBidder = highestBidder;
    }

    public BiddingRoom getBidRoom() {
        return BidRoom;
    }

    public void setBidRoom(BiddingRoom bidRoom) {
        BidRoom = bidRoom;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getBiddingProd() {
        return biddingProd;
    }

    public void setBiddingProd(Product biddingProd) {
        this.biddingProd = biddingProd;
    }

    public ArrayList<Bidder> getBiddersList() {
        return BiddersList;
    }

    public void setBiddersList(ArrayList<Bidder> biddersList) {
        BiddersList = biddersList;
    }

    private Transaction endSession() {
        return null;
    }


}
