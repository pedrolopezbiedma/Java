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
public class BadConsecuence {
    // Class attributes.
    public static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    // Methods
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
    protected boolean isEmpty(){
        boolean isEmpty;
        
        if(this.specificHiddenTreasures.isEmpty() &&
           this.specificVisibleTreasures.isEmpty() &&
           this.nHiddenTreasures == 0 &&
           this.nVisibleTreasures == 0 ){
            isEmpty = true;
        } // This BadConsecuence does not make treasures to be lost.
        else{
            isEmpty = false;
        }
        return isEmpty;
    }                                  // isEmpty 
    protected String getText(){
        return this.text;
    }                                    // getText
    protected int getLevels(){
        return this.levels;
    }                                     // getLevels
    protected int getNVisTreasures(){
        return this.nVisibleTreasures;
    }                              // getVisTreasures
    protected int getNHidTreasures(){
        return this.nHiddenTreasures;
    }                              // getHidTreasures
    protected ArrayList<TreasureKind> getSpecVisTreasures(){
        return this.specificVisibleTreasures;
    }       // getSpecVisTreasures
    protected ArrayList<TreasureKind> getSpecHidTreasures(){
        return this.specificHiddenTreasures;
    }       // getSpecHidTreasures
    protected void substractVisTreasures(Treasure t){
      this.specificVisibleTreasures.remove(t.getType());
      this.nVisibleTreasures--;
    }              // substractVisTreasures
    protected void substractHidTreasures(Treasure t){
      this.specificHiddenTreasures.remove(t.getType());
      this.nHiddenTreasures--;        
    }              // substractHidTreasures
    protected BadConsecuence adjustToFitTreasureLists(ArrayList<Treasure> visTreasures, 
            ArrayList<Treasure> hidTreasures){
        BadConsecuence bc = new BadConsecuence("Text");
        
        return bc;
    }                     // adjustToFitTreasureLists ***** TO BE DEVELOPED *****
    @Override // TODO Mostrar lista de tesoros.
    public String toString(){
        String status;
        status = "Text: " + this.text 
                + " ,Levels: " + Integer.toString(this.levels) 
                + " ,Visible Treasures: " + Integer.toString(this.nVisibleTreasures) +
                " and Hidden Treasures: " + Integer.toString(this.nHiddenTreasures);
        return status;
    }                                      // Retrieve object status
}
