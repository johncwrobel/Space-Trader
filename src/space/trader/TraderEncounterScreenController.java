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
 * FXML Controller class
 *
 * @author John
 */
public class TraderEncounterScreenController implements Initializable {
    
    @FXML
    private Button tradeButton;
    
    @FXML
    private Button ignoreButton;
    
    @FXML
    private Button fightButton;
    
    @FXML
    private Button buyButton;
    
    @FXML
    private Button sellButton;
    
    @FXML
    private ListView<String> playerItems;
            
    @FXML
    private ListView<String> traderItems;
    
    @FXML
    private TextField dialog;
    
    @FXML
    private Text credits;
    
    @FXML
    private Planet newPlanet;
    
    /**
     * Initializes the controller class.
     * @param url yessir
     * @param rb yeah that thing
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {
        traderItems.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
          }
        });
        buyButton.setDisable(true);
        sellButton.setDisable(true);
        tradeButton.setDisable(false);
        ignoreButton.setDisable(false);
        fightButton.setDisable(false);
    }
    
    /**
     * Method to handle the trade option
     * @param event 
     */
    @FXML
    public final void trade (final ActionEvent event) {
        playerItems.setDisable(false);
        traderItems.setDisable(false);
        ArrayList<SolarSystem> solarSystems = SpaceTrader.universe.solarSystems;
        int randomNumber = (int)(Math.random() * (solarSystems.size()));
        SolarSystem newSolarSystem = solarSystems.get(randomNumber);
        this.newPlanet = newSolarSystem.getPlanet(0);
        String dialogString = "Space Sloth: You tryna trade dare mite?";
        dialog.setText(dialogString);
        tradeButton.setDisable(true);
        fightButton.setDisable(true);
        ignoreButton.setDisable(false);
        buyButton.setDisable(false);
        sellButton.setDisable(false);
        ignoreButton.setText("Go Back");
        updateScreen();
    }
    
    /**
     * function to buy an item
     * @param event 
     */
    @FXML
    public final void buy (final ActionEvent event) {
        ObservableList<String> selectedItem = traderItems.getSelectionModel().getSelectedItems();
        System.out.println("buy: " + selectedItem);
        for (int i = 0; i < selectedItem.size(); i++) { //iterate through the selected items
            String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().canBuy(Integer.parseInt(split[1])) &&
                    newPlanet.marketplace.canBuy(split[0])) { //check if valid purchase
                newPlanet.marketplace.buy(split[0]); //then actually give them the items
                SpaceTrader.ship.addItem(split[0]);
                SpaceTrader.getMainCharacter().buy(Integer.parseInt(split[1]));
                String dialogString = "Space Sloth: Thats a good trade there mite";
                dialog.setText(dialogString);
            }
        }
        updateScreen();
    }
    
    /**
     * Function to sell an Item
     * @param event 
     */
    @FXML
    public final void sell (final ActionEvent event) {
        ObservableList<String> selectedItem = playerItems.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            SpaceTrader.ship.removeItem(temp[0]);
            int add = Integer.parseInt(temp[1]);
            SpaceTrader.getMainCharacter().sell(add);
            newPlanet.marketplace.sell(temp[0]);
            String dialogString = "Space Sloth: Oh ye, I definitely wonted that";
            dialog.setText(dialogString);
        }
        updateScreen();
    }
    
    /**
     * Method to handle the ignore option
     * @param event 
     */
    @FXML
    public final void ignore (final ActionEvent event) {
        tradeButton.setDisable(false);
        ignoreButton.setDisable(false);
        fightButton.setDisable(false);
        buyButton.setDisable(true);
        sellButton.setDisable(true);
        playerItems.setDisable(true);
        traderItems.setDisable(true);
        SpaceTrader.backToMain();
    }
    
    /**
     * Method to handle the fight option
     * @param even 
     */
    @FXML
    public final void fight (final ActionEvent even) {
        String dialogString = "Space Sloth: You tryna start a fight mite?";
        dialog.setText(dialogString);
        System.out.println("Fight");
        tradeButton.setDisable(false);
        ignoreButton.setDisable(false);
        fightButton.setDisable(false);
        buyButton.setDisable(true);
        sellButton.setDisable(true);
        SpaceTrader.backToMain();
    }
    
    /**
     * Method to help update the screen
     */
    public final void updateScreen() {
        ArrayList<String> list = newPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        traderItems.setItems(null);
        traderItems.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        playerItems.setItems(null);
        playerItems.setItems(observable2);
        
        updateText();
    }
    
    /**
     * Method to update the text on the screen
     */
    public final void updateText() {
        String creditString = "Credits: " + SpaceTrader.getMainCharacter().getCredits();
        credits.setText(creditString);
    }
}
