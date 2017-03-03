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
    public Prize(int t, int l){
        this.treasures = t;
        this.level = l;
    }        // Constructor
    public void setTreasures(int t){
        this.treasures = t;
    }   // Set treasure attribute
    public void setLevel(int l){
        this.level = l;
    }       // Set level attribute
    public int getTreasures(){
        return this.treasures;
    }         // Retrieve treasure attribute
    public int getLevel(){
        return this.level;
    }             // Retrieve level attribute
}
