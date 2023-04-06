package com.trabajo_integrador;

/*import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;*/

public class Ronda {
   public int nroRonda;
   public int nroPartidos;
   public Partido[] partido;

   public Ronda(int nroRonda, InterfaceResultados resultados){
      this.nroRonda = nroRonda;
      nroPartidos = resultados.partidos;
      partido = new Partido[nroPartidos];

      int p = 0;
      for(String[] partidoDeResultado: resultados.rondaPartido){
         if(nroRonda == Integer.parseInt(partidoDeResultado[0])){
            partido[p] = new Partido(partidoDeResultado);
            p++;
         }
      }

      // Abre el archivo resultados.csv y obtiene todas las lineas
      // la cantidad de lineas es la cantidad de partidos
      // Segun el numero de partidos, genera el arreglo partidos y pasa la info de cada partido
      /*
      nroPartidos = misFunciones.contarPartidos(archivoResultados);
      partido = new Partido[nroPartidos];
      int i = 0;
      try {
         for (String linea : Files.readAllLines(Paths.get(archivoResultados)))
            if (!linea.trim().isEmpty()){
               partido[i]= new Partido(linea.split(";"));
               //Recibe de resultado algo como: partido[0]=["Argentina","2","1","Arabia Saudita"]
               i++;
            }
      } catch (IOException e) {
         System.err.println("Error al leer el archivo: " + e.getMessage());
      } catch (ArrayIndexOutOfBoundsException e) {
         System.err.println("Error: " + e.getMessage());
         System.err.println("i es: "+ i);
      }*/
   }

   public Resultado resultado(int partido, String equipo) {
      /*
       * Dado un nroPartido y un nombreEquipo, devuelve el resultado para ese equipo en ese partido, dentro de la ronda.
       */
      return this.partido[partido].resultado(equipo);
   }
}
