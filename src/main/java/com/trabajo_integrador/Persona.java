package com.trabajo_integrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Persona {
   public String nombre;
   public Pronostico[] pronostico;

   public Persona(String nombre,String pathArchivo){
      this.nombre = nombre;
      try {
         int prn = 0;
         for (String linea : Files.readAllLines(Paths.get(pathArchivo))){
            String[] parte = linea.split(";");
            if(nombre.equals(parte[0]))
               prn++;
         }

         pronostico = new Pronostico[prn];
         for(prn = 0; prn<pronostico.length; prn++)
            pronostico[prn]=new Pronostico();

         prn = 0;
         for (String linea : Files.readAllLines(Paths.get(pathArchivo))){
            String[] parte = linea.split(";");
            if(nombre.equals(parte[0])){
               pronostico[prn].ronda = parte[1];
               pronostico[prn].partido = Integer.parseInt(parte[2]);
               pronostico[prn].equipo = parte[3];
               pronostico[prn].resultado = Resultado.valueOf(parte[4]);
               prn++;
            }
         }

      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
   }

   public int puntos(Ronda[] ronda){
      int totalPuntos = 0;
      try{
            for(int rnd = 0; rnd<ronda.length; rnd++){
               for(int pr = 0; pr<pronostico.length; pr++){
                  if(pronostico[pr].resultado == ronda[rnd].partido[pr].resultado(pronostico[pr].equipo))
                     totalPuntos++;
               }
            }

      }catch(Exception e){
         System.out.println("Error al comparar los pronosticos con los resultado. Error: " + e.toString());
         System.out.println("Es posible que el numero de pronosticos no coincida con el número de partidos por ronda");
      }
      return totalPuntos;
   }
}
