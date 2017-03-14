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
        this.pendingBadConsecuence = null;
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
            for(int i = 0; i < numTreasures; i++){
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
            if(bothHandsTreasure > 0 && ( t.getType() == TreasureKind.BOTHHANDS || t.getType() == TreasureKind.BOTHHANDS ) ){ //If already have a TWOHANDS assigned, no other "Hands" treasure can be assigned
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
           this.pendingBadConsecuence == null ){
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

        return status;
    }                                      // Retrieve object status
}
