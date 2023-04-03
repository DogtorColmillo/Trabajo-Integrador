package com.trabajo_integrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Pronostico {
   public String nombrePersona;
   public int cantidadPronosticos;
   public Equipo[] equipo1;
   public Equipo[] equipo2;
   public Resultado[] resultado1;
   public Resultado[] resultado2;

   public Pronostico(String archivoPronostico){
      nombrePersona = "Pepe";
      cantidadPronosticos = misFunciones.contarPartidos(archivoPronostico);
      equipo1 = new Equipo[cantidadPronosticos];
      equipo2 = new Equipo[cantidadPronosticos];
      resultado1 = new Resultado[cantidadPronosticos];
      resultado2 = new Resultado[cantidadPronosticos];
      int i = 0;
      //Abre el archivo pronostico.csv y leo las lineas
      try{
         for(String linea: Files.readAllLines(Paths.get(archivoPronostico))){
            String [] datos = linea.split(";");
            equipo1[i]=new Equipo(datos[0], "");
            resultado1[i] = Resultado.valueOf(datos[1]);
            resultado2[i] = Resultado.valueOf(datos[2]);
            equipo2[i]=new Equipo(datos[3], "");
            i++;
         }
      } catch (IOException e){
         System.err.println("Error al leer el archivo: " + e.getMessage());
      }
   }

   public Resultado resultadoEquipo1(int pronostico){
      return resultado1[pronostico];
   }

}
