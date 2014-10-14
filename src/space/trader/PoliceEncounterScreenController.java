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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    /**
     * causing an error

    public void bribe(ActionEvent event) {
        SpaceTrader.getMainCharacter().payBribe();
        SpaceTrader.setGameScene();
    }
    */
    
}
