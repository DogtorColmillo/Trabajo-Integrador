package src;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Ronda {
   public String numero;
   public Partido[] partido;
   public int cantidadPartidos;

   public Ronda(String archivoResultados){
      // Abre el archivo resultados.csv y obtiene todas las lineas
      // la cantidad de lineas es la cantidad de partidos
      // Segun el numero de partidos, genera el arreglo partidos y pasa la info de cada partido
      numero = "1";
      cantidadPartidos = misFunciones.contarPartidos(archivoResultados);
      partido = new Partido[cantidadPartidos];
      int i = 0;
      try {
         for (String linea : Files.readAllLines(Paths.get("src/csv/resultados.csv")))
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
      }
   }

   public Resultado resultado(int partido, int equipo) {
      return this.partido[partido].resultado(equipo);
   }
}
