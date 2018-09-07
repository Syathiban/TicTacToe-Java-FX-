/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Startklar
 */
public class TicTacToe extends Application {

    private static Stage primarystage;
    public int m;

    @Override
    public void start(Stage primarystage) throws Exception {
        this.primarystage = primarystage;
        Parent root = FXMLLoader.load(getClass().getResource("ChoseGameMode.fxml"));
        Scene scene = new Scene(root);
        primarystage.initStyle(StageStyle.TRANSPARENT);
        primarystage.show();
        primarystage.setResizable(false);
        primarystage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    

    public static Stage getStage() {
        return primarystage;
    }

    

    
}
