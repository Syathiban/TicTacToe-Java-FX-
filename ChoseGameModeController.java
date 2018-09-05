/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Startklar
 */
public class ChoseGameModeController implements Initializable {

    @FXML
    private Pane topbar;
    private double xOffset = 0;
    private double yOffset = 0;
    Stage stage = new Stage();
    
    public int m;

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage stage = TicTacToe.getStage();
        System.out.println("whiy");
        topbar.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }

        });

        topbar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
    }

    @FXML
    private void multiPlayer(ActionEvent event) throws IOException {
        
        m = 2;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent) loader.load();
        FXMLDocumentController con = loader.getController();
        con.myFunction(m);
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        stage.setResizable(false);

    }
    
    

    @FXML
    private void singlePlayer(ActionEvent event) throws IOException{
        m = 1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent) loader.load();
        FXMLDocumentController con = loader.getController();
        con.myFunction(m);
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        stage.setResizable(false);
    }

    public Stage getStage() {
        return stage;
    }

    
    
    
    
}
