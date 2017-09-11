/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Pedro
 * @Description Class to handle the treasure behavior.
 */
public class Treasure {
    // ***** Class attributes *****
    private String name;
    private int bonus;
    private TreasureKind type;
    
    // ***** Class constructors *****
    Treasure(String n, int b, TreasureKind tr){
        this.name = n;
        this.bonus = b;
        this.type = tr;
    }                    // Parameters Constructor
    
    // ***** Class methods *****
    /*
    * Method that retrieves the treasure name.
    * @return Treasure name
    */
    public String getName(){
        return this.name;
    }                                       // getName
    
    /*
    * Method that retrieves the bonus granted by the treasure
    * @return Bonus gained from the treasure
    */
    public int getBonus(){
        return this.bonus;
    }                                      // getBonus
    
    /*
    * Method that retrieves the type of the treasure.
    * @return Type from the treasure.
    */
    public TreasureKind getType(){
        return this.type;
    }                              // getType
    
    @Override
    public String toString(){
        String status = " - Treasure: " + this.name + " Bonus granted:" + this.bonus + " Type: " + this.type;
        return status;
    } // toString ***** TO BE DELETED *****
}
