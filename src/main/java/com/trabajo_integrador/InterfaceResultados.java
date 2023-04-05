package com.trabajo_integrador;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class InterfaceResultados {
   public List<String[]> rondaPartido;
   public int rondas;
   public int partidos;

   public InterfaceResultados(){
      rondaPartido = new ArrayList<String[]>();
   }

   public void cargarDesdeArchivo(String PathArchivo){
      try {
         for (String linea : Files.readAllLines(Paths.get(PathArchivo))){
            rondaPartido.add(linea.split(";"));
         }
         rondas=calcularRondas();
         partidos=calcularPartidos();

      } catch (IOException e) {
         // TODO: handle exception
         System.err.println("Error con el archivo: " + PathArchivo + ". Exception: " + e.toString());
      }
   }

   private int calcularRondas(){
      return Integer.parseInt(rondaPartido.get(rondaPartido.size()-1)[0]);
   }

   private int calcularPartidos(){
      int p=0;
      while (rondaPartido.get(1)[0]=="1"){
         p++;
      }
      return p;
   }
}
