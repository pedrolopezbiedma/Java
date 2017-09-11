/*
 * sudoku.h
 *
 *  Created on: 15/02/2010
 *      Author: Alberto Rodríguez Frías
 */

#ifndef SUDOKU_H_
#define SUDOKU_H_

#include <list>
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <stack>
#include <set>
#include "celda.h"

using namespace std;

class sudoku {
	public:
		sudoku(const string &file);
		~sudoku();
		bool fijar_valor(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor);
		void borrar_valor(const unsigned int &fila, const unsigned int &columna);
		bool finalizado() const;
		list<unsigned int> opciones(const unsigned int &fila, const unsigned int &columna) const;
		bool nueva_opcion(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor);
		bool borrar_opcion(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor);
		const celda valor(const unsigned int &fila, const unsigned int &columna) const;
		bool es_factible(const unsigned int &fila, const unsigned int &columna, const unsigned int &valor) const;
		bool undo();
//Añadidas por mi
		bool es_fijo(const unsigned int &fila, const unsigned int &columna) const;

	private:
		vector<vector <celda> > _tablero;
		stack<list<pair<pair<unsigned int, unsigned int>, celda> > > _jugadas;
};

ostream& operator<<(ostream& os, const sudoku& c);

#endif /* SUDOKU_H_ */
