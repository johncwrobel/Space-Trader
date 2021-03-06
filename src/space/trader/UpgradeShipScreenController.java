/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
//import javafx.scene.control.ScrollBar;
//import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;

/**
 * FXML Controller class.
 *
 * @author John
 */
public class UpgradeShipScreenController implements Initializable {
    /**
     * hundo.
     */
    private final int hundo = 100;
    /**
     * plvl5.
     */
    private final int plvl5 = 5;

    /**
     * @variable buyFalcon button to buy Falcon
     */
    @FXML
    private Button buyFalcon;


    /**
     * @variable buyEnterprise button to buy Enterprise
     */
    @FXML
    private Button buyEnterprise;


    /**
     * @variable buyGalactica button to buy Galactica
     */
    @FXML
    private Button buyGalactica;


    /**
     * @variable buyDaedalus button to buy Daedalus
     */
    @FXML
    private Button buyDaedalus;


    /**
     * @variable successLabel label to display upgrade success
     */
    @FXML
    private Label successLabel;


    /**
     * @variable creditLabel label to display credits
     */
    @FXML
    private Label creditLabel;


    /**
     * @variable currentSlotsLabel label to display current slots
     */
    @FXML
    private Label currentSlotsLabel;


    /**
     * @variable shieldUpgradeButton button to upgrade shield
     */
    @FXML
    private Button shieldUpgradeButton;


    /**
     * @variable gadgetUpgradeButton button to increase gadget slots
     */
    @FXML
    private Button gadgetUpgradeButton;


    /**
     * @variable weaponUpgradeButton button to upgrade weapon
     */
    @FXML
    private Button weaponUpgradeButton;


    /**
     * @variable showShipUpgradesButton button to show ship upgrades
     */
    @FXML
    private Button showShipUpgradesButton;


    /**
     * @variable newShipButton button to show new ship
     */
    @FXML
    private Button newShipButton;


    /**
     * @variable currentShipLabel label to show current ship
     */
    @FXML
    private Label currentShipLabel;


    /**
     * @variable currentShipPowerLabel label to show current ship power
     */
    @FXML
    private Label currentShipPowerLabel;

    /**
     * @variable imageViewMane the ImageView, mane
     */
    @FXML
    private ImageView imageViewMane;


    /**
     * @variable gadgetListView the listView for the gadgets
     */
    @FXML
    private ListView gadgetListView;


    /**
     * @variable viewGadgetButton the button to view gadgets
     */
    @FXML
    private Button viewGadgetButton;


    /**
     * @variable weaponButton button for weapons
     */
    @FXML
    private Button weaponButton;


    /**
     * @variable shieldButton button for shields
     */
    @FXML
    private Button shieldButton;


    /**
     * @variable shieldPriceLabel label to show shield price
     */
    @FXML
    private Label shieldPriceLabel;


    /**
     * @variable weaponPriceLabal label to show weapon price
     */
    @FXML
    private Label weaponPriceLabel;


    /**
     * @variable techLevel planet's tech level
     */
    private int techLevel;


    /**
     * @variable isShieldButtonPressed boolean to check if a button is pressed
     */
    private boolean isShieldButtonPressed = false;

    /**
     * @variable isWeaponButtonPRessed boolean to check if a button is pressed
     */
    private boolean isWeaponButtonPressed = false;

    /**
     * @variable shields ArrayList to hold all the shields
     */
    private ArrayList<Shield> shields = new ArrayList();


    /**
     * @variable weapons ArrayList to hold all weapons
     */
    private ArrayList<Weapon> weapons = new ArrayList();


    /**
     * @variable upgradeSuccessfulString checkstyles are bothersome
     */
    private String upgradeSuccessfulString = "Upgrade successful!";


    /**
     * @variable notEnoughCreditsString like is this really necessary?
     */
    private String notEnoughCreditsString = "Not enough credits!";

    /**
     * @variable falconPrice cost of the falcon
     */
    private final int falconPrice = 1000;

    /**
     * @variable enterprisePrice cost of the enterprise
     */
    private final int enterprisePrice = 2000;

    /**
     * @variable galacticaPrice cost of the galactica
     */
    private final int galacticaPrice = 3000;

    /**
     * @variable daedalusPrice cost of the daedalus
     */
    private final int daedalusPrice = 4000;

    /**
     * Initializes the controller class.
     * @param url the url
     * @param rb the resource bundle
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {

    }


    /**
     * Handler to let the player get back to the game.
     * @param e the event
     */
    public final void returnToGame(final ActionEvent e) {
        SpaceTrader.backToMain();
    }

    /**
     * Handler to purchase a new ship.
     * all of these follow the same structure
     * @param e the event
     */
    public final void purchaseFalcon(final ActionEvent e) {
        if (SpaceTrader.getMainCharacter().canBuy(falconPrice)) {
            //see if they have enough money
            SpaceTrader.getMainCharacter().buy(falconPrice);
            //deduct the money
            SpaceTrader.ship.setShip(Ship.ShipTypes.FALCON);
            //set their new ship type
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            //let them know about it
            updateText();
        } else {
            getSuccessLabel().setText(getNotEnoughCreditsString());
            //let them know they're poor
        }
    }

    /**
     * Handler to purchase a new ship.
     * @param e the event
     */
    public final void purchaseEnterprise(final ActionEvent e) {
        if (SpaceTrader.getMainCharacter().canBuy(enterprisePrice)) {
            SpaceTrader.getMainCharacter().buy(enterprisePrice);
            SpaceTrader.ship.setShip(Ship.ShipTypes.ENTERPRISE);
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            updateText();
        } else {
            getSuccessLabel().setText(getNotEnoughCreditsString());
        }
    }

    /**
     * Handler to purchase a new ship.
     * @param e the event
     */
    public final void purchaseGalactica(final ActionEvent e) {
        if (SpaceTrader.getMainCharacter().canBuy(galacticaPrice)) {
            SpaceTrader.getMainCharacter().buy(galacticaPrice);
            SpaceTrader.ship.setShip(Ship.ShipTypes.GALACTICA);
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            updateText();
        } else {
            getSuccessLabel().setText(getNotEnoughCreditsString());
        }
    }

    /**
     * Handler to purchase a new ship.
     * @param e the event
     */
    public final void purchaseDaedalus(final ActionEvent e) {
        if (SpaceTrader.getMainCharacter().canBuy(daedalusPrice)) {
            SpaceTrader.getMainCharacter().buy(daedalusPrice);
            SpaceTrader.ship.setShip(Ship.ShipTypes.DAEDALUS);
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            updateText();
        } else {
            getSuccessLabel().setText(getNotEnoughCreditsString());
        }
    }

    /**
     * Enables the buttons to purchase ship upgrades.
     * @param e the event
     */
    public final void showShipUpgrade(final ActionEvent e) {
        getWeaponButton().setDisable(false);
        getShieldButton().setDisable(false);
        getGadgetListView().setDisable(false);
        getImageViewMane().setDisable(false);
        getGadgetUpgradeButton().setDisable(false);

        getBuyFalcon().setDisable(true);
        getBuyEnterprise().setDisable(true);
        getBuyGalactica().setDisable(true);
        getBuyDaedalus().setDisable(true);

        getSuccessLabel().setText("Upgrade your ship!");
        updateText();
    }

    /**
     * Enables the buttons to purchase new ship.
     * @param e the event
     */
    public final void buyNewShip(final ActionEvent e) {
        getShieldUpgradeButton().setDisable(true);
        getGadgetUpgradeButton().setDisable(true);
        getWeaponUpgradeButton().setDisable(true);
        getWeaponButton().setDisable(true);
        getShieldButton().setDisable(true);
        getViewGadgetButton().setDisable(true);
        getGadgetListView().setDisable(true);
        getImageViewMane().setDisable(true);

        getBuyFalcon().setDisable(false);
        getBuyEnterprise().setDisable(false);
        getBuyGalactica().setDisable(false);
        getBuyDaedalus().setDisable(false);

        getSuccessLabel().setText("Upgrade your ship!");

        updateText();
    }

    /**
     * Handler to upgrade Shield.
     * @param e the event
     */
    public final void upgradeShield(final ActionEvent e) {
        final ObservableList<String> selectedItem = getGadgetListView().
                getSelectionModel().getSelectedItems();
        int powerLevel = 1;
//        String type = "";
        int gadgetIndex = 0;
        for (int i = 0; i < selectedItem.size(); i++) {
            final String[] temp = selectedItem.get(i).split(" ");
            powerLevel = Integer.parseInt(temp[2]);
//            type = temp[0];
        }

        for (int x = 0; x < getShields().size(); x++) {
            if (getShields().get(x).getShieldLevel() == (2 * powerLevel)) {
                gadgetIndex = x;
                break;
            }
        }
        final int shieldPrice = getShields().get(gadgetIndex).getPrice();
        if (SpaceTrader.getMainCharacter().canBuy(shieldPrice)
                && SpaceTrader.ship.checkGadget()) {
            SpaceTrader.getMainCharacter().buy(shieldPrice);
            SpaceTrader.ship.increaseShieldLevel(getShields().get(gadgetIndex)
                    .getShieldLevel());
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            SpaceTrader.ship.setGadgets(SpaceTrader.ship.getGadgets() + 1);
            updateText();
        } else if (!SpaceTrader.getMainCharacter().canBuy(shieldPrice)) {
            getSuccessLabel().setText(getNotEnoughCreditsString());
        } else {
            getSuccessLabel().setText("Not enough gadget space!");
        }
    }

    /**
     * handler to upgrade Gadget.
     * @param e the event
     */
    public final void upgradeGadget(final ActionEvent e) {
        final int gadgetSlotPrice = 500;
        if (SpaceTrader.getMainCharacter().canBuy(gadgetSlotPrice)) {
            SpaceTrader.getMainCharacter().buy(gadgetSlotPrice);
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            SpaceTrader.ship.setGadgetslots(SpaceTrader.ship.getGadgetslots()
                    + 1);
            updateTextGadget();
        } else {
            getSuccessLabel().setText(getNotEnoughCreditsString());
        }

    }

    /**
     * Handler to upgrade Weapons.
     * @param e the event
     */
    public final void upgradeWeapon(final ActionEvent e) {
        final ObservableList<String> selectedItem = getGadgetListView().
                getSelectionModel().getSelectedItems();
        int powerLevel = 1;
//        String type = "";
        int gadgetIndex = 0;
        for (int i = 0; i < selectedItem.size(); i++) {
            final String[] temp = selectedItem.get(i).split(" ");
            powerLevel = Integer.parseInt(temp[2]);
//            type = temp[0];
        }

        for (int x = 0; x < getWeapons().size(); x++) {
            if (getWeapons().get(x).getWeaponLevel() == (2 * powerLevel)) {
                gadgetIndex = x;
                break;
            }
        }
        final int weaponPrice = getWeapons().get(gadgetIndex).getPrice();
        if (SpaceTrader.getMainCharacter().canBuy(weaponPrice) && SpaceTrader.
                ship.checkGadget()) {
            SpaceTrader.getMainCharacter().buy(weaponPrice);
            getSuccessLabel().setText(getUpgradeSuccessfulString());
            SpaceTrader.ship.increaseWeaponLevel(getWeapons().get(gadgetIndex).
                    getWeaponLevel());
            SpaceTrader.ship.setGadgets(SpaceTrader.ship.getGadgets() + 1);
            updateText();
        } else if (!SpaceTrader.getMainCharacter().canBuy(weaponPrice)) {
            getSuccessLabel().setText(getNotEnoughCreditsString());
        } else {
            getSuccessLabel().setText("Not enough gadget space!");
        }
    }

    /**
     * Displays the list of shield upgrades.
     * @param e the event
     */
    public final void setShieldButton(final ActionEvent e) {
        getViewGadgetButton().setDisable(false);
        setIsShieldButtonPressed(true);
        setIsWeaponButtonPressed(false);

        setTechLevel(SpaceTrader.currentPlanet.getTechLevel() - 1);
        setShields((ArrayList<Shield>) new ArrayList());
        final ArrayList<String> shieldListString = new ArrayList();
        for (int x = 0; x <= getTechLevel(); x++) {
            getShields().add(new Shield(("Shield Level "
                    + (x + 1)), (2 * (x + 1)),
                    x, (hundo * (x + 1))));
            shieldListString.add(getShields().get(x).getName());
        }
        final ObservableList<String> observable = FXCollections.
                observableArrayList(shieldListString);
        getGadgetListView().setItems(null);
        getGadgetListView().setItems(observable);

    }

    /**
     * Displays the list of weapon upgrades.
     * @param e the event
     */
    public final void setWeaponButton(final ActionEvent e) {
        getViewGadgetButton().setDisable(false);
        setIsWeaponButtonPressed(true);
        setIsShieldButtonPressed(false);

        setTechLevel(SpaceTrader.currentPlanet.getTechLevel() - 1);
        setWeapons((ArrayList<Weapon>) new ArrayList());
        final ArrayList<String> weaponListString = new ArrayList();
        for (int x = 0; x <= getTechLevel(); x++) {
            getWeapons().add(new Weapon(("Weapon Level "
                    + (x + 1)), (2 * (x + 1)),
                    x , (hundo * (x + 1))));
            weaponListString.add(getWeapons().get(x).getName());
        }
        final ObservableList<String> observable = FXCollections.
                observableArrayList(weaponListString);
        getGadgetListView().setItems(null);
        getGadgetListView().setItems(observable);

    }

    /**
     * Displays the gadget information and previews.
     * @param e the event
     */
    public final void viewGadget(final ActionEvent e) {
        if (isIsShieldButtonPressed()) {
            getShieldUpgradeButton().setDisable(false);
        } else {
            getShieldUpgradeButton().setDisable(true);
        }
        if (isIsWeaponButtonPressed()) {
            getWeaponUpgradeButton().setDisable(false);
        } else {
            getWeaponUpgradeButton().setDisable(true);
        }

        final ObservableList<String> selectedItem = getGadgetListView().
                getSelectionModel().getSelectedItems();
        int powerLevel = 1;
        String type = "";
        int shieldPrice = 0;
        int weaponPrice = 0;
        int gadgetIndex = 0;
        int weaponPreview = 0;
        int shieldPreview = 0;

        for (int i = 0; i < selectedItem.size(); i++) {
            final String[] temp = selectedItem.get(i).split(" ");
            powerLevel = Integer.parseInt(temp[2]);
            type = temp[0];
        }

        if ("Shield".equals(type) && (powerLevel == 1 || powerLevel == plvl5)) {
            final String img = "weapon" + (powerLevel) + ".jpg";
            getImageViewMane().setImage(new Image(UpgradeShipScreenController.
                    class.getResourceAsStream(img)));
            for (int x = 0; x < getWeapons().size(); x++) {
                if (getWeapons().get(x).getWeaponLevel() == (2 * powerLevel)) {
                    gadgetIndex = x;
                    weaponPreview = getWeapons().get(x).getWeaponLevel();
                    break;
                }
            }
            weaponPrice = getWeapons().get(gadgetIndex).getPrice();
        } else if ("Weapon".equals(type)) {
            final String img = "weapon" + (powerLevel) + ".png";
            getImageViewMane().setImage(new Image(UpgradeShipScreenController.
                    class.getResourceAsStream(img)));
            for (int x = 0; x < getWeapons().size(); x++) {
                if (getWeapons().get(x).getWeaponLevel() == (2 * powerLevel)) {
                    gadgetIndex = x;
                    weaponPreview = getWeapons().get(x).getWeaponLevel();
                    break;
                }
            }
            weaponPrice = getWeapons().get(gadgetIndex).getPrice();
        }

        if ("Shield".equals(type)) {
            final String img = "shield" + (powerLevel) + ".png";
            getImageViewMane().setImage(new Image(UpgradeShipScreenController.
                    class.getResourceAsStream(img)));
            for (int x = 0; x < getShields().size(); x++) {
                if (getShields().get(x).getShieldLevel() == (2 * powerLevel)) {
                    gadgetIndex = x;
                    shieldPreview = getShields().get(x).getShieldLevel();
                    break;
                }
            }
            shieldPrice = getShields().get(gadgetIndex).getPrice();
        }

        updateText();
        updatePreview(weaponPreview, shieldPreview);
        updatePrice(weaponPrice, shieldPrice);
    }



    /**
     * Updates the credit amount when called.
     */
    public final void updateText() {
        final int creditsINT = SpaceTrader.getMainCharacter().getCredits();
        getCreditLabel().setText("Credit: " + creditsINT);
        getCurrentSlotsLabel().setText("Current Gadget Slots: " + SpaceTrader.
                ship.getGadgetslots());
        getCurrentShipLabel().setText("Current Ship: " + SpaceTrader.ship.
                getShipType() + " | Available Gadget Slots: "
                + (SpaceTrader.ship.getGadgetslots() - SpaceTrader.ship.
                        getGadgets()));
        getCurrentShipPowerLabel().setText("Current Levels: " + "Weapon: "
                + SpaceTrader.ship.getWeaponLevel() + " Shield: " + SpaceTrader.
                        ship.getShieldLevel());

    }

    /**
     * Specific text updater just for previews of the upgrades.
     * @param weaponLevel level of the weapon
     * @param shieldLevel level of the shield
     */
    public final void updatePreview(final int weaponLevel,
            final int shieldLevel) {
        if (weaponLevel != 0) {
            getCurrentShipPowerLabel().setText("Current Levels: " + "Weapon: "
                    + SpaceTrader.ship.getWeaponLevel() + "(+" + weaponLevel
                    + ")" + " Shield: " + SpaceTrader.ship.getShieldLevel());
        } else {
            getCurrentShipPowerLabel().setText("Current Levels: " + "Weapon: "
                    + SpaceTrader.ship.getWeaponLevel() + " Shield: "
                    + SpaceTrader.ship.getShieldLevel() + "(+" + shieldLevel
                    + ")");
        }

    }

    /**
     * specific text updater just when upgrading a gadget.
     */
    public final void updateTextGadget() {
        final int creditsINT = SpaceTrader.getMainCharacter().getCredits();
        getCreditLabel().setText("Credit: " + creditsINT);
        getCurrentSlotsLabel().setText("Current Gadget Slots: " + SpaceTrader.
                ship.getGadgetslots());
        getCurrentShipLabel().setText("Current Ship: " + SpaceTrader.ship.
                getShipType() + " | Available Gadget Slots: "
                + (SpaceTrader.ship.getGadgetslots()
                        - SpaceTrader.ship.getGadgets()));
    }

    /**
     * Specific text updater for prices.
     * @param weaponPrice the weapon price
     * @param shieldPrice the shield price
     */
    public final void updatePrice(final int weaponPrice, final int shieldPrice)
    {
        //String shieldPriceString =
        getShieldPriceLabel().setText(shieldPrice + " Credits");
        getWeaponPriceLabel().setText(weaponPrice + " Credits");
    }

    /**
     * @return the buyFalcon
     */
    public final Button getBuyFalcon() {
        return buyFalcon;
    }

    /**
     * @param buyFalcon the buyFalcon to set
     */
    public final void setBuyFalcon(final Button buyFalcon) {
        this.buyFalcon = buyFalcon;
    }

    /**
     * @return the buyEnterprise
     */
    public final Button getBuyEnterprise() {
        return buyEnterprise;
    }

    /**
     * @param buyEnterprise the buyEnterprise to set
     */
    public final void setBuyEnterprise(final Button buyEnterprise) {
        this.buyEnterprise = buyEnterprise;
    }

    /**
     * @return the buyGalactica
     */
    public final Button getBuyGalactica() {
        return buyGalactica;
    }

    /**
     * @param buyGalactica the buyGalactica to set
     */
    public final void setBuyGalactica(final Button buyGalactica) {
        this.buyGalactica = buyGalactica;
    }

    /**
     * @return the buyDaedalus
     */
    public final Button getBuyDaedalus() {
        return buyDaedalus;
    }

    /**
     * @param buyDaedalus the buyDaedalus to set
     */
    public final void setBuyDaedalus(final Button buyDaedalus) {
        this.buyDaedalus = buyDaedalus;
    }

    /**
     * @return the successLabel
     */
    public final Label getSuccessLabel() {
        return successLabel;
    }

    /**
     * @param successLabel the successLabel to set
     */
    public final void setSuccessLabel(final Label successLabel) {
        this.successLabel = successLabel;
    }

    /**
     * @return the creditLabel
     */
    public final Label getCreditLabel() {
        return creditLabel;
    }

    /**
     * @param creditLabel the creditLabel to set
     */
    public final void setCreditLabel(final Label creditLabel) {
        this.creditLabel = creditLabel;
    }

    /**
     * @return the currentSlotsLabel
     */
    public final Label getCurrentSlotsLabel() {
        return currentSlotsLabel;
    }

    /**
     * @param currentSlotsLabel the currentSlotsLabel to set
     */
    public final void setCurrentSlotsLabel(final Label currentSlotsLabel) {
        this.currentSlotsLabel = currentSlotsLabel;
    }

    /**
     * @return the shieldUpgradeButton
     */
    public final Button getShieldUpgradeButton() {
        return shieldUpgradeButton;
    }

    /**
     * @param shieldUpgradeButton the shieldUpgradeButton to set
     */
    public final void setShieldUpgradeButton(final Button shieldUpgradeButton) {
        this.shieldUpgradeButton = shieldUpgradeButton;
    }

    /**
     * @return the gadgetUpgradeButton
     */
    public final Button getGadgetUpgradeButton() {
        return gadgetUpgradeButton;
    }

    /**
     * @param gadgetUpgradeButton the gadgetUpgradeButton to set
     */
    public final void setGadgetUpgradeButton(final Button gadgetUpgradeButton) {
        this.gadgetUpgradeButton = gadgetUpgradeButton;
    }

    /**
     * @return the weaponUpgradeButton
     */
    public final Button getWeaponUpgradeButton() {
        return weaponUpgradeButton;
    }

    /**
     * @param weaponUpgradeButton the weaponUpgradeButton to set
     */
    public final void setWeaponUpgradeButton(final Button weaponUpgradeButton) {
        this.weaponUpgradeButton = weaponUpgradeButton;
    }

    /**
     * @return the showShipUpgradesButton
     */
    public final Button getShowShipUpgradesButton() {
        return showShipUpgradesButton;
    }

    /**
     * @param showShipUpgradesButton the showShipUpgradesButton to set
     */
    public final void setShowShipUpgradesButton(final Button
            showShipUpgradesButton) {
        this.showShipUpgradesButton = showShipUpgradesButton;
    }

    /**
     * @return the newShipButton
     */
    public final Button getNewShipButton() {
        return newShipButton;
    }

    /**
     * @param newShipButton the newShipButton to set
     */
    public final void setNewShipButton(final Button newShipButton) {
        this.newShipButton = newShipButton;
    }

    /**
     * @return the currentShipLabel
     */
    public final Label getCurrentShipLabel() {
        return currentShipLabel;
    }

    /**
     * @param currentShipLabel the currentShipLabel to set
     */
    public final void setCurrentShipLabel(final Label currentShipLabel) {
        this.currentShipLabel = currentShipLabel;
    }

    /**
     * @return the currentShipPowerLabel
     */
    public final Label getCurrentShipPowerLabel() {
        return currentShipPowerLabel;
    }

    /**
     * @param currentShipPowerLabel the currentShipPowerLabel to set
     */
    public final void setCurrentShipPowerLabel(final Label
            currentShipPowerLabel) {
        this.currentShipPowerLabel = currentShipPowerLabel;
    }

    /**
     * @return the imageViewMane
     */
    public final ImageView getImageViewMane() {
        return imageViewMane;
    }

    /**
     * @param imageViewMane the imageViewMane to set
     */
    public final void setImageViewMane(final ImageView imageViewMane) {
        this.imageViewMane = imageViewMane;
    }

    /**
     * @return the gadgetListView
     */
    public final ListView getGadgetListView() {
        return gadgetListView;
    }

    /**
     * @param gadgetListView the gadgetListView to set
     */
    public final void setGadgetListView(final ListView gadgetListView) {
        this.gadgetListView = gadgetListView;
    }

    /**
     * @return the viewGadgetButton
     */
    public final Button getViewGadgetButton() {
        return viewGadgetButton;
    }

    /**
     * @param viewGadgetButton the viewGadgetButton to set
     */
    public final void setViewGadgetButton(final Button viewGadgetButton) {
        this.viewGadgetButton = viewGadgetButton;
    }

    /**
     * @return the weaponButton
     */
    public final Button getWeaponButton() {
        return weaponButton;
    }

    /**
     * @param weaponButton the weaponButton to set
     */
    public final void setWeaponButton(final Button weaponButton) {
        this.weaponButton = weaponButton;
    }

    /**
     * @return the shieldButton
     */
    public final Button getShieldButton() {
        return shieldButton;
    }

    /**
     * @param shieldButton the shieldButton to set
     */
    public final void setShieldButton(final Button shieldButton) {
        this.shieldButton = shieldButton;
    }

    /**
     * @return the shieldPriceLabel
     */
    public final Label getShieldPriceLabel() {
        return shieldPriceLabel;
    }

    /**
     * @param shieldPriceLabel the shieldPriceLabel to set
     */
    public final void setShieldPriceLabel(final Label shieldPriceLabel) {
        this.shieldPriceLabel = shieldPriceLabel;
    }

    /**
     * @return the weaponPriceLabel
     */
    public final Label getWeaponPriceLabel() {
        return weaponPriceLabel;
    }

    /**
     * @param weaponPriceLabel the weaponPriceLabel to set
     */
    public final void setWeaponPriceLabel(final Label weaponPriceLabel) {
        this.weaponPriceLabel = weaponPriceLabel;
    }

    /**
     * @return the techLevel
     */
    public final int getTechLevel() {
        return techLevel;
    }

    /**
     * @param techLevel the techLevel to set
     */
    public final void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @return the isShieldButtonPressed
     */
    public final boolean isIsShieldButtonPressed() {
        return isShieldButtonPressed;
    }

    /**
     * @param isShieldButtonPressed the isShieldButtonPressed to set
     */
    public final void setIsShieldButtonPressed(final boolean
            isShieldButtonPressed) {
        this.isShieldButtonPressed = isShieldButtonPressed;
    }

    /**
     * @return the isWeaponButtonPressed
     */
    public final boolean isIsWeaponButtonPressed() {
        return isWeaponButtonPressed;
    }

    /**
     * @param isWeaponButtonPressed the isWeaponButtonPressed to set
     */
    public final void setIsWeaponButtonPressed(final boolean
            isWeaponButtonPressed) {
        this.isWeaponButtonPressed = isWeaponButtonPressed;
    }

    /**
     * @return the shields
     */
    public final ArrayList<Shield> getShields() {
        return shields;
    }

    /**
     * @param shields the shields to set
     */
    public final void setShields(final ArrayList<Shield> shields) {
        this.shields = shields;
    }

    /**
     * @return the weapons
     */
    public final ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    /**
     * @param weapons the weapons to set
     */
    public final void setWeapons(final ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    /**
     * @return the upgradeSuccessfulString
     */
    public final String getUpgradeSuccessfulString() {
        return upgradeSuccessfulString;
    }

    /**
     * @param upgradeSuccessfulString the upgradeSuccessfulString to set
     */
    public final void setUpgradeSuccessfulString(final String
            upgradeSuccessfulString) {
        this.upgradeSuccessfulString = upgradeSuccessfulString;
    }

    /**
     * @return the notEnoughCreditsString
     */
    public final String getNotEnoughCreditsString() {
        return notEnoughCreditsString;
    }

    /**
     * @param notEnoughCreditsString the notEnoughCreditsString to set
     */
    public final void setNotEnoughCreditsString(final String
            notEnoughCreditsString) {
        this.notEnoughCreditsString = notEnoughCreditsString;
    }

}
