/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201212764;

import java.util.Scanner;
import static practica1_201212764.juego.checkMinas;
import static practica1_201212764.juego.columnas;

import static practica1_201212764.juego.fi;
import static practica1_201212764.juego.filas;
import static practica1_201212764.juego.imprTablero;
import static practica1_201212764.juego.iniciaTablero;
import static practica1_201212764.juego.intrMinas;
import static practica1_201212764.juego.introMovim;
import static practica1_201212764.juego.libre;
import static practica1_201212764.juego.matriz;
import static practica1_201212764.juego.matriz2;
import static practica1_201212764.juego.mostrarMenu;
import static practica1_201212764.juego.mov1;
import static practica1_201212764.juego.mov2;
import static practica1_201212764.juego.recursivDestapa;



//codigo fuente del juego
class menu_201212764 {
    

    Scanner lector = new Scanner(System.in);
  String ini;
    private int count;
    private boolean fipartida;
    public void menu(){
         System.out.println("......................");
                System.out.println("LUDWING ALEXANDER ARIAS MORALES");
                System.out.println("201212764");
                 System.out.println("IPC A  PRACTICA 1");
                  System.out.println("  BUSCAMINAS");
                  ini=lector.nextLine();
                  if(ini.equals("")){
                   while (!fi) {
            count = 0;
            fipartida = false;
            mostrarMenu();
            iniciaTablero();
            imprTablero(filas, columnas, matriz2);
            System.out.println("");
           
            introMovim();
            intrMinas();
            checkMinas();
            recursivDestapa(mov1, mov2);
            while (!fipartida) {
                if (libre) {
                    imprTablero(filas, columnas, matriz);
                    System.out.println("");
                }
                imprTablero(filas, columnas, matriz2);
                System.out.println("");
               
             
                System.out.println("");
                introMovim();
                recursivDestapa(mov1, mov2);
            }
        }

    }
    }
}