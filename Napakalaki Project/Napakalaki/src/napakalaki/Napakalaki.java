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
    private void setEnemies(){
        int enemyIndex;
        for(int i=0;i<players.size();i++){
            
            do {
                enemyIndex=(int)(Math.random()*(players.size()));
            }
            while(enemyIndex==i);
            players.get(i).setEnemy(players.get(enemyIndex));
        }        
    }                                    // setEnemies
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
    protected boolean endOfGame(CombatResult result){
        if(result == CombatResult.WINGAME){
            return true;
        } // if
        else{
            return false;
        } // else
    }              // endOfGame
    protected void makeTreasuresVisible(ArrayList<Treasure> treasures){
      for(int i = 0; i < treasures.size(); i++){
        this.currentPlayer.makeTreasureVisible(treasures.get(i));
      }   // for
      
    }// makeTreasuresVisible
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
      for(int i = 0; i < treasures.size();i++){
        this.currentPlayer.discardVisibleTreasure(treasures.get(i));
        this.dealer.giveTreasureBack(treasures.get(i));
      } // for
            
    }// discardVisibleTreasures
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
      for(int i = 0; i < treasures.size();i++){
        this.currentPlayer.discardHiddenTreasure(treasures.get(i));
        this.dealer.giveTreasureBack(treasures.get(i));
      } // for
                
    } // discardHiddenTreasures
    public CombatResult developCombat(){
        CombatResult result = this.currentPlayer.combat(this.currentMonster);
        return result;
    }                           // developCombat
    public void initGame(ArrayList<String> players){
      // Initializing Decks
      this.dealer.initCards();
      
      // Inizialiting Players
      this.initPlayers(players);
      
      // Setting enemies
      this.setEnemies();
      
      // Initializing Game
      this.nextTurn();
    }              // initGame
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }                              // getCurrentPlayer
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }                            // getCurrentMonster
    public boolean nextTurn(){
        boolean nextTurnPossible = false;
        
        if(this.nextTurnIsAllowed() == true){
            nextTurnPossible = true;
            this.currentMonster = dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            
            if(this.currentPlayer.isDead() == true){
                currentPlayer.initTreasures();
            } // if
        } // if
        
        return nextTurnPossible;
    }                                    // nextTurn


   
}


