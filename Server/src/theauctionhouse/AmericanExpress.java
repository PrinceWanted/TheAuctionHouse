
package theauctionhouse;

public class AmericanExpress implements payMethod{

    @Override
    public void pay(int amount,  Bidder sender, Seller reciever) {
        if (sender.getBalance()>=amount){
            sender.setBalance(sender.getBalance()-amount);
            reciever.setBalance(reciever.getBalance()+amount);
            System.out.println("you have payed"+amount+"using American Express");
        }
        else{
            System.out.println("amount not enough");
        }
    }
    
}
