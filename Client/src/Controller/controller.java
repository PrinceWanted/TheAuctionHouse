package Controller;

import GUI.Login;
import GUI.Login.*;
import GUI.Moderator_Profile;
import theauctionhouse.BidderInterface;
import theauctionhouse.ModeratorInterface;
import theauctionhouse.SellerInterface;

import java.rmi.AccessException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;

public class controller {

    Login gui;
    Moderator_Profile gui2;
    Registry r;

    public controller(Login gui, Moderator_Profile gui2, Registry r) {
        this.gui = gui;
        this.r = r;
        this.gui2 = gui2;

        gui.getJButton().addActionListener(new GetLogin());
    }

    class GetLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                String type = gui.getjTextField().getText();
                String username = gui.getjTextField2().getText();
                String password = gui.getJPasswordField().getPassword().toString();

                switch (type) {

                    case "Bidder":

                        r = LocateRegistry.getRegistry(1099);
                        BidderInterface b = (BidderInterface) r.lookup("BidderInterface");
                        b.login(username, password);

                    case "Seller":

                        r = LocateRegistry.getRegistry(1099);
                        SellerInterface s = (SellerInterface) r.lookup("SellerInterface");
                        s.login(username, password);

                    case "Moderator":

                        r = LocateRegistry.getRegistry(1099);
                        ModeratorInterface m = (ModeratorInterface) r.lookup("ModeratorInterface");
                        m.login(username, password);

                }
            } catch (AccessException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }

        }
    }
}
