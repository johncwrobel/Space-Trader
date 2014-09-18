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
 *
 * @author John
 */
public class CharacterCreationController implements Initializable {
    
    @FXML
    private TextArea nameTextArea;
    @FXML
    private TextArea pilotTextArea;
    @FXML
    private TextArea fighterTextArea;
    @FXML
    private TextArea traderTextArea;
    @FXML
    private TextArea engineerTextArea;
    @FXML
    private TextArea investorTextArea;
    @FXML
    private Button confirm;
    
    @FXML
    private void confirm(ActionEvent event) {
        String pilotString = pilotTextArea.getText().trim();
        String fighterString = fighterTextArea.getText().trim();
        String traderString = traderTextArea.getText().trim();
        String engineerString = engineerTextArea.getText().trim();
        String investorString = investorTextArea.getText().trim();
        String name = nameTextArea.getText().trim();
        
        if (!isInteger(pilotString) || !isInteger(fighterString) || !isInteger(traderString) || !isInteger(engineerString) || !isInteger(investorString)) {
            JOptionPane.showMessageDialog(null, "One of your inputs is not an integer", "Alert!" , JOptionPane.ERROR_MESSAGE);
        } else {
            int pilot = Integer.parseInt(pilotString);
            int fighter = Integer.parseInt(fighterString);
            int trader = Integer.parseInt(traderString);
            int engineer = Integer.parseInt(engineerString);
            int investor = Integer.parseInt(investorString);
            
            if (pilot + fighter + trader + engineer + investor > 20) {
                JOptionPane.showMessageDialog(null, "You have used too many skill points", "Alert!" , JOptionPane.ERROR_MESSAGE);
            } else if (pilot + fighter + trader + engineer + investor < 20) {
                JOptionPane.showMessageDialog(null, "You have not used all of your skill points, rearrange the skill points", "Alert!" , JOptionPane.ERROR_MESSAGE);
            } else {
                Character myCharacter = new Character(name, pilot, fighter, trader, engineer, investor);
                SpaceTrader.createCharacter(myCharacter);
                JOptionPane.showMessageDialog(null, SpaceTrader.getMainCharacter(), "Your Character" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
}
