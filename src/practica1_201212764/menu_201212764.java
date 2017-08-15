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
    
     Scanner sn =new Scanner(System.in);
   boolean salir =false;
  int enter;  //  guardaremos la opcion del usuario
  
      public void menu()  throws IOException {
          while (!salir){
       System.out.println("......................");
                System.out.println("LUDWING ALEXANDER ARIAS MORALES");
                System.out.println("201212764");
                 System.out.println("IPC A  PRACTICA 1");
                  System.out.println("  BUSCAMINAS");
            System.out.println("Precione enter");
            System.out.println("");
            
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                enter = sn.nextInt();
 
                switch (enter) {
                    case 1:
                          System.out.println("precione enter");
   
                    
                        break;
                    case 2:
                         
    
                        break;
                    case 3:
                       salir = true;
                         System.out.println("bye bye bye");
                        break;
                   
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
 
} 

