/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author PedroL
 * @description Class that handle the monster behavior.
 */
public class Monster {
    // ***** Class attributes *****
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsecuence badConsec;
    
    // ***** Class constructors *****
    Monster(String n, int lvl, BadConsecuence bc, Prize p){
        this.name = n;
        this.combatLevel = lvl;
        this.badConsec = bc;
        this.prize = p;
    }        // Parameters Constructor
    
    // ***** Class methods *****
    /*
    * Methods that retrieves the monster name.
    * @return Monster name
    */
    public String getName(){
        return this.name;
    }                                    // getName
    
    /*
    * Method that retrieves monster level.
    * @return Monster level.
    */
    public int getCombatLvl(){
        return this.combatLevel;
    }                                  // getCombatLvl
    
    /*
    * Method that retrieves the monster BadConsequence to be suffered if combt is lost.
    * @return Monster BadConsequence
    */
    public BadConsecuence getBadConsecuence(){
        return this.badConsec;
    }                  // getBadConsuence
    
    /*
    * Method that retrieves the levels gained if monster is beated.
    * @return Monster levels gained.
    */
    public int getLevelsGained(){
        return this.prize.getLevel();
    }                               // getLevelsGained
    
    /*
    * Method that retrieves the treasures gained if monster is beated.
    * @return Monster treasures gained.
    */
    public int getTreasuresGained(){
        return this.prize.getTreasures();
    }                            // getTreasuresGained
    
    /*
    * Method that retrieves the prize from the monster.
    * @return Prize from the monster
    */
    public Prize getPrize(){
        return this.prize;
    }                                       // getPrize
    @Override
    public String toString(){
        String status;
        status = "Name: " + this.name 
                + " ,Combat Level: " + Integer.toString(this.combatLevel)
                + " ,Prize: " + this.prize.toString() 
                + " and Bad Consec: " + this.badConsec.toString();
        return status;
    }                                      // Retrieve object status
    
}
    
