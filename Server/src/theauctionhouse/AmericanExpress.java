package theauctionhouse;

public class AmericanExpress implements payMethod {

    @Override
    public void pay(int amount, Bidder sender, Seller receiver) {
        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            System.out.println("you have payed" + amount + "using American Express");
        } else {
            System.out.println("amount not enough");
        }
    }

}
