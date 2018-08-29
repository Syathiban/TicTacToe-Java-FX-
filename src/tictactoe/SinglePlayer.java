/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author Startklar
 */
public class SinglePlayer implements GameInterface {

   
    @Override
    public void setOpponentsField(Label[] labels) {
        Random rn = new Random();
        int index = 0;
        
        do {
            index = rn.nextInt(8);
            
        } while (labels[index].getText() == "X" || labels[index].getText() == "O");
        labels[index].setText("O");
        
    }
    
}
