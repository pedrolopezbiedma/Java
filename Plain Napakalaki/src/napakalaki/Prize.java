/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author PedroL
 * @description Class to handle the prize to be applied from a monster is combat is won.
 */
public class Prize {
    // ***** Class attributes. *****
    private int treasures;
    private int levels;
    
    // ***** Class constructor *****
    Prize(int t, int l){
        this.treasures = t;
        this.levels = l;
    }                                           // Parameter Constructor
    
    // ***** Class methods *****
    /*
    * Method that retrieves the treasures gained when the prize is applied.
    * @return Treasures gained.
    */
    protected int getTreasures(){
        return this.treasures;
    }                                  // Retrieve treasure attribute
    
    /*
    * Method that retrieves the levels gained when the prize is applied.
    * @return Levels gained.
    */
    protected int getLevel(){
        return this.levels;
    }                                      // Retrieve level attribute
    
    @Override
    public String toString(){
        String status;
        status = "Treasures: " + Integer.toString(this.treasures) 
                + " & Levels: " + Integer.toString(this.levels);
        return status;
    }                                      // Retrive object status
}
