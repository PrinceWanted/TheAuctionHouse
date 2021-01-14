package theauctionhouse;

import java.io.Serializable;

public class Product implements Serializable {


    private int ID;
    private String name;
    private String description;
    private int startingPrice;
   // private User owner; owner is causing me trouble because i need to get user here to know what that is
    // doing so will make me end up copying the entire project to the client

    public Product(int ID, String name, String description, int startingPrice/*, User owner*/) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
       // this.owner = owner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }


}
