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
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Parent character = FXMLLoader.load(getClass().getResource("CharacterCreation.fxml"));
        
        main = new Scene(root);
        characterCreation = new Scene(character);
        PrimaryStage = stage;
        PrimaryStage.setScene(main);
        PrimaryStage.show();
    }
    
    public static void setCreationScene() {
        PrimaryStage.setScene(characterCreation);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
