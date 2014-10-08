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
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author John
 */
public class GameUniverseScreenController implements Initializable {

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
    private Button myShipButton;
    
    private SolarSystem selectedSystem = null;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goods.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          }
        });
        
        
        // TODO
    }    
    
    /**
     * updates the text
     */
    private void updateText() {
        String credits = "Credits: " + SpaceTrader.getMainCharacter().getCredits();
        String selected = "Selected Solar System: ";
        String currentSystem = "Current Solar System: " + SpaceTrader.currentSolarSystem.getName();
        String planet = "Current Planet: " + SpaceTrader.currentPlanet.getName() + " Tech level " + SpaceTrader.currentPlanet.getTechLevel();
        String fuel = "fuel: " + SpaceTrader.ship.getFuel();
        if (selectedSystem == null) {
            selected += "none";
        } else {
            selected += selectedSystem.getName();
        }
        playerCredits.setText(credits);
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
        
        for (int i = 0; i < selectedItem.size(); i++) {
            String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().canBuy(Integer.parseInt(split[1])) &&
                    SpaceTrader.currentPlanet.marketplace.canBuy(split[0])) {
                SpaceTrader.currentPlanet.marketplace.buy(split[0]);
                SpaceTrader.ship.addItem(split[0]);
                SpaceTrader.getMainCharacter().buy(Integer.parseInt(split[1]));
            }
            
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
        GraphicsContext gc = universeDisplayCanvas.getGraphicsContext2D();
        drawShapes(gc);
        ObservableList<String> observable = getPlanets();
        for (int x = 0; x < observable.size(); x++) {
            System.out.println(observable.get(x).toString());
        }
        
        updateScreen();
    }
    
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
        
        planetComboBox = new ComboBox(observable);
    }
    
    public void chooseSystem(MouseEvent e) {
        double xPos = e.getX();
        double yPos = e.getY();
        xPos = (int) xPos/20;
        yPos = (int) yPos/20;
        selectedSystem = SpaceTrader.getSystemFromCoordinate((int) xPos, (int) yPos);
        updateScreen();
        System.out.println("Click: " + xPos + " x, " + yPos + "y");
    }
    
    private void drawShapes(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(1);
        gc.strokeLine(0,0,0,400);
        gc.strokeLine(0,0,400,0);
        gc.strokeLine(400,0,400,400);
        gc.strokeLine(0,400,400,400);
        gc.strokeLine(20,0,20,400);
        gc.strokeLine(40,0,40,400);
        gc.strokeLine(60,0,60,400);
        gc.strokeLine(80,0,80,400);
        gc.strokeLine(100,0,100,400);
        gc.strokeLine(120,0,120,400);
        gc.strokeLine(140,0,140,400);
        gc.strokeLine(160,0,160,400);
        gc.strokeLine(180,0,180,400);
        gc.strokeLine(200,0,200,400);
        gc.strokeLine(220,0,220,400);
        gc.strokeLine(240,0,240,400);
        gc.strokeLine(260,0,260,400);
        gc.strokeLine(280,0,280,400);
        gc.strokeLine(300,0,300,400);
        gc.strokeLine(320,0,320,400);
        gc.strokeLine(340,0,340,400);
        gc.strokeLine(360,0,360,400);
        gc.strokeLine(380,0,380,400);
        gc.strokeLine(0,20,400,20);
        gc.strokeLine(0,40,400,40);
        gc.strokeLine(0,60,400,60);
        gc.strokeLine(0,80,400,80);
        gc.strokeLine(0,100,400,100);
        gc.strokeLine(0,120,400,120);
        gc.strokeLine(0,140,400,140);
        gc.strokeLine(0,160,400,160);
        gc.strokeLine(0,180,400,180);
        gc.strokeLine(0,200,400,200);
        gc.strokeLine(0,220,400,220);
        gc.strokeLine(0,240,400,240);
        gc.strokeLine(0,260,400,260);
        gc.strokeLine(0,280,400,280);
        gc.strokeLine(0,300,400,300);
        gc.strokeLine(0,320,400,320);
        gc.strokeLine(0,340,400,340);
        gc.strokeLine(0,360,400,360);
        gc.strokeLine(0,380,400,380);
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
