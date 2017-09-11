#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int tabla[9][9];
int dificultad;

int main()
{
    void crearSudoku();

   printf("Generador de sudokus\nhttp://opengl-esp.superforo.net - por HarZe\n\nIntroduce una dificultad (5-75):");
   scanf("%i",&dificultad);
   if (!dificultad) dificultad = 40;
   else if (dificultad<5) dificultad = 5;
   else if (dificultad>75) dificultad = 75;
   printf("\nDificultad seleccionada: %i\nSudoku:\n",dificultad);

    crearSudoku();
    
    system("PAUSE");
    return 0;
}

void crearSudoku()
{
  int i,j,aux;
      srand(time(0)); /*Establece que el origen de los numeros rand() seran el numero de segundos sucedidos entre el anyo Nuevo de 1970 hasta hoy: time(0)*/
  tabla[0][0] = (rand()%(9))+1; /*Para obtener un entero entre 0 y 8, sacamos el resto (con el operador %) de un aleatorio entre 9, dando un numero entre 0 y 8. Le sumamos 1 para que sea entre 1 y 9 en numero resultante*/
  do aux = (rand()%(9)) + 1;
      while(aux == tabla[0][0]); /*Se busca un numero aleatorio que NO sea igual al anterior*/
  tabla[0][1] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1]);/*Se busca un numero aleatorio que NO sea igual que los anteriores*/
  tabla[0][2] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1] || aux == tabla[0][2]);
  tabla[1][0] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1] || aux == tabla[0][2] || aux == tabla[1][0]);
  tabla[1][1] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1] || aux == tabla[0][2] || aux == tabla[1][0] || aux == tabla[1][1]);
  tabla[1][2] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1] || aux == tabla[0][2] || aux == tabla[1][0] || aux == tabla[1][1] || aux == tabla[1][2]);
  tabla[2][0] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1] || aux == tabla[0][2] || aux == tabla[1][0] || aux == tabla[1][1] || aux == tabla[1][2] || aux == tabla[2][0]);
  tabla[2][1] = aux;
  do aux = (rand()%(9))+1;
      while(aux == tabla[0][0] || aux == tabla[0][1] || aux == tabla[0][2] || aux == tabla[1][0] || aux == tabla[1][1] || aux == tabla[1][2] || aux == tabla[2][0] || aux == tabla[2][1]);
  tabla[2][2] = aux;
  /*Se rellenan los dos cuadros que quedan de arriba*/
  tabla[1][3]=tabla[0][0];
  tabla[1][4]=tabla[0][1];
  tabla[1][5]=tabla[0][2];

  tabla[2][6]=tabla[0][0];
  tabla[2][7]=tabla[0][1];
  tabla[2][8]=tabla[0][2];

  tabla[2][3]=tabla[1][0];
  tabla[2][4]=tabla[1][1];
  tabla[2][5]=tabla[1][2];

  tabla[0][6]=tabla[1][0];
  tabla[0][7]=tabla[1][1];
  tabla[0][8]=tabla[1][2];

  tabla[0][3]=tabla[2][0];
  tabla[0][4]=tabla[2][1];
  tabla[0][5]=tabla[2][2];

  tabla[1][6]=tabla[2][0];
  tabla[1][7]=tabla[2][1];
  tabla[1][8]=tabla[2][2];

  /*Se rellenan los cuadros de la izquierda*/
  tabla[3][1]=tabla[0][0];
  tabla[4][1]=tabla[1][0];
  tabla[5][1]=tabla[2][0];

  tabla[6][2]=tabla[0][0];
  tabla[7][2]=tabla[1][0];
  tabla[8][2]=tabla[2][0];

  tabla[3][2]=tabla[0][1];
  tabla[4][2]=tabla[1][1];
  tabla[5][2]=tabla[2][1];

  tabla[6][0]=tabla[0][1];
  tabla[7][0]=tabla[1][1];
  tabla[8][0]=tabla[2][1];

  tabla[3][0]=tabla[0][2];
  tabla[4][0]=tabla[1][2];
  tabla[5][0]=tabla[2][2];

  tabla[6][1]=tabla[0][2];
  tabla[7][1]=tabla[1][2];
  tabla[8][1]=tabla[2][2];

  /* Se rellena el cuadro central y derecho-centro*/
  tabla[3][3]=tabla[5][0];
  tabla[3][4]=tabla[5][1];
  tabla[3][5]=tabla[5][2];

  tabla[4][6]=tabla[5][0];
  tabla[4][7]=tabla[5][1];
  tabla[4][8]=tabla[5][2];

  tabla[5][3]=tabla[4][0];
  tabla[5][4]=tabla[4][1];
  tabla[5][5]=tabla[4][2];

  tabla[3][6]=tabla[4][0];
  tabla[3][7]=tabla[4][1];
  tabla[3][8]=tabla[4][2];

  tabla[5][6]=tabla[3][0];
  tabla[5][7]=tabla[3][1];
  tabla[5][8]=tabla[3][2];

  tabla[4][3]=tabla[3][0];
  tabla[4][4]=tabla[3][1];
  tabla[4][5]=tabla[3][2];

  /* Se rellena el cuadro central y derecho-centro*/
  tabla[6][3]=tabla[8][0];
  tabla[6][4]=tabla[8][1];
  tabla[6][5]=tabla[8][2];

  tabla[7][6]=tabla[8][0];
  tabla[7][7]=tabla[8][1];
  tabla[7][8]=tabla[8][2];

  tabla[8][3]=tabla[7][0];
  tabla[8][4]=tabla[7][1];
  tabla[8][5]=tabla[7][2];

  tabla[6][6]=tabla[7][0];
  tabla[6][7]=tabla[7][1];
  tabla[6][8]=tabla[7][2];

  tabla[8][6]=tabla[6][0];
  tabla[8][7]=tabla[6][1];
  tabla[8][8]=tabla[6][2];

  tabla[7][3]=tabla[6][0];
  tabla[7][4]=tabla[6][1];
  tabla[7][5]=tabla[6][2];

   for (i=0;i<=8;i++) {
            for (j=0;j<=8;j++) {
                    if ( (rand()%81)>dificultad ) printf("%i",tabla[i][j]);
         else printf("#");
         if (j==2 || j==5 || j==8) printf("    ");
             }
            if (i==2 || i==5 || i==8) printf("\n\n");
      printf("\n");
         }
}