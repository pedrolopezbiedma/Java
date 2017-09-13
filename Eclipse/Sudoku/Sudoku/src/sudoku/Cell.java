package sudoku;
import java.util.ArrayList;

public class Cell {

	// Class attributes
	private int value;
	private ArrayList<Integer> values = new ArrayList<Integer>(9);
	private boolean fix;
	// Si una celda no esta vacía, entonces el conjunto de opciones es vacio.
	
	// Class Methods
	Cell( ){
		this.fix = false;
		this.value = 0;
		
	} // Constructor por Defecto
	protected int getValue( ){
		return this.value;
		
	} // getValue
	protected ArrayList<Integer> getValues( ){
		return this.values;
		
	} // getValues
	protected boolean isEmpty(){
		boolean valid = false;
		if(this.value == 0){
			valid = true;
			
		} // if
		
		return valid;
		
	} // isValid
	protected boolean isFix( ){
		if( this.isEmpty() != true && this.values.isEmpty() == true){
			return true;
		} // if
		else{
			return false;
		} // else
		
	} // getValid
	protected boolean setValue( int value ){
		if( this.fix != true ){
			this.value = value;
			return true;
		} // if
		
		return false;
	} // setValue
	
	protected void setFix(){
		this.fix = true;
		System.out.println( "Voy a hacer el clear.");
		this.values.clear();
		System.out.println( "El tamaño de las opciones es" + this.values.size());
		
	} // setFix
	
	protected void deleteValue( ){
		this.value = 0;
		this.fix = false;
		
	} // deleteValue
	protected boolean newOption( int value ){
		if( this.values.contains(value) == false){
			this.values.add(value);
			return true;
		}
		return false;
		
	} // newOption
	protected boolean deleteOption( int value ){
		for(int i = 0; i < this.values.size(); i++){
			if(this.values.get(i) == value){
				this.values.remove(i);
				return true;
			} // if
		} // for
		return false;
		
	} // deleteOption
	protected String showCell( ){
		String value;
		if(this.isEmpty() != true){	
			value = Integer.toString(this.getValue());		
		} // if
		else{
			value = "_";
		} // else.
		
		return value;
	} // showCell.
	
} // Cell
