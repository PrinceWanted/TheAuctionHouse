package theauctionhouse;

import java.io.Serializable;

public class Product implements Serializable {


    private int ID;
    private String name;
    private String description;
    private int startingPrice;


    public Product(int ID, String name, String description, int startingPrice) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;

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
