package com.trabajo_integrador;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class PronosticoDeportivo {
   public static void main(String[] args) {
      System.out.println("Bienvenido al Puntaje de Pronosticos Deportivos!");
      if(args.length==0){
         System.out.println("Se requieren dos parametros:");
         System.out.println("  1: Un archivo de texto o los datos de una BD para obtener los pronosticos.");
         System.out.println("  2: Un archivo de texto para obtener los resultados.");
         System.out.println("  Ej: \"csv/pronosticos.csv\" o \"url;user;password\"");
      }else{
         // CARGA PRONOSTICOS
         String[] nombresPersona;
         Persona[] persona;
         if("csv/pronosticos.csv".equals(args[1])){
            String archivoPronosticos = args[1];
            nombresPersona = personas(archivoPronosticos);
            persona = new Persona[nombresPersona.length];
            
            for(int per=0; per<persona.length; per++){
               persona[per] = new Persona(nombresPersona[per],archivoPronosticos);
            }

            // Test Persona OK
            //for(int per=0; per<persona.length; per++){
            //   System.out.println(persona[per].nombre + " hizo " + persona[per].pronostico.length + " pronosticos.");
            //   for(int prn=0; prn<persona[per].pronostico.length; prn++)
            //      System.out.println("   " + persona[per].pronostico[prn].equipo + " " + persona[per].pronostico[prn].resultado);
            //}
         }else{
            String url = args[1].split(";")[0];
            String user = args[1].split(";")[1];
            String pass = args[1].split(";")[2];
            ListaPronosticos listaPronosticos = new ListaPronosticos(url, user, pass);
            nombresPersona = personas(listaPronosticos);
            persona = new Persona[nombresPersona.length];
            
            for(int per=0; per<persona.length; per++){
               persona[per] = new Persona(nombresPersona[per],listaPronosticos);
            }
         }


         // CARGA RESULTADOS
         String archivoResultados = args[0];
         String[] nombresFase = fases(archivoResultados);


         Fase[] fase = new Fase[nombresFase.length];
         for(int fs = 0; fs<fase.length; fs++)
            fase[fs] = new Fase(nombresFase[fs], archivoResultados);
         
         // CALCULA PUNTOS
         // Resultado del programa OK
         for(int per = 0; per<persona.length; per++){
            System.out.println(persona[per].nombre + ": " + persona[per].puntos(fase));
         }
      }

      System.out.println("Gracias por participar!");
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

   private static String[] personas(ListaPronosticos listaPronosticos){
      String[] nombresPersona = null;
      // Primero, tomo el nombre de la primera ronda
      // y cuento cada vez que cambia, actualizando el 
      // nombreRondActual e incrementando el contador
      String nombrePersonaActual = listaPronosticos.pronosticos.get(0).split(";")[0];
      int per = 1;
      for(String linea : listaPronosticos.pronosticos){
         if(!nombrePersonaActual.equals(linea.split(";")[0])){
            nombrePersonaActual = linea.split(";")[0];
            per++;
         }
            
      }

      // Genero el arreglo de nombres
      nombresPersona = new String[per];

      // tercero, cada vez que cambia el nombrem, lo guardo y avanzo en el arreglo
      nombresPersona[0] = listaPronosticos.pronosticos.get(0).split(";")[0];
      per = 1;
      for(String linea : listaPronosticos.pronosticos){
         if(!nombresPersona[per-1].equals(linea.split(";")[0])){
            nombresPersona[per] = linea.split(";")[0];
            per++;
         }
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
