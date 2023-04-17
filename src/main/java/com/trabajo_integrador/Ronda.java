package com.trabajo_integrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Ronda {
   public String nombre;
   public Partido partido[];
   
   public Ronda(String ronda, String pathArchivo){
      nombre = ronda;

      partido = new Partido[contarPartidos(ronda,pathArchivo)];

      int prt=0;
      try {
         // Cuento las lineas del archivo que empiezan con
         // el nombre de la ronda dado.
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if(ronda.equals(linea.split(";")[1])){
               String[] datosPartido = linea.split(";");
               partido[prt] = new Partido(datosPartido[3],Integer.parseInt(datosPartido[4]), Integer.parseInt(datosPartido[5]), datosPartido[6]);
               prt++;
            }
               
         }
      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
   }

   private int contarPartidos(String ronda, String pathArchivo){
      int prt = 0;
      try {
         // Cuento las lineas del archivo que empiezan con
         // el nombre de la ronda dado.
         
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if(ronda.equals(linea.split(";")[1])){
               prt++;
            }
               
         }
      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
      return prt;
   }
}
