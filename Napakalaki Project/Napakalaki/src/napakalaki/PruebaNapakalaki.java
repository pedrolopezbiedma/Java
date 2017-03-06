/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author PedroL
 */
public class PruebaNapakalaki {

    private static ArrayList<Monster> readMonsters(){
        
        ArrayList<Monster> monsters = new ArrayList();

        // Bonanza
        BadConsecuence badConsec = new BadConsecuence("Pierdes tu armadura visible y otra oculta.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        Monster monster = new Monster("3 Byakhees de bonanza", 8, badConsec, prize);
        monsters.add(monster);
        
        // Angeles de la noche ibicenca.
        BadConsecuence badConsec1 = new BadConsecuence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descartan 1 mano visible y otra oculta.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize1 = new Prize(4,1);
        Monster monster1 = new Monster("Ángeles de la noche ibicenca", 14, badConsec1, prize1);
        monsters.add(monster1);
        
        // Bicéfalo.
        BadConsecuence badConsec2 = new BadConsecuence("Te faltan manos para tanta cabeza. Pïerdes 3 niveles y tus tesoros visibles de las manos.", 
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        Monster monster2 = new Monster("Bicéfalo", 20, badConsec2, prize2);
        monsters.add(monster2);
        
        // Bichgooth
        BadConsecuence badConsec3 = new BadConsecuence("Sientes bichos bajo la ropa. Descarta la armadura visible", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize3 = new Prize(1,1);
        Monster monster3 = new Monster("Bichgooth", 2, badConsec3, prize3);
        monsters.add(monster3);     
        
        // Chibithulthu
        BadConsecuence badConsec4 = new BadConsecuence("Embobados con el lindo primigeniote descartas de tu casco visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize4 = new Prize(1,1);
        Monster monster4 = new Monster("Chibithultu", 2, badConsec4, prize4);
        monsters.add(monster4);             
        
        // Dameargo
        BadConsecuence badConsec5 = new BadConsecuence("Te intentas escaquear. Pierdes una mano visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        Prize prize5 = new Prize(2,1);
        Monster monster5 = new Monster("Dameargo", 1, badConsec5, prize5);
        monsters.add(monster5);
        
        // El espía
        BadConsecuence badConsec6 = new BadConsecuence("Te asusta en la noche. Pierdes un casco visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(1,1);
        Monster monster6 = new Monster("El espía", 5, badConsec6, prize6);
        monsters.add(monster6);
        
        // El gorrón del umbral.
        BadConsecuence badConsec7 = new BadConsecuence("Pïerdes todos tus tesoros visbles.", 
                0, 5, 0);
        Prize prize7 = new Prize(3,1);
        Monster monster7 = new Monster("El gorrón del umbral", 10, badConsec7, prize7);
        monsters.add(monster7);  
        
        // El gran cthulhu. TODO ( +4 vs sectarios? )
        BadConsecuence badConsec8 = new BadConsecuence("Hoy no es tu dia de suerte. Mueres ");
        Prize prize8 = new Prize(2,5);
        Monster monster8 = new Monster("El gran cthulhu", 20, badConsec8, prize8);
        monsters.add(monster8);  

        // El lenguas
        BadConsecuence badConsec9 = new BadConsecuence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",
            2, 5, 0);
        Prize prize9 = new Prize(1,1);
        Monster monster9 = new Monster("El lenguas", 20, badConsec9, prize9);
        monsters.add(monster9);  
        
        // El mal indecible impronunciable TODO: ( -2 vs sectarios? )
        BadConsecuence badConsec10 = new BadConsecuence("Pierdes 1 mano visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        Prize prize10 = new Prize(3,1);
        Monster monster10 = new Monster("El lenguas", 10, badConsec10, prize10);
        monsters.add(monster10);       
        
        // El rey de rosa
        BadConsecuence badConsec11 = new BadConsecuence("Pierdes 5 niveles y 3 tesoros visbles.",
            5, 3, 0);
        Prize prize11 = new Prize(4,2);
        Monster monster11 = new Monster("El rey de rosa", 13, badConsec11, prize11);
        monsters.add(monster11); 
        
        // El sopor de Dunwich
        BadConsecuence badConsec12 = new BadConsecuence("El primordial bostezo contagioso. Pierdes el calzado visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(1,1);
        Monster monster12 = new Monster("El sopor de Dunwich", 2, badConsec12, prize12);
        monsters.add(monster12);
        
        // Familia feliz
        BadConsecuence badConsec13 = new BadConsecuence("La familia te atrapa. Estas muerto.");
        Prize prize13 = new Prize(4,1);
        Monster monster13 = new Monster("Familia feliz", 1, badConsec13, prize13);
        monsters.add(monster13);
        
        // Felpuggoth TODO: ( +5 vs sectarios? )
        BadConsecuence badConsec14 = new BadConsecuence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",
            0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
        Prize prize14 = new Prize(1,1);
        Monster monster14 = new Monster("Felpuggoth", 2, badConsec14, prize14);
        monsters.add(monster14);
        
        // H.P. Munchcraft
        BadConsecuence badConsec15 = new BadConsecuence("Pierdes la armadura visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize15 = new Prize(2,1);
        Monster monster15 = new Monster("H.P. Munchcraft", 6, badConsec15, prize15);
        monsters.add(monster15);
        
        // La que redacta en las tinieblas
        BadConsecuence badConsec16 = new BadConsecuence("Toses los pulmones y pierdes 2 niveles.",
            2, 0, 0);
        Prize prize16 = new Prize(1,1);
        Monster monster16 = new Monster("La que redacta en las tinieblas", 2, badConsec16, prize16);
        monsters.add(monster16);
        
        // Lolitagooth TODO: ( +3 vs sectatios? )
        BadConsecuence badConsec17 = new BadConsecuence("Pintalabias negro. Pierdes 2 niveles.",
            2, 0, 0);
        Prize prize17 = new Prize(1,1);
        Monster monster17 = new Monster("Lolitagooth", 2, badConsec17, prize17);
        monsters.add(monster17);
        
        // Los hondos
        BadConsecuence badConsec18 = new BadConsecuence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.");
        Prize prize18 = new Prize(2,1);
        Monster monster18 = new Monster("Los hondos", 8, badConsec18, prize18);
        monsters.add(monster18);
 
        // Pollipólipo volante
        BadConsecuence badConsec19 = new BadConsecuence("Da mucho asquito, pierdes 3 niveles.",
          3, 0, 0);
        Prize prize19 = new Prize(1,1);
        Monster monster19 = new Monster("Pollipólipo volante", 3, badConsec19, prize19);
        monsters.add(monster19); 
        
        // Roboggoth
        BadConsecuence badConsec20 = new BadConsecuence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de 2 manos visible.",
          2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize20 = new Prize(2,1);
        Monster monster20 = new Monster("Roboggoth", 8, badConsec20, prize20);
        monsters.add(monster20);  
        
        // Semillas Cthulhu
        BadConsecuence badConsec21 = new BadConsecuence("Pierdes 2 niveles y 2 tesoros ocultos",
          2, 0, 2);
        Prize prize21 = new Prize(2,1);
        Monster monster21 = new Monster("Semillas Cthulhu", 4, badConsec21, prize21);
        monsters.add(monster21);  

        // Serpiente político TODO: ( -2 vs Sectarios? )
        BadConsecuence badConsec22 = new BadConsecuence("Tu gobierno te recorta 2 niveles.",
          2, 0, 0);
        Prize prize22 = new Prize(2,1);
        Monster monster22 = new Monster("Serpiente político", 8, badConsec22, prize22);
        monsters.add(monster22); 

        // Shoggoth
        BadConsecuence badConsec23 = new BadConsecuence("Pierdes 2 niveles.",
          2, 0, 0);
        Prize prize23 = new Prize(4,2);
        Monster monster23 = new Monster("Shoggoth", 16, badConsec23, prize23);
        monsters.add(monster23);
        
        // Testigos Oculares TODO ( +2 VS Sectarios? )
        BadConsecuence badConsec24 = new BadConsecuence("Pïerdes tus tesoros visibles. Jajaja!!!.",
          0, 5, 0);
        Prize prize24 = new Prize(2,1);
        Monster monster24 = new Monster("Testigos Oculares", 6, badConsec24, prize24);
        monsters.add(monster24);
        
        // Yskhtihyssg-Goth
        BadConsecuence badConsec25 = new BadConsecuence("No le hace gracia que pronuncien mal su nombre. Estás muerto.");
        Prize prize25 = new Prize(3,1);
        Monster monster25 = new Monster("Yskhtihyssg-Goth", 12, badConsec25, prize25);
        monsters.add(monster25);
        
        return monsters;
    } // readMonsters
    private static void bigCombatLevelMonsters(ArrayList<Monster> monsters){
      for( int i = 0 ; i < monsters.size() ; i++){
          if(monsters.get(i).getCombatLvl() > 10){
              monsters.get(i).toString();
          } // if
      } // for 
    } // bigCombatLevelMonsters
    private static void justLevelLostMonsters(ArrayList<Monster> monsters){
        for(int i = 0 ; i < monsters.size() ; i++){
            if((monsters.get(i).getBadConsecuence().getLevels()!= 0)){
                if(monsters.get(i).getBadConsecuence().getVisTreasures() == 0 && 
                   monsters.get(i).getBadConsecuence().getHidTreasures() == 0){
                     monsters.get(i).toString();
                } // if
            } // if
        } // for
    } // justLevelLostMonsters
    private static void moreThanOneLevelPrizeMonsters(ArrayList<Monster> monsters){
        for(int i = 0 ; i < monsters.size() ; i++){
            if(monsters.get(i).getLevelsGained() > 1){
                monsters.get(i).toString();
            } // if
        } // for
    } // moreThanOneLevelPrizeMonsters
    private static void specificTreasureLostMonsters(ArrayList<Monster> monsters, TreasureKind tr){
        for(int i = 0; i < monsters.size() ;i++){
            ArrayList<TreasureKind> visTreasureKind = monsters.get(i).getBadConsecuence().getSpecVisTreasures();
            ArrayList<TreasureKind> hidTreasureKind = monsters.get(i).getBadConsecuence().getSpecHidTreasures();
            
            if(visTreasureKind.contains(tr) || hidTreasureKind.contains(tr)){
                monsters.get(i).toString();
            } // if
        } // for
    } // treasureLostMonsters
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        // ********** Variables **********
        ArrayList<Monster> monsters = new ArrayList();
        
        // ********** Creating Monsters **********
        monsters = readMonsters();
        
        // ********** Reports **********
        bigCombatLevelMonsters(monsters);
        justLevelLostMonsters(monsters);
        moreThanOneLevelPrizeMonsters(monsters);
        
        // TODO: Generalizar esto.
        System.out.println("Elija que tipo de tesoro quiere comprobar: ");
        specificTreasureLostMonsters(monsters, TreasureKind.HELMET );

        
        

        
    } // Main
    
}
