/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201212764;

import java.util.Scanner;

/**
 *
 * @author Majosh
 */
class Intermedio {
    Scanner leer = new Scanner (System.in);
		//matriz del tablero [fila x][coolumna y]
		int tablero [][]= new int[20][20];
		//variables para la generacion de bonbas
		double w=0;
  		double z=0;
		//variable k lleva el total de minas
		int ntminas=0;
		//variable para llevar la cuenta de los intentos
		int intento=90;// si quieres disminuir los numero de intentos aqui
		// indicando el numero de minas
		int tminas=10;
                public void play(){
                    for(int j=0;j<20;j++)
			for (int i=0;i<20;i++)
				tablero [j][i]=0;
		//agragando bonbas aleatoriamente
		do  {  
     			w=Math.random()*20;
        		z=Math.random()*20;  
           		w=(int)w;
           		z=(int)z;
           		if  (z!=0 && w!=0 && z!=20-1 && w!=20-1){
             	tablero[(int)w][(int) z ]=1;
              	ntminas++;
           			}
       		}while (ntminas<=10);
       
       //-----------------------------------------------------------------
       //-----------------------------------------------------------------
       //======================> IMPORTANTE <=============================
       //imprime la matriz por si kieres saber donde estan las minas  
 	    //for(int xx=0;xx<20;xx++)
	     //	for (int yy=0;yy<20;yy++)
	       // 		 if(tablero [xx][yy]==1)
	         //          System.out.println("Fila   "+(xx+1)+"     columna "+(yy+1)); 
       	//---------------------------------------------------------------------------
       	//---------------------------------------------------------------------------
       	
       	//cuerpo principal del juego en el se piden las cordenada
       	// se revisan las minas al rededor de las cordenadas
       	// se informa el progreso del juego
       	System.out.println("\n<---------------------------------------------------->");
       	System.out.println("  Ingrese coordenas en el rango del 1 al 20");
       	do {
       		int x=0,y=0;
       		int nminas = 0;
       		//
       		//ciclo para saber k ingreso un numero en el rango del 1 al 20
       		//
       		do{
       			 System.out.println("\n<---------------------------------------------------->");
       			 System.out.println("\n	Intento :"+intento+" , Cual es su coordenada? \n");
       			 System.out.print("		Fila:  ");
       			 x=leer.nextInt();
       			 System.out.println();
       			 System.out.print("		Columna:  ");
       			 y=leer.nextInt();
       			 //revisando k las coordenadas se encuentren dentro del rango
       			 if(x==0 || y==0 || x>20 || y>20)
       			 	System.out.println("\n	==>Coordenadas incorrectas<== \n");
       		}while (x==0 || y==0 || x>20 || y>20);
       		//restando un valor ya k la matriz enpieza en 0 no 1
       		x=x-1;
       		y=y-1;
       		//revisando si en las coordenadas hay una mina
       		//si no hay mina 0=no mina
       		if(tablero [x][y]==0){
       			//revisando cuantas bonbas hay alrededor
       			// corriegiendo el error de kerer acceder a la posicion -1 tanto en "X" como en "Y"
       			if (x==0&&y==0){
       				if(x+1>=0 && x+1<20 && y<20)
       					nminas=nminas+tablero [x+1][y];
       				if(x+1>=0 && x+1<20 && y+1<20 && y+1>=0)
       					nminas=nminas+tablero [x+1][y+1];
       				if(x>=0 && x<20 && y+1<20 && y+1>= 0)
       					nminas=nminas+tablero [x][y+1];
       			}
       			else {
       				if(y==0){
       					if(x+1>=0 && x+1<20 && y<20)
       						nminas=nminas+tablero [x+1][y];
       					if(x-1>=0 && x-1<20 && y<20)
       						nminas=nminas+tablero [x-1][y];
       					if(x-1>=0 && x-1<20 && y+1<20 && y+1>=0)
       						nminas=nminas+tablero [x-1][y+1];
       					if(x>=0 && x<20 && y+1<20 && y+1>= 0)
       						nminas=nminas+tablero [x][y+1];
       					if(x+1>=0 && x+1<20 && y+1<20 && y+1>=0)
       						nminas=nminas+tablero [x+1][y+1];
       					
       				}
       				// para todos los demas donde "X"  o "Y" no son 0
       				else{
       				
       					if(x-1>=0 && x-1<20 && y-1<20)
       						nminas=nminas+tablero [x-1][y-1];
       					if(x>=0 && x<20 && y-1<20)
       						nminas=nminas+tablero [x][y-1];
       					if(x+1>=0 && x+1<20 && y-1<20)
       						nminas=nminas+tablero [x+1][y-1];
       					if(x+1>=0 && x+1<20 && y<20)
       						nminas=nminas+tablero [x+1][y];
       					if(x-1>=0 && x-1<20 && y<20)
       						nminas=nminas+tablero [x-1][y];
       					if(x-1>=0 && x-1<20 && y+1<20 && y+1>=0)
       						nminas=nminas+tablero [x-1][y+1];
       					if(x>=0 && x<20 && y+1<20 && y+1>= 0)
       						nminas=nminas+tablero [x][y+1];
       					if(x+1>=0 && x+1<20 && y+1<20 && y+1>=0)
       						nminas=nminas+tablero [x+1][y+1];
       					}
       			 }
       			 System.out.print("\n	Mina no encontrada. ");
       			 //para que coincida con los mensajes que pide en el documento minas.xls
       			 if(intento>tminas)
       			 	 System.out.print("	Alrededor hay: "+ nminas);
       			 System.out.println("\n	Intentos restantes: "+(intento-1));
       		}
       		else
       			{
       				tminas = tminas-1;
       				System.out.println("\n	Acertaste!, Mina Eliminada Restan "+tminas+" Minas");
       				System.out.println("\n	Intentos restantes: "+(intento-1));
       			}
       	
          intento=intento-1;
      }while (intento>=tminas && intento>0 && tminas>0);	
 	   //revisando si gana por que termino las minas
       	if(tminas==0)
       		System.out.println("		GANASTE!");
       	//revisando si pierde por k son mayor las minas k los intentos
       	if(tminas>intento)
       		System.out.println("		PERDISTE!    (Exceso de minas restantes "+tminas+")\n\n");
       	//revisando si se le terminaron los intentos
       	if(intento==0)
       		System.out.println("		PERDISTE!");
 	   }
}


