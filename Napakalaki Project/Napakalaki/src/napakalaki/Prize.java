/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author PedroL
 */
public class Prize {
    // Class attributes.
    private int treasures;
    private int level;
    
    // Methods
    Prize(int t, int l){
        this.treasures = t;
        this.level = l;
    }                                           // Parameter Constructor
    protected int getTreasures(){
        return this.treasures;
    }                                  // Retrieve treasure attribute
    protected int getLevel(){
        return this.level;
    }                                      // Retrieve level attribute
    @Override
    public String toString(){
        String status;
        status = "Treasures: " + Integer.toString(this.treasures) 
                + " & Levels: " + Integer.toString(this.level);
        return status;
    }                                      // Retrive object status
}
