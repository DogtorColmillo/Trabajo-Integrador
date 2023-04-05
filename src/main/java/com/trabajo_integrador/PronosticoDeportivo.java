package com.trabajo_integrador;
class PronosticoDeportivo {
   public static void main(String[] args) {
      Ronda ronda = new Ronda("csv/resultados.csv");
      Pronostico pronostico = new Pronostico("csv/pronostico.csv");

      /*System.out.println("Datos en ronda:");
      System.out.println("Cantidad de partidos: "+ronda.cantidadPartidos);
      for(int i=0; i<ronda.cantidadPartidos; i++){
         System.out.println("Partido: " + ronda.partido[i].equipo1.nombre + "- "+ ronda.partido[i].golesEquipo1 +" vs " + ronda.partido[i].equipo2.nombre + "- "+ ronda.partido[i].golesEquipo2);
      }

      System.out.println();

      System.out.println("Pronostico");
      for(int i=0; i<pronostico.cantidadPronosticos; i++){
         System.out.println(pronostico.nombrePersona + " aposto que " + pronostico.equipo1[i].nombre + " " +pronostico.resultado1[i]);
      }*/

      //Ver los puntos
      int puntos=0;
      for(int i=0; i<ronda.nroPartidos;i++){
         //si ronda.resultado(1,1) == pronostico.resultado(), entonces puntos++
         if(ronda.resultado(i, 1)==pronostico.resultadoEquipo1(i)){
            puntos++;
         }
      }

      System.out.println("El puntaje de "+pronostico.nombrePersona+" es "+puntos);

      Word docWord = new Word();
      docWord.crear("El puntaje de "+pronostico.nombrePersona+" es "+puntos);
   }
}