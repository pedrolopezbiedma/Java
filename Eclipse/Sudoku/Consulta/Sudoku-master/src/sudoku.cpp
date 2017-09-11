/*
 * sudoku.cpp
 *
 *  Created on: 15/02/2010
 *      Author: Alberto Rodríguez Frías
 */

#include "sudoku.h"

//PISTA: %3 para manejar los bloques

sudoku::sudoku(const string &file) : _tablero(vector<vector<celda> >(9, vector<celda>(9))) {
	string basura;
	unsigned int dato;
	
	ifstream fich(file.c_str());
	if (fich.is_open()) {
		fich >> basura;

	    unsigned int fila = 1;
	    unsigned int columna = 1;

	    while ((fila < 10) and (columna < 10)) {
	    	fich >> basura;
	    	// string to int
	    	istringstream buffer(basura);
	    	buffer >> dato;
	    	if ((dato >= 1) and (dato <= 9)) {
	    		bool res = _tablero[fila-1][columna-1].fijar_valor(dato, true);
	    		if (!res) {
	    			cout << "Problemas con el tablero..." << endl;
	    		}
	    	}
	    	++columna;
	    	if (columna == 10) {
	    		columna = 1;
	    		++fila;
	    	}
	    }

	    fich.close();
	  }
	else {
		cout << "Imposible abrir fichero " << file << endl;
	}
}

sudoku::~sudoku(){
	
}
bool sudoku::fijar_valor(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor){

/*
 Para fijar un valor: 
 * 1.- Compruebo si es factible
 * 2.- Veo si la casilla es valida
 * 3.- Modifico las opciones de las casillas a las que afecte el cambio y las meto en jugadas
 * 4.- Meto la casilla en jugadas
 * 5.- Modifico el valor de la casilla
 */

if(es_factible(fila,columna,valor)){
	cout << endl << "Entro en es_factible de fijar valor" << endl;	
	if(_tablero[fila][columna].valida()){
		cout << endl << "Entro en valida de fijar valor" << endl;	
		//Aqui guardo la jugada
		
		//Creo una lista auxiliar
		list<pair<pair<unsigned int, unsigned int>, celda> >  _modificadas;
		
	set<unsigned int> _opciones_aux;
	bool devolver;
	
	//Recorro toda la fila para quitar esa opcion de cada casilla de esa fila
		for(unsigned int i=0; i<9; i++){
			
			
			_opciones_aux=_tablero[fila][i].opciones();
			if(_opciones_aux.find(valor)!=_opciones_aux.end()){
				
				//Meto la celda en la lista de jugadas
				pair<pair<unsigned int, unsigned int>, celda> par_aux;
				par_aux.first.first=fila;
				par_aux.first.second=i;
				par_aux.second=_tablero[fila][i];
				_modificadas.insert(_modificadas.end(),par_aux);
				
				//Borro la opcion de esa celda
				devolver=_tablero[fila][i].borrar_opcion(valor);
				
				
				}
			}
		//Recorro toda la columna para quitar esa opcion de cada casilla de esa columna
		for(unsigned int i=0; i<9; i++){
			
			
			_opciones_aux=_tablero[i][columna].opciones();
			if(_opciones_aux.find(valor)!=_opciones_aux.end()){
				
				//Meto la celda en la lista de jugadas
				pair<pair<unsigned int, unsigned int>, celda> par_aux;
				par_aux.first.first=i;
				par_aux.first.second=columna;
				par_aux.second=_tablero[i][columna];
				_modificadas.insert(_modificadas.end(),par_aux);
				
				//Borro la opcion de esa celda
				devolver=_tablero[i][columna].borrar_opcion(valor);
				
				
				}
			}
			//Ahora tengo que borrar la opcion del cuadrante
			//Calculo donde inicia el cuadrante
			for(unsigned int i=fila-fila%3; i<=(fila-fila%3)+2; i++){
				
				for(unsigned int j=columna-columna%3; j<=(columna-columna%3)+2; j++){
				
					_opciones_aux=_tablero[i][j].opciones();
					if(_opciones_aux.find(valor)!=_opciones_aux.end()){
				
						//Meto la celda en la lista de jugadas
					pair<pair<unsigned int, unsigned int>, celda> par_aux;
					par_aux.first.first=i;
					par_aux.first.second=columna;
					par_aux.second=_tablero[i][columna];
					_modificadas.insert(_modificadas.end(),par_aux);
				
					//Borro la opcion de esa celda
					devolver=_tablero[i][j].borrar_opcion(valor);
				
				
						}
						
						
					}
				
				}
			//Modifico el tablero	
				
			pair<pair<unsigned int, unsigned int>, celda> par_aux;
					par_aux.first.first=fila;
					par_aux.first.second=columna;
					par_aux.second=_tablero[fila][columna];
					_modificadas.insert(_modificadas.end(),par_aux);
		
		_tablero[fila][columna].fijar_valor(valor);
		
		_jugadas.push(_modificadas);
		
		
		
		
		return true;
		}
	}
	return false;
	
}
void sudoku::borrar_valor(const unsigned int &fila, const unsigned int &columna){
	
	//Si borra un valor... actualiza las opciones de las demás casillas??
	//Mi teoría es que no, ya que deberé si quiero poner en la casilla que quiera el valor como opción
	
		//Aqui guardo la jugada
		
		list<pair<pair<unsigned int, unsigned int>, celda> >  _modificadas;
		pair<pair<unsigned int, unsigned int>, celda> par_aux;
		par_aux.first.first=fila;
		par_aux.first.second=columna;
		par_aux.second=_tablero[fila][columna];
		
		_modificadas.insert(_modificadas.end(),par_aux);
		
		_jugadas.push(_modificadas);
		
		//Modifico el tablero
		_tablero[fila][columna].borrar_valor();
		
	
}
bool sudoku::finalizado() const{
	
	bool fin=true;
	
	for(int i=0; i < 9 && fin; i++){
	
		for(int j=0; j < 9 && fin; j++){
		
			if(_tablero[i][j].valor()<1 || _tablero[i][j].valor()>9)	fin=false;
		
			}
		
		}
	return fin;
	
	
}
list<unsigned int> sudoku::opciones(const unsigned int &fila, const unsigned int &columna) const{
	
	
	set<unsigned int> aux_set=_tablero[fila][columna].opciones();
	list<unsigned int> aux;
	
	
	set<unsigned int>::iterator i;
	for(i=aux_set.begin();i!=aux_set.end();++i){
		
		aux.insert(aux.end(),*i);
		
		}
		
	return aux;
	
}
bool sudoku::nueva_opcion(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor){
	
	if(_tablero[fila][columna].nueva_opcion(valor))
		return true;
	return false;
}
bool sudoku::borrar_opcion(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor){
	
	if(_tablero[fila][columna].borrar_opcion(valor))
		return true;
	return false;
	
}
const celda sudoku::valor(const unsigned int &fila, const unsigned int &columna) const{
	
	return _tablero[fila][columna];
	
}

bool sudoku::es_fijo(const unsigned int &fila, const unsigned int &columna) const{
	
	if(_tablero[fila][columna].es_fijo())	return true;
	else return false;
}

bool sudoku::es_factible(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor) const{
	
	//Comprueba Filas y Columnas
	for(int i=0; i<9; i++){
		
		if(_tablero[i][columna].valor()==valor || _tablero[fila][i].valor()==valor)
			return false;
		}
	//Comprubea Cuadrante
	for(unsigned int i=fila-fila%3; i<=(fila-fila%3)+2; i++){
				
				for(unsigned int j=columna-columna%3; j<=(columna-columna%3)+2; j++){
		
					if(_tablero[i][j].valor()==valor)	
						return false;
		
				}
		}
	return true;
	
}
bool sudoku::undo(){
	//Creo que es pop
	
	if(_jugadas.empty())	{return false;}
	
	else {
		list<pair<pair<unsigned int, unsigned int>, celda> > restaurar=_jugadas.top();
		
		//for(list<pair<pair<unsigned int, unsigned int>, celda> >::iterator i=restaurar.begin(); i!= restaurar.end(); ++i){
		while(!restaurar.empty()){ 
			
			pair<pair<unsigned int, unsigned int>, celda> aux=restaurar.front();
			_tablero[aux.first.first][aux.first.second]=aux.second;
			
			restaurar.pop_front();
		}
	_jugadas.pop();
	return true;
	}
}
ostream& operator<<(ostream& os, const sudoku& c){


		for(int i=1; i<=9; i++){ 
			
			for(int j=1; j<=9; j++){
				
				if(c.es_fijo(i-1,j-1)){
				
					if(j==4 || j==7) os << "\x1b[93m  " << c.valor(i-1,j-1)<< "\x1b[m";
					else os << "\x1b[93m " << c.valor(i-1,j-1) << "\x1b[m";
					
					}
				else {
					
					if(j==4 || j==7) os << "  " << c.valor(i-1,j-1);
					else os << " " << c.valor(i-1,j-1);
					
					}
			}
			if(i!=9)
				{
				if(i%3==0) os << "\x1b[94m |" << i-1 << "\x1b[m" <<  endl << endl;
				else os << "\x1b[94m |" << i-1 << "\x1b[m" << endl;
				}
			else 
				{
				if(i%3==0) os << "\x1b[94m |" << i-1 << "\x1b[m" << endl;
				else os << "\x1b[94m |" << i-1 << "\x1b[m" ;
				}
			}
		os << "\x1b[94m _ _ _  _ _ _  _ _ _  \x1b[m" << endl;
		os << "\x1b[94m 0 1 2  3 4 5  6 7 8  \x1b[m" << endl;
			 return os;
	
}
