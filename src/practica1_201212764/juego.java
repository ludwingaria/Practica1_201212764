/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201212764;

import java.util.InputMismatchException;
import java.util.Scanner;

/**como
 *
 * @author Majosh
 */
class juego {
    
     Scanner sn =new Scanner(System.in);
   boolean salir =false;
  int opcion;  //  guardaremos la opcion del usuario
  
    public void go(){
          while (!salir){
       System.out.println("......................");
                
                System.out.println("  BUSCAMINAS  ");
                 System.out.println("1. principiante");
                 System.out.println("2. intermedio");
            System.out.println("3. experto");
            System.out.println("");
            
            System.out.println("0. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                       
   
                    
                        break;
                    case 2:
                         
    
                        break;
                        case 3:
                         
    
                        break;
                    case 0:
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


    

