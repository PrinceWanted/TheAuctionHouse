package theauctionhouse;

import java.io.Serializable;
import java.util.ArrayList;

public class BidSession implements Serializable {


    private ArrayList<Bidder> BiddersList ;
    private BiddingRoom Room;
    private Boolean IsAvailable;


    public BidSession(ArrayList<Bidder> biddersList, BiddingRoom room, Boolean isAvailable) {
        BiddersList = biddersList;
        Room = room;
        IsAvailable = isAvailable;
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

    public Boolean getAvailable() {
        return IsAvailable;
    }

    public void setAvailable(Boolean available) {
        IsAvailable = available;
    }

    private Transaction endSession() {
        return null;
    }


}
