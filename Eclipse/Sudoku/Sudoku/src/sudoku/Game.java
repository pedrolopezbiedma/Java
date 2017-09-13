/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author PedroL
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	// Attributes
    	Scanner in = new Scanner(System.in);
    	int level,row, col, value, option = 0;
    	boolean done, finished = false, fits;
    	ArrayList<Integer> array = new ArrayList();
        // TODO code application logic here
    	
    	// ***** Creating Sudoku's board *****
        System.out.println( "***** Por favor, introduzca la dificultad deseada para el Sudoku. *****");
        level = in.nextInt();
        System.out.println("");
        
        Sudoku board = new Sudoku(level);
        
        // ***** Actual Game *****
        do{
        	finished = board.gameFinished();
            System.out.println( "***** El estado del sudoku es el siguiente. *****");
            board.showBoard();
            System.out.println("");
            
            option = 0;
            System.out.println( "***** Elija la opcion que desea. *****");
            System.out.println( "1.- Asignar opcion a una celda. ");
            System.out.println( "2.- Borrar opcion de una celda.");
            System.out.println( "3.- Mostrar opciones de una celda.");
            System.out.println( "4.- Fijar valor a una celda.");
            System.out.println( "5.- Borrar valor de una celda.");
            System.out.println( "6.- Verificar factible.");
            System.out.println( "0.- Salir");
            option = in.nextInt();
            
            switch(option){
            // ***** Añadir una opcion *****
            case 1: System.out.println( "Introduzca el valor de la fila a la que quiere añadir un valor. [1-9]");
            		row = in.nextInt();
            		row = row-1;
            		System.out.println( "Introduzca el valor de la columna a la que quiere añadir un valor. [1-9]");
            		col = in.nextInt();
            		col = col-1;
            		System.out.println( "Introduzca el valor que quiere añadir.");
            		value = in.nextInt();
            		
            		fits = board.fitsGame(row, col, value);
            		if(fits == true){
	            		done = board.newOption(row, col, value);           		
	            		
	            		if(done == true){
	                		System.out.println( "Opcion añadida correctamente.");            			
	            		} // if
	            		else{
	            			System.out.println( "La opcion no se ha podido añadir.");            			
	            		} // else
            		} // if
            		else{
            			System.out.println("La opcion no es factible en esta celda.");
            		} // else
            		break;
            		
    		// ***** Borrar una opcion *****
            case 2: System.out.println( "Introduzca el valor de la fila en la que quiere borrar una opcion. [1-9]");
		    		row = in.nextInt();
		    		row = row-1;
		    		System.out.println( "Introduzca el valor de la columna en la que quiere borrar una opcion. [1-9]");
		    		col = in.nextInt();
		    		col = col-1;
		    		System.out.println( "Introduzca el valor que quiere borrar.");
            		value = in.nextInt();
            				    		
	    			board.deleteOption(row, col,value);
	    			break;
	    			
			// ***** Mostrar opciones *****
            case 3: System.out.println( "Introduzca el valor de la fila que quiere comprobar. [1-9]");
		    		row = in.nextInt();
		    		row = row-1;
		    		System.out.println( "Introduzca el valor de la columna que quiere comprobar. [1-9]");
		    		col = in.nextInt();
		    		col = col-1;
		    		
		    		array = board.getOptions(row, col);
		    		System.out.println( " Los valores son: ");
		    		for(int i = 0; i < array.size(); i++){
		    			System.out.println(array.get(i) );
		    		} // for
		    		break;
		    		
    		// ***** Fijar valor a una celda *****
            case 4: System.out.println( "Introduzca el valor de la fila que quiere fijar. [1-9]");
		    		row = in.nextInt();
		    		row = row-1;
		    		System.out.println( "Introduzca el valor de la columna que quiere fijar. [1-9]");
		    		col = in.nextInt();
		    		col = col-1;
		    		System.out.println( "Introduzca el valor que quiere fijar.");
            		value = in.nextInt();
            		
            		if(board.fitsGame(row, col, value)){
            			done = board.setCellValue(row, col, value);
                		
                		if(done == true){
                			board.setCellFix(row, col);
                		} // if            			
            		} // if
            		else{
    		    		System.out.println( "El valor no es factible.");            			
            		} // else
            		
            		break;
            		
    		// ***** Borrar valor a una celda *****
            case 5: System.out.println( "Introduzca el valor de la fila que quiere borrar. [1-9]");
		    		row = in.nextInt();
		    		row = row-1;
		    		System.out.println( "Introduzca el valor de la columna que quiere borrar. [1-9]");
		    		col = in.nextInt();
		    		col = col-1;

	    			board.deleteCellValue(row, col);
	    			break;
	    			
			// ***** Verificar si es factible *****
            case 6: System.out.println( "Introduzca el valor de la fila que quiere verificar. [1-9]");
		    		row = in.nextInt();
		    		row = row-1;
		    		System.out.println( "Introduzca el valor de la columna que quiere verificar. [1-9]");
		    		col = in.nextInt();
		    		col = col-1;
		    		System.out.println( "Introduzca el valor que quiere verificar.");
            		value = in.nextInt();
            		
            		fits = board.fitsGame(row, col, value);
            		
            		if(fits){
            			System.out.println( "El valor es factible.");            			
            		} // if
            		else{
            			System.out.println( "El valor NO es factible.");
            		}
            		break;
            		
            } // switch
        }while(option != 0 && finished == false);
        
        if(finished){
        	System.out.println( "***** ENHORABUENA, HA TERMINADO EL SUDOKU. *****");
        	
        } // if
    } // main
} // Game
