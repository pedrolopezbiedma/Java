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
 * @Descripion: Class to handle BadConsequence behavior.
 */
public class BadConsecuence {
    // ***** Class attributes. *****
    public static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    // ***** Class constructors *****
    BadConsecuence(String t, int l, int nVis, int nHid){
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = nVis;
        this.nHiddenTreasures = nHid;
        this.specificVisibleTreasures = null; 
        this.specificHiddenTreasures = null;
    }           // Parameter Constructor
    BadConsecuence(String t, int l, ArrayList<TreasureKind> visTreasures, 
            ArrayList<TreasureKind> hidTreasures){
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = visTreasures.size();
        this.nHiddenTreasures = hidTreasures.size();
        this.specificVisibleTreasures = visTreasures;
        this.specificHiddenTreasures = hidTreasures;
    }                 // Parameter Constructor with specific treasures
    BadConsecuence(String t){
        this.text = t;
        this.levels = Player.MAXLEVEL;
        this.nVisibleTreasures = MAXTREASURES;
        this.nHiddenTreasures = MAXTREASURES;
        this.specificHiddenTreasures = null;
        this.specificVisibleTreasures = null; 
    }                                      // Parameter Constructor simulating death
    
    // ***** Class methods *****
    /*
    * Method that checks if BadConsequence is empty.
    * @return Boolean specifying if BadConsequence is empty.
    */
    protected boolean isEmpty(){
        boolean isEmpty;
        if(this.nHiddenTreasures == 0 &&
            this.nVisibleTreasures == 0 ){
            if(this.specificHiddenTreasures == null &&
                this.specificVisibleTreasures == null){
                isEmpty = true;
            } // if
            else{
                if(this.specificHiddenTreasures.size() > 0 &&
                   this.specificVisibleTreasures.size() > 0){
                    isEmpty = false;
                } // if
                else{
                    isEmpty = true;
                } // else
            } // else
        } // if
        else{
            isEmpty = false;
        }
        return isEmpty;
    }                                  // isEmpty
    
    /*
    * Method that retrieves BadConsequence description.
    * @return BadConsequence description
    */
    public String getText(){
        return this.text;
    }                                    // getText
    
    /*
    * Method that retieves levels that player will lose if BadConsequence is applied.
    * @return BadConsequence level
    */
    public int getLevels(){
        return this.levels;
    }                                     // getLevels
    
    /*
    * Method that retrieves the number of visible but not specific treasures that the player will lose if BadConsequence is applied .
    * @return BadConsequence visible treasures number.
    */
    public int getNVisTreasures(){
        return this.nVisibleTreasures;
    }                              // getVisTreasures
    
    /*
    * Method that will retrieves the number of hidden but not specific treasures that the player will lose if BadConsequence is applied.
    * @return BadConsequence hidden treasures number.
    */
    public int getNHidTreasures(){
        return this.nHiddenTreasures;
    }                              // getHidTreasures
    
    /*
    * Method that will trtrieves the specific visible treasures that the player will lose if BadConsequence is applied.
    * @return ArrayList with the specific visible treasures.
    */
    public ArrayList<TreasureKind> getSpecVisTreasures(){
        return this.specificVisibleTreasures;
    }       // getSpecVisTreasures
    
    /*
    * Method that will retrieves the specific hidden treasures that the player will lose if BadConsequence is applied.
    * @return ArrayList with the specific hidden treasures.
    */
    public ArrayList<TreasureKind> getSpecHidTreasures(){
        return this.specificHiddenTreasures;
    }       // getSpecHidTreasures
    
    /*
    * Method that subtracts a specific visible treasure from the BadConsequence.
    * @param t Treasure to be removed.
    */
    protected void substractVisTreasures(Treasure t){
        if(this.specificVisibleTreasures != null){
            boolean removed = false;
            removed = this.specificVisibleTreasures.remove(t.getType());
            if(removed == true){
                this.nVisibleTreasures--;
            } // if
        } // if
        else{
            this.nVisibleTreasures--;
        } // else
    }             // substractVisTreasures
    
    /*
    * Method that substract a specific hidden treasure from the BadConsequence.
    * @param t Treasure to be removed.
    */
    protected void substractHidTreasures(Treasure t){
        if(this.specificHiddenTreasures != null){
            boolean removed = false;
            this.specificHiddenTreasures.remove(t.getType());
            if(removed == true){
                this.nHiddenTreasures--;        
            } // if
        } // if
        else{
            this.nHiddenTreasures--;
        } // else
    }             // substractHidTreasures
    
    /*
    * Method that adjust the BadConsequence to the actual list of treasures from the player and retrieves an updated BadConsequence.
    * @param visSpecTreasures specific visible treasures owned by the player.
    * @param hidSpecTreasures specific hidden treasures owned by the player.
    * @return an updated BadConsequence that can be suffered by the player with its treasures lists.
    */
    protected BadConsecuence adjustToFitTreasureLists(ArrayList<Treasure> visSpecTreasures, 
            ArrayList<Treasure> hidSpecTreasures){
            if(visSpecTreasures != null){
                if(this.nVisibleTreasures > visSpecTreasures.size()){
                    this.nVisibleTreasures = visSpecTreasures.size();
                } // if
                
                if(this.specificVisibleTreasures != null){
                    ArrayList<TreasureKind> newVisibleTreasures = new ArrayList();
                    for(int i = 0; i < this.specificVisibleTreasures.size(); i++){
                        boolean found = false;
                        for(int j = 0; j < visSpecTreasures.size() && found == false; j++){
                            if(this.specificVisibleTreasures.get(i) == visSpecTreasures.get(j).getType()){
                                newVisibleTreasures.add(this.specificVisibleTreasures.get(i));
                                found = true;
                            }  // if
                        } // for
                    } // for
                    this.specificVisibleTreasures = newVisibleTreasures;
                    if(newVisibleTreasures != null){
                        this.nVisibleTreasures = newVisibleTreasures.size();
                    } // if
                    else{
                        this.nVisibleTreasures = 0;
                    }
                } // if
            } // if
            else{
                this.nVisibleTreasures = 0;
            } // else

            if(hidSpecTreasures != null){    
                if(this.nHiddenTreasures > hidSpecTreasures.size()){
                    this.nHiddenTreasures = hidSpecTreasures.size();
                } // if
                
                if(this.specificHiddenTreasures != null){
                    ArrayList<TreasureKind> newHiddenTreasures = new ArrayList();
                    for(int i = 0; i < this.specificHiddenTreasures.size(); i++){
                        boolean found = false;
                            for(int j = 0; j < hidSpecTreasures.size() && found == false; j++){
                                if(this.specificHiddenTreasures.get(i) == hidSpecTreasures.get(j).getType()){
                                    newHiddenTreasures.add(this.specificHiddenTreasures.get(i));
                                    found = true;
                                }  // if
                            } // for
                    } // for
                    this.specificHiddenTreasures = newHiddenTreasures;
                    if(newHiddenTreasures != null){
                        this.nHiddenTreasures = newHiddenTreasures.size();
                    } // if
                    else{
                        this.nHiddenTreasures = 0;
                    }
                } // if
            } // if
            else{
                this.nHiddenTreasures = 0;             
            }
        return this;
    }                // adjustToFitTreasureLists
    @Override
    public String toString(){
        String status;
        status = "Text: " + this.text 
                + " ,Levels: " + Integer.toString(this.levels);
                status = status + " and Num Visible Treasures: " + Integer.toString(this.nVisibleTreasures);
                status = status + " ***** Visible Treasures: *****" + "\n";
                if(this.specificHiddenTreasures != null){
                    for(int i = 0; i < this.specificVisibleTreasures.size();i++){
                        status = status + i+1 + this.specificVisibleTreasures.get(i).toString() + "\n";
                    } // for
                } // if
                status = status + " ,Num Hidden Treasures: " + Integer.toString(this.nHiddenTreasures);
                status = status + " ***** Hidden Treasures: ***** " + "\n";
                
                if(this.specificVisibleTreasures != null){
                    for(int i = 0; i < this.specificHiddenTreasures.size();i++){
                        status = status + i+1 + this.specificHiddenTreasures.get(i).toString() + "\n";
                    } // for
                } // if


        return status;
    }                                     // Retrieve object status
}
