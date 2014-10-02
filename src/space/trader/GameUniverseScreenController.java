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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void updateText(ActionEvent event) {
        String credits = "Credits: " + SpaceTrader.getMainCharacter().getCredits();
        playerCredits.setText(credits);
    }
    
    @FXML
    public void accessMarketPlace(ActionEvent event) {
        System.out.println("Button press");
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        for (String s: list) {
            System.out.println(s);
        }
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        goods.setItems(null);
        goods.setItems(observable);
    }
    
}
