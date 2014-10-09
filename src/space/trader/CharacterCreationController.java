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

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Application;

/**
 *
 * @author Tanmay/Ben/John/Thomas
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
    
    /**
     * Takes the data from the text area, validates it and creates a Character object if valid
     * 
     * @param event ActionEvent for the listener
     */
    @FXML
    private void confirm(ActionEvent event) throws Exception {
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
          //      SpaceTrader.createNewUniverse();
                SpaceTrader.setGameScene();
                SpaceTrader.printUniverse();
                System.out.println(SpaceTrader.getMainCharacter());
            }
        }
    }
    
    /**
     * Goes back to title screen
     * @param event 
     */
    @FXML
    private void cancel(ActionEvent event) {
        SpaceTrader.setTitleScene();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{ //all of this sets up and plays the music
            final URL resource = getClass().getResource("backgroundMusic.mp3"); //change the string to change the music file used
            Media music = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE); //this is the line that loops the mp3 indefinitely
            mediaPlayer.play();
        }catch(Exception e){
        }
    }
    
    /**
     * Checks if s is an integer
     * 
     * @param String s
     * @return true if s is an integer, false otherwise
     */
    private static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
}
