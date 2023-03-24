package src;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Pronostico {
   public String nombrePersona;
   public int cantidadPronosticos;
   public Equipo[] equipo;
   public Resultado[] resultado;

   public Pronostico(){
      nombrePersona = "";
      cantidadPronosticos = misFunciones.contarPartidos("src/csv/resultados.csv");
      equipo = new Equipo[cantidadPronosticos];
      resultado = new Resultado[cantidadPronosticos];
      int i = 0;
      //Abre el archivo pronostico.csv y leo las lineas
      try{
         for(String linea: Files.readAllLines(Paths.get("src/csv/pronostico.csv"))){
            String [] datos = linea.split(";");
            if(nombrePersona.length()<1){
               nombrePersona = datos[0];
            }
            equipo[i]=new Equipo(datos[1], "");
            resultado[i] = Resultado.valueOf(datos[2]);
            i++;
         }
      } catch (IOException e){
         System.err.println("Error al leer el archivo: " + e.getMessage());
      }
   }

   public int puntos(){
      // Deberia comparar los pronosticos con los resultados, y por cada hacierto +1, y devolver el resultado
      return 0;
   }
}
