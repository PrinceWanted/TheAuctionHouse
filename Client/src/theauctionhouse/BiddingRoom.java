
package theauctionhouse;


import java.io.Serializable;
import java.util.ArrayList;

public class BiddingRoom implements Serializable {
    private int RoomNumber;
    private int BidderCount;
    private Product BiddingProd;
    private int BiddingInsurance;
    private Bidder HighestBidder;
    private int HighestPrice;
    private ArrayList<Bidder> BiddersList;

    public BiddingRoom(int roomNumber, int bidderCount, Product biddingProd, int biddingInsurance, Bidder highestBidder, int highestPrice, ArrayList<Bidder> biddersList) {
        RoomNumber = roomNumber;
        BidderCount = bidderCount;
        BiddingProd = biddingProd;
        BiddingInsurance = biddingInsurance;
        HighestBidder = highestBidder;
        HighestPrice = highestPrice;
        BiddersList = biddersList;
    }

    public ArrayList<Bidder> getBiddersList() {
        return BiddersList;
    }

    public void setBiddersList(ArrayList<Bidder> biddersList) {
        BiddersList = biddersList;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public int getBidderCount() {
        return BidderCount;
    }

    public void setBidderCount(int bidderCount) {
        BidderCount = bidderCount;
    }

    public Product getBiddingProd() {
        return BiddingProd;
    }

    public void setBiddingProd(Product biddingProd) {
        BiddingProd = biddingProd;
    }

    public int getBiddingInsurance() {
        return BiddingInsurance;
    }

    public void setBiddingInsurance(int biddingInsurance) {
        BiddingInsurance = biddingInsurance;
    }

    public Bidder getHighestBidder() {
        return HighestBidder;
    }

    public void setHighestBidder(Bidder highestBidder) {
        HighestBidder = highestBidder;
    }

    public int getHighestPrice() {
        return HighestPrice;
    }

    public void setHighestPrice(int highestPrice) {
        HighestPrice = highestPrice;
    }

    public void updateBidderCount(){
        
    }

    public void updateBiddingRoom(int x){
        
    }
    public void deleteBiddingRoom(int x){
        
    }
    public void addToBiddingRoom(Product x){
        
    }


}
