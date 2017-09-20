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
 * @Description Class to handle the game aspects & initializations
 */
public class Napakalaki {
    // ***** Class attributes *****
    private static final Napakalaki instance = new Napakalaki();
    ArrayList<Player> players = new ArrayList();
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    
    // ***** Class constructor *****
    private Napakalaki(){
        this.dealer = CardDealer.getInstance();
    }                                          // Private Constructor
    
    // ***** Class methods *****
    
    /*
    * Method that retrieves an instance from the class.
    * @return Napakalaki instance.
    */
    public static Napakalaki getInstance(){
        return instance;
    }                        // getInstance
    
    /*
    * Method that initializes the players of the game.
    * @param names Names from the players to be created.
    */
    private void initPlayers(ArrayList<String> names){
        for(int i = 0 ; i < names.size() ; i++){
            Player p = new Player(names.get(i));
            players.add(p);
        } // for
    }             // initPlayers
    
    /*
    * Method that set the enemy for each player ( random player from the rest of players ) to who each player will try to steal.
    */
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
    
    /*
    * Method that retrieves the next player to play
    * @return Next player to play
    */
    private Player nextPlayer(){
        if(this.currentPlayer == null){ // First Play
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
    
    /*
    * Method that check if the player can pass the turn to the next player.
    * @return Boolean indicating if the turn can be passed to the next player.
    */
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
    
    /*
    * Method that checks if the last combat causes the end of the game
    * @param result Result from the last combat developed.
    * @return boolean indicating if the game has ended.
    */
    protected boolean endOfGame(CombatResult result){
        if(result == CombatResult.WINGAME){
            return true;
        } // if
        else{
            return false;
        } // else
    }              // endOfGame
    
    /*
    * Method that makes a list of treasures visible.
    * @param treasures Array with the treasures to be moved to the visible treasures array.
    */
    protected void makeTreasuresVisible(ArrayList<Treasure> treasures){
      for(int i = 0; i < treasures.size(); i++){
        this.currentPlayer.makeTreasureVisible(treasures.get(i));
      }   // for
      
    }// makeTreasuresVisible
    
    /*
    * Method that discards a visible treasure from the player and retrieves it to the used treasure list.
    * @param treasures Treasures to be discarded from the player.
    */
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
      for(int i = 0; i < treasures.size();i++){
        this.currentPlayer.discardVisibleTreasure(treasures.get(i));
        this.dealer.giveTreasureBack(treasures.get(i));
      } // for
            
    }// discardVisibleTreasures
    
    /*
    * Method that discards a hidden treasure from the player and trtrieves it to the used treasure list.
    * @param treasures Treasures to be discarded from the player.
    */
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
      for(int i = 0; i < treasures.size();i++){
        this.currentPlayer.discardHiddenTreasure(treasures.get(i));
        this.dealer.giveTreasureBack(treasures.get(i));
      } // for
                
    } // discardHiddenTreasures
    
    /*
    * Method in charge of performing a combat between a monster and the current player.
    * @return Result form the combat.
    */
    public CombatResult developCombat(){
        CombatResult result = this.currentPlayer.combat(this.currentMonster);
        return result;
    }                           // developCombat
    
    /*
    * Method that initializes the game ( Decks, players, enemies and set the next turn )
    * @param players Names for the playres to be created.
    */
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
    
    /*
    * Method that retrieves the current player.
    * @return Current player
    */
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }                              // getCurrentPlayer
    
    /*
    * Method that retrieves current monster.
    * @return Current monster.
    */
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }                            // getCurrentMonster
    
    /*
    * Method that checks if next turn if possible and if so, changes turn.
    * @return Boolean indicating if turn has been changed.
    */
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


