/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author PedroL
 */
public class Napakalaki {
    // Class Attributes
    private static final Napakalaki instance = new Napakalaki();
    ArrayList<Player> players = new ArrayList();
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    
    // Methods
    private Napakalaki(){
        
    }                                          // Private Constructor
    public static Napakalaki getInstance(){
        return instance;
    }                        // getInstance
    private void initPlayers(ArrayList<String> names){
        for(int i = 0 ; i < names.size() ; i++){
            Player p = new Player(names.get(i));
            players.add(p);
        } // for
    }             // initPlayers
    private Player nextPlayer(){
        if(this.currentPlayer.getName().isEmpty()){ // First Play
            int nextPlayer = (int)(Math.random()*(players.size()));
            this.currentPlayer = this.players.get(nextPlayer);
            
        } // if
        else{ // Not the first play of the game
            int index = this.players.indexOf(this.currentPlayer);
            if(index == this.players.size()-1){ // currentPlayer is the last one
                this.currentPlayer = this.players.get(0);
            } // if
            else{ // currentPlayer is not the last one
                this.currentPlayer = this.players.get(index+1);
            } // else
        } // else
        
        return this.currentPlayer;
    }                                  // nextPlayer
    private boolean nextTurnIsAllowed(){
        if(this.currentPlayer == null){
            return true;
        }
        else{
            if(this.currentPlayer.validState() == true){
                return true;
            }
            else{
                return false;        
            } // else
        } // else
    }                          // nextTurnAllowed
    protected CombatResult developCombat(){
        return CombatResult.WIN;
    }                        // developCombat ***** TO BE DEVELOPED *****
    protected void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }// discardVisibleTreasures ***** TO BE DEVELOPED *****
    protected void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    } // discardHiddenTreasures ***** TO BE DEVELOPED *****
    protected void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }   // makeTreasuresVisible ***** TO BE DEVELOPED *****
    protected void initGame(ArrayList<String> players){
           
    }            // initGame ***** TO BE DEVELOPED *****
    protected Player getCurrentPlayer(){
        return this.currentPlayer;
    }                           // getCurrentPlayer
    protected Monster getCurrentMonster(){
        return this.currentMonster;
    }                         // getCurrentMonster
    protected boolean nextTurn(){
        boolean isTrue = true;
        return isTrue;
    }                                  // nextTurn ***** TO BE DEVELOPED *****
    protected boolean endOfGame(CombatResult result){
        if(result == CombatResult.WINGAME){
            return true;
        } // if
        else{
            return false;
        } // else
    }              // endOfGame
    protected void setEnemies(){
        int enemyIndex;
        for(int i=0;i<players.size();i++){
            
            do {
                enemyIndex=(int)(Math.random()*(players.size()));
            }
            while(enemyIndex==i);
            players.get(i).setEnemy(players.get(enemyIndex));
        }        
    }                                  // setEnemies
   
}


