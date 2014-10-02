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
    
}
