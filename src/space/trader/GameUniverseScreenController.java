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
import javafx.scene.control.*;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author John
 */
public class GameUniverseScreenController implements Initializable {

    @FXML
    private Label playerCredits;
    
    @FXML
    private ListView<String> goods;
    
    @FXML
    private ListView<String> selling;
    
    @FXML
    private Button buy;
    
    @FXML
    private Button sell;
    
    @FXML
    private ListView<Item> cargo;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goods.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          }
        });
        // TODO
    }    
    
    /**
     * updates the text
     */
    private void updateText() {
        String credits = "Credits: " + SpaceTrader.getMainCharacter().getCredits();
        playerCredits.setText(credits);
    }
    
    /**
     * function to buy an item
     * @param event 
     */
    @FXML
    public void buy (ActionEvent event) {
        ObservableList<String> selectedItem = goods.getSelectionModel().getSelectedItems();
        
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().canBuy(Integer.parseInt(split[1])) &&
                    SpaceTrader.currentPlanet.marketplace.canBuy(split[0])) {
                SpaceTrader.currentPlanet.marketplace.buy(split[0]);
                SpaceTrader.ship.addItem(split[0]);
                SpaceTrader.getMainCharacter().buy(Integer.parseInt(split[1]));
            }
            
        }
        
        updateText();
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        goods.setItems(null);
        goods.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        selling.setItems(null);
        selling.setItems(observable2);
        
        ArrayList<Item> list3 = SpaceTrader.ship.cargoHold;
        ObservableList<Item> observable3 = FXCollections.observableArrayList(list3);
        cargo.setItems(null);
        cargo.setItems(observable3);
        
        for (int x = 0; x < SpaceTrader.ship.cargoHold.size(); x++) {
            System.out.println(SpaceTrader.ship.cargoHold.get(x).toString());
        }
    }
    
    /**
     * Function to sell an Item
     * @param event 
     */
    @FXML
    public void sell (ActionEvent event) {
        ObservableList<String> selectedItem = selling.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            SpaceTrader.ship.removeItem(temp[0]);
            int add = Integer.parseInt(temp[1]);
            SpaceTrader.getMainCharacter().sell(add);
        }
        
        updateText();
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        goods.setItems(null);
        goods.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        selling.setItems(null);
        selling.setItems(observable2);
        
        ArrayList<Item> list3 = SpaceTrader.ship.cargoHold;
        ObservableList<Item> observable3 = FXCollections.observableArrayList(list3);
        cargo.setItems(null);
        cargo.setItems(observable3);
    };
    
    /**
     * Function to accessMarketPlace
     * @param event 
     */
    @FXML
    public void accessMarketPlace(ActionEvent event) {
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        goods.setItems(null);
        goods.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        selling.setItems(null);
        selling.setItems(observable2);
        
        ArrayList<Item> list3 = SpaceTrader.ship.cargoHold;
        ObservableList<Item> observable3 = FXCollections.observableArrayList(list3);
        cargo.setItems(null);
        cargo.setItems(observable3);
        
    }
    
}
