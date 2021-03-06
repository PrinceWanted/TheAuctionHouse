package theauctionhouse;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;


public class DB {


    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    Gson gson = new Gson();

    public DB() {
        // Disable Mongo Logs

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");// removes extra warnings
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize database
        String connectionString = "mongodb+srv://Prince:wasdWASD@cluster0.19key.mongodb.net/TheAuctionHouse?retryWrites=true&w=majority";
        mongoClient = new MongoClient(new MongoClientURI(connectionString));

        database = mongoClient.getDatabase("TheAuctionHouse");
//     for every function:    collection = database.getCollection("USER");  Collection name
    }

    public void insertSeller(Seller s) {
        collection = database.getCollection("Seller");

        collection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Seller inserted");
    }

    // delete user
    public void BanUser(String mail) {
        collection = database.getCollection("User");
        collection.deleteOne(Filters.eq("umail", mail));
        System.out.println("User Deleted");
    }

    //Edit seller balance
    public void editSellerBalance(int Balance, String mail) {
        collection = database.getCollection("Seller");
        collection.updateOne(Filters.eq("umail", mail), Updates.set("balance", Balance));
        System.out.println("Seller Balance edited");
    }

    // Edit bidder balance
    public void editBidderBalance(int Balance, String mail) {
        collection = database.getCollection("Bidder");
        collection.updateOne(Filters.eq("umail", mail), Updates.set("balance", Balance));
        System.out.println("Bidder Balance edited");
    }

    // Create bidding room
    public void createBiddingRoom(BiddingRoom b) {
        collection = database.getCollection("BiddingRoom");
        collection.insertOne(Document.parse(gson.toJson(b)));
        System.out.println("Bidding Room Created");
    }

    // Delete bidding room
    public void deleteBiddingRoom(int RoomNumber) {
        collection = database.getCollection("BiddingRoom");
        collection.deleteOne(Filters.eq("RoomNumber", RoomNumber));
        System.out.println("Bidding Room deleted");
    }

    // Edit bidder count in bidding room
    public void editbidderCount(String bidderCount, String mail) {
        collection = database.getCollection("BiddingRoom");
        collection.updateOne(Filters.eq("umail", mail), Updates.set("BidderCount", bidderCount));
    }

    // Editing highest price in bidding room
    public void editHighestPrice(String HighestPrice, String mail) {
        collection = database.getCollection("BiddingRoom");
        collection.updateOne(Filters.eq("umail", mail), Updates.set("BidderCount", HighestPrice));
    }

    //-----what Mekawy did so you can blame him later-----//
    public void insertBidder(Bidder b) {
        collection = database.getCollection("Bidder");

        collection.insertOne(Document.parse(gson.toJson(b)));
        System.out.println("Bidder inserted");
    }

    public void insertProduct(Product p) {
        collection = database.getCollection("Product");

        collection.insertOne(Document.parse(gson.toJson(p)));
        System.out.println("Product inserted");
    }

    public void deleteProduct(int p) {
        collection = database.getCollection("Product");

        collection.deleteOne(Filters.eq("ID", p)); //is this how we delete?
        System.out.println("Product is removed!");
    }

    public void insertBidSession(BidSession bs) {
        collection = database.getCollection("BidSession");

        collection.insertOne(Document.parse(gson.toJson(bs)));
        System.out.println("BidSession inserted");
    }

    public ArrayList<Product> getALlProducts(){
        collection = database.getCollection("Product");
        ArrayList<Product> products = new ArrayList();
        ArrayList<Document> doc = collection.find().into(new ArrayList<Document>()); //returns all rows of Product Table
        for(int i = 0; i< doc.size(); i++){
            products.add(gson.fromJson(doc.get(i).toJson(), Product.class));
        }
        return products;
    }
    //-----end of Mekawy's DB stuff-----//

    public void readUser(String type, String name) {
        collection = database.getCollection(type);
        Document Result = (Document) collection.find(Filters.all("Uname", name));
        System.out.println(Result);

    }

    public Seller retrieveSeller(String name) {
        collection = database.getCollection("Seller");
        Document Result = (Document) collection.find(Filters.all("Uname", name)).first();
        Seller user = gson.fromJson(Result.toJson(), Seller.class);
        return user;
    }

    public Bidder retrieveBidder(String name) {
        collection = database.getCollection("Bidder");
        Document Result = (Document) collection.find(Filters.all("Uname", name)).first();
        Bidder user = gson.fromJson(Result.toJson(), Bidder.class);
        return user;
    }

    public Moderator retrieveModerator() {
        collection = database.getCollection("Moderator");
        Document Result = (Document) collection.find().first();
        Moderator user = gson.fromJson(Result.toJson(), Moderator.class);
        return user;
    }

    public void insertModerator(Moderator s) {
        collection = database.getCollection("Moderator");

        collection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Moderator inserted");
    }

    public void UserLogin(String type, String name, String pass) {
        try {
            if (type == "Seller") {
                collection = database.getCollection("Seller");
                Document Result = collection.aggregate(Arrays.asList(Aggregates.match(Filters.eq("Uname", name)), Aggregates.match(Filters.eq("Upass", pass)))).first();
                System.out.println("Login Successful!");
            } else if (type == "Bidder") {
                collection = database.getCollection("Bidder");
                Document Result = collection.aggregate(Arrays.asList(Aggregates.match(Filters.eq("Uname", name)), Aggregates.match(Filters.eq("Upass", pass)))).first();
                System.out.println("Login Successful!");
            } else if (type == "Moderator") {
                collection = database.getCollection("Moderator");
                Document Result = collection.aggregate(Arrays.asList(Aggregates.match(Filters.eq("Uname", name)), Aggregates.match(Filters.eq("Upass", pass)))).first();
                System.out.println("Login Successful!");
            }
        } catch (Exception e) {
            System.out.println("USer Error");
        }
    }


    public ArrayList<Bidder> retrieveAllBidders (){
        collection = database.getCollection("Bidder");
        ArrayList<Bidder> results = new ArrayList<>();
        ArrayList<Document> documents = collection.find().into(new ArrayList<>());
        System.out.println(documents);
        for (Document document : documents) {
            results.add(gson.fromJson(document.toJson(), Bidder.class));
        }
        return results;
    }

    public ArrayList<Seller> retrieveAllSeller (){
        collection = database.getCollection("Seller");
        ArrayList<Seller> results = new ArrayList<>();
        ArrayList<Document> documents = collection.find().into(new ArrayList<>());
        System.out.println(documents);
        for (Document document : documents) {
            results.add(gson.fromJson(document.toJson(), Seller.class));
        }
        return results;
    }


    public ArrayList<Bidder> getAllBidders() {
        collection = database.getCollection("Bidder");
        ArrayList<Bidder> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Bidder.class));
        }
        return result;
    }

    public float retrieveBalanceSeller(int ID) throws RemoteException {
        collection = database.getCollection("Seller");
        Seller s = new Seller();
        Document Result = (Document) collection.find(Filters.eq("uID", ID)).first();
        s = gson.fromJson(Result.toJson(), Seller.class);
        return s.getBalance();
    }

    public int retrieveBalanceBidder(int ID) throws RemoteException {
        collection = database.getCollection("Bidder");
        Bidder s = new Bidder();
        Document Result = (Document) collection.find(Filters.eq("uID", ID)).first();
        s = gson.fromJson(Result.toJson(), Bidder.class);
        return s.getBalance();
    }

    public void editBalance(int balance, int BidderID, int SellerID) throws RemoteException {
        collection = database.getCollection("Bidder");
        collection.updateOne(Filters.eq("uID", BidderID), Updates.set("balance", retrieveBalanceSeller(BidderID)-balance));
        collection = database.getCollection("Seller");
        collection.updateOne(Filters.eq("uID", SellerID), Updates.set("balance", retrieveBalanceBidder(SellerID)+balance));
    }

    public Seller retrievesSeller(String name) {
        collection = database.getCollection("Seller");
        Document Result = (Document) collection.find(Filters.all("Uname", name)).first();
        Seller user = gson.fromJson(Result.toJson(), Seller.class);
        return user;
    }

    public Bidder retrievebBidder(String name) {
        collection = database.getCollection("Bidder");
        Document Result = (Document) collection.find(Filters.all("Uname", name)).first();
        Bidder user = gson.fromJson(Result.toJson(), Bidder.class);
        return user;
    }

    public void BanSeller(String mail) {
        collection = database.getCollection("Seller");
        collection.deleteOne(Filters.eq("Umail", mail));
        System.out.println("User Deleted");
    }

    public void BanBidder(String mail) {
        collection = database.getCollection("Bidder");
        collection.deleteOne(Filters.eq("Umail", mail));
        System.out.println("User Deleted");
    }


}

