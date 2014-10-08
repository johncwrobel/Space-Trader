/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Tanmay
 */
public class SpaceTrader extends Application {
    
    private static Stage PrimaryStage;
    private static Scene main;
    private static Scene characterCreation;
    private static Scene gameScreen;
    private static Character myCharacter;
    public static Universe universe;
    public static SolarSystem currentSolarSystem;
    public static Planet currentPlanet;
    public static Ship ship = new  Ship();
    
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
        createNewUniverse();
        Parent game = FXMLLoader.load(getClass().getResource("GameUniverseScreen.fxml"));
        
        main = new Scene(root);
        gameScreen = new Scene(game);
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
    
    public static SolarSystem getSystemFromCoordinate(int x, int y) {
        return universe.getSystem(x, y);
    }
    
    public static void travel(SolarSystem system) {
        if (ship.canTravelTo(system)) {
            ship.travel(system.getPlanet(0));
        } else {
             JOptionPane.showMessageDialog(null, "You do not have enough fuel", "Alert!" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * sets the scene to the characterCreation scene
     */
    public static void setGameScene() throws Exception {
        PrimaryStage.setScene(gameScreen);
        //GameUniverseScreenController.initializeScreen();
    }
    
    /**
     * creates a new Universe
     */
    public static void createNewUniverse() {
        universe = new Universe();
        currentPlanet = universe.homePlanet;
        currentSolarSystem = universe.homeSolarSystem;
    }
    
    /**
     * prints the Universe
     */
    public static void printUniverse() {
        System.out.println(universe);
    }
    
    /**
     * sets the scene to the characterCreation scene
     */
    public static void setTitleScene() {
        PrimaryStage.setScene(main);
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
     * getter Method for the Cargo
     * @return an ArrayList of String Item names
     */
    public static ArrayList<String> getCargo() {
        ArrayList<Item> cargo = ship.cargoHold;
        ArrayList<String> cargoDisplay = new ArrayList<>();
        MarketPlace market = currentPlanet.marketplace;
        for (int i = 0; i < cargo.size(); i++) {
            if (market.canSell(cargo.get(i))) {
                cargoDisplay.add(cargo.get(i).toString() + ": " + market.getSellingPrice(cargo.get(i)) + " credits");
            }
        }
        return cargoDisplay;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
