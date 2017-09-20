#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <stack>
#include <set>
#include <list>
#include <iterator>
#include "sudoku.h"

using namespace std;
	
int menu(){

		cout << endl << "***************************************************";
		cout << endl << "1.- Agregar opción a una celda.";
		cout << endl << "2.- Borrar opción de una celda.";
		cout << endl << "3.- Fijar valor una celda.";
		cout << endl << "4.- Borrar valor de una celda.";
		cout << endl << "5.- Verificar factible.";
		cout << endl << "6.- Ver Opciones de una celda.";
		cout << endl << "7.- Deshacer.";
		cout << endl << "8.- Salir.";		
		cout << endl << "*****************************************[opcion]->";
		int opcion;
		cin >> opcion;
		return opcion;		
	
}
	
int main(int argc, char* argv[]){

	

	if (argc!=2){	
		cout << "Dime el nombre del fichero.\n";
		return -1;	

		}
	
		sudoku sudok(argv[1]);

		cout << sudok;
		
		unsigned int fila, columna, valor;
		list<unsigned int> lista;
		list<unsigned int>::iterator j;
		
		bool salir=false;
		while(!salir){
		
		if(sudok.finalizado())	{cout << endl << "Juego Acabado, enhorabuena." << endl;salir=true;}
		else {
			
			int opcion=menu();
			switch(opcion){
				
				case 1:
					cout << endl << "Introduzca fila:";
					cin >> fila;
					cout << endl << "Introduzca columna:";
					cin >> columna;
					cout << endl << "Introduzca valor:";
					cin >> valor;
					if(sudok.nueva_opcion(fila,columna,valor)){
						
						cout << endl << "\x1b[92mLa opcion ha sido introducida correctamente.\x1b[m"<< endl;
						cout << sudok;
						
						}
					else {
						
						cout << endl << "\x1b[91mLa opcion NO ha sido introducida correctamente, revise el puzzle.\x1b[m "<< endl;
						cout << sudok;
						
						}
				
					break;
					
				case 2:
				
					cout << endl << "Introduzca fila:";
					cin >> fila;
					cout << endl << "Introduzca columna:";
					cin >> columna;
					cout << endl << "Introduzca valor:";
					cin >> valor;
					if(sudok.borrar_opcion(fila,columna,valor)){
						
						cout << endl << "\x1b[92mLa opcion ha sido borrada correctamente.\x1b[m"<< endl;
						cout << sudok;
						
						}
					else {
						
						cout << endl << "\x1b[91mLa opcion NO ha sido borrada correctamente, revise el puzzle.\x1b[m "<< endl;
						cout << sudok;
						
						}
					break;
					
				case 3:
					cout << endl << "Introduzca fila:";
					cin >> fila;
					cout << endl << "Introduzca columna:";
					cin >> columna;
					cout << endl << "Introduzca valor:";
					cin >> valor;
					if(sudok.fijar_valor(fila,columna,valor)){
						
						cout << endl << "\x1b[92mEl valor ha sido fijado correctamente.\x1b[m"<< endl;
						cout << sudok;
						
						}
					else {
						
						cout << endl << "\x1b[91mEl valor NO ha sido fijado correctamente, revise el puzzle.\x1b[m "<< endl;
						cout << sudok;
						
						}
					break;
					
				case 4:
					
					cout << endl << "Introduzca fila:";
					cin >> fila;
					cout << endl << "Introduzca columna:";
					cin >> columna;
					
					sudok.borrar_valor(fila, columna);
						
						cout << endl << "\x1b[92mPetición procesada.\x1b[m"<< endl;
						cout << sudok;
						
					break;
					
				case 5:
				
					cout << endl << "Introduzca fila:";
					cin >> fila;
					cout << endl << "Introduzca columna:";
					cin >> columna;
					cout << endl << "Introduzca valor:";
					cin >> valor;
					if(sudok.es_factible(fila,columna,valor)){
						
						cout << endl << "\x1b[92mEl valor " << valor << " es factible en la posicion " << fila << "," << columna << ".\x1b[m"<< endl;
						cout << sudok;
						
						}
					else {
						
						cout << endl << "\x1b[91mEl valor " << valor << " NO es factible en la posicion " << fila << "," << columna << ".\x1b[m "<< endl;
						cout << sudok;
						
						}
					break;	
				case 6:
					cout << endl << "Introduzca fila:";
					cin >> fila;
					cout << endl << "Introduzca columna:";
					cin >> columna;
					lista=sudok.opciones(fila,columna);
					
					
					cout << endl << "Las opciones son: ";
					for(j=lista.begin();j!=lista.end();++j){
		
						cout << *j << "|";
					
					}
					
					cout << endl << sudok;
						
					break;
				case 7:
					if(sudok.undo()){
						
						cout << endl << "\x1b[92Movimiento desecho\x1b[m"<< endl;
						cout << sudok;
						
						}
					else {
						
						cout << endl << "\x1b[91mMovimiento NO desecho\x1b[m "<< endl;
						cout << sudok;
						
						}
					break;
					
				case 8:
					salir=true;
					break;
				default:
					cout << endl << "\x1b[91mOpción incorrecta.\x1b[m " << endl;
					
					break;
				
				
				
				}
			
			}
		}
			cout << endl << "\x1b[91mSaliendo del juego.\x1b[m "<< endl;


}
