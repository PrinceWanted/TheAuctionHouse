
package GUIController;

import GUI.*;
import GUI.Login.*;
import theauctionhouse.Controller.BidderInterface;
import theauctionhouse.Controller.ModeratorInterface;
import theauctionhouse.Controller.SellerInterface;

import java.rmi.AccessException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import theauctionhouse.BidSession;
import theauctionhouse.Bidder;
import theauctionhouse.Moderator;
import theauctionhouse.Seller;
import theauctionhouse.BiddingRoom;
import theauctionhouse.Product;

public class GUIcontroler {

    
    Login gui;
    Moderator m;
    Bidder b;
    Seller s;
    BidSession bs;
    Moderator_Profile gui2 = new Moderator_Profile(m);
    Pay gui3;
    Bidding_Room_UI gui4;
    Bidder_Profile bp;
    Seller_Profile sp;
    Registry r;

    public GUIcontroler(Login gui, Moderator_Profile gui2, Pay gui3, Bidding_Room_UI gui4, Bidder_Profile bp,Seller_Profile sp, Registry r) throws RemoteException {
        
        this.m = Moderator.getInstance();
        this.b = new Bidder();
        this.s = new Seller();
        this.gui = gui;
        this.r = r;
        this.gui2 = gui2 ;
        this.gui3 = gui3;
        this.gui4 = gui4;
        this.bp = bp;
        this.sp = sp;

        gui.getjButton().addActionListener(new GetLogin());
        gui2.getjButton().addActionListener(new RemoveProductBtn());
        gui2.getjButton2().addActionListener(new banSellerBtn());
        gui2.getjButton3().addActionListener(new banBidderBtn());
        gui2.getjButton3().addActionListener(new LogoutBtn());
        //gui4.getjButton().addActionListener(new bidBtn());
        gui4.getjButton2().addActionListener(new LogoutBtn());
        //gui3.getjButton().addActionListener(new paypriceBtn());
        bp.getDisplayAllProducts().addActionListener(new DisplayProducts());
        bp.getBidForProduct().addActionListener(new RegisterBid());
        sp.getsellerProducts().addActionListener(new displaySellerProducts());
        sp.getAddProduct().addActionListener(new addProduct());
    }

    class GetLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String type = gui.getjTextField().getText();
                String username = gui.getjTextField2().getText();
                String password = String.valueOf(gui.getJPasswordField().getPassword());
                switch (type) {

                    case "Bidder":
                        r = LocateRegistry.getRegistry(1099);
                        BidderInterface b = (BidderInterface) r.lookup("BidderInterface");
                        b.login(username, password);
                        bp.setVisible(true);
                        
                        
                    case "Seller":
                        r = LocateRegistry.getRegistry(1099);
                        SellerInterface s = (SellerInterface) r.lookup("SellerInterface");
                        s.login(username, password);
                        sp.setVisible(true);
                        

                        
                    case "Moderator":
                        gui2.setVisible(true);
                        r = LocateRegistry.getRegistry(1099);
                        ModeratorInterface m = (ModeratorInterface) r.lookup("ModeratorInterface");
                        m.login(username, password);
                        gui.m = m.login(username, password);
                        gui.dispose();
                        
                        
                }
            } catch (AccessException e) {
                Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, e);
            } catch (RemoteException e) {
                Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, e);
            } catch (NotBoundException e) {
                Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    class RemoveProductBtn implements ActionListener{
       
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                r = LocateRegistry.getRegistry(1099);
                ModeratorInterface m = (ModeratorInterface) r.lookup("ModeratorInterface");
                int productID = Integer.parseInt(gui2.getjTextField().getText());
                m.RemoveProduct(productID);
                
                } catch (RemoteException | NotBoundException remoteException) {
                Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, remoteException);
            }
        }
    }
    
   class banSellerBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                r = LocateRegistry.getRegistry(1099);
                ModeratorInterface m = (ModeratorInterface) r.lookup("ModeratorInterface");
                String mail = gui2.getjTextField2().getText();
                m.BanSeller(mail);

                } catch (RemoteException | NotBoundException remoteException) {
                Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, remoteException);
            }
        }
    }
   
   class banBidderBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                r = LocateRegistry.getRegistry(1099);
                ModeratorInterface m = (ModeratorInterface) r.lookup("ModeratorInterface");
                String mail = gui2.getjTextField2().getText();
                m.BanBidder(mail);

                } catch (RemoteException | NotBoundException remoteException) {
                Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, remoteException);
            }
        }
    }
    
    class LogoutBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                gui.setVisible(true);
                if(gui2.isVisible()){
                    gui2.dispose();
                    gui.setVisible(true);
                }
                if (gui4.isVisible()){
                    gui4.dispose();
                    gui.setVisible(true);
                }
                
                } catch (Exception ex) {
                    Logger.getLogger(GUIcontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class DisplayProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                r = LocateRegistry.getRegistry(1099);
                BidderInterface b = (BidderInterface) r.lookup("Binterface");
                String products = b.viewProductList(); //convert that function to return string
                bp.getTextArea().setText(products);
            }catch (AccessException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }


    }
    class RegisterBid implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                r = LocateRegistry.getRegistry(1099);
                BidderInterface b = (BidderInterface) r.lookup("Binterface");
                Product p = new Product(2,"Modelkit","plastic kit", 400);
                //int roomNumber, int bidderCount, Product biddingProd, int biddingInsurance, Bidder highestBidder, int highestPrice, ArrayList<Bidder> biddersList
                BiddingRoom br = new BiddingRoom(1,0,p,10,null,0,null);
                //ArrayList<Bidder> biddersList, BiddingRoom room, Boolean isAvailable
                ArrayList<Bidder>bidders = new ArrayList<Bidder>();
                BidSession bs = new BidSession(bidders,br);
                bs.addBidder(bp.getBidder());
                System.out.println(bs);
            }catch (AccessException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }

    class displaySellerProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                r = LocateRegistry.getRegistry(1099);
                SellerInterface s = (SellerInterface) r.lookup("Sellerinterface");
                ArrayList<Product> products = s.getPostedProducts();
                String list = "";
                for (int i = 0; i < products.size(); i++) {
                    list += products.get(i).toString() + "\n";
                }
                sp.getsellerProducts().setText(list);
                //make an array list of products
                //then get the arraylist from the interface and assign it to the array list made here
                //make a string
                //make a for loop getting to the toString of eachproduct object into the string, tho make sure an endline is made
                //set that variable to the text area
            }catch (AccessException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }

    class addProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                r = LocateRegistry.getRegistry(1099);
                SellerInterface s = (SellerInterface) r.lookup("Sellerinterface");
                String Name,Description;
                Name = sp.getProductName().getText();
                Description = sp.getProductDescription().getText();
                int ID = Integer.parseInt(sp.getProductID().getText());
                int startPrice = Integer.parseInt(sp.getProductStartPrice().getText());
                Product p = new Product(ID,Name,Description,startPrice);
                s.postProduct(p);
                System.out.println(s);
            }catch (AccessException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }
    /*class bidBtn implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                gui4.
                

                } catch (RemoteException | NotBoundException remoteException) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, remoteException);
            }
        }
    }
    
    class paypriceBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                r = LocateRegistry.getRegistry(1099);
                payMethod PM = (payMethod) r.lookup("payMethod");
                int pay = Integer.parseInt(gui3.getjTextField().getText());
                if(gui3.getJRadioButton().isSelected()){
                    PM = (payMethod) new CreditPayment();
                    PM.paydb(pay, , );
                }
                
                if(gui3.getJRadioButton2().isSelected()){
                    PM = (payMethod) new AmericanExpress();
                    PM.paydb(pay, , );
                }
                
                if(gui3.getJRadioButton3().isSelected()){
                    PM = (payMethod) new DebitPayment();
                    PM.paydb(pay, , );
                }

                } catch (RemoteException | NotBoundException remoteException) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, remoteException);
            }
        }
    }*/
}
