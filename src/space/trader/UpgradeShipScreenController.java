/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author John
 */
public class UpgradeShipScreenController implements Initializable {
    
    @FXML
    private Button buyFalcon;
    
    @FXML
    private Button buyEnterprise;
    
    @FXML
    private Button buyGalactica;
    
    @FXML
    private Button buyDaedalus;
    
    @FXML
    private Label successLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Handler to let the player get back to the game
     * @param e 
     */
    public void returnToGame(ActionEvent e) {
        SpaceTrader.backToMain();
    }
    
    /**
     * Handler to purchase a new ship
     * all of these follow the same structure
     * @param e 
     */
    public void purchaseFalcon(ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(1000)) { //see if they have enough money
            SpaceTrader.getMainCharacter().buy(1000); //deduct the money
            SpaceTrader.ship.setShip(Ship.ShipTypes.FALCON); //set their new ship type
            successLabel.setText("Upgrade successful!"); //let them know about it
        } else {
            successLabel.setText("Not enough credits!"); //let them know they're poor
        }
    }
    
    /**
     * Handler to purchase a new ship
     * @param e 
     */
    public void purchaseEnterprise(ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(2000)) {
            SpaceTrader.getMainCharacter().buy(2000);
            SpaceTrader.ship.setShip(Ship.ShipTypes.ENTERPRISE);
            successLabel.setText("Upgrade successful!");
        } else {
            successLabel.setText("Not enough credits!");
        }
    }
    
    /**
     * Handler to purchase a new ship
     * @param e 
     */
    public void purchaseGalactica(ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(3000)) {
            SpaceTrader.getMainCharacter().buy(3000);
            SpaceTrader.ship.setShip(Ship.ShipTypes.GALACTICA);
            successLabel.setText("Upgrade successful!");
        } else {
            successLabel.setText("Not enough credits!");
        }
    }
    
    /**
     * Handler to purchase a new ship
     * @param e 
     */
    public void purchaseDaedalus(ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(4000)) {
            SpaceTrader.getMainCharacter().buy(4000);
            SpaceTrader.ship.setShip(Ship.ShipTypes.DAEDALUS);
            successLabel.setText("Upgrade successful!");
        } else {
            successLabel.setText("Not enough credits!");
        }
    }
}
