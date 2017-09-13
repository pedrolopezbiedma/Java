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
    private Cell[][] board = new Cell[9][9];
    
    // Private Methods
    private boolean checkRow(int row, int val){
    	boolean detected = false;
    	for(int i = 0; i < 8 && detected == false; i++){
    		if( this.board[row][i].getValue() == val){
    			detected = true;
    		} // if
    	} // for
    	
    	return detected;
    } // checkRow.
    private boolean checkColumn(int col, int val){
    	boolean detected = false;
    	for(int i = 0; i < 8 && detected == false; i++){
    		if( this.board[i][col].getValue() == val){
    			detected = true;
    		} // if
    	} // for
    	
    	return detected;
    } // checkColumn.
    private boolean checkSquare(int row, int col, int val){
    	boolean detected = false;
    	int squareRow, squareCol;
    	squareRow = (row / 3) * 3;
    	squareCol = (col / 3) * 3;
    	
    	for(int i = squareRow; i < squareRow+3 && detected == false ; i++){
    		for(int j = squareCol; j < squareCol+3 && detected == false; j++){
        		if( this.board[i][j].getValue() == val){
        			detected = true;    			
        		} // if
    		} // for
    	} // for
    	
    	return detected;
    } // checkSquare	
    
    // Constructor & Additional Methods
    Sudoku(int level){
        this.board = new Cell[9][9];
        this.sudokuGenerator(level);
        
    } // Constructor por defecto.
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
    public void sudokuGenerator(int level){
        int index;
        ArrayList<Integer> randomNumbers;
         
        // Generamos un vector con numeros aleatorios entre 1 y 9.
        randomNumbers = generateRandomNumbers();
        
        for(int i = 0; i < 9; i++){
        	for( int j = 0; j < 9; j++){
        		this.board[i][j] = new Cell();
        	}
        }
        
        index = 0;
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                this.board[i][j].setValue(randomNumbers.get(index));
                index++;
            } // for
        } // for

        /*Se rellenan los dos cuadros que quedan de arriba*/
        this.board[1][3].setValue(this.board[0][0].getValue());
        this.board[1][4].setValue(this.board[0][1].getValue());
        this.board[1][5].setValue(this.board[0][2].getValue());
        this.board[2][6].setValue(this.board[0][0].getValue());
        this.board[2][7].setValue(this.board[0][1].getValue());
        this.board[2][8].setValue(this.board[0][2].getValue());
        this.board[2][3].setValue(this.board[1][0].getValue());
        this.board[2][4].setValue(this.board[1][1].getValue());
        this.board[2][5].setValue(this.board[1][2].getValue());
        this.board[0][6].setValue(this.board[1][0].getValue());
        this.board[0][7].setValue(this.board[1][1].getValue());
        this.board[0][8].setValue(this.board[1][2].getValue());
        this.board[0][3].setValue(this.board[2][0].getValue());
        this.board[0][4].setValue(this.board[2][1].getValue());
        this.board[0][5].setValue(this.board[2][2].getValue());
        this.board[1][6].setValue(this.board[2][0].getValue());
        this.board[1][7].setValue(this.board[2][1].getValue());
        this.board[1][8].setValue(this.board[2][2].getValue());
        
        /*Se rellenan los cuadros de la izquierda*/
        this.board[3][1].setValue(this.board[0][0].getValue());
        this.board[4][1].setValue(this.board[1][0].getValue());
        this.board[5][1].setValue(this.board[2][0].getValue());
        this.board[6][2].setValue(this.board[0][0].getValue());
        this.board[7][2].setValue(this.board[1][0].getValue());
        this.board[8][2].setValue(this.board[2][0].getValue());
        this.board[3][2].setValue(this.board[0][1].getValue());
        this.board[4][2].setValue(this.board[1][1].getValue());
        this.board[5][2].setValue(this.board[2][1].getValue());
        this.board[6][0].setValue(this.board[0][1].getValue());
        this.board[7][0].setValue(this.board[1][1].getValue());
        this.board[8][0].setValue(this.board[2][1].getValue());
        this.board[3][0].setValue(this.board[0][2].getValue());
        this.board[4][0].setValue(this.board[1][2].getValue());
        this.board[5][0].setValue(this.board[2][2].getValue());
        this.board[6][1].setValue(this.board[0][2].getValue());
        this.board[7][1].setValue(this.board[1][2].getValue());
        this.board[8][1].setValue(this.board[2][2].getValue());

        /* Se rellena el cuadro central y derecho-centro*/
        this.board[3][3].setValue(this.board[5][0].getValue());
        this.board[3][4].setValue(this.board[5][1].getValue());
        this.board[3][5].setValue(this.board[5][2].getValue());
        this.board[4][6].setValue(this.board[5][0].getValue());
        this.board[4][7].setValue(this.board[5][1].getValue());
        this.board[4][8].setValue(this.board[5][2].getValue());
        this.board[5][3].setValue(this.board[4][0].getValue());
        this.board[5][4].setValue(this.board[4][1].getValue());
        this.board[5][5].setValue(this.board[4][2].getValue());
        this.board[3][6].setValue(this.board[4][0].getValue());
        this.board[3][7].setValue(this.board[4][1].getValue());
        this.board[3][8].setValue(this.board[4][2].getValue());
        this.board[5][6].setValue(this.board[3][0].getValue());
        this.board[5][7].setValue(this.board[3][1].getValue());
        this.board[5][8].setValue(this.board[3][2].getValue());
        this.board[4][3].setValue(this.board[3][0].getValue());
        this.board[4][4].setValue(this.board[3][1].getValue());
        this.board[4][5].setValue(this.board[3][2].getValue());

        /* Se rellena el cuadro central y derecho-centro*/
        this.board[6][3].setValue(this.board[8][0].getValue());
        this.board[6][4].setValue(this.board[8][1].getValue());
        this.board[6][5].setValue(this.board[8][2].getValue());
        this.board[7][6].setValue(this.board[8][0].getValue());
        this.board[7][7].setValue(this.board[8][1].getValue());
        this.board[7][8].setValue(this.board[8][2].getValue());
        this.board[8][3].setValue(this.board[7][0].getValue());
        this.board[8][4].setValue(this.board[7][1].getValue());
        this.board[8][5].setValue(this.board[7][2].getValue());
        this.board[6][6].setValue(this.board[7][0].getValue());
        this.board[6][7].setValue(this.board[7][1].getValue());
        this.board[6][8].setValue(this.board[7][2].getValue());
        this.board[8][6].setValue(this.board[6][0].getValue());
        this.board[8][7].setValue(this.board[6][1].getValue());
        this.board[8][8].setValue(this.board[6][2].getValue());
        this.board[7][3].setValue(this.board[6][0].getValue());
        this.board[7][4].setValue(this.board[6][1].getValue());
        this.board[7][5].setValue(this.board[6][2].getValue());

        System.out.println("El nivel es:" + level);
        
        // Esconder aqui los valores aleatorios dependiendo del nivel. TOREVIEW
        for(int i = 0 ; i < 8; i++){
        	for(int j = 0; j < 8; j++){
        		if( ((Math.random()*81+1) < level) ){
        			this.board[i][j].setValue(0);
        		}
        		else{
        			this.board[i][j].setFix();
        		}
        	} // for
        } // for
        
    } // sudokuGenerator
    
    // Class Methods
    protected boolean setCellValue( int row, int col, int value){
    	boolean done = false;
    	if( this.board[row][col].isEmpty() == true ){
    		done = this.board[row][col].setValue(value);
    		
    		if(done == true){
    			this.board[row][col].setFix();
    		}
    	} // if
    	
    	return done;
    } // setCellValue
    
    protected void setCellFix( int row, int col ){
    	this.board[row][col].setFix();
    }
    protected void deleteCellValue( int row, int col ){
    	this.board[row][col].deleteValue();
    	
    } // deleteCellValue
    protected boolean gameFinished(){
    	boolean finished = true;
    	
    	for(int i = 0; i < 9; i++){
    		for(int j = 0; j < 9; j++){
    			if( this.board[i][j].isFix() != true){
    				finished = false;	
    			} // if
    		} // for
    	} // for
    	
    	return finished;
    } // gameFinished
    protected ArrayList<Integer> getOptions(int row, int col){
    	return this.board[row][col].getValues();
    	
    } // getOptions
    protected boolean newOption(int row, int col, int val){
    	boolean done = this.board[row][col].newOption(val);
    	return done;
    	
    } // newOption
    protected boolean deleteOption( int row, int col, int val){
    	boolean done = this.board[row][col].deleteOption(val);
    	return done;
    	
    } // deleteOption
    protected Cell getCell(int row, int col){
    	return this.board[row][col];
    	
    }    
    protected boolean fitsGame(int row, int col, int val){
    	if( this.checkRow(row, val) == false){
    		if( this.checkColumn(col, val) == false){
    			if( this.checkSquare(row, col, val) == false){
            		return true;    				
    			} // if
    		} // if
    	} // if
    	return false;

    } // fitsGame 
    public void showBoard(){
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";

        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8 ; j++){
            	if( this.board[i][j].getValue() != '_'){
            		if(this.board[i][j].isFix() == true){
            			System.out.print(ANSI_GREEN + " " + this.board[i][j].showCell() + " " + ANSI_RESET);
            		} // if
            		else{
            			System.out.print(" " + this.board[i][j].showCell() + " ");
            		}
            	} // if
            	else{
                    System.out.print(ANSI_RED + " " + this.board[i][j].showCell() + " " + ANSI_RESET);
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

    } // showBoard

} // Sudoku

