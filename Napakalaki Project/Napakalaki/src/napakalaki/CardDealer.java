/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Pedro
 */
public class CardDealer {
    // Class Attributes
    private static final CardDealer instance = new CardDealer();
    ArrayList<Monster> unusedMonsters = new ArrayList();
    ArrayList<Monster> usedMonsters = new ArrayList();
    ArrayList<Treasure> unusedTreasures = new ArrayList();
    ArrayList<Treasure> usedTreasures = new ArrayList();
    
    // Methods
    private CardDealer(){
        
    }                                          // Parameter Constructor
    public static CardDealer getInstance(){
        return instance;
    }                        // getInstance
    protected void initTreasureCardDeck(){
        
    }                         // initTreasureCardDeck **** TO BE DEVELOPED *****
    protected void initMonsterCardDeck(){
        // Bonanza
        BadConsecuence badConsec = new BadConsecuence("Pierdes tu armadura visible y otra oculta.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        Monster monster = new Monster("3 Byakhees de bonanza", 8, badConsec, prize);
        this.unusedMonsters.add(monster);
        
        // Angeles de la noche ibicenca.
        BadConsecuence badConsec1 = new BadConsecuence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descartan 1 mano visible y otra oculta.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize1 = new Prize(4,1);
        Monster monster1 = new Monster("Ángeles de la noche ibicenca", 14, badConsec1, prize1);
        this.unusedMonsters.add(monster1);
        
        // Bicéfalo.
        BadConsecuence badConsec2 = new BadConsecuence("Te faltan manos para tanta cabeza. Pïerdes 3 niveles y tus tesoros visibles de las manos.", 
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        Monster monster2 = new Monster("Bicéfalo", 20, badConsec2, prize2);
        this.unusedMonsters.add(monster2);
        
        // Bichgooth
        BadConsecuence badConsec3 = new BadConsecuence("Sientes bichos bajo la ropa. Descarta la armadura visible", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize3 = new Prize(1,1);
        Monster monster3 = new Monster("Bichgooth", 2, badConsec3, prize3);
        this.unusedMonsters.add(monster3);     
        
        // Chibithulthu
        BadConsecuence badConsec4 = new BadConsecuence("Embobados con el lindo primigeniote descartas de tu casco visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize4 = new Prize(1,1);
        Monster monster4 = new Monster("Chibithultu", 2, badConsec4, prize4);
        this.unusedMonsters.add(monster4);             
        
        // Dameargo
        BadConsecuence badConsec5 = new BadConsecuence("Te intentas escaquear. Pierdes una mano visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        Prize prize5 = new Prize(2,1);
        Monster monster5 = new Monster("Dameargo", 1, badConsec5, prize5);
        this.unusedMonsters.add(monster5);
        
        // El espía
        BadConsecuence badConsec6 = new BadConsecuence("Te asusta en la noche. Pierdes un casco visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(1,1);
        Monster monster6 = new Monster("El espía", 5, badConsec6, prize6);
        this.unusedMonsters.add(monster6);
        
        // El gorrón del umbral.
        BadConsecuence badConsec7 = new BadConsecuence("Pïerdes todos tus tesoros visbles.", 
                0, BadConsecuence.MAXTREASURES, 0);
        Prize prize7 = new Prize(3,1);
        Monster monster7 = new Monster("El gorrón del umbral", 10, badConsec7, prize7);
        this.unusedMonsters.add(monster7);  
        
        // El gran cthulhu. TODO ( +4 vs sectarios? )
        BadConsecuence badConsec8 = new BadConsecuence("Hoy no es tu dia de suerte. Mueres ");
        Prize prize8 = new Prize(2,5);
        Monster monster8 = new Monster("El gran cthulhu", 20, badConsec8, prize8);
        this.unusedMonsters.add(monster8);  

        // El lenguas
        BadConsecuence badConsec9 = new BadConsecuence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",
            2, 5, 0);
        Prize prize9 = new Prize(1,1);
        Monster monster9 = new Monster("El lenguas", 20, badConsec9, prize9);
        this.unusedMonsters.add(monster9);  
        
        // El mal indecible impronunciable TODO: ( -2 vs sectarios? )
        BadConsecuence badConsec10 = new BadConsecuence("Pierdes 1 mano visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        Prize prize10 = new Prize(3,1);
        Monster monster10 = new Monster("El lenguas", 10, badConsec10, prize10);
        this.unusedMonsters.add(monster10);       
        
        // El rey de rosa
        BadConsecuence badConsec11 = new BadConsecuence("Pierdes 5 niveles y 3 tesoros visbles.",
            5, 3, 0);
        Prize prize11 = new Prize(4,2);
        Monster monster11 = new Monster("El rey de rosa", 13, badConsec11, prize11);
        this.unusedMonsters.add(monster11); 
        
        // El sopor de Dunwich
        BadConsecuence badConsec12 = new BadConsecuence("El primordial bostezo contagioso. Pierdes el calzado visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(1,1);
        Monster monster12 = new Monster("El sopor de Dunwich", 2, badConsec12, prize12);
        this.unusedMonsters.add(monster12);
        
        // Familia feliz
        BadConsecuence badConsec13 = new BadConsecuence("La familia te atrapa. Estas muerto.");
        Prize prize13 = new Prize(4,1);
        Monster monster13 = new Monster("Familia feliz", 1, badConsec13, prize13);
        this.unusedMonsters.add(monster13);
        
        // Felpuggoth TODO: ( +5 vs sectarios? )
        BadConsecuence badConsec14 = new BadConsecuence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",
            0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
        Prize prize14 = new Prize(1,1);
        Monster monster14 = new Monster("Felpuggoth", 2, badConsec14, prize14);
        this.unusedMonsters.add(monster14);
        
        // H.P. Munchcraft
        BadConsecuence badConsec15 = new BadConsecuence("Pierdes la armadura visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize15 = new Prize(2,1);
        Monster monster15 = new Monster("H.P. Munchcraft", 6, badConsec15, prize15);
        this.unusedMonsters.add(monster15);
        
        // La que redacta en las tinieblas
        BadConsecuence badConsec16 = new BadConsecuence("Toses los pulmones y pierdes 2 niveles.",
            2, 0, 0);
        Prize prize16 = new Prize(1,1);
        Monster monster16 = new Monster("La que redacta en las tinieblas", 2, badConsec16, prize16);
        this.unusedMonsters.add(monster16);
        
        // Lolitagooth TODO: ( +3 vs sectatios? )
        BadConsecuence badConsec17 = new BadConsecuence("Pintalabias negro. Pierdes 2 niveles.",
            2, 0, 0);
        Prize prize17 = new Prize(1,1);
        Monster monster17 = new Monster("Lolitagooth", 2, badConsec17, prize17);
        this.unusedMonsters.add(monster17);
        
        // Los hondos
        BadConsecuence badConsec18 = new BadConsecuence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.");
        Prize prize18 = new Prize(2,1);
        Monster monster18 = new Monster("Los hondos", 8, badConsec18, prize18);
        this.unusedMonsters.add(monster18);
 
        // Pollipólipo volante
        BadConsecuence badConsec19 = new BadConsecuence("Da mucho asquito, pierdes 3 niveles.",
          3, 0, 0);
        Prize prize19 = new Prize(1,1);
        Monster monster19 = new Monster("Pollipólipo volante", 3, badConsec19, prize19);
        this.unusedMonsters.add(monster19); 
        
        // Roboggoth
        BadConsecuence badConsec20 = new BadConsecuence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de 2 manos visible.",
          2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize20 = new Prize(2,1);
        Monster monster20 = new Monster("Roboggoth", 8, badConsec20, prize20);
        this.unusedMonsters.add(monster20);  
        
        // Semillas Cthulhu
        BadConsecuence badConsec21 = new BadConsecuence("Pierdes 2 niveles y 2 tesoros ocultos",
          2, 0, 2);
        Prize prize21 = new Prize(2,1);
        Monster monster21 = new Monster("Semillas Cthulhu", 4, badConsec21, prize21);
        this.unusedMonsters.add(monster21);  

        // Serpiente político TODO: ( -2 vs Sectarios? )
        BadConsecuence badConsec22 = new BadConsecuence("Tu gobierno te recorta 2 niveles.",
          2, 0, 0);
        Prize prize22 = new Prize(2,1);
        Monster monster22 = new Monster("Serpiente político", 8, badConsec22, prize22);
        this.unusedMonsters.add(monster22); 

        // Shoggoth
        BadConsecuence badConsec23 = new BadConsecuence("Pierdes 2 niveles.",
          2, 0, 0);
        Prize prize23 = new Prize(4,2);
        Monster monster23 = new Monster("Shoggoth", 16, badConsec23, prize23);
        this.unusedMonsters.add(monster23);
        
        // Testigos Oculares TODO ( +2 VS Sectarios? )
        BadConsecuence badConsec24 = new BadConsecuence("Pïerdes tus tesoros visibles. Jajaja!!!.",
          0, BadConsecuence.MAXTREASURES, 0);
        Prize prize24 = new Prize(2,1);
        Monster monster24 = new Monster("Testigos Oculares", 6, badConsec24, prize24);
        this.unusedMonsters.add(monster24);
        
        // Yskhtihyssg-Goth
        BadConsecuence badConsec25 = new BadConsecuence("No le hace gracia que pronuncien mal su nombre. Estás muerto.");
        Prize prize25 = new Prize(3,1);
        Monster monster25 = new Monster("Yskhtihyssg-Goth", 12, badConsec25, prize25);
        this.unusedMonsters.add(monster25);
    }                        // initMonsterCardDeck
    protected void shuffleTreasures(){
        long seed = System.nanoTime();
        Collections.shuffle(this.unusedTreasures,new Random(seed));
    }                             // shuffleTreasures
    protected void shuffleMonsters(){
        long seed = System.nanoTime();
        Collections.shuffle(this.unusedMonsters,new Random(seed));        
    }                              // shuffleMonsters
    protected Treasure nextTreasure(){
       Treasure t;
       return t;
    }                             // nextTreasure ***** TO BE DEVELOPED *****
    protected Monster nextMonster(){
        Monster m;
        return m;
    }                               // nextMonster ***** TO BE DEVELOPED *****
    protected void giveTreasureBack(Treasure t){
      if(this.unusedTreasures.contains(t) == true){
        this.unusedTreasures.remove(t);
        this.usedTreasures.add(t);
      } // if
    }                   // giveTreasureBack
    protected void giveMonsterBack(Monster m){
      if(this.unusedMonsters.contains(m) == true){
        this.unusedMonsters.remove(m);
        this.usedMonsters.add(m);           
      } // if
    }                     // giveMonsterBack
    protected void initCards(){
        
    }                                    // initCards ***** TO BE DEVELOPED *****
}
