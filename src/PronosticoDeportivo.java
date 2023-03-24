package src;
class PronosticoDeportivo {
   public static void main(String[] args) {
      Ronda ronda = new Ronda("Ronda 1");
      Pronostico pronostico = new Pronostico();

      System.out.println("Datos en ronda:");
      System.out.println("Cantidad de partidos: "+ronda.cantidadPartidos);
      for(int i=0; i<ronda.cantidadPartidos; i++){
         System.out.println("Partido: " + ronda.partido[i].equipo1.nombre + "- "+ ronda.partido[i].golesEquipo1 +" vs " + ronda.partido[i].equipo2.nombre + "- "+ ronda.partido[i].golesEquipo2);
      }

      System.out.println();

      System.out.println("Pronostico");
      for(int i=0; i<pronostico.cantidadPronosticos; i++){
         System.out.println(pronostico.nombrePersona + " aposto que " + pronostico.equipo[i].nombre + " " +pronostico.resultado[i]);
      }
   }
}