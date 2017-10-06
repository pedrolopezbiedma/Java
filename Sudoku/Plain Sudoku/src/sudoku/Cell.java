package sudoku;
import java.util.ArrayList;

/**
 *
 * @author PedroL
 * @description Class that handle the cell behavior.
 */
public class Cell {

	// ***** Class attributes *****
	private int value;
	private ArrayList<Integer> values = new ArrayList<Integer>(9);
	private boolean fix;
	
	// ***** Class Constructors *****
	Cell( ){
		this.fix = false;
		this.value = 0;
		
	} // Default Constructor
        
        // ***** Class Methods *****
        /*
        * Method that retrieves the Cell value.
        * @return Cell value.
        */
	protected int getValue( ){
		return this.value;
		
	} // getValue
        
        /*
        * Method that retrieves the Cell possible values.
        * @return Cell possible values.
        */
	protected ArrayList<Integer> getValues( ){
		return this.values;
		
	} // getValues
        
        /*
        * Method that checks if a Cell is empty ( Cell is empty if value if 0 ).
        * @return Boolean that indicates if the Cell is empty.
        */
	protected boolean isEmpty(){
		boolean valid = false;
		if(this.value == 0){
			valid = true;
			
		} // if
		
		return valid;
		
	} // isEmpty.
        
        /*
        * Method that checks if the Cell value is fix. ( Cell is fix if it's not empty and the possible values are empty )
        * @return Boolean that indicates if the Cell is fix.
        */
	protected boolean isFix( ){
		if( this.isEmpty() != true && this.values.isEmpty() == true){
			return true;
		} // if
		else{
			return false;
		} // else
		
	} // isFix
        
        /*
        * Method that set the value for a Cell if it's not fix.
        * @return Boolean if the value has been set, pending if the Cell is already fix.
        * @param value Value that will be set in the Cell.
        */
	protected boolean setValue( int value ){
		if( this.fix != true ){
			this.value = value;
			return true;
		} // if
		
		return false;
	} // setValue
	
        /*
        * Method that set a Cell as fix.
        */
	protected void setFix(){
		this.fix = true;
		this.values.clear();
		
	} // setFix
	
        /*
        * Method that clear the value from a Cell.
        */
	protected void deleteValue( ){
		this.value = 0;
		this.fix = false;
		
	} // deleteValue
        
        /*
        * Method that includes a new option in the possible values list.
        * @return Boolean indicating if the value has been included or not.
        * @param value Value to be included in the possible values list.
        */
	protected boolean newOption( int value ){
		if( this.values.contains(value) == false){
			this.values.add(value);
			return true;
		}
		return false;
		
	} // newOption
        
         /*
        * Method that deletes an option from the possible values list.
        * @return Boolean indicating if the value has been deleted or not.
        * @param value Value to be deleted from the possible values list.
        */       
	protected boolean deleteOption( int value ){
		for(int i = 0; i < this.values.size(); i++){
			if(this.values.get(i) == value){
				this.values.remove(i);
				return true;
			} // if
		} // for
		return false;
		
	} // deleteOption
        
        /*
        * Method that shows the value from a Cell.
        * @return Retrieves the Cell value as will be shown in the console.
        */
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
