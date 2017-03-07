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
    ArrayList<Treasure> visibleTreasures = new ArrayList();
    ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
    // Methods
    Player(String n){
        this.name = n;
        this.level = 0;
        this.visibleTreasures = null;
        this.hiddenTreasures = null;
        this.pendingBadConsecuence = new BadConsecuence("Dead");
    }                                              // Player
    protected String getName(){
        return this.name;
    }                                    // getName
    private void bringToLife(){
        this.dead = false;
    }                                    // bringToLife
    private int getCombatLevel(){
        int totalCombatLevel = this.level;
        for(int i = 0; i < this.visibleTreasures.size() ; i++){
            if(this.visibleTreasures.get(i).getBonus() != 0){
                totalCombatLevel = totalCombatLevel + this.visibleTreasures.get(i).getBonus();
            } // if
        } // for

        for(int i = 0; i < this.hiddenTreasures.size() ; i++){
            if(this.hiddenTreasures.get(i).getBonus() != 0){
                totalCombatLevel = totalCombatLevel + this.hiddenTreasures.get(i).getBonus();
            } // if
        } // for    
        
        return totalCombatLevel;
    }                                 // getCombatLevel
    private void incrementLevels(int i){
      this.level = this.level + i;  
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
        boolean isTrue = true;
        return isTrue;
    }            // canMakeTreasureVisible ***** TO BE DEVELOPED *****
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
      }  // if
    }                               // dieIfNoTreasures
    protected boolean isDead(){
        return this.dead;
    }                                    // isDead 
    protected ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }            // getHiddenTreasures ***** TO BE DEVELOPED *****
    protected ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }           // getVisibleTreasures ***** TO BE DEVELOPED *****
    protected CombatResult combat(Monster m){
       return CombatResult.WIN;
       
    }                      // combat ***** TO BE DEVELOPED *****
    protected void makeTreasureVisible(Treasure t){
        
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
        
    }                           // discardAllTreasures ***** TO BE DEVELOPED *****
    
    
    
}
