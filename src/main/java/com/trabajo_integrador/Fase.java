package com.trabajo_integrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Fase {
   public String nombre;
   public Ronda ronda[];

   public Fase(String nombre, String pathArchivo){
      this.nombre = nombre;

      String[] nombresRonda = rondas(pathArchivo);

      ronda = new Ronda[nombresRonda.length];
      for(int rnd = 0; rnd<ronda.length; rnd++)
         ronda[rnd] = new Ronda(nombresRonda[rnd], pathArchivo);
   }

   private String[] rondas(String pathArchivo){
      String[] nombresRonda = null;
      try {
         // Primero: hay que contar las rondas de la fase
         // Inicialmente rondaActual = "" y rnd = 0.
         // Itero por las lineas del archivo
         // Si rondaActual con rondaArchivo son distintos
         // cuento rnd++ y cambio rondaActual
         // solo para las lineas donde nombreFase == faseActual
         String nombreRondaActual = "";//Files.readAllLines(Paths.get(pathArchivo)).get(0).split(";")[1];
         int rnd = 0;
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if((nombre.equals(linea.split(";")[0]))&&(!nombreRondaActual.equals(linea.split(";")[1]))){
               nombreRondaActual = linea.split(";")[1];
               rnd++;
            }
               
         }

         // Genero el arreglo de nombres
         nombresRonda = new String[rnd];

         // tercero, cada vez que cambia el nombre, lo guardo y avanzo en el arreglo
         nombreRondaActual = "";
         rnd = 0;
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if((nombre.equals(linea.split(";")[0]))&&(!nombreRondaActual.equals(linea.split(";")[1]))){
               nombresRonda[rnd] = linea.split(";")[1];
               nombreRondaActual = linea.split(";")[1];
               rnd++;
            }
         }
      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
      return nombresRonda;
   }
}
