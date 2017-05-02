/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PedroL
 */
public class Sudoku {
    
    // Class attributes
    private int[][] board = new int[9][9];
    
    // Class Methods
    Sudoku(){
        this.board = new int [9][9];
    } // Constructor
    private ArrayList<Integer> generateRandomNumbers(){
        
        ArrayList<Integer> randomNumbers = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList<>(9);
        for (int i=1;i<10;i++){
           numbers.add(i);
        }

        // Instanciamos la clase Random
        Random random = new Random();

        // Mientras queden cartas en el mazo (en la lista de numbers)
        while (numbers.size()>=1){
           // Elegimos un índice al azar, entre 0 y el número de cartas que quedan por sacar
           int randomIndex = random.nextInt(numbers.size());

           // Damos la carta al jugador (sacamos el número por pantalla)
           //System.out.println("Not Repeated Random Number "+numbers.get(randomIndex));
           randomNumbers.add(numbers.get(randomIndex));

           // Y eliminamos la carta del mazo (la borramos de la lista)
           numbers.remove(randomIndex);
        }
        return randomNumbers;
        
    } // generateRandomNumbers 
    public void sudokuGenerator(){
        int index;
        ArrayList<Integer> randomNumbers;
         
        // Generamos un vector con numeros aleatorios entre 1 y 9.
        randomNumbers = generateRandomNumbers();
        
        System.out.println("Estoy en sudoku Generator");
        index = 0;
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                board[i][j] = randomNumbers.get(index);
                index++;
            } // for
        } // for
        System.out.println("Termino la primera celda de sudoku Generator");

        /*Se rellenan los dos cuadros que quedan de arriba*/
        board[1][3]=board[0][0];
        board[1][4]=board[0][1];
        board[1][5]=board[0][2];

        board[2][6]=board[0][0];
        board[2][7]=board[0][1];
        board[2][8]=board[0][2];

        board[2][3]=board[1][0];
        board[2][4]=board[1][1];
        board[2][5]=board[1][2];

        board[0][6]=board[1][0];
        board[0][7]=board[1][1];
        board[0][8]=board[1][2];

        board[0][3]=board[2][0];
        board[0][4]=board[2][1];
        board[0][5]=board[2][2];

        board[1][6]=board[2][0];
        board[1][7]=board[2][1];
        board[1][8]=board[2][2];

        /*Se rellenan los cuadros de la izquierda*/
        board[3][1]=board[0][0];
        board[4][1]=board[1][0];
        board[5][1]=board[2][0];

        board[6][2]=board[0][0];
        board[7][2]=board[1][0];
        board[8][2]=board[2][0];

        board[3][2]=board[0][1];
        board[4][2]=board[1][1];
        board[5][2]=board[2][1];

        board[6][0]=board[0][1];
        board[7][0]=board[1][1];
        board[8][0]=board[2][1];

        board[3][0]=board[0][2];
        board[4][0]=board[1][2];
        board[5][0]=board[2][2];

        board[6][1]=board[0][2];
        board[7][1]=board[1][2];
        board[8][1]=board[2][2];

        /* Se rellena el cuadro central y derecho-centro*/
        board[3][3]=board[5][0];
        board[3][4]=board[5][1];
        board[3][5]=board[5][2];

        board[4][6]=board[5][0];
        board[4][7]=board[5][1];
        board[4][8]=board[5][2];

        board[5][3]=board[4][0];
        board[5][4]=board[4][1];
        board[5][5]=board[4][2];

        board[3][6]=board[4][0];
        board[3][7]=board[4][1];
        board[3][8]=board[4][2];

        board[5][6]=board[3][0];
        board[5][7]=board[3][1];
        board[5][8]=board[3][2];

        board[4][3]=board[3][0];
        board[4][4]=board[3][1];
        board[4][5]=board[3][2];

        /* Se rellena el cuadro central y derecho-centro*/
        board[6][3]=board[8][0];
        board[6][4]=board[8][1];
        board[6][5]=board[8][2];

        board[7][6]=board[8][0];
        board[7][7]=board[8][1];
        board[7][8]=board[8][2];

        board[8][3]=board[7][0];
        board[8][4]=board[7][1];
        board[8][5]=board[7][2];

        board[6][6]=board[7][0];
        board[6][7]=board[7][1];
        board[6][8]=board[7][2];

        board[8][6]=board[6][0];
        board[8][7]=board[6][1];
        board[8][8]=board[6][2];

        board[7][3]=board[6][0];
        board[7][4]=board[6][1];
        board[7][5]=board[6][2];
        
    } // sudokuGenerator
    public void showBoard(int level){

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8 ; j++){
                if( ((Math.random()*81+1) > level) ){
                    System.out.print(" " + board[i][j] + " ");
                }
                else{
                    System.out.print(ANSI_RED + " " + "#" + " " + ANSI_RESET);
                }
                if(j==2 || j==5 || j==8){
                    System.out.print(ANSI_BLUE + " | " + ANSI_RESET);
                } // if
            } // for
            if(i==2 || i==5 || i==8){
                System.out.print("\n");
                System.out.print(ANSI_BLUE + "-----------------------------------" + ANSI_RESET);
            } // if
            System.out.print("\n");
        } // for
        
        
        /*for (int i=0;i<=8;i++) {
                for (int j=0;j<=8;j++){
                    if( ((Math.random()*81+1) > level) ){
                    System.out.println("%i",board[i][j]);
                    System.out.println(board[i][j]);
                    } // if
                    else{
                        System.out.println("#");
                    } // else
                    if(j==2 || j==5 || j==8){
                        System.out.println("    ");
                    } // if
                } // for
            if(i==2 || i==5 || i==8){
                System.out.println("\n\n");
            } // if
            System.out.println("\n");
        } // for
        */
        System.out.println("Voy a salir del showBoard");
    } // showBoard
}
