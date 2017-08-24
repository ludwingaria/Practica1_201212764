/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201212764;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**como
 *
 * @author Majosh
 */
class juego {
    
    public static char[][] matriz = new char[9][9];
    public static char[][] matriz2 = new char[9][9];
    public static int filas = 0;
    public static int columnas = 0;
    public static int minas = 0;
    public static int mov1 = 0;
    public static int mov2 = 0;
    public static int win = 0;
    public static boolean fipartida = false;
    public static boolean debug = false;
    public static int count = 0;
    public static boolean fi = false;

    /**
     * @return Devuelve el tiempo actual en ms
     */
   //menu principal con sus datos

    /**
     * @see mostrarMenu Muestra el menú de juego al usuario y según la decisión
     * del usuario establece las dimensiones del tablero y la cantidad de minas
     * a disponer así como el cálculo de cuantas casillas hay que destapar para
     * ganar
     */
    public static void go() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("BUSCAMINAS");
        System.out.println("=========================");
        System.out.println("Menu:");
        System.out.println("1. Jugar Nivel Principiante");
        System.out.println("2. Jugar Nivel Intermedio");
        System.out.println("3. Jugar Nivel Avanzado");
        System.out.println("4. Jugar Modo Debug");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Selecciona el nivel que desea jugar (1-5): ");
        int opcion = sc.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                filas = 5;
                columnas = 5;
                minas = 4;
                win = (4 * 4) - 19;
                break;
            case 2:
                filas = 7;
                columnas = 7;
                minas = 8;
                win = (6 * 6) - 8;
                break;
            case 3:
                filas = 9;
                columnas = 9;
                minas = 12;
                win = (8 * 8) - 12;
                break;
            case 4:
                debug = true;
                filas = 9;
                columnas = 9;
                minas = 19;
                win = (8 * 8) - 19;
                break;
            case 5:
                fi = true;
                System.exit(0);
                System.out.println("Te has salido del juego bye bye");
                break;
            default:
                System.out.println("Introduce una opción valida!!");
                break;
        }
    }

    /**
     * @see imprTablero Imprime el tablero de juego en pantalla
     * @param length Tamaño de las filas del tablero
     * @param length0 Tamaño de las columnas del tablero
     * @param matriz Matriz del tablero de juego
     */
    public static void imprTablero(int length, int length0, char[][] matriz) {
        System.out.println("Tablero de juego");
        for (int i = 1; i < length; i++) {
            if (i == 1) {
                System.out.println("---------------------------------");
            }
            System.out.printf("%4s", i + " ");
            for (int j = 1; j < length0; j++) {
                System.out.printf("%s", "|" + matriz[i][j] + "|");
            }
            if (i == length - 1) {
                System.out.println("");
                for (int j = 1; j < columnas; j++) {
                    if (j == 1) {
                        System.out.print("    ");
                    }
                    System.out.printf("%3s", j + " ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * @see randNumero Crea un numero aleatorio para disponer las minas
     * @param sup Limite del rango númerico
     * @return Devuelve el número aleatorio
     */
    public static int randNumero(int sup) {
        Random rnd = new Random();
        int num = (int) (Math.random() * sup);
        return num;
    }

    /**
     * @see iniciaTablero Inicia la matriz del tablero con guiones
     */
    public static void iniciaTablero() {
        for (int l = 1; l < filas; l++) {
            for (int m = 1; m < columnas; m++) {
                matriz2[l][m] = '-';
            }
        }
        for (int l = 1; l < filas; l++) {
            for (int m = 1; m < columnas; m++) {
                matriz[l][m] = '-';
            }
        }
    }

    /**
     * @see intrMinas Introduce las minas en el tablero de juego de manera
     * aleatoria y de manera que no coincida con la primera casilla destapada
     */
    public static void intrMinas() {
        boolean full = false;
        int i = 0;
        out:
        while (i <= minas) {
            for (int j = 1; j < filas; j++) {
                for (int k = 1; k < columnas; k++) {
                    int mina = randNumero(columnas);
                    if ((k == mina) && (matriz[j][k] == '-') && (j != mov1 && k != mov2)) {
                        matriz[j][k] = '*';
                        ++i;
                        if (i == minas) {
                            break out;
                        }
                    }
                }
            }
        }
    }

    /**
     * @see checkMinas Cuenta el numero de minas y espacios del tablero de juego
     */
    public static void checkMinas() {
        int count = 0;
        for (int n = 2; n <= matriz.length - 2; ++n) {
            for (int o = 2; o <= matriz[0].length - 2; ++o) {
                count = 0;
                if ((matriz[n + 1][o + 1] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n - 1][o - 1] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n - 1][o + 1] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n + 1][o - 1] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n - 1][o] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n + 1][o] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n][o + 1] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if ((matriz[n][o - 1] == '*') && (matriz[n][o] == '-')) {
                    ++count;
                }
                if (matriz[n][o] == '-') {
                    if (count > 0) {
                        matriz[n][o] = Integer.toString(count).charAt(0);
                    } else if (count == 0) {
                        matriz[n][o] = Integer.toString(count).charAt(0);
                    }
                }
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == '-') {
                    matriz[i][j] = Integer.toString(0).charAt(0);
                }
            }
        }
    }

    /**
     * @see introMovim Introduce el movimiento del jugador en el juego
     */
    public static void introMovim() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("voltear!");
            System.out.print("Introduce la fila ");
            mov1 = sc.nextInt();
            System.out.print("Introduce la columna ");
            mov2 = sc.nextInt();
            System.out.println("");
            if ((mov1 < filas && mov2 < columnas) && (mov1 > 0 && mov2 > 0)) {
                valid = true;
            } else {
                valid = false;
            }
        }
    }

    /**
     * @see recursivDestapa Destapa recursivamente las casillas de juego segun
     * se reunan las condiciones asi como comprueba si se gana o pierde el juego
     * @param casilla Casilla de fila
     * @param casilla2 Casilla de columna
     */
    public static void recursivDestapa(int casilla, int casilla2) {
        int casillorg = mov1;
        int casill2org = mov2;
        if (casilla > filas - 1 || casilla < 0 || casilla2 > columnas - 1 || casilla2 < 0) {
            return;
        }
        if (matriz[casillorg][casill2org] == '*') {
            fipartida = true;
            System.out.println("BOOM!!");
            System.out.println("");
        } else if (matriz[casilla][casilla2] == '0') {
            if (matriz2[casilla][casilla2] != matriz[casilla][casilla2]) {
                matriz2[casilla][casilla2] = matriz[casilla][casilla2];
                ++count;
                recursivDestapa(casilla + 1, casilla2);
                recursivDestapa(casilla, casilla2 + 1);
                recursivDestapa(casilla + 1, casilla2 + 1);
            }
            if (casilla > filas - 1 || casilla < 0 || casilla2 > columnas - 1 || casilla2 < 0) {
                recursivDestapa(casilla, casilla2 - 1);
                recursivDestapa(casilla - 1, casilla2);
                recursivDestapa(casilla - 1, casilla2 - 1);
                recursivDestapa(casilla - 1, casilla2 + 1);
                recursivDestapa(casilla + 1, casilla2 - 1);
            }
        } else if ((matriz[casilla][casilla2] > '0')) {
            if (matriz2[casilla][casilla2] != matriz[casilla][casilla2]) {
                matriz2[casilla][casilla2] = matriz[casilla][casilla2];
                ++count;
            }
        }
        if (count == win) {
            System.out.println("Has ganado!!!");
            fipartida = true;
        }
    }

    /**
     * @see main Metodo main donde se llama de manera ordenada a las distintas
     * funciones de juego
     * @param args the command line arguments
     */
   
        // TODO code application logic here
        
           
          
           
           
           
            
         
                    
              
              
            }
        

    
