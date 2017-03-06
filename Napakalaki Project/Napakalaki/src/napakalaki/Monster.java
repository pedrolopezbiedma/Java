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
public class Monster {
    
    // Class Attibutes
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsecuence badConsec;
    
    // Methods
    Monster(String n, int lvl, BadConsecuence bc, Prize p){
        this.name = n;
        this.combatLevel = lvl;
        this.badConsec = bc;
        this.prize = p;
    } // Parameters Constructor

    public String getName(){
        return this.name;
    } // getName
    public int getCombatLvl(){
        return this.combatLevel;
    } // getCombatLvl

    public BadConsecuence getBadConsecuence(){
        return this.badConsec;
    }
    
    public int getLevelsGained(){
        return this.prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return this.prize.getTreasures();
    }
    @Override
    public String toString(){
        String status;
        status = "Name: " + this.name 
                + " ,Combat Level: " + Integer.toString(this.combatLevel)
                + " ,Prize: " + this.prize.toString() 
                + " and Bad Consec: " + this.badConsec.toString();
        return status;
    } // Retrieve object status
    
}
    
