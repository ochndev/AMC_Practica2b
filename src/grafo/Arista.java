/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import amc_practica2b.Punto;

/**
 *
 * @author oscar
 */
public class Arista implements Comparable<Arista>{

    private Vertice A;
    private Vertice B;
    private double distancia;
    
    public Arista(Vertice a, Vertice b, double distancia){
        this.A = a;
        this.B = b;
        this.distancia = distancia;
    }
    
    public String MostrarArista(){
        String auxiliar = "("+A.getNombre()+" - "+B.getNombre()+")";
        
        return auxiliar;
    }
    
    public Vertice getA(){
        return A;
    }
    
    public Vertice getB(){
        return B;
    }

    @Override
    public int compareTo(Arista otra) {
        
        if(this.distancia > otra.distancia)
            return 1;
        else
            return -1;
    }
    
    
}
