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

/**
 *
 * @author John
 */
public class StartScreenController implements Initializable {
    
    @FXML
    private Label Title;
    
    @FXML
    private Button newGameButton;
    
    /**
     * sets the creation scene as the main scene when the button is clicked
     * 
     * @param event 
     */
    @FXML
    private void handleButtonAction(final ActionEvent event) {
        SpaceTrader.setCreationScene();
    }
    
    /**
     * Inializes
     * @param url no idea what this does, honestly
     * @param rb 
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        // TODO
    }    
    
}
