SRC= src
INCLUDE = include
LIB = lib
BIN = bin
OBJ = obj
CPPFLAGS = -Wall -g  -I$(INCLUDE)
CXX = g++
OBJETOS =  $(OBJ)/celda.o $(OBJ)/sudoku.o $(OBJ)/juego.o

all : sudoku
sudoku : $(BIN)/sudoku

$(OBJ)/celda.o : $(SRC)/celda.cpp $(INCLUDE)/celda.h 
	$(CXX) -c $(CPPFLAGS) $(SRC)/celda.cpp -o $(OBJ)/celda.o
$(OBJ)/sudoku.o : $(SRC)/sudoku.cpp $(INCLUDE)/celda.h $(INCLUDE)/sudoku.h 
	$(CXX) -c $(CPPFLAGS) $(SRC)/sudoku.cpp -o $(OBJ)/sudoku.o
$(OBJ)/juego.o : $(SRC)/juego.cpp $(INCLUDE)/celda.h $(INCLUDE)/sudoku.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/juego.cpp -o $(OBJ)/juego.o
################################# EJECUTABLE #############################
$(BIN)/sudoku: $(OBJETOS) 
	$(CXX) $(OBJETOS) -o $(BIN)/sudoku
clean:
	-rm $(OBJ)/* $(SRC)/*~ $(INCLUDE)/*~ ./*~ $(BIN)/*
