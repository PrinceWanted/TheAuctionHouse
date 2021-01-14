
package theauctionhouse;


public class DebitPayment implements payMethod {

    @Override
    public void pay(int amount,  Bidder sender, Seller reciever) {

        if (sender.balance>=amount){
            sender.setBalance(sender.getBalance()-amount);
            reciever.setBalance(reciever.getBalance()+amount);
            System.out.println("you have payed"+amount+"using DebitCard");
        }
        else{
            System.out.println("amount not enough");
        }
    }
    
}
