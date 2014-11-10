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
 * FXML Controller class
 *
 * @author John
 */
public class PirateEncounterScreenController implements Initializable {

    @FXML
    private Canvas canvas;
    
    @FXML
    private Label time;
    
    @FXML
    private Button start;
    
    private int timer = 3;
            
    private Timeline clock;
    
    private boolean[][] target = new boolean[20][20];
    
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
     * Draws all of the planets on the canvas
     */
    public final void updateCanvas() {
        final GraphicsContext gc = getCanvas().getGraphicsContext2D();
        gc.clearRect(0, 0, 400, 400);
        for (int i = 0; i < getTarget().length; i++) {
            for (int j = 0; j < getTarget()[0].length; j++) {
                if (getTarget()[i][j]) {
                    gc.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }

    /**
     * @return the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * @param canvas the canvas to set
     */
    public void setCanvas(final Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * @return the time
     */
    public Label getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(final Label time) {
        this.time = time;
    }

    /**
     * @return the start
     */
    public Button getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(final Button start) {
        this.start = start;
    }

    /**
     * @return the timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(final int timer) {
        this.timer = timer;
    }

    /**
     * @return the clock
     */
    public Timeline getClock() {
        return clock;
    }

    /**
     * @param clock the clock to set
     */
    public void setClock(final Timeline clock) {
        this.clock = clock;
    }

    /**
     * @return the target
     */
    public boolean[][] getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(final boolean[][] target) {
        final boolean[][] assignArray = target;
        this.target = assignArray;
    }

    /**
     * @return the playing
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * @param playing the playing to set
     */
    public void setPlaying(final boolean playing) {
        this.playing = playing;
    }
    
    public class TimeClass implements EventHandler {

        private int counter;
        
        /**
         * Constructor for the TimeClass
         * @param count the counter
         */
        public TimeClass(final int count) {
            counter = count;
        }

        @Override
        public final void handle(final Event event) {
            
            if(getCounter() >= 1) {
                getTime().setText("TIMER: " + getCounter() + " seconds");
            } else {
                getClock().stop();
                getTime().setText("GAME OVER");
                if (hasWon()) {
                    getTime().setText("You Win");
                }
                setPlaying(false);
                SpaceTrader.getMainCharacter().buy(300);
                SpaceTrader.setGameScene();
            }
            setCounter(getCounter() - 1);
        }

        /**
         * @return the counter
         */
        public int getCounter() {
            return counter;
        }

        /**
         * @param counter the counter to set
         */
        public void setCounter(final int counter) {
            this.counter = counter;
        }
    }
    
    /**
     * Clears the rectangle
     */
    public final void clearRect() {
        for (int i = 0; i < getTarget().length; i++) {
            for (int j = 0; j < getTarget()[0].length; j++) {
                getTarget()[i][j] = false;
            }
        }
    }
    
    /**
     * Handler to start the game
     * @param e the event
     */
    public final void startGame(final ActionEvent e) {
        if (!isPlaying()) {
            setPlaying(true);
            int count = getTimer();
            getTime().setText("TIMER: " + count + " seconds");
            count--;

            setTarget(new boolean[20][20]);

            for (int i = 0; i < 3; i++) {
                final int x = (int)(Math.random() * 20);
                final int y = (int)(Math.random() * 20);
                if (!getTarget()[x][y]) {
                    getTarget()[x][y] = true;
                } else {
                    i--;
                }
            }

            updateCanvas();

            final TimeClass tc = new TimeClass(count);
            setClock(new Timeline(new KeyFrame(Duration.seconds(1), tc)));
            getClock().setCycleCount(4);
            getClock().play();
        }
    }
    
    /**
     * checks if the player has won
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
     * Handler for shooting
     * @param e the event
     */
    public final void shoot(final MouseEvent e) {
        final int x = (int) (e.getX() / 20);
        final int y = (int) (e.getY() / 20);
        
        if (getTarget()[x][y] && isPlaying()) {
            getTarget()[x][y] = false;
            if(hasWon()) {
                setPlaying(false);
                SpaceTrader.getMainCharacter().sell(300);
                SpaceTrader.setGameScene();
            }
        }
        
        handle(e);
    }
    
    /**
     * Handler to update the canvas
     * @param e 
     */
    public final void handle(final MouseEvent e) {
        final GraphicsContext gc = getCanvas().getGraphicsContext2D();
        updateCanvas();
        drawMouse(e, gc);
        
    }
    
    /**
     * Handler to draw the mouse
     * @param e the event
     * @param gc the graphics context
     */
    public final void drawMouse(final MouseEvent e, final GraphicsContext gc) {
        final double x = e.getX();
        final double y = e.getY();
        gc.setStroke(Color.GREEN);
        gc.strokeLine(x - 10, y, x + 10, y);
        gc.strokeLine(x, y - 10, x, y + 10);
    }
    
}
