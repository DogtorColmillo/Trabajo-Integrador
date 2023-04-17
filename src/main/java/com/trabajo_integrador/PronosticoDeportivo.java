package com.trabajo_integrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class PronosticoDeportivo {
   public static void main(String[] args) {
      System.out.println("Bienvenido al Puntaje de Pronosticos Deportivos!");
      // CARGA PRONOSTICOS
      String archivoPronosticos = args[0];
      String[] nombresPersona = personas(archivoPronosticos);
      Persona[] persona = new Persona[nombresPersona.length];
      
      for(int per=0; per<persona.length; per++){
         persona[per] = new Persona(nombresPersona[per],archivoPronosticos);
      }

      // Test Persona OK
      //for(int per=0; per<persona.length; per++){
      //   System.out.println(persona[per].nombre + " hizo " + persona[per].pronostico.length + " pronosticos.");
      //   for(int prn=0; prn<persona[per].pronostico.length; prn++)
      //      System.out.println("   " + persona[per].pronostico[prn].equipo + " " + persona[per].pronostico[prn].resultado);
      //}


      // CARGA RESULTADOS
      String archivoResultados = args[1];

      String[] nombresFase = fases(archivoResultados);
      // Test nombresRonda OK
      //for(int rnd=0; rnd<nombresRonda.length; rnd++)
      //   System.out.println((rnd+1) + " - " + nombresRonda[rnd]);


      Fase[] fase = new Fase[nombresFase.length];
      for(int fs = 0; fs<fase.length; fs++)
         fase[fs] = new Fase(nombresFase[fs], archivoResultados);
      
      // Resultado del programa OK
      for(int per = 0; per<persona.length; per++){
         System.out.println(persona[per].nombre + ": " + persona[per].puntos(fase));
      }
               
                  

      System.out.println("Gracias por participar!");
      System.out.println();
      System.out.println();
   }

   private static String[] personas(String pathArchivo){
      String[] nombresPersona = null;
      try {
         // Primero, tomo el nombre de la primera ronda
         // y cuento cada vez que cambia, actualizando el 
         // nombreRondActual e incrementando el contador
         String nombrePersonaActual = Files.readAllLines(Paths.get(pathArchivo)).get(0).split(";")[0];
         int per = 1;
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if(!nombrePersonaActual.equals(linea.split(";")[0])){
               nombrePersonaActual = linea.split(";")[0];
               per++;
            }
               
         }

         // Genero el arreglo de nombres
         nombresPersona = new String[per];

         // tercero, cada vez que cambia el nombrem, lo guardo y avanzo en el arreglo
         nombresPersona[0] = Files.readAllLines(Paths.get(pathArchivo)).get(0).split(";")[0];
         per = 1;
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if(!nombresPersona[per-1].equals(linea.split(";")[0])){
               nombresPersona[per] = linea.split(";")[0];
               per++;
            }
         }
      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
      return nombresPersona;
   }

   private static String[] fases(String pathArchivo){
      String[] nombresFase = null;
      try {
         // Primero, tomo el nombre de la primera ronda
         // y cuento cada vez que cambia, actualizando el 
         // nombreRondActual e incrementando el contador
         String nombreFaseActual = Files.readAllLines(Paths.get(pathArchivo)).get(0).split(";")[0];
         int rnd = 1;
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if(!nombreFaseActual.equals(linea.split(";")[0])){
               nombreFaseActual = linea.split(";")[0];
               rnd++;
            }
               
         }

         // Genero el arreglo de nombres
         nombresFase = new String[rnd];

         // tercero, cada vez que cambia el nombrem, lo guardo y avanzo en el arreglo
         nombresFase[0] = Files.readAllLines(Paths.get(pathArchivo)).get(0).split(";")[0];
         rnd = 1;
         for(String linea : Files.readAllLines(Paths.get(pathArchivo))){
            if(!nombresFase[rnd-1].equals(linea.split(";")[0])){
               nombresFase[rnd] = linea.split(";")[0];
               rnd++;
            }
         }
      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
      return nombresFase;
   }
}
