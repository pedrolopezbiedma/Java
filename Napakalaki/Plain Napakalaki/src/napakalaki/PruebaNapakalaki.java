/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import tester.GameTester;
/**
 *
 * @author PedroL
 * @Description Main class
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // ***** Variables & Inizialations *****
        Napakalaki napakalaki = Napakalaki.getInstance();
        GameTester game = GameTester.getInstance();
        
        // ***** Logic *****
        game.play(napakalaki, 2);

    } // Main
    
}
