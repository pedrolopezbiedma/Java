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
    }    // Parameter Constructor
    BadConsecuence(String t, int l, ArrayList<TreasureKind> visTreasures, 
            ArrayList<TreasureKind> hidTreasures){
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = visTreasures.size();
        this.nHiddenTreasures = hidTreasures.size();
        this.specificVisibleTreasures = visTreasures;
        this.specificHiddenTreasures = hidTreasures;
    }          // Parameter Constructor with specific treasures
    BadConsecuence(String t){
        this.text = t;
        this.levels = 10;
        this.nVisibleTreasures = 10;
        this.nHiddenTreasures = 10;
        this.specificHiddenTreasures = null;
        this.specificVisibleTreasures = null; 
    }                               // Parameter Constructor simulating death
    
    public void setText(String t){
        this.text = t;
    }                          // setText
    public void setLevels(int l){
        this.levels = l;
    }                           // setLevels
    public void setVisTreasures(int nVisT){
        this.nVisibleTreasures = nVisT;
    }                 // setVisTreasures
    public void setHidTreasures(int nHidT){
        this.nHiddenTreasures = nHidT;
    }                 // setHidTreasures
    public String getText(){
        return this.text;
    }                                // getText
    public int getLevels(){
        return this.levels;
    }                                 // getLevels
    public int getVisTreasures(){
        return this.nVisibleTreasures;
    }                           // getVisTreasures
    public int getHidTreasures(){
        return this.nHiddenTreasures;
    }                           // getHidTreasures
    
    
}
