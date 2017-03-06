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
public class Treasure {
    // Class Attributes
    private String name;
    private int bonus;
    private TreasureKind type;
    
    // Methods
    Treasure(String n, int b, TreasureKind tr){
        this.name = n;
        this.bonus = b;
        this.type = tr;
    }                    // Parameters Constructor
    protected String getName(){
        return this.name;
    }                                    // getName
    protected int getBonus(){
        return this.bonus;
    }                                      // getBonus
    protected TreasureKind getType(){
        return this.type;
    }                              // getType
}
