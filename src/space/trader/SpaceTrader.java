/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
    private static Scene characterCreationScene;
    private static Scene gameScreen;
    private static Scene policeEncounterScene;
    private static Scene traderEncounterScene;
    private static Scene pirateEncounterScene;
    private static Scene upgradeShipScene;
    private static CharacterInterface myCharacter;
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
        Parent policeEncounter = FXMLLoader.load(getClass().getResource("PoliceEncounterScreen.fxml"));//make the Parents to load
        Parent traderEncounter = FXMLLoader.load(getClass().getResource("TraderEncounterScreen.fxml"));//encounters
        Parent pirateEncounter = FXMLLoader.load(getClass().getResource("PirateEncounterScreen.fxml"));
        Parent upgradeShipStore = FXMLLoader.load(getClass().getResource("UpgradeShipScreen.fxml"));
        
        main = new Scene(root);
        gameScreen = new Scene(game);
        characterCreationScene = new Scene(character);
        policeEncounterScene = new Scene(policeEncounter); //making the Scenes for encounters
        traderEncounterScene = new Scene(traderEncounter);
        pirateEncounterScene = new Scene(pirateEncounter);
        upgradeShipScene = new Scene(upgradeShipStore);
        PrimaryStage = stage;
        PrimaryStage.setScene(main);
        PrimaryStage.show();
    }
    
    /**
     * sets the scene to the characterCreation scene
     */
    public static void setCreationScene() {
        PrimaryStage.setScene(characterCreationScene);
    }
    
    public static SolarSystem getSystemFromCoordinate(int x, int y) {
        return universe.getSystem(x, y);
    }
    
    public static void travelSolarSystem(SolarSystem system) {
        if (ship.canTravelTo(system)) {
            ship.travel(system.getPlanet(0));
        } else {
             JOptionPane.showMessageDialog(null, "You do not have enough fuel", "Alert!" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void travelPlanet(Planet planet) {
        if (ship.canTravelTo(planet)) {
            ship.travel(planet);
        } else {
            JOptionPane.showMessageDialog(null, "You do not have enough fuel", "Alert!" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void save() {
        try {
            OutputStream fChar = new FileOutputStream("char.ser");
            OutputStream fUniverse = new FileOutputStream("uni.ser");
            OutputStream fSolar = new FileOutputStream("sol.ser");
            OutputStream fPlanet = new FileOutputStream("plan.ser");
            OutputStream fShip = new FileOutputStream("ship.ser");
            
            OutputStream bChar = new BufferedOutputStream(fChar);
            OutputStream bUniverse = new BufferedOutputStream(fUniverse);
            OutputStream bSolar = new BufferedOutputStream(fSolar);
            OutputStream bPlanet = new BufferedOutputStream(fPlanet);
            OutputStream bShip = new BufferedOutputStream(fShip);
            
            ObjectOutput oChar = new ObjectOutputStream(bChar);
            ObjectOutput oUniverse = new ObjectOutputStream(bUniverse);
            ObjectOutput oSolar = new ObjectOutputStream(bSolar);
            ObjectOutput oPlanet = new ObjectOutputStream(bPlanet);
            ObjectOutput oShip = new ObjectOutputStream(bShip);
            
            oChar.writeObject(myCharacter);
            oUniverse.writeObject(universe);
            oSolar.writeObject(currentSolarSystem);
            oPlanet.writeObject(currentPlanet);
            oShip.writeObject(ship);
            
            oChar.close();
            oUniverse.close();
            oSolar.close();
            oPlanet.close();
            oShip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void load() {
        try {
            InputStream fChar = new FileInputStream("char.ser");
            InputStream fUniverse = new FileInputStream("uni.ser");
            InputStream fSolar = new FileInputStream("sol.ser");
            InputStream fPlanet = new FileInputStream("plan.ser");
            InputStream fShip = new FileInputStream("ship.ser");
            
            InputStream bChar = new BufferedInputStream(fChar);
            InputStream bUniverse = new BufferedInputStream(fUniverse);
            InputStream bSolar = new BufferedInputStream(fSolar);
            InputStream bPlanet = new BufferedInputStream(fPlanet);
            InputStream bShip = new BufferedInputStream(fShip);
            
            ObjectInput oChar = new ObjectInputStream(bChar);
            ObjectInput oUniverse = new ObjectInputStream(bUniverse);
            ObjectInput oSolar = new ObjectInputStream(bSolar);
            ObjectInput oPlanet = new ObjectInputStream(bPlanet);
            ObjectInput oShip = new ObjectInputStream(bShip);
            
            myCharacter = (Character) oChar.readObject();
            universe = (Universe) oUniverse.readObject();
            currentSolarSystem = (SolarSystem) oSolar.readObject();
            currentPlanet = (Planet) oPlanet.readObject();
            ship = (Ship) oShip.readObject();
            
            oChar.close();
            oUniverse.close();
            oSolar.close();
            oPlanet.close();
            oShip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * sets the scene to the characterCreation scene
     */
    public static void setGameScene() {
        PrimaryStage.setScene(gameScreen);
        //GameUniverseScreenController.initializeScreen();
    }
    
    /**
     * creates a new Universe
     */
    private static void createNewUniverse() {
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
     * sets the scene to the title scene
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
    public static CharacterInterface getMainCharacter() {
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
     * Set Scene to police encounter screen
     */
    public static void setPoliceEncounterScene() {
        PrimaryStage.setScene(policeEncounterScene);
    }
    
    /**
     * Set Scene to trader encounter screen
     */
    public static void setTraderEncounterScene() {
        PrimaryStage.setScene(traderEncounterScene);
    }
    
    /**
     * Set Scene to pirate encounter screen
     */
    public static void setPirateEncounterScene() {
        PrimaryStage.setScene(pirateEncounterScene);
    }
    
    /**
     * Set Scene back to the game scene
     */
    public static void backToMain() {
        PrimaryStage.setScene(gameScreen);
    }
    
    public static void setUpgradeShipScene() {
        PrimaryStage.setScene(upgradeShipScene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
