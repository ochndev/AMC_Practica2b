/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amc_practica2b;

import manejaFichero.ManejaFichero;
import algoritmos.Algoritmos;
import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;
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
        ArrayList<Vertice> ArrayDeVertices = new ArrayList<>();
        ManejaFichero MF = new ManejaFichero(nombreFichero);
        int talla = 0;
        ArrayList<Arista> Resultado = new ArrayList<>();
        
        do{
            Scanner scn;
            scn = new Scanner(System.in);
            
            System.out.println("ARBOL RECUBRIDOR MINIMO (KRUSKAL Y PRIM)");
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
                    ArrayDeVertices = Algo.GenerarVerticesAleatorios(talla);
                break;

                case 2:
                {
                    System.out.println("Escriba el nombre del fichero: ");
                    nombreFichero = scn.next();
                    MF = new ManejaFichero(nombreFichero);

                    try {
                        ArrayDeVertices = MF.Leer();
                    } catch (IOException ex) {
                        Logger.getLogger(AMC_Practica2b.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 3:
                {   
                    
                    long tiempoini = 0, tiempofin = 0, tiempototal = 0;
                    
                    for(int i = 0; i< 10; i++){                    
                        Grafo graf = new Grafo(ArrayDeVertices);
                        tiempoini = System.nanoTime();
                        Resultado = Algo.AlgoritmoDeKruskal(graf);
                        tiempofin = System.nanoTime();
                        tiempototal += tiempofin - tiempoini;
                    }
                    
                    Algo.mostrarAristas(Resultado);
                    System.out.println("Solucion: "+Algo.CalcularSolucion(Resultado));
                    
                    System.out.println("El tiempo es: "+tiempototal/10/1000+" us");
                    
                    try {
                        MF.Escribir(Resultado);
                    } catch (IOException ex) {
                        Logger.getLogger(AMC_Practica2b.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case 4:
                {   
                    
                    long tiempoini = 0, tiempofin = 0, tiempototal = 0;

                    
                    for(int i = 0 ; i < 10; i++){
                        Grafo graf = new Grafo(ArrayDeVertices);
                        tiempoini = System.nanoTime();
                        Resultado = Algo.AlgoritmoDePrim(graf);
                        tiempofin = System.nanoTime();
                        tiempototal += tiempofin - tiempoini;
                    }

                    Algo.mostrarAristas(Resultado);
                    System.out.println("Solucion: "+Algo.CalcularSolucion(Resultado));
                    
                    System.out.println("El tiempo es: "+tiempototal/10/1000+" us");
                    
                    try {
                        MF.Escribir(Resultado);
                    } catch (IOException ex) {
                        Logger.getLogger(AMC_Practica2b.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }while(opcion != 0);
    }
}
