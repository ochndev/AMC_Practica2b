/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejaFichero;

import algoritmos.Algoritmos;
import grafo.Arista;
import grafo.Vertice;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Locale;

/**
 *
 * @author usuario
 */
public class ManejaFichero {
    
    String inputFile;
    String outputFile;
    ArrayList<Vertice> aux;
    int dimmension;
    String nombreFichero;
    private double solution;
    
    public ManejaFichero(String Fichero){       

        this.inputFile = Fichero;       
        
    }
    
    public ArrayList<Vertice> Leer() throws FileNotFoundException, IOException{
        
        File F = new File(inputFile);
        Scanner scr = new Scanner(F);
        scr.useLocale(Locale.ENGLISH);

        Vertice vert;
        String cadena = "";
        double coordX, coordY;
        
        cadena = scr.nextLine();
        nombreFichero = cadena.replace("NAME: ","");
        scr.nextLine();
        scr.nextLine();
        scr.next();
        dimmension = scr.nextInt();
        while(!scr.hasNextInt()){
            cadena = scr.next();
        }
        
        aux = new ArrayList<>(dimmension);
                
        for (int i = 0 ; i < dimmension ; i++) {
            
            scr.nextInt();
            coordX = scr.nextFloat();
            coordY = scr.nextFloat();
            
            vert = new Vertice(coordX, coordY, i);
            
            aux.add(vert);
        }
        
        scr.close();
        
        return this.aux;        
    }
    
    public void Escribir(ArrayList<Arista>  solucion) throws IOException{
        
        Algoritmos algo = new Algoritmos();
        solution = algo.CalcularSolucion(solucion);
        outputFile = inputFile + ".opt.tour";
        
        FileWriter f = new FileWriter(outputFile);
        try (BufferedWriter BFR = new BufferedWriter(f)) {
            BFR.write("NAME : "+nombreFichero);
            BFR.newLine();
            BFR.write("TYPE : TOUR");
            BFR.newLine();
            BFR.write("DIMMENSION : "+dimmension);
            BFR.newLine();
            BFR.write("SOLUTION : "+solution);
            BFR.newLine();
            BFR.write("TOUR_SECTION");
            for(int i = 0; i < solucion.size() ; i++){
                BFR.write(solucion.get(i).MostrarArista());
                BFR.newLine();
            }
            BFR.write("-1");
            BFR.newLine();
            BFR.write("EOF");
            BFR.newLine();
        }
    }

    public void setNombreFichero(String NombreFichero) {
        this.nombreFichero = NombreFichero;
    }    
}
