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
 * @description Class that handle the sudoku's board behavior.
 */
public class Sudoku {
    
    // ***** Class attributes *****
    private Cell[][] board = new Cell[9][9];
    
    // ***** Private Methods *****
    /*
    * Method that checks if a value fits in a row according to the game rules.
    * @param row Row that will be checked.
    * @param val Value that will be checked.
    * @return Boolean indicating if the value fits in the row.
    */
    private boolean checkRow(int row, int val){
    	boolean detected = false;
    	for(int i = 0; i < 8 && detected == false; i++){
    		if( this.board[row][i].getValue() == val){
    			detected = true;
    		} // if
    	} // for
    	
    	return detected;
    } // checkRow.
    
    /*
    * Method that checks if a value fits in a column according to the game rules.
    * @param col Column that will be checked.
    * @param val Value that will be checked.
    * @return Boolean indicating if the value fits in the column.
    */    
    private boolean checkColumn(int col, int val){
    	boolean detected = false;
    	for(int i = 0; i < 8 && detected == false; i++){
    		if( this.board[i][col].getValue() == val){
    			detected = true;
    		} // if
    	} // for
    	
    	return detected;
    } // checkColumn.
    
    /*
    * Method that checks if a value fits in a square according to the game rules.
    * @param row Row from the square that will be checked.
    * @param col Column from the square that will be checked.
    * @param val Value that will be checked.
    * @return Boolean indicating if the value fits in the square.
    */
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
    
    // ***** Constructor & Additional Methods *****
    Sudoku(int level){
        this.board = new Cell[9][9];
        this.sudokuGenerator(level);
        
    } // Default Constructor.
    
    /*
    * Method that generates an array of random numbers.
    * @return Array of random numbers.
    */
    private ArrayList<Integer> generateRandomNumbers(){
        
        ArrayList<Integer> randomNumbers = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList<>(9);
        for (int i=1;i<10;i++){
           numbers.add(i);
        }

        Random random = new Random();

        while (numbers.size()>=1){
           int randomIndex = random.nextInt(numbers.size());
           randomNumbers.add(numbers.get(randomIndex));
           numbers.remove(randomIndex);
        }
        return randomNumbers;
        
    } // generateRandomNumbers 
    
    /*
    * Method that creates the sudoku board.
    * @param level Level of the sudoku board ( number of cells hidden at the start of the game ).
    */
    public void sudokuGenerator(int level){
        int index;
        ArrayList<Integer> randomNumbers;

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

        for(int i = 0 ; i < 8; i++){
        	for(int j = 0; j < 8; j++){
                    if( ((Math.random()*81+1) > level) ){
                            this.board[i][j].setFix();

                    }
                    else{
                            this.board[i][j].setValue(0);
                    }
        	} // for
        } // for
        
    } // sudokuGenerator
    
    // ***** Class Methods *****
    /*
    * Method that set the value for a board Cell.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @param value Value to be set to the Cell.
    * @return Boolean indicating if the value has been set or not.
    */
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
    
    /*
    * Method that sets the value for a board Cell fix.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    */
    protected void setCellFix( int row, int col ){
    	this.board[row][col].setFix();
    } // setCellFix
    
    /*
    * Method that delete the value from a board Cell.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @return Boolean indicating if the value has been deleted or not.
    */
    protected void deleteCellValue( int row, int col ){
    	this.board[row][col].deleteValue();
    	
    } // deleteCellValue
    
    /*
    * Method that checks if the game is finished or not.
    * @return Boolean indicating if the game is finished or not.
    */
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
    
    /*
    * Method that retrieves the possible option list from a Cell.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @return Array with the Cell's possible options.
    */
    protected ArrayList<Integer> getOptions(int row, int col){
    	return this.board[row][col].getValues();
    	
    } // getOptions
    
    /*
    * Method that includes a new option in the Cell's possible options list.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @param val Value to be included in the list.
    * @return Boolean indicating if the new option has been included or not.
    */
    protected boolean newOption(int row, int col, int val){
    	boolean done = this.board[row][col].newOption(val);
    	return done;
    	
    } // newOption
    
    /*
    * Method that deletes an option from Cell's posible options list.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @param val Value to be deleted.
    * @return Boolean indicating if the value has been removed from the list.
    */
    protected boolean deleteOption( int row, int col, int val){
    	boolean done = this.board[row][col].deleteOption(val);
    	return done;
    	
    } // deleteOption
    
    /*
    * Method that retrieves a Cell from the board.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @return Cell from the board.
    */
    protected Cell getCell(int row, int col){
    	return this.board[row][col];
    	
    } // getCell
    
    /*
    * Method that checks if a value fits in a Cell according to the game rules.
    * @param row Row where the Cell is.
    * @param col Column where the Cell is.
    * @param val Value to be checked.
    * @return Boolean indicating the value fits in that Cell or not.
    */
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
    
    /*
    * Method that paints the sudoku's board.
    */
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

