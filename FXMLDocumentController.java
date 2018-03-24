/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.net.URL;
import static java.sql.DriverManager.println;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Startklar
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9;

    @FXML
    private AnchorPane Anchor;
    
    private int zahl = 0;

    private int gamemode = 0;
    
    private boolean isYourTurn = true;

    private Label[] labels = new Label[9];

    

    @FXML
    private void clicked(MouseEvent event) {
        if (gamemode == 0) {
            Label temp = ((Label) event.getSource());
            if (temp.getText() == "") {
                temp.setText("X");
                zahl++;
                if(zahl < 5) {
                    SinglePlayer sp = new SinglePlayer();
                    sp.setOpponentsField(labels);
                    
                    
                }
                int winner = checkField();
                    if(winner == 1) {
                        JOptionPane.showMessageDialog(null, "You won");
                        resetField();
                    }else if(winner == 2){
                        JOptionPane.showMessageDialog(null, "You lost");
                        resetField();
                    }else if(zahl == 5 /**&& winner == 0/**winner != 2 && winner != 1 &&  winner != 0**/){
                        JOptionPane.showMessageDialog(null, "No-one Won");
                        resetField();
                    }
            }

        } else {
            Label temp = ((Label) event.getSource());
            if(temp.getText() == "" && isYourTurn == true) {
               temp.setText("X"); 
               zahl++;
               isYourTurn = false;
               
            } else if(temp.getText() == "" && isYourTurn == false){
                temp.setText("O"); 
                zahl++;
               isYourTurn = true;
            }
            
            int winner = checkField();
                    if(winner == 1) {
                        JOptionPane.showMessageDialog(null, "You won");
                        resetField();
                    }else if(winner == 2){
                        JOptionPane.showMessageDialog(null, "You lost");
                        resetField();
                    }else if(zahl == 9 /*&& winner == 0**/){
                        JOptionPane.showMessageDialog(null, "No-one Won");
                        resetField();
                    }
        }
        

    }
    
    
    private int checkField() {
        if(labels[0].getText() == "X" && labels[1].getText() == "X" && labels[2].getText() == "X" ) {
            return 1;
        } else if(labels[3].getText() == "X" && labels[4].getText() == "X" && labels[5].getText() == "X") {
            return 1;
        } else if(labels[6].getText() == "X" && labels[7].getText() == "X" && labels[8].getText() == "X") {
            return 1;
        }
        
        if(labels[0].getText() == "X" && labels[3].getText() == "X" && labels[6].getText() == "X") {
            return 1;
        } else if(labels[1].getText() == "X" && labels[4].getText() == "X" && labels[7].getText() == "X") {
            return 1;
        } else if(labels[2].getText() == "X" && labels[5].getText() == "X" && labels[8].getText() == "X") {
            return 1;
        }
        
        if(labels[0].getText() == "X" && labels[4].getText() == "X" && labels[8].getText() == "X") {
            return 1;
        } else if(labels[2].getText() == "X" && labels[4].getText() == "X" && labels[6].getText() == "X") {
            return 1;
        }
        
        // Opponent
        
        
        
        if(labels[0].getText() == "O" && labels[1].getText() == "O" && labels[2].getText() == "O") {
            return 2;
        } else if(labels[3].getText() == "O" && labels[4].getText() == "O" && labels[5].getText() == "O") {
            return 2;
        } else if(labels[6].getText() == "O" && labels[7].getText() == "O" && labels[8].getText() == "O") {
            return 2;
        }
        
        if(labels[0].getText() == "O" && labels[3].getText() == "O" && labels[6].getText() == "O") {
            return 2;
        } else if(labels[1].getText() == "O" && labels[4].getText() == "O" && labels[7].getText() == "O") {
            return 2;
        } else if(labels[2].getText() == "O" && labels[5].getText() == "O" && labels[8].getText() == "O") {
            return 2;
        }
        
        if(labels[0].getText() == "O" && labels[4].getText() == "O" && labels[8].getText() == "O") {
            return 2;
        } else if(labels[2].getText() == "O" && labels[4].getText() == "O" && labels[6].getText() == "O") {
            return 2;
        }else  
            
        return 0;
        
             
       
        
       
    }
    
    public void resetField() {
        for (int i = 0; i < labels.length; i++) {
            labels[i].setText("");
        }
        zahl = 0;
        isYourTurn = true;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        this.gamemode = Integer.parseInt(JOptionPane.showInputDialog("0 = SinglePlayer\n1= MultiPlayer"));
        labels[0] = lb1;
        labels[1] = lb2;
        labels[2] = lb3;
        labels[3] = lb4;
        labels[4] = lb5;
        labels[5] = lb6;
        labels[6] = lb7;
        labels[7] = lb8;
        labels[8] = lb9;
        
        
        
    }
 
   

}
