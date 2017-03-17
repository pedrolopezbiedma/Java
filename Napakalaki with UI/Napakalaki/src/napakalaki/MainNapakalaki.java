/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import GUI.NapakalakiView;
import GUI.Dice;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author PedroL
 * @Description Main class
 */
public class MainNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // ***** Variables ***** 
        ArrayList<String> names = new ArrayList();
        
        // ***** Inizialations *****
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);        
        
        // ***** Logic *****
        names = namesCapture.getNames();
        game.initGame(names);
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);        

    } // Main
    
}
