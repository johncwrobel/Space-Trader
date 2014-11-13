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
//import javafx.application.Application;

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
    private Button confirmButton;
    
    /**
     * Takes the data from the text area, 
     * validates it and creates a Character object if valid.
     *
     * @param event ActionEvent for the listener
     */
    @FXML
    private void confirm(final ActionEvent event) {
        final String pilotString = getPilotTextArea().getText().trim();
        final String fighterString = getFighterTextArea().getText().trim();
        final String traderString = getTraderTextArea().getText().trim();
        final String engineerString = getEngineerTextArea().getText().trim();
        final String investorString = getInvestorTextArea().getText().trim();
        final String name = getNameTextArea().getText().trim();
        
        if (!isInteger(pilotString) || !isInteger(fighterString) ||
                !isInteger(traderString) || !isInteger(engineerString) ||
                !isInteger(investorString)) {
            JOptionPane.showMessageDialog(null,
                    "One of your inputs is not an integer", "Alert!" ,
                    JOptionPane.ERROR_MESSAGE);
        } else {
            final int pilot = Integer.parseInt(pilotString);
            final int fighter = Integer.parseInt(fighterString);
            final int trader = Integer.parseInt(traderString);
            final int engineer = Integer.parseInt(engineerString);
            final int investor = Integer.parseInt(investorString);
            
            if (pilot + fighter + trader + engineer + investor > 20) {
                JOptionPane.showMessageDialog(null,
                        "You have used too many skill points", "Alert!" ,
                        JOptionPane.ERROR_MESSAGE);
            } else if (pilot + fighter + trader + engineer + investor < 20) {
                JOptionPane.showMessageDialog(null,
                        "You have not used all of your skill points, rearrange"
                                + " the skill points", "Alert!" 
                        , JOptionPane.ERROR_MESSAGE);
            } else {
                final Character myCharacter = new Character(name, pilot,
                        fighter, trader, engineer, investor);
                SpaceTrader.createCharacter(myCharacter);
          //      SpaceTrader.createNewUniverse();
                SpaceTrader.setGameScene();
                SpaceTrader.printUniverse();
            }
        }
    }
    
    /**
     * Goes back to title screen.
     * @param event 
     */
    @FXML
    private void cancel(final ActionEvent event) {
        SpaceTrader.setTitleScene();
    }
    
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {
//all of this sets up and plays the music
            final URL resource = getClass().getResource("backgroundMusic.mp3");
            //change the string to change the music file used
            final Media music = new Media(resource.toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
            //this is the line that loops the mp3 indefinitely
            mediaPlayer.play();
    }
    
    /**
     * Checks if s is an integer.
     * 
     * @param s a String
     * @return true if s is an integer, false otherwise
     */
    private static boolean isInteger(final String s) {
        boolean toReturn;
        try { 
            Integer.parseInt(s);
            toReturn = true;
        } catch(NumberFormatException e) { 
            toReturn = false; 
        }
        return toReturn;
    }

    /**
     * @return the nameTextArea
     */
    final public TextArea getNameTextArea() {
        return nameTextArea;
    }

    /**
     * @param nameTextArea the nameTextArea to set
     */
    final public void setNameTextArea(final TextArea nameTextArea) {
        this.nameTextArea = nameTextArea;
    }

    /**
     * @return the pilotTextArea
     */
    final public TextArea getPilotTextArea() {
        return pilotTextArea;
    }

    /**
     * @param pilotTextArea the pilotTextArea to set
     */
    final public void setPilotTextArea(final TextArea pilotTextArea) {
        this.pilotTextArea = pilotTextArea;
    }

    /**
     * @return the fighterTextArea
     */
    final public TextArea getFighterTextArea() {
        return fighterTextArea;
    }

    /**
     * @param fighterTextArea the fighterTextArea to set
     */
    final public void setFighterTextArea(final TextArea fighterTextArea) {
        this.fighterTextArea = fighterTextArea;
    }

    /**
     * @return the traderTextArea
     */
    final public TextArea getTraderTextArea() {
        return traderTextArea;
    }

    /**
     * @param traderTextArea the traderTextArea to set
     */
    final public void setTraderTextArea(final TextArea traderTextArea) {
        this.traderTextArea = traderTextArea;
    }

    /**
     * @return the engineerTextArea
     */
    final public TextArea getEngineerTextArea() {
        return engineerTextArea;
    }

    /**
     * @param engineerTextArea the engineerTextArea to set
     */
    final public void setEngineerTextArea(final TextArea engineerTextArea) {
        this.engineerTextArea = engineerTextArea;
    }

    /**
     * @return the investorTextArea
     */
    final public TextArea getInvestorTextArea() {
        return investorTextArea;
    }

    /**
     * @param investorTextArea the investorTextArea to set
     */
    final public void setInvestorTextArea(final TextArea investorTextArea) {
        this.investorTextArea = investorTextArea;
    }

    /**
     * @return the confirmButton
     */
    final public Button getConfirmButton() {
        return confirmButton;
    }

    /**
     * @param confirmButton the confirmButton to set
     */
    final public void setConfirmButton(final Button confirmButton) {
        this.confirmButton = confirmButton;
    }
    
}
