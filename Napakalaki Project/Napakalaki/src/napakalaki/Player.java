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
    }                                              // Player
    private void bringToLife(){
        this.dead = false;
        this.level = 1;
        if(this.hiddenTreasures.size() > 0){
            this.hiddenTreasures = null;
        } // if
        if(this.visibleTreasures.size() > 0){
            this.visibleTreasures = null;
        } // if
    }                                    // bringToLife
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
        
    }                            // applyPrize ***** TO BE DEVELOPED *****
    private void applyBadConsecuence(Monster m){
        
    }                   // applyBadConsecuence ***** TO BE DEVELOPED *****
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
    protected String getName(){
        return this.name;
    }                                    // getName
    protected boolean isDead(){
        return this.dead;
    }                                    // isDead 
    protected ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }            // getHiddenTreasures
    protected ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }           // getVisibleTreasures 
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
    protected void makeTreasureVisible(Treasure t){
      if(this.canMakeTreasureVisible(t) == true){
          this.visibleTreasures.add(t);
          this.hiddenTreasures.remove(t);
          
      } // if  
    }                // makeTreasureVisible ***** TO BE DEVELOPED *****
    protected void discardVisibleTreasure(Treasure t){
        
    }             // discardvisibleTreasure ***** TO BE DEVELOPED *****
    protected void discardHiddenTreasure(Treasure t){
        
    }              // discardHiddenTreasure ***** TO BE DEVELOPED *****
    protected boolean validState(){
        boolean valid = false;
        if(this.hiddenTreasures.size() <= 4 &&
           this.pendingBadConsecuence.isEmpty() == true ){
            valid = true;
        } // if
        
        return valid;
    }                                // validState
    protected void initTreasures(){
        
    }                                // initTreasures ***** TO BE DEVELOPED *****
    protected int getLevels(){
        int i = 0;
        return i;
    }                                     // getLevels ***** TO BE DEVELOPED *****
    protected void discardAllTreasures(){
        
    }                          // discardAllTreasures ***** TO BE DEVELOPED *****
    protected void setEnemy(Player enemy){
        this.enemy = enemy;
    }                         // setEnemy
    protected Treasure giveMeATreasure(){
        int treasureIndex = (int)(Math.random()*(this.hiddenTreasures.size()));
        Treasure t = this.hiddenTreasures.get(treasureIndex);
        //this.hiddenTreasures.remove(treasureIndex); // Not sure if to be done here.
        return t;
    }                          // giveMeATreasure
    
    
    
}
