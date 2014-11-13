/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class.
 *
 * @author John
 */
public class PirateEncounterScreenController implements Initializable {

    /**
     * twenty.
     */
    private final int twenty = 20;
    /**
     * offset.
     */
    private final int offset = 10;
    /**
     * rectSize.
     */
    private final int rectSize = 400;
    /**
     * price.
     */
    private final int price = 300;

    /**
     * @variable canvas where the game is displayed
     */
    @FXML
    private Canvas canvas;

    /**
     * @variable time label to show the time
     */
    @FXML
    private Label time;


    /**
     * @variable start button to start game
     */
    @FXML
    private Button start;


    /**
     * @variable timer amount of time to play game
     */
    private int timer = 3;

    /**
     * @variable clock the time keeper
     */
    private Timeline clock;

    /**
     * @variable target helps shooting
     */
    private boolean[][] target = new boolean[twenty][twenty];

    /**
     * @variable playing shows if player is playing
     */
    private boolean playing = false;




    /**
     * Initializes the controller class.
     * @param url the url
     * @param rb the resource bundle
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        //does nothing

    }

    /**
     * Draws all of the planets on the canvas.
     */
    public final void updateCanvas() {
        final GraphicsContext gc = getCanvas().getGraphicsContext2D();
        gc.clearRect(0, 0, rectSize, rectSize);
        for (int i = 0; i < getTarget().length; i++) {
            for (int j = 0; j < getTarget()[0].length; j++) {
                if (getTarget()[i][j]) {
                    gc.fillRect(i * twenty, j * twenty, twenty, twenty);
                }
            }
        }
    }

    /**
     * @return the canvas
     */
    public final Canvas getCanvas() {
        return canvas;
    }

    /**
     * @param canvas the canvas to set
     */
    public final void setCanvas(final Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * @return the time
     */
    public final Label getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public final void setTime(final Label time) {
        this.time = time;
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
     * @return the timer
     */
    public final int getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public final void setTimer(final int timer) {
        this.timer = timer;
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
     * @return the target
     */
    public final boolean[][] getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public final void setTarget(final boolean[][] target) {
        final boolean[][] assignArray = target;
        this.target = assignArray;
    }

    /**
     * @return the playing
     */
    public final boolean isPlaying() {
        return playing;
    }

    /**
     * @param playing the playing to set
     */
    public final void setPlaying(final boolean playing) {
        this.playing = playing;
    }

    /**
     * TimeClass to update screen and keep track of time.
     */
    public class TimeClass implements EventHandler {

        /**
         * @variable counter the counter for the clock
         */
        private int counter;

        /**
         * Constructor for the TimeClass.
         * @param count the counter
         */
        public TimeClass(final int count) {
            counter = count;
        }

        @Override
        public final void handle(final Event event) {

            if (getCounter() >= 1) {
                getTime().setText("TIMER: " + getCounter() + " seconds");
            } else {
                getClock().stop();
                getTime().setText("GAME OVER");
                if (hasWon()) {
                    getTime().setText("You Win");
                }
                setPlaying(false);
                SpaceTrader.getMainCharacter().buy(price);
                SpaceTrader.setGameScene();
            }
            setCounter(getCounter() - 1);
        }

        /**
         * @return the counter
         */
        public final int getCounter() {
            return counter;
        }

        /**
         * @param counter the counter to set
         */
        public final void setCounter(final int counter) {
            this.counter = counter;
        }
    }

    /**
     * Clears the rectangle.
     */
    public final void clearRect() {
        for (int i = 0; i < getTarget().length; i++) {
            for (int j = 0; j < getTarget()[0].length; j++) {
                getTarget()[i][j] = false;
            }
        }
    }

    /**
     * Handler to start the game.
     * @param e the event
     */
    public final void startGame(final ActionEvent e) {
        if (!isPlaying()) {
            setPlaying(true);
            int count = getTimer();
            getTime().setText("TIMER: " + count + " seconds");
            count--;

            setTarget(new boolean[twenty][twenty]);

            for (int i = 0; i < timer; i++) {
                final int x = (int) (Math.random() * twenty);
                final int y = (int) (Math.random() * twenty);
                if (!getTarget()[x][y]) {
                    getTarget()[x][y] = true;
                } else {
                    i--;
                }
            }

            updateCanvas();

            final TimeClass tc = new TimeClass(count);
            setClock(new Timeline(new KeyFrame(Duration.seconds(1), tc)));
            getClock().setCycleCount(timer+1);
            getClock().play();
        }
    }

    /**
     * checks if the player has won.
     * @return if they've won
     */
    public final boolean hasWon() {
        boolean toReturn = true;
        for (int i = 0; i < getTarget().length; i++) {
            for (int j = 0; j < getTarget()[0].length; j++) {
                if (getTarget()[i][j]) {
                    toReturn = false;
                }
            }
        }

        return toReturn;
    }

    /**
     * Handler for shooting.
     * @param e the event
     */
    public final void shoot(final MouseEvent e) {
        final int x = (int) (e.getX() / twenty);
        final int y = (int) (e.getY() / twenty);

        if (getTarget()[x][y] && isPlaying()) {
            getTarget()[x][y] = false;
            if (hasWon()) {
                setPlaying(false);
                SpaceTrader.getMainCharacter().sell(price);
                SpaceTrader.setGameScene();
            }
        }

        handle(e);
    }

    /**
     * Handler to update the canvas.
     * @param e the event
     */
    public final void handle(final MouseEvent e) {
        final GraphicsContext gc = getCanvas().getGraphicsContext2D();
        updateCanvas();
        drawMouse(e, gc);

    }

    /**
     * Handler to draw the mouse.
     * @param e the event
     * @param gc the graphics context
     */
    public final void drawMouse(final MouseEvent e, final GraphicsContext gc) {
        final double x = e.getX();
        final double y = e.getY();
        gc.setStroke(Color.GREEN);
        gc.strokeLine(x - offset, y, x + offset, y);
        gc.strokeLine(x, y - offset, x, y + offset);
    }

}
