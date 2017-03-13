/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author Pedro
 */
public class Player {
    // Class Attributes
    public static final int MAXLEVEL = 10;
    private String name;
    private boolean canISteal;
    private int level;
    private boolean dead = true;
    BadConsecuence pendingBadConsecuence;
    private Player enemy;
    ArrayList<Treasure> visibleTreasures = new ArrayList();
    ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
    // Methods
    Player(String n){
        this.name = n;
        this.level = 1;
        this.visibleTreasures = null;
        this.hiddenTreasures = null;
        this.pendingBadConsecuence = new BadConsecuence("Dead");
        this.enemy = null;
        this.canISteal = true;
    }                                              // Player
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
    private int getCombatLevel(){
        int totalCombatLevel = this.level;
        for(int i = 0; i < this.visibleTreasures.size() ; i++){
            if(this.visibleTreasures.get(i).getBonus() != 0){
                totalCombatLevel = totalCombatLevel + this.visibleTreasures.get(i).getBonus();
            } // if
        } // for
        
        return totalCombatLevel;
    }                                 // getCombatLevel
    private void incrementLevels(int i){
        if(this.level < Player.MAXLEVEL){
            this.level = this.level + i;  
        } // if
        if(this.level > Player.MAXLEVEL){
            this.level = Player.MAXLEVEL;
        } // if
    }                           // incrementLevels
    private void decrementLevels(int i){
      this.level = this.level - i;
      
      if(this.level < 1){
          this.level = 1;
      } // if
    }                           // decrementLevels
    private void setPendingBadConsecuence(BadConsecuence bc){
      this.pendingBadConsecuence = bc;  
    }      // setPendingBadConsecuence
    private void applyPrize(Monster m){
       CardDealer dealer; 
       this.incrementLevels(m.getLevelsGained());
       int numTreasures = m.getTreasuresGained();

        if (numTreasures > 0){
            dealer = CardDealer.getInstance();
            for(int i = 0; i < numTreasures-1; i++){
                this.hiddenTreasures.add(dealer.nextTreasure());
            }
        } // if
    }                           // applyPrize
    private void applyBadConsecuence(Monster m){
        BadConsecuence bc = m.getBadConsecuence();
        this.decrementLevels(bc.getLevels());
        BadConsecuence newBC = bc.adjustToFitTreasureLists(this.visibleTreasures,this.hiddenTreasures);
        this.setPendingBadConsecuence(newBC);
        
    }                   // applyBadConsecuence
    private boolean canMakeTreasureVisible(Treasure t){
        boolean canEquip = true;
        int oneHandTreasures = 0;
        for(int i = 0; i < this.visibleTreasures.size();i++){
          if(this.visibleTreasures.get(i).getType() == TreasureKind.ONEHAND){ // ONEHAND treasure: special treatment
            oneHandTreasures = oneHandTreasures + 1;
          }
          else{ // Not ONEHAND treasure
            if(this.visibleTreasures.get(i).getType() == t.getType()){ // Already equiped a treasure of that kind
              canEquip = false;  
            }  // if
          } // else
        } // for
        if(oneHandTreasures == 2 && t.getType() == TreasureKind.ONEHAND){
            canEquip = false;
        } // if
        return canEquip;
    }           // canMakeTreasureVisible
    private int howManyVisibleTreasures(TreasureKind tr){
        int count = 0;
        for(int i = 0 ; i < this.visibleTreasures.size() ; i++){
            if(this.visibleTreasures.get(i).getType() == tr){
              count = count + 1;  
            } // if
        } // for
        
        return count;
    }         // howManyVisibleTreasures
    private void dieIfNoTreasures(){
      if(this.hiddenTreasures.isEmpty() &&
         this.visibleTreasures.isEmpty()){
          this.dead = true;
          this.level = 1;
      }  // if
    }                               // dieIfNoTreasures
    private void haveStolen() {
        this.canISteal = false;
    }                                    // haveStolen
    protected boolean isDead(){
                      System.out.println("Salgo del isDead");
        return this.dead;
    }                                    // isDead 
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
    protected boolean validState(){
        boolean valid = false;
        if(this.hiddenTreasures.size() <= 4 &&
           this.pendingBadConsecuence.isEmpty() == true ){
            valid = true;
        } // if
        
        return valid;
    }                                // validState
    protected void initTreasures(){
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
    protected int getLevels(){
        return this.level;
    }                                     // getLevels
    protected void setEnemy(Player enemy){
        this.enemy = enemy;
    }                         // setEnemy
    protected Treasure giveMeATreasure(){
        int treasureIndex = (int)(Math.random()*(this.hiddenTreasures.size()));
        Treasure t = this.hiddenTreasures.get(treasureIndex);
        //this.hiddenTreasures.remove(treasureIndex); // Not sure if to be done here.
        return t;
    }                          // giveMeATreasure
    protected boolean canYouGiveMeATreasure() {
        if (this.visibleTreasures.size() > 0) {
            return true;
        } else {
            return false;
        }
    }                    // canYouGiveMeATreasure
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }               // getHiddenTreasures
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }              // getVisibleTreasures 
    public void makeTreasureVisible(Treasure t){
      if(this.canMakeTreasureVisible(t) == true){
          this.visibleTreasures.add(t);
          this.hiddenTreasures.remove(t);
          
      } // if  
    }                   // makeTreasureVisible
    public void discardVisibleTreasure(Treasure t){
        boolean removed = false;
        
        // Discarding the treasure.
        removed = this.visibleTreasures.remove(t);
        
        if(removed == true){ // If treasure was removed, update pending Badconsequence
            this.pendingBadConsecuence.substractVisTreasures(t);
        } // if
        this.dieIfNoTreasures();
        
    }               // discardvisibleTreasure
    public void discardHiddenTreasure(Treasure t){
         boolean removed = false;
        
        // Discarding the treasure.
        removed = this.hiddenTreasures.remove(t);
        
        if(removed == true){ // If treasure was removed, update pending Badconsequence
            this.pendingBadConsecuence.substractHidTreasures(t);
        } // if
        this.dieIfNoTreasures();       
    }                // discardHiddenTreasure
    public void discardAllTreasures(){
        ArrayList<Treasure> myVisibleTreasures = this.visibleTreasures;
        ArrayList<Treasure> myHiddenTreasures = this.hiddenTreasures;
        
        for(int i = 0; i < this.visibleTreasures.size(); i++){
            this.discardVisibleTreasure(this.visibleTreasures.get(i));
        } // for
        
        for(int i = 0; i < this.hiddenTreasures.size(); i++){
            this.discardHiddenTreasure(this.hiddenTreasures.get(i));
        } // for
    }                            // discardAllTreasures
    public boolean canISteal() {
        if (this.canISteal == true) {
            return true;
        } else {
            return false;
        }
    }                                   // canISteal
    public Treasure stealTreasure(){
        Treasure treasure = null;
        boolean canYou;
        boolean canI = this.canISteal;

        if (canI) {
            canYou = enemy.canYouGiveMeATreasure();
            if (canYou) {
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();

            }
        }
        return treasure;
    }                              // stealTreasure
    public String getName(){
        return this.name;
    }                                       // getName
    
}
