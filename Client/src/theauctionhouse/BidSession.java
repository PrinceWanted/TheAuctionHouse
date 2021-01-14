package theauctionhouse;

import java.io.Serializable;
import java.util.ArrayList;

public class BidSession implements Serializable {


    private ArrayList<Bidder> BiddersList ;
    private BiddingRoom Room;

    public BidSession(ArrayList<Bidder> biddersList, BiddingRoom room) {
        BiddersList = biddersList;
        Room = room;
    }

    public ArrayList<Bidder> getBiddersList() {
        return BiddersList;
    }

    public void setBiddersList(ArrayList<Bidder> biddersList) {
        BiddersList = biddersList;
    }

    public BiddingRoom getRoom() {
        return Room;
    }

    public void setRoom(BiddingRoom room) {
        Room = room;
    }



}
