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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        traderItems.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          }
        });
        
        buyButton.setDisable(true);
        sellButton.setDisable(true);
    }
    
    @FXML
    public void trade (ActionEvent event) {
        String dialogString = "Space Sloth: You tryna trade dare mite?";
        dialog.setText(dialogString);
        fightButton.setDisable(true);
        buyButton.setDisable(false);
        ignoreButton.setText("Go Back");
        updateScreen();
    }
    
    /**
     * function to buy an item
     * @param event 
     */
    @FXML
    public void buy (ActionEvent event) {
        ObservableList<String> selectedItem = traderItems.getSelectionModel().getSelectedItems();
        System.out.println("buy: " + selectedItem);
        for (int i = 0; i < selectedItem.size(); i++) { //iterate through the selected items
            String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().canBuy(Integer.parseInt(split[1])) &&
                    SpaceTrader.currentPlanet.marketplace.canBuy(split[0])) { //check if valid purchase
                SpaceTrader.currentPlanet.marketplace.buy(split[0]); //then actually give them the items
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
    public void sell (ActionEvent event) {
        ObservableList<String> selectedItem = playerItems.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            SpaceTrader.ship.removeItem(temp[0]);
            int add = Integer.parseInt(temp[1]);
            SpaceTrader.getMainCharacter().sell(add);
            SpaceTrader.currentPlanet.marketplace.sell(temp[0]);
            String dialogString = "Space Sloth: Oh ye, I definitely wonted that";
            dialog.setText(dialogString);
        }
        updateScreen();
    }
    
    @FXML
    public void ignore (ActionEvent event) {
        SpaceTrader.backToMain();
    }
    
    @FXML
    public void fight (ActionEvent even) {
        String dialogString = "Space Sloth: You tryna start a fight mite?";
        dialog.setText(dialogString);
    }
    
    public void updateScreen() {
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        traderItems.setItems(null);
        traderItems.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        playerItems.setItems(null);
        playerItems.setItems(observable2);
        
        updateText();
    }
    
    public void updateText() {
        String creditString = "Credits: " + SpaceTrader.getMainCharacter().getCredits();
        credits.setText(creditString);
    }
}
