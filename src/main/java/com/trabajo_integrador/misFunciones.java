package com.trabajo_integrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class misFunciones {
   public static int contarPartidos(String pathArchivo) {
      int conta = 0;
      try {
         for (String linea : Files.readAllLines(Paths.get(pathArchivo)))
            if (!linea.trim().isEmpty())
               conta++;
      } catch (IOException e) {
         System.err.println("Error al leer el archivo: " + e.getMessage());
         conta = -1;
      }
      return conta;
   }
}
