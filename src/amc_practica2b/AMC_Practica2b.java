/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amc_practica2b;

import manejaFichero.ManejaFichero;
import algoritmos.Algoritmos;
import grafo.Grafo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class AMC_Practica2b {

    
    public static final int MAX = 1500;
    public static final int REPETICIONES = 10;
    
    public static void main(String[] args) {

        String nombreFichero = "";
        
        int opcion;
        Algoritmos Algo = new Algoritmos();
        ArrayList<Punto> ArrayDePuntos = new ArrayList<>();
        ManejaFichero MF;
        int talla = 0;
        
        do{
            Scanner scn;
            scn = new Scanner(System.in);
            
            System.out.println("DISTANCIA 3 PUNTOS");
            System.out.println("1. Generar array aleatorio");
            System.out.println("2. Leer fichero");
            System.out.println("3. Arbol de recubrimiento minimo Kruskal");
            System.out.println("4. Arbol de recubrimiento minimo Prim");
            System.out.println("0. Salir");
            System.out.println("Introduzca una opcion: ");
            
            System.out.println(opcion = scn.nextInt());

            switch(opcion){
                case 1:
                    System.out.println("Escriba la talla del problema: ");
                    talla = scn.nextInt();
                    ArrayDePuntos = Algo.GenerarPuntosAleatorios(talla);
                break;

                case 2:
                {
                    System.out.println("Escriba el nombre del fichero: ");
                    nombreFichero = scn.next();
                    MF = new ManejaFichero(nombreFichero);

                    try {
                        ArrayDePuntos = MF.Leer();
                    } catch (IOException ex) {
                        Logger.getLogger(AMC_Practica2b.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 3:
                {   
                    Grafo graf = new Grafo(ArrayDePuntos);
                    
                    Algo.AlgoritmoDeKruskal(graf);
                }    
                break;
                
                case 4:
                {
                    Grafo graf = new Grafo(ArrayDePuntos);
                    
                    MF.Escribir(Algo.AlgoritmoDePrim(graf));

                }
                break;
            }
        }while(opcion != 0);
    }
}
