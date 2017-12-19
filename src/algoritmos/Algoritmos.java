/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import grafo.Arista;
import grafo.Grafo;
import amc_practica2b.Punto;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Algoritmos {

    ArrayList<Punto> puntos;
    
    
    public ArrayList<Punto>  GenerarVerticesAleatorios(int talla){

        Random rnd = new Random(System.currentTimeMillis());        
        ArrayList<Punto> ArrayDePuntos = new ArrayList();
        Punto puntoAux;

        System.out.println("Generando Puntos Aleatorios");
        
        for (int i = 0; i < talla; i++) {
            
            int coordX = rnd.nextInt(10000);
            int coordY = rnd.nextInt(10000);
            
            puntoAux = new Punto(coordX,coordY);
            
            ArrayDePuntos.add(puntoAux);            
        }
        
        return ArrayDePuntos;
        
    }
    
    public ArrayList<Arista> AlgoritmoDeKruskal(Grafo g){
        ArrayList<Arista> ConjuntoSolucion;
        ConjuntoSolucion = new ArrayList<>();
        return ConjuntoSolucion;
    }
    
    public ArrayList<Arista> AlgoritmoDePrim(Grafo graf){
                
        Arista auxar;
        
        //elegir punto de partida
        
        Random rnd = new Random();
        int indicealeatorio = rnd.nextInt()/graf.getNumelementos();
        
        Vertice verticeaux = graf.getVertices().get(indicealeatorio);
        
        //desplegamos los adyacentes del vertice, añadimos al arbol la distancia minima
        //añadimos el vertice al arbol
        //movemos el puntero al vertice apuntado por la arista con distancia minima
               
        ArrayList<Arista> ConjuntoSolucion;
        ConjuntoSolucion = new ArrayList<>();
        
        double distanciaminima = 1000000;
        
        for(int j = 0; j< graf.getNumelementos(); j++){
            
            distanciaAux = Distancia2Vertices();
            
            
                        verticeaux = graf.getVertices().get(j);
            if(graf.getMatrizDistancias())

        }
        //si es solucion lo añado al conjunto solucion
        
        ConjuntoSolucion.add(auxar);
        
        return ConjuntoSolucion;
    }
    
}
