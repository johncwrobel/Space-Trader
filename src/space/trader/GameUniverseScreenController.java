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
    private ListView<String> cargo;
    
    @FXML
    private Button buy;
    
    @FXML
    private Button sell;
    
    @FXML
    private TextField buyText;
    
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
    
    private void updateText() {
        String credits = "Credits: " + SpaceTrader.getMainCharacter().getCredits();
        playerCredits.setText(credits);
    }
    
    @FXML
    public void buy (ActionEvent event) {
        ObservableList<String> selectedItem = goods.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            
        }
    }
    
    @FXML
    public void sell (ActionEvent event) {
        ObservableList<String> selectedItem = cargo.getSelectionModel().getSelectedItems();
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
        cargo.setItems(null);
        cargo.setItems(observable2);
        
        System.out.println("sell method works on click");
    };
    
    @FXML
    public void accessMarketPlace(ActionEvent event) {
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        goods.setItems(null);
        goods.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        cargo.setItems(null);
        cargo.setItems(observable2);
        
        
    }
    
}
