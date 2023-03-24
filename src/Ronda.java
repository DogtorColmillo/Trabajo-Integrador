package src;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Ronda {
   public String numero;
   public Partido[] partido;
   public int cantidadPartidos;

   public Ronda(String numero){
      // Abre el archivo resultados.csv y obtiene todas las lineas
      // la cantidad de lineas es la cantidad de partidos
      // Segun el numero de partidos, genera el arreglo partidos y pasa la info de cada partido
      cantidadPartidos = misFunciones.contarPartidos("src/csv/resultados.csv");
      partido = new Partido[cantidadPartidos];
      int i = 0;
      try {
         for (String linea : Files.readAllLines(Paths.get("src/csv/resultados.csv")))
            if (!linea.trim().isEmpty()){
               partido[i]= new Partido(linea.split(";"));
               i++;
            }
      } catch (IOException e) {
         System.err.println("Error al leer el archivo: " + e.getMessage());
      } catch (ArrayIndexOutOfBoundsException e) {
         System.err.println("Error: " + e.getMessage());
         System.err.println("i es: "+ i);
      }
   }

   public int puntos() {
      // WTF?
      return 0;
   }
}
