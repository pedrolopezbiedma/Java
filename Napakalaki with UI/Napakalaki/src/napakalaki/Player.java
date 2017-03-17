/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import GUI.Dice;

/**
 *
 * @author Pedro
 * @description Class to handle player behavior.
 */
public class Player {
    // ***** Class attributes *****
    public static final int MAXLEVEL = 10;
    private String name;
    private boolean canISteal;
    private int level;
    private boolean dead = true;
    BadConsecuence pendingBadConsecuence;
    private Player enemy;
    ArrayList<Treasure> visibleTreasures = new ArrayList();
    ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
    // ***** Class constructors *****
    Player(String n){
        this.name = n;
        this.level = 1;
        this.visibleTreasures = null;
        this.hiddenTreasures = null;
        this.pendingBadConsecuence = null;
        this.enemy = null;
        this.canISteal = true;
    }                                              // Player
    
    // ***** Class methods *****
    
    /*
    * Method that brings to life a player that has dead.
    */
    private void bringToLife(){
        this.dead = false;
        this.level = 1;
        if(this.hiddenTreasures == null){
            this.hiddenTreasures = new ArrayList();
        } // if
        if(this.visibleTreasures == null){
            this.visibleTreasures = new ArrayList();
        } // if
    }                                   // bringToLife
    
    /*
    * Method that retrieves the combat level ( player level + treasures level ) from the player.
    * @return Combat level for the player
    */
    public int getCombatLevel(){
        int totalCombatLevel = this.level;
        for(int i = 0; i < this.visibleTreasures.size() ; i++){
            if(this.visibleTreasures.get(i).getBonus() != 0){
                totalCombatLevel = totalCombatLevel + this.visibleTreasures.get(i).getBonus();
            } // if
        } // for
        
        return totalCombatLevel;
    }                                 // getCombatLevel
    
    /*
    * Method that increment the level from the player.
    * @param i levels to gain
    */
    private void incrementLevels(int i){
        if(this.level < Player.MAXLEVEL){
            this.level = this.level + i;  
        } // if
        if(this.level > Player.MAXLEVEL){
            this.level = Player.MAXLEVEL;
        } // if
    }                           // incrementLevels
    
    /*
    * Method tht decrement levels from the player
    * @param i level to decrement 
    */
    private void decrementLevels(int i){
      this.level = this.level - i;
      
      if(this.level < 1){
          this.level = 1;
      } // if
    }                           // decrementLevels
    
    /*
    * Method that sets a BadConsequence as pending to the player.
    * @param bc BadConsequence to be set.
    */
    private void setPendingBadConsecuence(BadConsecuence bc){
      this.pendingBadConsecuence = bc;  
    }      // setPendingBadConsecuence
    
    /*
    * Method that applies a prize from a monster when player wins a battle.
    * @param m Monster that has been beated in battle.
    */
    private void applyPrize(Monster m){
       CardDealer dealer; 
       this.incrementLevels(m.getLevelsGained());
       int numTreasures = m.getTreasuresGained();

        if (numTreasures > 0){
            dealer = CardDealer.getInstance();
            for(int i = 0; i < numTreasures; i++){
                this.hiddenTreasures.add(dealer.nextTreasure());
            }
        } // if
    }                           // applyPrize
    
    /*
    * Method that applies a BadConsequence from a monster when a player losses a battle.
    * @param m Monster that has beated the player in battle.
    */
    private void applyBadConsecuence(Monster m){
        BadConsecuence bc = m.getBadConsecuence();
        this.decrementLevels(bc.getLevels());
        BadConsecuence newBC = bc.adjustToFitTreasureLists(this.visibleTreasures,this.hiddenTreasures);
        this.setPendingBadConsecuence(newBC);
    }                   // applyBadConsecuence
    
    /*
    * Method that check if a treasure can be equipped ( visible ) according to the game rules.
    * @param t Treasure to be checked.
    * @return boolean indicating if treasure can be equipped or not.
    */
    private boolean canMakeTreasureVisible(Treasure t){
        boolean canEquip = true;
        int oneHandTreasures = 0;
        int bothHandsTreasure = 0;
        
        // Check if new treasure type is already assigned. ( Except for one Hand that needs special treatment )
        for(int i = 0; i < this.visibleTreasures.size() && canEquip == true ;i++){
            if(this.visibleTreasures.get(i).getType() == t.getType() && t.getType() != TreasureKind.ONEHAND){
             canEquip = false;
            }
        } // for
        
        // If new treasure type is not already assigned
        if(canEquip == true){
            for(int i = 0; i < this.visibleTreasures.size() ;i++){
                if(this.visibleTreasures.get(i).getType() == TreasureKind.ONEHAND){
                    oneHandTreasures = oneHandTreasures + 1;
                } // if
                if(this.visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS){
                    bothHandsTreasure = bothHandsTreasure + 1;
                } // if                
            } // for

            if(oneHandTreasures > 1 && t.getType() == TreasureKind.ONEHAND){ // If already have 2 TWOHANDS asisgned, not able to equipo another one
                canEquip = false;
            } // if
            if(oneHandTreasures > 0 && t.getType() == TreasureKind.BOTHHANDS){ // If already have any ONEHAND and try to equip a TWOHANDS treasure, error.
                canEquip = false;
            } // if
            if(bothHandsTreasure > 0 && ( t.getType() == TreasureKind.BOTHHANDS || t.getType() == TreasureKind.ONEHAND ) ){ //If already have a TWOHANDS assigned, no other "Hands" treasure can be assigned
                canEquip = false;
            } // if
        } // if

        if(canEquip){
            System.out.println ("Tesoro equipado");
        }else{
            System.out.println ("Tesoro NO equipado");
        }
        return canEquip;
    }           // canMakeTreasureVisible
    
    /*
    * Method that kills the player if it does not have any treasure.
    */
    private void dieIfNoTreasures(){
      if(this.hiddenTreasures.isEmpty() &&
         this.visibleTreasures.isEmpty()){
          this.dead = true;
          this.level = 1;
      }  // if
    }                               // dieIfNoTreasures
    
    /*
    * Method that indicates that the player cannot steal anything else as it has already done it.
    */
    private void haveStolen() {
        this.canISteal = false;
    }                                    // haveStolen
    
    /*
    * Method that retrieves if player is dead.
    * @return Player is dead or not.
    */
    protected boolean isDead(){
        return this.dead;
    }                                    // isDead 
    
    /*
    * Method that perform the combat & applies the consecuences according to the result.
    * @param m Monster to combat with
    * @return Combat result from the combat
    */
    protected CombatResult combat(Monster m){
        CombatResult result;
       if(this.getCombatLevel() > m.getCombatLvl()){
           this.applyPrize(m);
           
           if(this.level >= Player.MAXLEVEL){
             result = CombatResult.WINGAME;
           }
           else{
             result = CombatResult.WIN;  
           } // else
       } // if Combat Won
       else{
           this.applyBadConsecuence(m);
           result = CombatResult.LOSE;
       } // else Combat Lost
       
       return result;       
    }                     // combat
    
    /*
    * Method that checks is player is in a valid state to pass the turn.
    * @return boolean indicating if player can pass turn.
    */
    protected boolean validState(){
        boolean valid = false;
        if(this.hiddenTreasures.size() <= 4){
           if(this.pendingBadConsecuence == null){
               valid = true;
           }
           else{
               if(this.pendingBadConsecuence.isEmpty()){
                   valid = true;
               } // if
           } // else
        } // if
        
        return valid;
    }                               // validState
    
    /*
    * Method that give the initial treasures to the player if dead or first turn.
    */
    public void initTreasures(){
      CardDealer dealer = CardDealer.getInstance();
      Dice dice = Dice.getInstance();
      Treasure treasure;
      int number;
      
      this.bringToLife();  
      treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        number = dice.nextNumber();

        if (number > 1) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }

        if (number == 6) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
    }                               // initTreasures
    
    
    /*
    * Method that retrieves the level from the actual player.
    * @return Player's level
    */
    public int getLevels(){
        return this.level;
    }                                     // getLevels
    
    /*
    * Method that set the enemy for the current player.
    * @param enemy Player to be set as enemy.
    */
    protected void setEnemy(Player enemy){
        this.enemy = enemy;
    }                         // setEnemy
    
    /*
    * Method that get a treasure from the enemy player
    * @param Treasure stolen.
    */
    protected Treasure giveMeATreasure(){
        int treasureIndex = (int)(Math.random()*(this.hiddenTreasures.size()));
        Treasure t = this.hiddenTreasures.get(treasureIndex);
        this.hiddenTreasures.remove(treasureIndex);
        return t;
    }                          // giveMeATreasure
    
    /*
    * Method that checks if a treasure can be stolen.
    * @return boolean if a treasure can be stolen from the enemy player.
    */
    protected boolean canYouGiveMeATreasure() {
        if (this.hiddenTreasures != null) {
            return true;
        } else {
            return false;
        }
    }                    // canYouGiveMeATreasure
    
    /*
    * Method that retrieves the hidden treasures list. from the current player.
    * @return Hidden treasure list from the player.
    */
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }               // getHiddenTreasures
    
    /*
    * Method that retrieves the visible treasure list from the current player.
    * @return Visible treasure list from the current player.
    */
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }              // getVisibleTreasures 
    
    /*
    * Method that makes a treasure visible for the current player.
    * @param t Treasure to be equiped.
    */
    public void makeTreasureVisible(Treasure t){
      if(this.canMakeTreasureVisible(t) == true){
          this.visibleTreasures.add(t);
          this.hiddenTreasures.remove(t);
          
      } // if  
    }                   // makeTreasureVisible
    
    /*
    * Method that discard a visible treasure from the player.
    * @param t Visible treasure to be discarded from the player
    */
    public void discardVisibleTreasure(Treasure t){
        boolean removed = false;
        
        // Discarding the treasure.
        removed = this.visibleTreasures.remove(t);

        if(removed == true){
            // If there's a pending Bad Consecuence, remove the treasure from it.
            if(this.pendingBadConsecuence != null){
                this.pendingBadConsecuence.substractVisTreasures(t);
            } // if
        } // if
        this.dieIfNoTreasures();
        
    }               // discardvisibleTreasure
    
    /*
    * Method that discards a hidden treasure from the current player.
    * @param t Hidden treasure to be discarded from the player.
    */
    public void discardHiddenTreasure(Treasure t){
         boolean removed = false;
        
        // Discarding the treasure.
        removed = this.hiddenTreasures.remove(t);
        
        if(removed == true){ // If treasure was removed, update pending Badconsequence
            this.pendingBadConsecuence.substractHidTreasures(t);
        } // if
        this.dieIfNoTreasures();       
    }                // discardHiddenTreasure
    
    /*
    * Method that discards all treasures from the player.
    */
    public void discardAllTreasures(){
        ArrayList<Treasure> myVisibleTreasures = new ArrayList(this.visibleTreasures);
        ArrayList<Treasure> myHiddenTreasures = new ArrayList(this.hiddenTreasures);

        for(int i = myVisibleTreasures.size()-1; i >= 0 ; i--){
            this.discardVisibleTreasure(myVisibleTreasures.get(i));
        } // for
        
        for(int i = myHiddenTreasures.size()-1; i >= 0; i--){
            this.discardHiddenTreasure(myHiddenTreasures.get(i));
        } // for
    }                            // discardAllTreasures
    
    /*
    * Method that check if player can steal a treasure from the enemy player.
    * @return boolean indicating if player can steal.
    */
    public boolean canISteal() {
        if (this.canISteal == true) {
            return true;
        } else {
            return false;
        }
    }                                   // canISteal
    
    /*
    * Method that steals a treasure from the enemy player
    * @return Treasure stolen from the enemy player.
    */
    public Treasure stealTreasure(){
        Treasure treasure = null;
        boolean canYou;

        if (this.canISteal == true) {
            if(enemy != null){
                canYou = enemy.canYouGiveMeATreasure();
                if (canYou == true) {
                    treasure = enemy.giveMeATreasure();
                    this.hiddenTreasures.add(treasure);
                    this.haveStolen();
                }
            } // if
        }
        return treasure;
    }                              // stealTreasure
    
    /*
    * Method that retrieves the name from the current player.
    * @param Player name
    */
    public String getName(){
        return this.name;
    }                                       // getName
    
    /*
    * Method that retrieves the enemy player from the current player.
    * @return Enemy player from the current player.
    */
    public Player getEnemy(){
        return this.enemy;
    }                                      // getEnemy
    
    /*
    * Method that retrieves the pending BadConsecuence from the player.
    * @return The pending BadConsecuence
    */
    public BadConsecuence getPendingBC(){
        return this.pendingBadConsecuence;
    }                          // getPendingBC
    @Override // TODO Mostrar lista de tesoros.
    public String toString(){
        String status;
        status = "Player's name: " + this.name + "\n"
                + ", Player's level: " + Integer.toString(this.level) + "\n"
                + ". Player's combat level:" + Integer.toString(this.getCombatLevel()) + "\n";
        
        status = status + " ***** Hidden Treasures: ***** " + "\n";
        for(int i = 0; i < this.hiddenTreasures.size();i++){
            status = status + i+1 + this.hiddenTreasures.get(i).toString() + "\n";
        } // for
        
         status = status + " ***** Visible Treasures: *****" + "\n";
        for(int i = 0; i < this.visibleTreasures.size();i++){
            status = status + i+1 + this.visibleTreasures.get(i).toString() + "\n";
        } // for
        status = status + "My enemy is:" + this.enemy.getName();

        if(this.pendingBadConsecuence != null){
            System.out.println("Queda mal royo pendiente.");
            System.out.println(this.pendingBadConsecuence.toString());
        }
        else{
            System.out.println ("No hay mal royo pendiente.");
        } // else
        return status;
    }                                     // Retrieve object status
}
