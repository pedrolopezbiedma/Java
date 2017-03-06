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
        
    }                                    // bringToLife ***** TO BE DEVELOPED *****
    private int getCombatLevel(){
        int i;
        return i;
    }                                  // getCombatLevel ***** TO BE DEVELOPED *****
    private void incrementLevels(int i){
        
    }                           // incrementLevels ***** TO BE DEVELOPED *****
    private void decrementLevels(int i){
        
    }                           // decrementLevels ***** TO BE DEVELOPED *****
    private void setPendingBadConsecuence(BadConsecuence bc){
        
    }      // setPendingBadConsecuence ***** TO BE DEVELOPED *****
    private void applyPrize(Monster m){
        
    }                            // applyPrize ***** TO BE DEVELOPED *****
    private void applyBadConsecuence(Monster m){
        
    }                   // applyBadConsecuence ***** TO BE DEVELOPED *****
    private boolean canMakeTreasureVisible(Treasure t){
        boolean isTrue = true;
        return isTrue;
    }            // canMakeTreasureVisible ***** TO BE DEVELOPED *****
    private int howManyVisibleTreasures(TreasureKind tr){
        int i = 0;
        return i;
    }          // howManyVisibleTreasures ***** TO BE DEVELOPED *****
    private void dieIfNoTreasures(){
        
    }                               // dieIfNoTreasures ***** TO BE DEVELOPED *****
    protected boolean isDead(){
        boolean isTrue = true;
        return isTrue;
    }                                    // isDead *****  TO BE DEVELOPED *****
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
        boolean isTrue = true;
        return isTrue;
    }                                // validState ***** TO BE DEVELOPED *****
    protected void initTreasures(){
        
    }                                // initTreasures ***** TO BE DEVELOPED *****
    protected int getLevels(){
        int i = 0;
        return i;
    }                                     // getLevels ***** TO BE DEVELOPED *****
    protected void discardAllTreasures(){
        
    }                           // discardAllTreasures ***** TO BE DEVELOPED *****
    
    
    
}
