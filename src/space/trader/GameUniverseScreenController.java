/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javax.swing.JOptionPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
//import static space.trader.SpaceTrader.ship;


/**
 * FXML Controller class.
 *
 * @author John
 */
public class GameUniverseScreenController implements Initializable {


    /**
     * @variable saveButton button to save
     */
    @FXML
    private Button saveButton;

    /**
     * @variable loadButton button to load
     */
    @FXML
    private Button loadButton;


    /**
     * @variable playerCredits the player's credits
     */
    @FXML
    private Label playerCredits;


    /**
     * @variable goods the goods, dawg
     */
    @FXML
    private ListView<String> goods;


    /**
     * @variable selling what's being sold
     */
    @FXML
    private ListView<String> selling;


    /**
     * @variable buyButton button to buy
     */
    @FXML
    private Button buyButton;


    /**
     * @variable sellButton button to sell
     */
    @FXML
    private Button sellButton;


    /**
     * @variable cargo ship's cargo
     */
    @FXML
    private ListView<Item> cargo;


    /**
     * @variable currentSolarSystemLabel name says it all
     */
    @FXML
    private Label currentSolarSystemLabel;


    /**
     * @variable currentPlanetLebel you guessed it!
     */
    @FXML
    private Label currentPlanetLabel;


    /**
     * @variable fuelLabel displays current fuel
     */
    @FXML
    private Label fuelLabel;


    /**
     * @variable planetComboBox the dropdown for planets
     */
    @FXML
    private ComboBox<String> planetComboBox;


    /**
     * @variable universeDisplayCanvas what the universe is displayed on
     */
    @FXML
    private Canvas universeDisplayCanvas;


    /**
     * @variable selectedSystemLabel displays selected system
     */
    @FXML
    private Label selectedSystemLabel;


    /**
     * @variable travelButton facilitates traveling
     */
    @FXML
    private Button travelButton;


    /**
     * @variable jumpButton hop around, hop around
     */
    @FXML
    private Button jumpButton;


    /**
     * @variable upgradeShipButton button to upgrade ship
     */
    @FXML
    private Button upgradeShipButton;


    /**
     * @variable start StartGame button
     */
    @FXML
    private Button start;


    /**
     * @variable selectedSystem currently selected system
     */
    private SolarSystem selectedSystem = null;


    /**
     * @variable clock tick tock
     */
    private Timeline clock;


    /**
     * @variable alertString hurray for dumb checkstyle fixes!
     */
    private String alertString = "Alert!";

    /**
     * Method that handles buying fuel.
     * @param e action event parameter
     */
    public final void buyFuel(final ActionEvent e) {
        if (((SpaceTrader.ship.getFuel() + 5) < SpaceTrader.ship.getMaxFuel())
                && (SpaceTrader.getMainCharacter().canBuy(100))) {
            SpaceTrader.ship.addFuel(5);
            SpaceTrader.getMainCharacter().buy(100);
        } else if ((SpaceTrader.ship.getFuel() + 5)
                > SpaceTrader.ship.getMaxFuel()) {
            JOptionPane.showMessageDialog(null,
                    "You do not have enough fuel capacity.", getAlertString(),
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You do not have enough credits.", getAlertString(),
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * @return the saveButton
     */
    public final Button getSaveButton() {
        return saveButton;
    }

    /**
     * @param saveButton the saveButton to set
     */
    public final void setSaveButton(final Button saveButton) {
        this.saveButton = saveButton;
    }

    /**
     * @return the loadButton
     */
    public final Button getLoadButton() {
        return loadButton;
    }

    /**
     * @param loadButton the loadButton to set
     */
    public final void setLoadButton(final Button loadButton) {
        this.loadButton = loadButton;
    }

    /**
     * @return the playerCredits
     */
    public final Label getPlayerCredits() {
        return playerCredits;
    }

    /**
     * @param playerCredits the playerCredits to set
     */
    public final void setPlayerCredits(final Label playerCredits) {
        this.playerCredits = playerCredits;
    }

    /**
     * @return the goods
     */
    public final ListView<String> getGoods() {
        return goods;
    }

    /**
     * @param goods the goods to set
     */
    public final void setGoods(final ListView<String> goods) {
        this.goods = goods;
    }

    /**
     * @return the selling
     */
    public final ListView<String> getSelling() {
        return selling;
    }

    /**
     * @param selling the selling to set
     */
    public final void setSelling(final ListView<String> selling) {
        this.selling = selling;
    }

    /**
     * @return the buyButton
     */
    public final Button getBuyButton() {
        return buyButton;
    }

    /**
     * @param buyButton the buyButton to set
     */
    public final void setBuyButton(final Button buyButton) {
        this.buyButton = buyButton;
    }

    /**
     * @return the sellButton
     */
    public final Button getSellButton() {
        return sellButton;
    }

    /**
     * @param sellButton the sellButton to set
     */
    public final void setSellButton(final Button sellButton) {
        this.sellButton = sellButton;
    }

    /**
     * @return the cargo
     */
    public final ListView<Item> getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public final void setCargo(final ListView<Item> cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the currentSolarSystemLabel
     */
    public final Label getCurrentSolarSystemLabel() {
        return currentSolarSystemLabel;
    }

    /**
     * @param currentSolarSystemLabel the currentSolarSystemLabel to set
     */
    public final void setCurrentSolarSystemLabel(final Label
            currentSolarSystemLabel) {
        this.currentSolarSystemLabel = currentSolarSystemLabel;
    }

    /**
     * @return the currentPlanetLabel
     */
    public final Label getCurrentPlanetLabel() {
        return currentPlanetLabel;
    }

    /**
     * @param currentPlanetLabel the currentPlanetLabel to set
     */
    public final void setCurrentPlanetLabel(final Label currentPlanetLabel) {
        this.currentPlanetLabel = currentPlanetLabel;
    }

    /**
     * @return the fuelLabel
     */
    public final Label getFuelLabel() {
        return fuelLabel;
    }

    /**
     * @param fuelLabel the fuelLabel to set
     */
    public final void setFuelLabel(final Label fuelLabel) {
        this.fuelLabel = fuelLabel;
    }

    /**
     * @return the planetComboBox
     */
    public final ComboBox<String> getPlanetComboBox() {
        return planetComboBox;
    }

    /**
     * @param planetComboBox the planetComboBox to set
     */
    public final void setPlanetComboBox(final ComboBox<String> planetComboBox) {
        this.planetComboBox = planetComboBox;
    }

    /**
     * @return the universeDisplayCanvas
     */
    public final Canvas getUniverseDisplayCanvas() {
        return universeDisplayCanvas;
    }

    /**
     * @param universeDisplayCanvas the universeDisplayCanvas to set
     */
    public final void setUniverseDisplayCanvas(final Canvas
            universeDisplayCanvas) {
        this.universeDisplayCanvas = universeDisplayCanvas;
    }

    /**
     * @return the selectedSystemLabel
     */
    public final Label getSelectedSystemLabel() {
        return selectedSystemLabel;
    }

    /**
     * @param selectedSystemLabel the selectedSystemLabel to set
     */
    public final void setSelectedSystemLabel(final Label selectedSystemLabel) {
        this.selectedSystemLabel = selectedSystemLabel;
    }

    /**
     * @return the travelButton
     */
    public final Button getTravelButton() {
        return travelButton;
    }

    /**
     * @param travelButton the travelButton to set
     */
    public final void setTravelButton(final Button travelButton) {
        this.travelButton = travelButton;
    }

    /**
     * @return the jumpButton
     */
    public final Button getJumpButton() {
        return jumpButton;
    }

    /**
     * @param jumpButton the jumpButton to set
     */
    public final void setJumpButton(final Button jumpButton) {
        this.jumpButton = jumpButton;
    }

    /**
     * @return the upgradeShipButton
     */
    public final Button getUpgradeShipButton() {
        return upgradeShipButton;
    }

    /**
     * @param upgradeShipButton the upgradeShipButton to set
     */
    public final void setUpgradeShipButton(final Button upgradeShipButton) {
        this.upgradeShipButton = upgradeShipButton;
    }

    /**
     * @return the start
     */
    public final Button getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public final void setStart(final Button start) {
        this.start = start;
    }

    /**
     * @return the selectedSystem
     */
    public final SolarSystem getSelectedSystem() {
        return selectedSystem;
    }

    /**
     * @param selectedSystem the selectedSystem to set
     */
    public final void setSelectedSystem(final SolarSystem selectedSystem) {
        this.selectedSystem = selectedSystem;
    }

    /**
     * @return the clock
     */
    public final Timeline getClock() {
        return clock;
    }

    /**
     * @param clock the clock to set
     */
    public final void setClock(final Timeline clock) {
        this.clock = clock;
    }

    /**
     * @return the alertString
     */
    public final String getAlertString() {
        return alertString;
    }

    /**
     * @param alertString the alertString to set
     */
    public final void setAlertString(final String alertString) {
        this.alertString = alertString;
    }

    /**
     * Class to help handle a timer that should help
     * update the screen automatically.
     */
    public class TimeClass implements EventHandler {


        /**
         * Handles the passing of the counter.
         * @param event
         */
        public final void handle(final Event event) {

            updateScreen();
        }
    }

    /**
     * Method to save the game.
     * @param event
     */
    public final void save(final ActionEvent event) {
        SpaceTrader.save();
        JOptionPane.showMessageDialog(null,
                "You have saved the game, overriding all previous save data",
                getAlertString(), JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Method to load the game.
     * @param event
     */
    public final void load(final ActionEvent event) {
        SpaceTrader.load();
        updateScreen();
    }

    /**
     * Initializes the controller class.
     * @param url the url
     * @param rb the resource bundle
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {
        getGoods().getSelectionModel().selectedItemProperty().addListener(new
        ChangeListener<String>() {
            public void changed(final ObservableValue<? extends String>
                    observable, final String oldValue, final String newValue) {
                //does nothing
          }
        });
    }

    /**
     * Handler for traveling.
     * @param event the event
     */
    public final void travel(final ActionEvent event) {
        if (getSelectedSystem() != null) {
            //make sure they actually selected a planet
            SpaceTrader.travelSolarSystem(getSelectedSystem());
            if (SpaceTrader.ship.canTravelTo(getSelectedSystem())) {
                //fixes bug where encounters occour even when you don't
                //have enough fuel to travel to selected system
                final int encounterChance = (int) (Math.random() * 12);
                if ((encounterChance == 0) && !(SpaceTrader.getMainCharacter()
                        .isCriminal())) { //check for all types of encounters
                    JOptionPane.showMessageDialog(null,
                            "You have encountered the police!", getAlertString()
                            , JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setPoliceEncounterScene();
                } else if ((encounterChance == 0) && (SpaceTrader.
                        getMainCharacter().isCriminal())) {
                    JOptionPane.showMessageDialog(null,
                            "You have encountered the police and are wanted!",
                            getAlertString(), JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setPirateEncounterScene();
                } else if (encounterChance == 1) {
                    JOptionPane.showMessageDialog(null,
                            "You have encountered a pirate!", getAlertString(),
                            JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setPirateEncounterScene();
                } else if (encounterChance == 2) {
                    JOptionPane.showMessageDialog(null,
                            "You have encountered a trader!", getAlertString(),
                            JOptionPane.WARNING_MESSAGE);
                    SpaceTrader.setTraderEncounterScene();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected a system"
                    , getAlertString(), JOptionPane.ERROR_MESSAGE);
        }
        updateScreen(); //update the screen after they've traveled
    }


    /**
     * updates the text.
     */
    private void updateText() {
        final String credits = "Credits: " + SpaceTrader.getMainCharacter().
                getCredits(); //build everything into strings
        StringBuffer selected = new StringBuffer("Selected Solar System");
        final String currentSystem = "Current Solar System: " + SpaceTrader.
                currentSolarSystem.getName();
        final String planet = "Current Planet: " + SpaceTrader.currentPlanet.
                getName() + " Tech level " + SpaceTrader.currentPlanet.
                        getTechLevel();
        final String fuel = "fuel: " + SpaceTrader.ship.getFuel();
        if (getSelectedSystem() == null) {
            selected.append("none");
        } else {
            selected.append(getSelectedSystem().getName());
        }
        getPlayerCredits().setText(credits);
//then use those strings to update the labels
        getSelectedSystemLabel().setText(selected.toString());
        getCurrentSolarSystemLabel().setText(currentSystem);
        getCurrentPlanetLabel().setText(planet);
        getFuelLabel().setText(fuel);
        if (SpaceTrader.currentPlanet.getTechLevel() < 4) {
            getUpgradeShipButton().setDisable(true);
        } else {
            getUpgradeShipButton().setDisable(false);
        }
    }

    /**
     * function to buy an item.
     * @param event
     */
    @FXML
    public final void buy(final ActionEvent event) {
        final ObservableList<String> selectedItem = getGoods().
                getSelectionModel().getSelectedItems();

        for (int i = 0; i < selectedItem.size(); i++) {
            //iterate through the selected items
            final String[] split = selectedItem.get(i).split(" ");
            if (SpaceTrader.ship.canAdd() && SpaceTrader.getMainCharacter().
                    canBuy(Integer.parseInt(split[1]))
                    && SpaceTrader.currentPlanet.getMarketplace()
                            .canBuy(split[0])) { //check if valid purchase
                SpaceTrader.currentPlanet.getMarketplace().buy(split[0]);
//then actually give them the items
                SpaceTrader.ship.addItem(split[0]);
                SpaceTrader.getMainCharacter().buy(Integer.parseInt(split[1]));
            }

        }
        updateScreen();
    }
    /**
     * Moves player between planets in a solar system.
     * @param event
     */
    @FXML
    public final void jump(final ActionEvent event) {
        final String planetString = getPlanetComboBox().getValue();
        Planet toPlanet = null;
        for (int x = 0; x < SpaceTrader.currentSolarSystem.planets.size(); x++)
        { //find the planet they want to travel to
            if (planetString.equals(SpaceTrader.currentSolarSystem.planets.
                    get(x).getName())) {
                toPlanet = SpaceTrader.currentSolarSystem.planets.get(x);
            }
        }
        if (toPlanet != null) { //if it's a real selection, put them there
            SpaceTrader.travelPlanet(toPlanet);
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected a Planet"
                    , getAlertString(), JOptionPane.ERROR_MESSAGE);
        }
        updateScreen();
    }

    /**
     * Function to sell an Item.
     * @param event
     */
    @FXML
    public final void sell(final ActionEvent event) {
        final ObservableList<String> selectedItem = getSelling().
                getSelectionModel().getSelectedItems();
        for (int i = 0; i < selectedItem.size(); i++) {
            final String[] temp = selectedItem.get(i).split(" ");
            SpaceTrader.ship.removeItem(temp[0]);
            final int add = Integer.parseInt(temp[1]);
            SpaceTrader.getMainCharacter().sell(add);
        }

        updateScreen();
    };

    /**
     * Function to start the game.
     * @param event
     */
    @FXML
    public final void startGame(final ActionEvent event) {
        final ObservableList<String> observable = getPlanets();

        updateScreen();

        final TimeClass tc = new TimeClass();
        setClock(new Timeline(new KeyFrame(Duration.seconds(1), tc)));
        getClock().setCycleCount(Timeline.INDEFINITE);
        getClock().play();
        getStart().setVisible(false);
    }

    /**
     * Helper method to update the list of planets.
     * @return the list of planets
     */
    public final ObservableList<String> getPlanets() {
        final ArrayList<Planet> planetList = SpaceTrader.currentSolarSystem.
                planets;
        final ArrayList<String> planetString = new ArrayList();
        for (int x = 0; x < planetList.size(); x++) {
            planetString.add(planetList.get(x).getName());
        }
        //final ObservableList<String> observable =
        return FXCollections.observableArrayList(planetString);
        //return observable;
    }

    /**
     * Helper method to update the view.
     */
    private void updateScreen() {
        final GraphicsContext gc = getUniverseDisplayCanvas().
                getGraphicsContext2D();
        gc.clearRect(0, 0, 400, 400);
        drawShapes(gc);
        updateText();
        final ArrayList<String> list = SpaceTrader.currentPlanet.
                getMarketplace().getDisplay();
        final ObservableList<String> observable = FXCollections.
                observableArrayList(list);
        getGoods().setItems(null);
        getGoods().setItems(observable);

        final ArrayList<String> list2 = SpaceTrader.getCargo();
        final ObservableList<String> observable2 = FXCollections.
                observableArrayList(list2);
        getSelling().setItems(null);
        getSelling().setItems(observable2);

        final ArrayList<Item> list3 = SpaceTrader.ship.getCargoHold();
        final ObservableList<Item> observable3 = FXCollections.
                observableArrayList(list3);
        getCargo().setItems(null);
        getCargo().setItems(observable3);

        getPlanetComboBox().setItems(null);
        getPlanetComboBox().setItems(getPlanets());
    }

    /**
     * Handles the user clicking on new systems.
     * @param e
     */
    public final void chooseSystem(final MouseEvent e) {
        double xPos = e.getX();
        double yPos = e.getY();
        xPos = (int) xPos / 20;
        yPos = (int) yPos / 20;
        setSelectedSystem(SpaceTrader.getSystemFromCoordinate((int) xPos,
                (int) yPos));
        updateScreen();
    }

    /**
     * Changes the scene to the upgrade ship screen.
     * @param e the event
     */
    public final void upgradeShip(final ActionEvent e) {
        SpaceTrader.setUpgradeShipScene();
    }

    /**
     * Draws the planets.
     * @param gc
     */
    private void drawShapes(final GraphicsContext gc) {
        gc.setLineWidth(1);
        gc.setFill(Color.RED);
        gc.setStroke(Color.GREEN);
        int sX = 0;
        int sY = 0;

        for (int x = 0; x <= 20; x++) {
            sX = x * 20;
            gc.strokeLine(sX, 0, sX, 400);
        }
        for (int y = 0; y <= 20; y++) {
            sY = y * 20;
            gc.strokeLine(0, sY, 400, sY);
        }

        for (SolarSystem s : SpaceTrader.universe.getSolarSystems()) {
            int x = (s.getXLocation() * 20);
            int y = (s.getYLocation() * 20);
            int w = 20;
            gc.fillOval(x, y, w, w);

        }
        int x = (SpaceTrader.currentSolarSystem.getXLocation() * 20);
        int y = (SpaceTrader.currentSolarSystem.getYLocation() * 20);
        int w = 20;
        gc.setFill(Color.BLUE);
        gc.fillOval(x, y, w, w);


    }

}
