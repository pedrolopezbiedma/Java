/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Pedro
 * @description Class to provide random numbers
 */
public class Dice {
    // ***** Class attributes *****
    private static final Dice instance = new Dice();
    
    // ***** Class constructors *****
    private Dice(){
        
    }                                                // Private constructor
    
    // ***** Class methods *****
    /*
    * Method that retrieves an instance from the class.
    * @return Dice instance.
    */
    public static Dice getInstance(){
        return instance;
    }                              // getInstance
    
    /*
    * Method that retrieves a random number between 1 & 6.
    * @return random number
    */
    protected int nextNumber(){
        double random = Math.random()*6+1;
        int nextNumber = (int)random;
        return nextNumber;
    }                                    // nextNumber
    
}
