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
public class PoliceEncounterScreenController implements Initializable {

    @FXML
    private Label dialogueLabel;
    
    @FXML
    private Button bribeButton;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button fightButton;
    
    @FXML
    private Label bribeAmountLabel;
    
    /**
     * Initializes the controller class.
     * @param url the url
     * @param rb the rb
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        //does nothing
    } 
    
    /**
     * handles the option to bribe the police
     * @param event the event
     */
    @FXML
    public final void bribe(final ActionEvent event) {
        SpaceTrader.getMainCharacter().payBribe();
        SpaceTrader.setGameScene();
    }
    
    /**
     * handles the option to search
     * @param event the event
     */
    @FXML
    public final void search(final ActionEvent event) {
        SpaceTrader.getMainCharacter().consentSearch();
        SpaceTrader.setGameScene();
    }
    
    /**
     * handles the fight option
     * @param event the event
     */
    @FXML
    public final void fight(final ActionEvent event) {
        SpaceTrader.getMainCharacter().setCriminal(true);
        SpaceTrader.setPirateEncounterScene();
    }
    
}
