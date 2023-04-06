package com.trabajo_integrador;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class InterfacePronosticos {
   public List<String[]> pronosticos;
   public int personas;
   public int partidos;

   public InterfacePronosticos(){
      pronosticos = new ArrayList<String[]>();
   }

   public void cargarDesdeArchivo(String PathArchivo){
      try {
         for (String linea : Files.readAllLines(Paths.get(PathArchivo))){
            pronosticos.add(linea.split(";"));
         }
         personas=calcularPersonas();
         partidos=calcularPartidos();

      } catch (IOException e) {
         // TODO: handle exception
         System.err.println("Error con el archivo: " + PathArchivo + ". Exception: " + e.toString());
      }
   }

   private int calcularPersonas(){
      String primeraPersona = pronosticos.get(1)[0];
      int p = 1;
      while(primeraPersona == pronosticos.get(p)[0]){
         p++;
      }
      return p;
   }

   private int calcularPartidos(){
      int p=0;
      while (pronosticos.get(1)[1]=="1"){
         p++;
      }
      return p;
   }
}
