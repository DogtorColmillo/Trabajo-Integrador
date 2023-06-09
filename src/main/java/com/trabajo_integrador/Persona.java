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
               pronostico[prn].fase = parte[1];
               pronostico[prn].ronda = parte[2];
               pronostico[prn].partido = Integer.parseInt(parte[3]);
               pronostico[prn].equipo = parte[4];
               if(parte[5].equals("1"))
                  pronostico[prn].resultado = Resultado.valueOf("ganador");
               else if(parte[5].equals("2"))
                  pronostico[prn].resultado = Resultado.valueOf("perdedor");
               else
                  pronostico[prn].resultado = Resultado.valueOf("empate");
               prn++;
            }
         }

      } catch (IOException e) {
         System.err.println("Error con el archivo: " + pathArchivo + ". Exception: " + e.toString());
      }
   }

   public Persona(String nombre,ListaPronosticos listaPronostico){
      this.nombre = nombre;
      int prn = 0;
      for (String linea : listaPronostico.pronosticos){
         String[] parte = linea.split(";");
         if(nombre.equals(parte[0]))
            prn++;
      }

      pronostico = new Pronostico[prn];
      for(prn = 0; prn<pronostico.length; prn++)
         pronostico[prn]=new Pronostico();

      prn = 0;
      for (String linea : listaPronostico.pronosticos){
         String[] parte = linea.split(";");
         if(nombre.equals(parte[0])){
            pronostico[prn].fase = parte[1];
            pronostico[prn].ronda = parte[2];
            pronostico[prn].partido = Integer.parseInt(parte[3]);
            pronostico[prn].equipo = parte[4];
            if(parte[5].equals("1"))
               pronostico[prn].resultado = Resultado.valueOf("ganador");
            else if(parte[5].equals("2"))
               pronostico[prn].resultado = Resultado.valueOf("perdedor");
            else
               pronostico[prn].resultado = Resultado.valueOf("empate");
            prn++;
         }
      }
   }

   public int puntos(Fase[] fase){
      // TODO
      // ronda.length = 12
      // Hay 8 rondas de 6 partidos, 1 de 8, 1 de 4 y 2 de 2, total 64 partidos
      // pronostico.length = 64
      // Deria: Ciclar por los pronosticos, rondas y partidos,
      // empieza en 0,0,0 y avanza 1 en todos
      // pronostico no reinicia, pero si cambia ronda, reinicia partido

      int totalPuntos = 0;
      int puntosFaseIniciales = 0;
      int puntosRondaIniciales = 0;
      int prn = 0, fs = 0, rnd = 0, prt = 0;
      try{
         /* for(int rnd = 0; rnd<ronda.length; rnd++){
            for(int pr = 0; pr<pronostico.length; pr++){
               if(pronostico[pr].resultado == ronda[rnd].partido[pr].resultado(pronostico[pr].equipo))
                  totalPuntos++;
            }
         } */
         
         for(prn = 0; prn<pronostico.length; prn++){
            for(fs = 0; fs<fase.length;fs++){
               puntosFaseIniciales = totalPuntos;
               for(rnd = 0; rnd<fase[fs].ronda.length; rnd++){
                  puntosRondaIniciales = totalPuntos;
                  for(prt = 0; (prt<fase[fs].ronda[rnd].partido.length)&&(prn<pronostico.length); prt++,prn++)
                     if(pronostico[prn].resultado == fase[fs].ronda[rnd].partido[prt].resultado(pronostico[prn].equipo))
                        totalPuntos++;
                  
                  //Puntos extra por ronda, si acerto a todos los partidos
                  if(totalPuntos - puntosRondaIniciales == prt)
                     totalPuntos++;
               }
               if(totalPuntos-puntosFaseIniciales == fs)
                  totalPuntos++;
            }
         }

      }catch(Exception e){
         System.out.println("Error al comparar los pronosticos con los resultado. Error: " + e.toString());
         System.out.println("Es posible que el numero de pronosticos no coincida con el número de partidos por ronda");
         System.out.println("catch linea 76 en Persona.java - " + prn + "," + fs + "," + rnd + "," + prt);
      }
      return totalPuntos;
   }
}
