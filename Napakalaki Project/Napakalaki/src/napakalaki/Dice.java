/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Pedro
 */
public class Dice {
    // Class Attributes
    private static final Dice instance = new Dice();
    
    // Methods
    private Dice(){
        
    }                                                // Private constructor
    public static Dice getInstance(){
        return instance;
    }                              // getInstance
    protected int nextNumber(){
        double random = Math.random()*6+1;
        int nextNumber = (int)random;
        return nextNumber;
    }                                    // nextNumber
    
}
