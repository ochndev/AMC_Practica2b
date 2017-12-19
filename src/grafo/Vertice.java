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
public class Vertice {
    
    private int coordX;
    private int coordY;
    int nombre;

    public Vertice(int coordX, int coordY, int nombre) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.nombre = nombre;
    }

    public int getX() {
        return coordX;
    }

    public void setX(int coordX) {
        this.coordX = coordX;
    }

    public int getY() {
        return coordY;
    }

    public void setY(int coordY) {
        this.coordY = coordY;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
}
