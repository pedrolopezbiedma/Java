/*
 *  celda.cpp
 *
 *  Created on: 15/02/2010
 *      Author: Alberto Rodríguez Frías
 */

#include "celda.h"


celda::celda(){
	
	_fija=false;
	_valor=0;
	
	
}
celda::~celda(){

	

}

bool celda::fijar_valor(const unsigned int &dato, const bool &fija){

	//Controlar el rango de valores de dato
	if(_fija || dato>9 || dato<1)	return false;
	else{
		
		_valor=dato;
		if(fija)	_fija=fija;
		//ES necesario borrar las opeicones una vez fijado un valor?
		_opciones.clear();
		return true;
		}
	
}

void celda::borrar_valor(){
	
	if(_fija==false){
	
	_valor=0;
	
	}
	
	//SI ESTA FIJO NO BORRA NADA
	
}

unsigned int celda::valor() const{
	
	return _valor;
	
}

bool celda::valida() const{
	
	if(_valor!=0)	return false;
	return true;
	
}

bool celda::nueva_opcion(const unsigned int &dato){
	
	
	if(_opciones.find(dato)!=_opciones.end())	return false;
	_opciones.insert(dato);
	return true;
}

bool celda::borrar_opcion(const unsigned int &dato){
	
	if(_opciones.find(dato)==_opciones.end())	return false;
	_opciones.erase(dato);
	return true;
	
}
set<unsigned int> celda::opciones() const{
	
	return _opciones;
	
}

celda& celda::operator=(const celda &otra){
	
	if(this!=&otra){
	_valor=otra._valor;
	_opciones=otra._opciones;
	_fija=otra._fija;
}
	return *this;
	
}

ostream& operator<<(ostream& os, const celda& c){

		if(c.valor()==0)	os << "_";
		else if(c.valor()>0 || c.valor()<=9)	os << c.valor();
		
		return os;
}
