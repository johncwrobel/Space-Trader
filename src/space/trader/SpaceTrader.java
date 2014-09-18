/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author John
 */
public class SpaceTrader extends Application {
    
    private static Stage PrimaryStage;
    private static Scene main;
    private static Scene characterCreation;
    private static Character myCharacter;
    
    /**
     * starts the main application by loading the scenes and the primary stage
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        Parent character = FXMLLoader.load(getClass().getResource("CharacterCreation.fxml"));
        
        main = new Scene(root);
        characterCreation = new Scene(character);
        PrimaryStage = stage;
        PrimaryStage.setScene(main);
        PrimaryStage.show();
    }
    
    /**
     * sets the scene to the characterCreation scene
     */
    public static void setCreationScene() {
        PrimaryStage.setScene(characterCreation);
    }
    
    /**
     * sets myCharacter to the parameter passed in
     * 
     * @param character 
     */
    public static void createCharacter(Character character) {
        myCharacter = character;
    }
    
    /**
     * Returns the character
     * 
     * @return 
     */
    public static Character getMainCharacter() {
        return myCharacter;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
