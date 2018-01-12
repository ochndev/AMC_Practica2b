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
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Algoritmos {

    ArrayList<Punto> puntos;
    
    
    public ArrayList<Vertice>  GenerarVerticesAleatorios(int talla){

        Random rnd = new Random(System.currentTimeMillis());        
        ArrayList<Vertice> ArrayDeVertices = new ArrayList();
        Vertice puntoAux;

        System.out.println("Generando Puntos Aleatorios");
        
        for (int i = 0; i < talla; i++) {
            
            int coordX = rnd.nextInt(10000);
            int coordY = rnd.nextInt(10000);
            
            puntoAux = new Vertice(coordX,coordY,i);
            
            ArrayDeVertices.add(puntoAux);            
        }
        
        return ArrayDeVertices;        
    }
    
    /////////////// ALGORITMO DE KRUSKAL /////////////////////////////////////
    
    public ArrayList<Arista> AlgoritmoDeKruskal(Grafo g){
        
        ArrayList<Arista> ConjuntoSolucion;
        PriorityQueue<Arista> QueueCandidatos;
        QueueCandidatos = new PriorityQueue();

        ArrayList<Arista> ConjuntoCandidatos;
        ConjuntoSolucion = new ArrayList<>();
        ConjuntoCandidatos = new ArrayList<>();

        //Crear una Cola de prioridad con las aristas ordenadas por distancia
        
        for(int i = 0; i < ConjuntoCandidatos.size(); i++)
            QueueCandidatos.add(g.getAristas().get(i));
        
        int n = QueueCandidatos.size();
        
        //Inicializar, creamos un conjunto de conjuntos disjuntos de vertices
            
            ArrayList<ArrayList> ConjuntoConjuntoVertice = new ArrayList<>();
            
            for(int z = 0 ; z < g.getVertices().size() ; z++){
                ArrayList<Vertice> ConjuntoVertices = new ArrayList<>();
                ConjuntoVertices.add(g.getVertices().get(z));
                ConjuntoConjuntoVertice.add(ConjuntoVertices);
            }
            
        //Bucle voraz
        
        while(ConjuntoSolucion.size()!= n-1){
            
            //Extraemos la arista mas corta eliminandola de la cola.       
            Arista aux = QueueCandidatos.poll();

            int i = 0 , j = 0;
            
            //Comprobamos que los vertices de la arista pertenecena distintos
            //conjuntos disjuntos.
            while(!ConjuntoConjuntoVertice.get(i).contains(aux.getA()))
                i++;
            
            while(ConjuntoConjuntoVertice.get(j).contains(aux.getB()))
                j++;
            
            if(i != j){
                Fusionar(ConjuntoConjuntoVertice,i,j);
                ConjuntoSolucion.add(aux);
            }
        }
        
        return ConjuntoSolucion;        
    }
    
    public void Fusionar(ArrayList <ArrayList> CCV, int i, int j){
        
        int x = 0;
        
        for(x = 0; x < CCV.get(i).size(); x++)
            CCV.get(j).add(CCV.get(i).get(x));
        
        CCV.get(i).remove(x);
        
    }
    
    
    //////////////////////// ALGORITMO DE PRIM /////////////////////////////////
    
    
    
    public ArrayList<Arista> AlgoritmoDePrim(Grafo graf){
                
        Arista auxar;
        
        //elegir punto de partida        
        Random rnd = new Random();
        int indicealeatorio = rnd.nextInt()%graf.getNumelementos();
        
        Vertice verticeaux = graf.getVertices().get(indicealeatorio);
        //Añadimos el vertice en una cola de prioridad ordenada por distancia
        
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
