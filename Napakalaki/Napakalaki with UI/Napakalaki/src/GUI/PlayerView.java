/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Component;
import napakalaki.Player;
import napakalaki.Treasure;
import napakalaki.Napakalaki;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pjlopezb
 */
public class PlayerView extends javax.swing.JPanel {

    public Player playerModel;
    private Napakalaki napakalakiModel;
    NapakalakiView napakalakiView;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    private void fillHiddenTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Cleaning the view.
        aPanel.removeAll();
                
        // Building the treasure view at the same time we loop over it
        if(aList != null){
            for(Treasure t: aList){
            
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aPanel.add (aTreasureView);
            aTreasureView.setEnabled (true);
            aTreasureView.setVisible (true);
            System.out.println("Tesoro:" + t.getName());
            aPanel.revalidate();
            
            } // for
        } // if
        
        // Updating the panel view for sure

        aPanel.revalidate();
        aPanel.repaint();

    } // fillTreasurePanel
    public void setPlayer(Player p, NapakalakiView napaView){
        this.napakalakiView = napaView;
        this.playerModel = p;
        this.playerName.setText (playerModel.getName());
        this.playerLevel.setText (Integer.toString(playerModel.getLevels()));
        this.playerCombatLevel.setText (Integer.toString(playerModel.getCombatLevel()));
        this.playerEnemyName.setText(playerModel.getEnemy().getName());

        if(p.getPendingBC()!=null){
            this.playerPendingBC.setPendingBadConsequence(playerModel.getPendingBC());
            this.playerPendingBC.setVisible(true);
        }
        else{
            this.playerPendingBC.setVisible(false);
        }

        if(playerModel.getVisibleTreasures() != null){
            System.out.println("Tesoros Visibles:");
            this.fillHiddenTreasurePanel(visibleTreasures,playerModel.getVisibleTreasures());
            this.visibleTreasures.repaint();
            this.visibleTreasures.revalidate();
        }
        
        if(playerModel.getHiddenTreasures() != null){
            System.out.println("Tesoros Ocultos:");
            this.fillHiddenTreasurePanel(hiddenTreasures,playerModel.getHiddenTreasures());
            this.hiddenTreasures.setVisible(true);
            this.hiddenTreasures.repaint();
            this.hiddenTreasures.revalidate();
        }
        
        if(playerModel.getHiddenTreasures().isEmpty() && playerModel.getVisibleTreasures().isEmpty()){
            discardTreasure.setEnabled(false);
            discardAllTreasures.setEnabled(false);
        } else{
            discardTreasure.setEnabled(true);
            discardAllTreasures.setEnabled(true);
        }
        
        makeTreasureVisible.setEnabled(!playerModel.getHiddenTreasures().isEmpty());
        stealTreasure.setEnabled(playerModel.canISteal());
        
        repaint();
        revalidate();
    }     // setPlayer
    public void setNapakalakiModel(Napakalaki n){
           this.napakalakiModel = n;
    }
    public GUI.PendingBCView getPBadConsequenceView() {
        return this.playerPendingBC;
    }
    public void update(){
        setPlayer(playerModel, napakalakiView);
        repaint();
    }    
    public void setStealButton(boolean status){
        if(status == true && playerModel.canISteal())
            this.stealTreasure.setEnabled(true);
        else
            this.stealTreasure.setEnabled(false);
    } // setStealButton
    public void setDiscardButtons(boolean status){
        this.discardTreasure.setEnabled(status);
        this.discardAllTreasures.setEnabled(status);
    }
    public void setMakeTreasureVisibleButton(boolean status){
        this.makeTreasureVisible.setEnabled(status);
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {

        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.getIsSelected() )
                output.add ( tv.getTreasure() );
        }
        return output;
    }
       
    private ArrayList<Treasure> getAllTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            output.add(tv.getTreasure());
        }
        return output;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stealTreasure = new javax.swing.JButton();
        makeTreasureVisible = new javax.swing.JButton();
        discardTreasure = new javax.swing.JButton();
        discardAllTreasures = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerLevel = new javax.swing.JLabel();
        playerCombatLevel = new javax.swing.JLabel();
        playerEnemyName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        playerPendingBC = new GUI.PendingBCView();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Player View");

        jLabel2.setText("Name:");

        jLabel3.setText("Level:");

        jLabel4.setText("Combat Level:");

        jLabel5.setText("Enemy:");

        visibleTreasures.setBackground(new java.awt.Color(255, 255, 255));
        visibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hiddenTreasures.setBackground(new java.awt.Color(255, 255, 255));
        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Visible Treasures:");

        jLabel7.setText("Hidden Treasures:");

        stealTreasure.setBackground(new java.awt.Color(0, 0, 0));
        stealTreasure.setText("Steal Treasure");
        stealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureActionPerformed(evt);
            }
        });

        makeTreasureVisible.setText("Make Visible");
        makeTreasureVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeTreasureVisibleActionPerformed(evt);
            }
        });

        discardTreasure.setText("Discard Treasure");
        discardTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasureActionPerformed(evt);
            }
        });

        discardAllTreasures.setText("Discard All Treasures");
        discardAllTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasuresActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel8.setText("Player Actions");

        playerName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        playerLevel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        playerCombatLevel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        playerEnemyName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel9.setText("Player Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerPendingBC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(playerLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(playerEnemyName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(playerName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(playerCombatLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(stealTreasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(discardTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(discardAllTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(makeTreasureVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel8))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(playerEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playerLevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerCombatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(makeTreasureVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discardAllTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discardTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerPendingBC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void discardAllTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasuresActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getAllTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getAllTreasures(visibleTreasures);
        this.napakalakiModel.discardHiddenTreasures(selHidden);
        this.napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(this.napakalakiModel.getCurrentPlayer(),napakalakiView);
        this.playerPendingBC.setPendingBadConsequence(playerModel.getPendingBC());
    }//GEN-LAST:event_discardAllTreasuresActionPerformed

    private void makeTreasureVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeTreasureVisibleActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        this.napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(this.napakalakiModel.getCurrentPlayer(),this.napakalakiView);
    }//GEN-LAST:event_makeTreasureVisibleActionPerformed

    private void discardTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasureActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        this.napakalakiModel.discardHiddenTreasures(selHidden);
        this.napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(this.napakalakiModel.getCurrentPlayer(), this.napakalakiView);
        napakalakiView.update();
        this.playerPendingBC.setPendingBadConsequence(playerModel.getPendingBC());
    }//GEN-LAST:event_discardTreasureActionPerformed

    private void stealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureActionPerformed
        // TODO add your handling code here:
        Treasure aTreasure = napakalakiModel.getCurrentPlayer().stealTreasure();
        if(aTreasure == null){
            JOptionPane.showMessageDialog(null, "No has podido robar nada!");
        } else{
            JOptionPane.showMessageDialog(null, "Has robado un tesoro!");
        }
        setPlayer(napakalakiModel.getCurrentPlayer(), napakalakiView);
        stealTreasure.setEnabled(false);
    }//GEN-LAST:event_stealTreasureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton discardAllTreasures;
    private javax.swing.JButton discardTreasure;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton makeTreasureVisible;
    private javax.swing.JLabel playerCombatLevel;
    private javax.swing.JLabel playerEnemyName;
    private javax.swing.JLabel playerLevel;
    private javax.swing.JLabel playerName;
    private GUI.PendingBCView playerPendingBC;
    private javax.swing.JButton stealTreasure;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
