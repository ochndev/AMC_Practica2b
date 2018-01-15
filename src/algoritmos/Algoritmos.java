/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Algoritmos {
    
    public ArrayList<Vertice>  GenerarVerticesAleatorios(int talla){

        Random rnd = new Random(System.currentTimeMillis());        
        ArrayList<Vertice> ArrayDeVertices = new ArrayList<>();
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
        ConjuntoCandidatos = g.getAristas();

        //Crear una Cola de prioridad con las aristas ordenadas por distancia
        
        for(int i = 0; i < ConjuntoCandidatos.size(); i++){
            QueueCandidatos.add(ConjuntoCandidatos.get(i));
        }
        
        int n = g.getNumelementos();
        
        //Inicializar, creamos un conjunto de conjuntos disjuntos de vertices
            
        ArrayList<ArrayList> ConjuntoConjuntoVertice = new ArrayList<>();
            
        for(int z = 0 ; z < g.getVertices().size() ; z++){
            ArrayList<Vertice> ConjuntoVertices = new ArrayList<>();
            ConjuntoVertices.add(g.getVertices().get(z));
            ConjuntoConjuntoVertice.add(ConjuntoVertices);
        }
         
            
        //Bucle voraz
        
        while(ConjuntoSolucion.size() < n-1){
            
            //Extraemos la arista mas corta eliminandola de la cola.       
            Arista aux = QueueCandidatos.poll();

            int i = 0 , j = 0;
            
            //Comprobamos que los vertices de la arista pertenecena distintos
            //conjuntos disjuntos.
            
            while(!ConjuntoConjuntoVertice.get(i).contains(aux.getA()))
                i++;
            
            while(!ConjuntoConjuntoVertice.get(j).contains(aux.getB()))
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
                
        CCV.remove(i);
    }
    
    public void mostrarAristas(ArrayList<Arista> solucion){
        for(int i = 0 ; i < solucion.size(); i++)
            System.out.println(solucion.get(i).MostrarArista());
    }
    
    //////////////////////// ALGORITMO DE PRIM /////////////////////////////////
    
    //Como todos los puntos en el grafo estan conectados con todos, contruiremos
    //el algoritmo de un modo diferente (Sin matriz de adyacencia)
    public ArrayList<Arista> AlgoritmoDePrim(Grafo graf){
                
        ArrayList<Arista> ConjuntoSolucion;
        Arista AristaAux;
        
        int n = graf.getNumelementos();
        
        //elegir punto de partida        
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        int indicealeatorio = Math.abs(rnd.nextInt()%graf.getNumelementos());
        
        Vertice verticeaux = graf.getVertices().get(indicealeatorio);
        //Añadimos el vertice en una cola de prioridad ordenada por distancia
        
        ArrayList<Vertice> VerticesVisitados = new ArrayList<>();
        
        //desplegamos los adyacentes del vertice, añadimos al arbol la distancia minima
        //añadimos el vertice al arbol
        //movemos el puntero al vertice apuntado por la arista con distancia minima
        
        ConjuntoSolucion = new ArrayList<>();        
        
        //si es solucion lo añado al conjunto solucion
        
        while(ConjuntoSolucion.size() < n-1){
            
            AristaAux = MasProximo(graf,verticeaux,VerticesVisitados);
            
            ConjuntoSolucion.add(AristaAux);
            VerticesVisitados.add(AristaAux.getB());
            verticeaux = AristaAux.getB();
            
        }
        
        return ConjuntoSolucion;
    }
    
    public Arista MasProximo(Grafo graf, Vertice verticeaux, ArrayList<Vertice> VerticesVisitados){
        
        int indice = graf.getVertices().indexOf(verticeaux);
        double distancia_minima = 1000000;
        int indice_final = 0;
        for(int j = 0 ; j < graf.getVertices().size() ; j++){
            if((graf.getMatrizDistancias()[indice][j] < distancia_minima) && 
               (!VerticesVisitados.contains(graf.getVertices().get(j))) && 
               ( j != indice )){
                
                indice_final = j;
                distancia_minima = graf.getMatrizDistancias()[indice][j];
            
            }            
        }
            
        return (new Arista(verticeaux,graf.getVertices().get(indice_final),graf.getMatrizDistancias()[indice][indice_final]));
            
    }
    
    public double CalcularSolucion(ArrayList<Arista> solucion){
        double suma_solucion = 0;
        for(int i = 0 ; i < solucion.size() ; i++){
            suma_solucion += solucion.get(i).getDistancia();
        }
        return suma_solucion;
    }
    
}
