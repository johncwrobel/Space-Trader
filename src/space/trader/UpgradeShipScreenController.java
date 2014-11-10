/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
    
    @FXML
    private Label creditLabel;
    
    @FXML
    private Label currentSlotsLabel;
            
    @FXML
    private Button shieldUpgradeButton;
    
    @FXML
    private Button gadgetUpgradeButton;
    
    @FXML
    private Button weaponUpgradeButton;
    
    @FXML
    private Button showShipUpgradesButton;
    
    @FXML
    private Button newShipButton;
    
    @FXML
    private Label currentShipLabel;

    @FXML
    private Label currentShipPowerLabel;
    
    @FXML
    private ImageView imageViewMane;
    
    @FXML
    private ListView gadgetListView;
    
    @FXML
    private Button viewGadgetButton;
    
    @FXML
    private Button weaponButton;
    
    @FXML
    private Button shieldButton;
    
    @FXML
    private Label shieldPriceLabel;
    
    @FXML
    private Label weaponPriceLabel;
    
    private int techLevel;
    
    private boolean isShieldButtonPressed = false;
    private boolean isWeaponButtonPressed = false;
    
    private ArrayList<Shield> shields = new ArrayList();
    
    private ArrayList<Weapon> weapons = new ArrayList();
    /**
     * Initializes the controller class.
     * @param url the url
     * @param rb the resource bundle
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {
        gadgetListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
          }
        });
    }
    
    
    /**
     * Handler to let the player get back to the game
     * @param e 
     */
    public final void returnToGame(final ActionEvent e) {
        SpaceTrader.backToMain();
    }
    
    /**
     * Handler to purchase a new ship
     * all of these follow the same structure
     * @param e 
     */
    public final void purchaseFalcon(final ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(1000)) { //see if they have enough money
            SpaceTrader.getMainCharacter().buy(1000); //deduct the money
            SpaceTrader.ship.setShip(Ship.ShipTypes.FALCON); //set their new ship type
            successLabel.setText("Upgrade successful!"); //let them know about it
            updateText();
        } else {
            successLabel.setText("Not enough credits!"); //let them know they're poor
        }
    }
    
    /**
     * Handler to purchase a new ship
     * @param e 
     */
    public final void purchaseEnterprise(final ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(2000)) {
            SpaceTrader.getMainCharacter().buy(2000);
            SpaceTrader.ship.setShip(Ship.ShipTypes.ENTERPRISE);
            successLabel.setText("Upgrade successful!");
            updateText();
        } else {
            successLabel.setText("Not enough credits!");
        }
    }
    
    /**
     * Handler to purchase a new ship
     * @param e 
     */
    public final void purchaseGalactica(final ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(3000)) {
            SpaceTrader.getMainCharacter().buy(3000);
            SpaceTrader.ship.setShip(Ship.ShipTypes.GALACTICA);
            successLabel.setText("Upgrade successful!");
            updateText();
        } else {
            successLabel.setText("Not enough credits!");
        }
    }
    
    /**
     * Handler to purchase a new ship
     * @param e 
     */
    public final void purchaseDaedalus(final ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(4000)) {
            SpaceTrader.getMainCharacter().buy(4000);
            SpaceTrader.ship.setShip(Ship.ShipTypes.DAEDALUS);
            successLabel.setText("Upgrade successful!");
            updateText();
        } else {
            successLabel.setText("Not enough credits!");
        }
    }
    
    /**
     * Enables the buttons to purchase ship upgrades
     * @param e 
     */
    public final void showShipUpgrade(final ActionEvent e) {
        weaponButton.setDisable(false);
        shieldButton.setDisable(false);
        gadgetListView.setDisable(false);
        imageViewMane.setDisable(false);
        gadgetUpgradeButton.setDisable(false);
        
        buyFalcon.setDisable(true);
        buyEnterprise.setDisable(true);
        buyGalactica.setDisable(true);
        buyDaedalus.setDisable(true);
        
        successLabel.setText("Upgrade your ship!");
        updateText();
    }
    
    /**
     * Enables the buttons to purchase new ship
     * @param e 
     */
    public final void buyNewShip(final ActionEvent e) {
        shieldUpgradeButton.setDisable(true);
        gadgetUpgradeButton.setDisable(true);
        weaponUpgradeButton.setDisable(true);
        weaponButton.setDisable(true);
        shieldButton.setDisable(true);
        viewGadgetButton.setDisable(true);
        gadgetListView.setDisable(true);
        imageViewMane.setDisable(true);
        
        buyFalcon.setDisable(false);
        buyEnterprise.setDisable(false);
        buyGalactica.setDisable(false);
        buyDaedalus.setDisable(false);
        
        successLabel.setText("Upgrade your ship!");
        
        updateText();
    }
    
    /**
     * Handler to upgrade Shield
     * @param e 
     */
    public final void upgradeShield(final ActionEvent e) {
        ObservableList<String> selectedItem = gadgetListView.getSelectionModel().getSelectedItems();
        int powerLevel = 1;
        String type = "";
        int gadgetIndex = 0;
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            powerLevel = Integer.parseInt(temp[2]);
            type = temp[0];
        }
        
        for (int x = 0; x < shields.size(); x++) {
            if (shields.get(x).shieldLevel == (2*powerLevel)) {
                gadgetIndex = x;
                break;
            }
        }
        int shieldPrice = shields.get(gadgetIndex).price;
        if(SpaceTrader.getMainCharacter().canBuy(shieldPrice) && SpaceTrader.ship.checkGadget()) {
            SpaceTrader.getMainCharacter().buy(shieldPrice);
            SpaceTrader.ship.increaseShieldLevel(shields.get(gadgetIndex).shieldLevel);
            successLabel.setText("Upgrade successful!");
            SpaceTrader.ship.gadgets++;
            updateText();
        } else if(!SpaceTrader.getMainCharacter().canBuy(shieldPrice)) {
            successLabel.setText("Not enough credits!");
        } else {
            successLabel.setText("Not enough gadget space!");
        }
    }
    
    /**
     * handler to upgrade Gadge
     * @param e 
     */
    public final void upgradeGadget(final ActionEvent e) {
        if(SpaceTrader.getMainCharacter().canBuy(500)) {
            SpaceTrader.getMainCharacter().buy(500);
            successLabel.setText("Upgrade successful!");
            SpaceTrader.ship.gadgetslots++;
            updateTextGadget();
        } else {
            successLabel.setText("Not enough credits!");
        }
    
    }
    
    /**
     * Handler to upgrade Weapons
     * @param e the event
     */
    public final void upgradeWeapon(final ActionEvent e) {
        ObservableList<String> selectedItem = gadgetListView.getSelectionModel().getSelectedItems();
        int powerLevel = 1;
        String type = "";
        int gadgetIndex = 0;
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            powerLevel = Integer.parseInt(temp[2]);
            type = temp[0];
        }
        
        for (int x = 0; x < weapons.size(); x++) {
            if (weapons.get(x).weaponLevel == (2*powerLevel)) {
                gadgetIndex = x;
                break;
            }
        }
        int weaponPrice = weapons.get(gadgetIndex).price;
        if(SpaceTrader.getMainCharacter().canBuy(weaponPrice) && SpaceTrader.ship.checkGadget()) {
            SpaceTrader.getMainCharacter().buy(weaponPrice);
            successLabel.setText("Upgrade successful!");
            SpaceTrader.ship.increaseWeaponLevel(weapons.get(gadgetIndex).weaponLevel);
            SpaceTrader.ship.gadgets++;
            updateText();
        } else if(!SpaceTrader.getMainCharacter().canBuy(weaponPrice)) {
            successLabel.setText("Not enough credits!");
        } else {
            successLabel.setText("Not enough gadget space!");
        }
    }
    
    /**
     * Displays the list of shield upgrades
     * @param e 
     */
    public final void shieldButton(final ActionEvent e) {
        viewGadgetButton.setDisable(false);
        isShieldButtonPressed = true;
        isWeaponButtonPressed = false;
        
        techLevel = SpaceTrader.currentPlanet.getTechLevel() - 1;
        shields = new ArrayList();
        ArrayList<String> shieldListString = new ArrayList();
        for (int x = 0; x <= techLevel; x++) {
            shields.add(new Shield(("Shield Level " + (x+1)), (2*(x+1)), x, (100*(x+1))));
            shieldListString.add(shields.get(x).name);
        }
        ObservableList<String> observable = FXCollections.observableArrayList(shieldListString);
        gadgetListView.setItems(null);
        gadgetListView.setItems(observable);
        
    }
    
    /**
     * Displays the list of weapon upgrades
     * @param e 
     */
    public final void weaponButton(final ActionEvent e) {
        viewGadgetButton.setDisable(false);
        isWeaponButtonPressed = true;
        isShieldButtonPressed = false;
        
        techLevel = SpaceTrader.currentPlanet.getTechLevel() - 1;
        weapons = new ArrayList();
        ArrayList<String> weaponListString = new ArrayList();
        for (int x = 0; x <= techLevel; x++) {
            weapons.add(new Weapon(("Weapon Level " + (x+1)), (2*(x+1)), x , (100*(x+1))));
            weaponListString.add(weapons.get(x).name);
        }
        ObservableList<String> observable = FXCollections.observableArrayList(weaponListString);
        gadgetListView.setItems(null);
        gadgetListView.setItems(observable);
        
    }
    
    /**
     * Displays the gadget information and previews
     * @param e 
     */
    public final void viewGadget(final ActionEvent e) {
        if (isShieldButtonPressed) {
            shieldUpgradeButton.setDisable(false);
        } else {
            shieldUpgradeButton.setDisable(true);
        }
        if (isWeaponButtonPressed) {
            weaponUpgradeButton.setDisable(false);
        } else {
            weaponUpgradeButton.setDisable(true);
        }
        
        ObservableList<String> selectedItem = gadgetListView.getSelectionModel().getSelectedItems();
        int powerLevel = 1;
        String type = "";
        int shieldPrice = 0;
        int weaponPrice = 0;
        int gadgetIndex = 0;
        int weaponPreview = 0;
        int shieldPreview = 0;
        
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            powerLevel = Integer.parseInt(temp[2]);
            type = temp[0];
        }
                
        if (type.equals("Weapon") &&(powerLevel == 1 || powerLevel == 5)) {
            String img = "weapon" + (powerLevel) + ".jpg";
            imageViewMane.setImage(new Image(UpgradeShipScreenController.class.getResourceAsStream(img)));
            for (int x = 0; x < weapons.size(); x++) {
                if (weapons.get(x).weaponLevel == (2*powerLevel)) {
                    gadgetIndex = x;
                    weaponPreview = weapons.get(x).weaponLevel;
                    break;
                }
            }
            weaponPrice = weapons.get(gadgetIndex).price;
        } else if (type.equals("Weapon")) {
            String img = "weapon" + (powerLevel) + ".png";
            imageViewMane.setImage(new Image(UpgradeShipScreenController.class.getResourceAsStream(img)));
            for (int x = 0; x < weapons.size(); x++) {
                if (weapons.get(x).weaponLevel == (2*powerLevel)) {
                    gadgetIndex = x;
                    weaponPreview = weapons.get(x).weaponLevel;
                    break;
                }
            }
            weaponPrice = weapons.get(gadgetIndex).price;
        }
        
        if (type.equals("Shield")) {
            String img = "shield" + (powerLevel) + ".png";
            imageViewMane.setImage(new Image(UpgradeShipScreenController.class.getResourceAsStream(img)));
            for (int x = 0; x < shields.size(); x++) {
                if (shields.get(x).shieldLevel == (2*powerLevel)) {
                    gadgetIndex = x;
                    shieldPreview = shields.get(x).shieldLevel;
                    break;
                }
            }
            shieldPrice = shields.get(gadgetIndex).price;
        }
        
        updateText();
        updatePreview(weaponPreview, shieldPreview);
        updatePrice(weaponPrice, shieldPrice);
    }
    
    
    
    /**
     * Updates the credit amount when called
     */
    public final void updateText() {
        int creditsINT = SpaceTrader.getMainCharacter().getCredits();
        creditLabel.setText("Credit: " + creditsINT);
        currentSlotsLabel.setText("Current Gadget Slots: " + SpaceTrader.ship.gadgetslots);
        currentShipLabel.setText("Current Ship: " + SpaceTrader.ship.shipType + " | Available Gadget Slots: " + (SpaceTrader.ship.gadgetslots - SpaceTrader.ship.gadgets));
        currentShipPowerLabel.setText("Current Levels: " + "Weapon: " + SpaceTrader.ship.weaponLevel + " Shield: " + SpaceTrader.ship.shieldLevel);
        
    }
    
    /**
     * Specific text updater just for previews of the upgrades
     * @param weaponLevel level of the weapon
     * @param shieldLevel level of the shield
     */
    public final void updatePreview(final int weaponLevel, final int shieldLevel) {
        if (weaponLevel != 0) {
            currentShipPowerLabel.setText("Current Levels: " + "Weapon: " + SpaceTrader.ship.weaponLevel + "(+" + weaponLevel + ")" + " Shield: " + SpaceTrader.ship.shieldLevel);
        } else {
            currentShipPowerLabel.setText("Current Levels: " + "Weapon: " + SpaceTrader.ship.weaponLevel + " Shield: " + SpaceTrader.ship.shieldLevel + "(+" + shieldLevel + ")");
        }
        
    }
    
    /**
     * specific text updater just when upgrading a gadget
     */
    public final void updateTextGadget() {
        int creditsINT = SpaceTrader.getMainCharacter().getCredits();
        creditLabel.setText("Credit: " + creditsINT);
        currentSlotsLabel.setText("Current Gadget Slots: " + SpaceTrader.ship.gadgetslots);
        currentShipLabel.setText("Current Ship: " + SpaceTrader.ship.shipType + " | Available Gadget Slots: " + (SpaceTrader.ship.gadgetslots - SpaceTrader.ship.gadgets));
    }
    
    /**
     * Specific text updater for prices
     * @param weaponPrice the weapon price
     * @param shieldPrice the shield price
     */
    public final void updatePrice(final int weaponPrice, final int shieldPrice) {
        shieldPriceLabel.setText("" + shieldPrice + " Credits");
        weaponPriceLabel.setText("" + weaponPrice + " Credits");
    }

}
