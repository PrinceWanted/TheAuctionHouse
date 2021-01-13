
package theauctionhouse;


public class BiddingRoom {
    private int RoomNumber;
    private int BidderCount;
    private Product BiddingProd;
    private int BiddingInsurance;
    private Bidder HighestBidder;
    private int HighestPrice;

    public BiddingRoom(int roomNumber, int bidderCount, Product biddingProd, int biddingInsurance, Bidder highestBidder, int highestPrice) {
        RoomNumber = roomNumber;
        BidderCount = bidderCount;
        BiddingProd = biddingProd;
        BiddingInsurance = biddingInsurance;
        HighestBidder = highestBidder;
        HighestPrice = highestPrice;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public int getBidderCount() {
        return BidderCount;
    }

    public void setBidderCount(int BidderCount) {
        this.BidderCount = BidderCount;
    }

    public int getBiddingInsurance() {
        return BiddingInsurance;
    }

    public void setBiddingInsurance(int BiddingInsurance) {
        this.BiddingInsurance = BiddingInsurance;
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
