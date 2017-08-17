/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201212764;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Majosh
 */
class menu_201212764 {
    
     Scanner lector = new Scanner(System.in);
  String ini;
    public void menu(){
         System.out.println("......................");
                System.out.println("LUDWING ALEXANDER ARIAS MORALES");
                System.out.println("201212764");
                 System.out.println("IPC A  PRACTICA 1");
                  System.out.println("  BUSCAMINAS");
                  ini=lector.nextLine();
                  if(ini.equals("")){
                     juego menu=new juego(); //Creamos un objeto de la clase Juego
                      menu.go();
                  }else{
                      System.out.println("precione enter");
}
}
}