/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javax.swing.JOptionPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import static space.trader.SpaceTrader.ship;


/**
 * FXML Controller class
 *
 * @author John
 */
public class GameUniverseScreenController implements Initializable {

    @FXML
    private Button saveButton;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Label playerCredits;
    
    @FXML
    private ListView<String> goods;
    
    @FXML
    private ListView<String> selling;
    
    @FXML
    private Button buy;
    
    @FXML
    private Button sell;
    
    @FXML
    private ListView<Item> cargo;
    
    @FXML 
    private Label currentSolarSystemLabel;
    
    @FXML
    private Label currentPlanetLabel;
    
    @FXML
    private Label fuelLabel;
    
    @FXML
    private ComboBox<String> planetComboBox;
    
    @FXML
    private Canvas universeDisplayCanvas;
    
    @FXML
    private Label selectedSystemLabel;
    
    @FXML
    private Button travelButton;
    
    @FXML
    private Button jumpButton;
    
    @FXML
    private Button myShipButton;
    
    private SolarSystem selectedSystem = null;
    
    public void save(ActionEvent event) {
        SpaceTrader.save();
        JOptionPane.showMessageDialog(null, "You have saved the game, overriding all previous save data", "Alert!" , JOptionPane.WARNING_MESSAGE);
    }
    
    public void load(ActionEvent event) {
        SpaceTrader.load();
        updateScreen();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goods.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          }
        });
    }
    
    public void travel(ActionEvent event) {
        if (selectedSystem != null) { //make sure they actually selected a planet
            SpaceTrader.travelSolarSystem(selectedSystem);
            if (SpaceTrader.ship.canTravelTo(selectedSystem)) { //fixes bug where encounters occour even when you don't have enough fuel to travel to selected system
                int encounterChance = (int)(Math.random() * 12);
                if ((encounterChance == 0) && !(SpaceTrader.getMainCharacter().getReputation())) { //check for all types of encounters
                    JOptionPane.showMessageDialog(null, "You have encountered the police!", "Alert!" , JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setPoliceEncounterScene();
                } else if ((encounterChance == 0) && (SpaceTrader.getMainCharacter().getReputation())) {
                    JOptionPane.showMessageDialog(null, "You have encountered the police and are wanted!", "Alert!" , JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setPirateEncounterScene();
                } else if (encounterChance == 1) {
                    JOptionPane.showMessageDialog(null, "You have encountered a pirate!", "Alert!" , JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setPirateEncounterScene();
                } else if (encounterChance == 2) {
                    JOptionPane.showMessageDialog(null, "You have encountered a trader!", "Alert!" , JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setTraderEncounterScene();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected a system", "Alert!" , JOptionPane.ERROR_MESSAGE);
        }
        updateScreen(); //update the screen after they've traveled
    }
    
    
    /**
     * updates the text
     */
    private void updateText() { 
        String credits = "Credits: " + SpaceTrader.getMainCharacter().getCredits(); //build everything into strings
        String selected = "Selected Solar System: ";
        String currentSystem = "Current Solar System: " + SpaceTrader.currentSolarSystem.getName();
        String planet = "Current Planet: " + SpaceTrader.currentPlanet.getName() + " Tech level " + SpaceTrader.currentPlanet.getTechLevel();
        String fuel = "fuel: " + SpaceTrader.ship.getFuel();
        if (selectedSystem == null) {
            selected += "none";
        } else {
            selected += selectedSystem.getName();
        }
        playerCredits.setText(credits); //then use those strings to update the labels
        selectedSystemLabel.setText(selected);
        currentSolarSystemLabel.setText(currentSystem);
        currentPlanetLabel.setText(planet);
        fuelLabel.setText(fuel);
    }
    
    /**
     * function to buy an item
     * @param event 
     */
    @FXML
    public void buy (ActionEvent event) {
        ObservableList<String> selectedItem = goods.getSelectionModel().getSelectedItems();
        
        for (int i = 0; i < selectedItem.size(); i++) { //iterate through the selected items
            String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().canBuy(Integer.parseInt(split[1])) &&
                    SpaceTrader.currentPlanet.marketplace.canBuy(split[0])) { //check if valid purchase
                SpaceTrader.currentPlanet.marketplace.buy(split[0]); //then actually give them the items
                SpaceTrader.ship.addItem(split[0]);
                SpaceTrader.getMainCharacter().buy(Integer.parseInt(split[1]));
            }
            
        }
        updateScreen();
    }
    /**
     * Moves player between planets in a solar system
     * @param event 
     */
    @FXML
    public void jump (ActionEvent event) {
        String planetString = planetComboBox.getValue();
        Planet toPlanet = null;
        for (int x = 0; x < SpaceTrader.currentSolarSystem.planets.size(); x++) { //find the planet they want to travel to
            if (planetString.equals(SpaceTrader.currentSolarSystem.planets.get(x).getName())) {
                toPlanet = SpaceTrader.currentSolarSystem.planets.get(x);
            }
        }
        if (toPlanet != null) { //if it's a real selection, put them there
            SpaceTrader.travelPlanet(toPlanet);
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected a Planet", "Alert!" , JOptionPane.ERROR_MESSAGE);
        }
        updateScreen();
    }
    
    /**
     * Function to sell an Item
     * @param event 
     */
    @FXML
    public void sell (ActionEvent event) {
        ObservableList<String> selectedItem = selling.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] temp = selectedItem.get(i).split(" ");
            SpaceTrader.ship.removeItem(temp[0]);
            int add = Integer.parseInt(temp[1]);
            SpaceTrader.getMainCharacter().sell(add);
        }
        
        updateScreen();
    };
    
    /**
     * Function to accessMarketPlace
     * @param event 
     */
    @FXML
    public void accessMarketPlace(ActionEvent event) {
        ObservableList<String> observable = getPlanets();
        for (int x = 0; x < observable.size(); x++) {
            System.out.println(observable.get(x).toString());
        }
        updateScreen();
    }
    
    /**
     * Helper method to update the list of planets
     */
    public ObservableList<String> getPlanets() {
        ArrayList<Planet> planetList = SpaceTrader.currentSolarSystem.planets;
        ArrayList<String> planetString = new ArrayList();
        for (int x = 0; x < planetList.size(); x++) {
            planetString.add(planetList.get(x).getName());
        }
        ObservableList<String> observable = FXCollections.observableArrayList(planetString);
        return observable;
    }
    
    /**
     * Helper method to update the view
     */
    private void updateScreen() {
        GraphicsContext gc = universeDisplayCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 400, 400);
        drawShapes(gc);
        updateText();
        ArrayList<String> list = SpaceTrader.currentPlanet.marketplace.getDisplay();
        ObservableList<String> observable = FXCollections.observableArrayList(list);
        goods.setItems(null);
        goods.setItems(observable);
        
        ArrayList<String> list2 = SpaceTrader.getCargo();
        ObservableList<String> observable2 = FXCollections.observableArrayList(list2);
        selling.setItems(null);
        selling.setItems(observable2);
        
        ArrayList<Item> list3 = SpaceTrader.ship.cargoHold;
        ObservableList<Item> observable3 = FXCollections.observableArrayList(list3);
        cargo.setItems(null);
        cargo.setItems(observable3);
        
        planetComboBox.setItems(null);
        planetComboBox.setItems(getPlanets());
    }
    
    /**
     * Handles the user clicking on new systems
     * @param e 
     */
    public void chooseSystem(MouseEvent e) {
        double xPos = e.getX();
        double yPos = e.getY();
        xPos = (int) xPos/20;
        yPos = (int) yPos/20;
        selectedSystem = SpaceTrader.getSystemFromCoordinate((int) xPos, (int) yPos);
        updateScreen();
        System.out.println("Click: " + xPos + " x, " + yPos + "y");
    }
    
    /**
     * Draws the planets
     * @param gc 
     */
    private void drawShapes(GraphicsContext gc){
        gc.setLineWidth(1);
        gc.setFill(Color.RED);
        gc.setStroke(Color.GREEN);
        int sX = 0;
        int sY = 0;
        for(int x=0; x<=20; x++){
            sX = x * 20;
            gc.strokeLine(sX, 0, sX, 400);
        }
        for(int y=0; y<=20; y++){
            sY = y * 20;               
            gc.strokeLine(0, sY, 400, sY);
        }
        
        for(SolarSystem s: SpaceTrader.universe.solarSystems){
            int x = (s.getXLocation() * 20);
            int y = (s.getYLocation() * 20);
            int w = 20;
            gc.fillOval(x,y,w,w);
            
        }
        int x = (SpaceTrader.currentSolarSystem.getXLocation() * 20);
        int y = (SpaceTrader.currentSolarSystem.getYLocation() * 20);
        int w = 20;
        gc.setFill(Color.BLUE);
        gc.fillOval(x,y,w,w);
        
        
    }
    
}
