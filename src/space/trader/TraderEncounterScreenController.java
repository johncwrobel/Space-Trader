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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void trade(ActionEvent event) {
        System.out.println("Trade");
    }
}
