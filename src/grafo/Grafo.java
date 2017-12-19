/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import amc_practica2b.Punto;
import java.util.ArrayList;
import algoritmos.Algoritmos;

/**
 *
 * @author oscar
 */
public class Grafo {
   
    private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;
    private int numelementos;
    private double [][] matriz_distancias;

    public Grafo(ArrayList<Vertice> vertices, ArrayList<Arista> aristas, int numelementos) {
        this.vertices = vertices;
        this.aristas = aristas;
        this.numelementos = numelementos;
        this.matriz_distancias = new double [numelementos][numelementos];
        
    }
    
    public Grafo(ArrayList<Punto> puntos){
        
        numelementos = puntos.size();
        
        matriz_distancias = new double [numelementos][numelementos];
        
        for(int i= 0; i<numelementos; i++)
            for(int j = 0; j<numelementos; j++)
                matriz_distancias[i][j] = CalcularDistancia2Puntos(puntos.get(i),puntos.get(j));
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }

    public int getNumelementos() {
        return numelementos;
    }

    public void setNumelementos(int numelementos) {
        this.numelementos = numelementos;
    }
    
    private double CalcularDistancia2Puntos(Punto A, Punto B){
        double distancia = Math.sqrt(Math.pow(A.getX()-B.getX(),2)+Math.pow(A.getY()-B.getY(),2));
        return distancia;
    }
    
    public double [][] getMatrizDistancias(){
        return this.matriz_distancias;
    }
    
}
