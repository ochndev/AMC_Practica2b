/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author oscar
 */
public class Arista {

    private Vertice A;
    private Vertice B;
    private double distancia;
    
    public Arista(Vertice a, Vertice b, double distancia){
        this.A = a;
        this.B = b;
        this.distancia = distancia;
    }
    
    
}
