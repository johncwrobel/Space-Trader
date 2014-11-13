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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class.
 *
 * @author John
 */
public class TraderEncounterScreenController implements Initializable {

    /**
     * @variable tradeButton button to trade
     */
    @FXML
    private Button tradeButton;


    /**
     * @variable ignoreButton button to ignore
     */
    @FXML
    private Button ignoreButton;


    /**
     * @variable fightButton button to fight
     */
    @FXML
    private Button fightButton;


    /**
     * @variable buyButton button to buy
     */
    @FXML
    private Button buyButton;


    /**
     * @variable sellButton button to sell
     */
    @FXML
    private Button sellButton;


    /**
     * @variable playerItems display of the player's items
     */
    @FXML
    private ListView<String> playerItems;


    /**
     * @variable traderItems display of the trader's items
     */
    @FXML
    private ListView<String> traderItems;


    /**
     * @variable dialog the dialog box
     */
    @FXML
    private TextField dialog;


    /**
     * @variable credits the player's credits
     */
    @FXML
    private Text credits;


    /**
     * @variable newPlanet the next planet
     */
    @FXML
    private Planet newPlanet;

    /**
     * Initializes the controller class.
     * @param url yessir
     * @param rb yeah that thing
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {
        getTraderItems().getSelectionModel().selectedItemProperty().
                addListener(new ChangeListener<String>() {
            public void changed(final ObservableValue<? extends String>
                    observable, final String oldValue, final String newValue
            ) { //does nothing
          }
        });
        getBuyButton().setDisable(true);
        getSellButton().setDisable(true);
        getTradeButton().setDisable(false);
        getIgnoreButton().setDisable(false);
        getFightButton().setDisable(false);
    }

    /**
     * Method to handle the trade option.
     * @param event the event
     */
    @FXML
    public final void trade(final ActionEvent event) {
        getPlayerItems().setDisable(false);
        getTraderItems().setDisable(false);
        ArrayList<SolarSystem> solarSystems = SpaceTrader.universe.
                getSolarSystems();
        int randomNumber = (int) (Math.random() * (solarSystems.size()));
        SolarSystem newSolarSystem = solarSystems.get(randomNumber);
        this.setNewPlanet(newSolarSystem.getPlanet(0));
        String dialogString = "Space Sloth: You tryna trade dare mite?";
        getDialog().setText(dialogString);
        getTradeButton().setDisable(true);
        getFightButton().setDisable(true);
        getIgnoreButton().setDisable(false);
        getBuyButton().setDisable(false);
        getSellButton().setDisable(false);
        getIgnoreButton().setText("Go Back");
        updateScreen();
    }

    /**
     * function to buy an item.
     * @param event the event
     */
    @FXML
    public final void buy(final ActionEvent event) {
        final ObservableList<String> selectedItem = getTraderItems().
                getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
//iterate through the selected items
            final String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().
                    canBuy(Integer.parseInt(split[1]))
                    && getNewPlanet().getMarketplace().canBuy(split[0])) {
//check if valid purchase
                getNewPlanet().getMarketplace().buy(split[0]);
                //then actually give them the items
                SpaceTrader.ship.addItem(split[0]);
                SpaceTrader.getMainCharacter().buy(Integer.parseInt(split[1]));
                String dialogString =
                        "Space Sloth: Thats a good trade there mite";
                getDialog().setText(dialogString);
            }
        }
        updateScreen();
    }

    /**
     * Function to sell an Item.
     * @param event the event
     */
    @FXML
    public final void sell(final ActionEvent event) {
        final ObservableList<String> selectedItem = getPlayerItems().
                getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            final String[] temp = selectedItem.get(i).split(" ");
            SpaceTrader.ship.removeItem(temp[0]);
            final int add = Integer.parseInt(temp[1]);
            SpaceTrader.getMainCharacter().sell(add);
            getNewPlanet().getMarketplace().sell(temp[0]);
            String dialogString =
                    "Space Sloth: Oh ye, I definitely wonted that";
            getDialog().setText(dialogString);
        }
        updateScreen();
    }

    /**
     * Method to handle the ignore option.
     * @param event the event
     */
    @FXML
    public final void ignore(final ActionEvent event) {
        getTradeButton().setDisable(false);
        getIgnoreButton().setDisable(false);
        getFightButton().setDisable(false);
        getBuyButton().setDisable(true);
        getSellButton().setDisable(true);
        getPlayerItems().setDisable(true);
        getTraderItems().setDisable(true);
        SpaceTrader.backToMain();
    }

    /**
     * Method to handle the fight option.
     * @param event the event
     */
    @FXML
    public final void fight(final ActionEvent event) {
        String dialogString = "Space Sloth: You tryna start a fight mite?";
        getDialog().setText(dialogString);
        getTradeButton().setDisable(false);
        getIgnoreButton().setDisable(false);
        getFightButton().setDisable(false);
        getBuyButton().setDisable(true);
        getSellButton().setDisable(true);
        SpaceTrader.backToMain();
    }

    /**
     * Method to help update the screen.
     */
    public final void updateScreen() {
        final ArrayList<String> list = getNewPlanet().getMarketplace().
                getDisplay();
        final ObservableList<String> observable = FXCollections.
                observableArrayList(list);
        getTraderItems().setItems(null);
        getTraderItems().setItems(observable);

        final ArrayList<String> list2 = SpaceTrader.getCargo();
        final ObservableList<String> observable2 = FXCollections.
                observableArrayList(list2);
        getPlayerItems().setItems(null);
        getPlayerItems().setItems(observable2);

        updateText();
    }

    /**
     * Method to update the text on the screen.
     */
    public final void updateText() {
        final String creditString = "Credits: " + SpaceTrader.getMainCharacter()
                .getCredits();
        getCredits().setText(creditString);
    }

    /**
     * @return the tradeButton
     */
    public final Button getTradeButton() {
        return tradeButton;
    }

    /**
     * @param tradeButton the tradeButton to set
     */
    public final void setTradeButton(final Button tradeButton) {
        this.tradeButton = tradeButton;
    }

    /**
     * @return the ignoreButton
     */
    public final Button getIgnoreButton() {
        return ignoreButton;
    }

    /**
     * @param ignoreButton the ignoreButton to set
     */
    public final void setIgnoreButton(final Button ignoreButton) {
        this.ignoreButton = ignoreButton;
    }

    /**
     * @return the fightButton
     */
    public final Button getFightButton() {
        return fightButton;
    }

    /**
     * @param fightButton the fightButton to set
     */
    public final void setFightButton(final Button fightButton) {
        this.fightButton = fightButton;
    }

    /**
     * @return the buyButton
     */
    public final Button getBuyButton() {
        return buyButton;
    }

    /**
     * @param buyButton the buyButton to set
     */
    public final void setBuyButton(final Button buyButton) {
        this.buyButton = buyButton;
    }

    /**
     * @return the sellButton
     */
    public final Button getSellButton() {
        return sellButton;
    }

    /**
     * @param sellButton the sellButton to set
     */
    public final void setSellButton(final Button sellButton) {
        this.sellButton = sellButton;
    }

    /**
     * @return the playerItems
     */
    public final ListView<String> getPlayerItems() {
        return playerItems;
    }

    /**
     * @param playerItems the playerItems to set
     */
    public final void setPlayerItems(final ListView<String> playerItems) {
        this.playerItems = playerItems;
    }

    /**
     * @return the traderItems
     */
    public final ListView<String> getTraderItems() {
        return traderItems;
    }

    /**
     * @param traderItems the traderItems to set
     */
    public final void setTraderItems(final ListView<String> traderItems) {
        this.traderItems = traderItems;
    }

    /**
     * @return the dialog
     */
    public final TextField getDialog() {
        return dialog;
    }

    /**
     * @param dialog the dialog to set
     */
    public final void setDialog(final TextField dialog) {
        this.dialog = dialog;
    }

    /**
     * @return the credits
     */
    public final Text getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public final void setCredits(final Text credits) {
        this.credits = credits;
    }

    /**
     * @return the newPlanet
     */
    public final Planet getNewPlanet() {
        return newPlanet;
    }

    /**
     * @param newPlanet the newPlanet to set
     */
    public final void setNewPlanet(final Planet newPlanet) {
        this.newPlanet = newPlanet;
    }
}
