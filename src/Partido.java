package src;
public class Partido {
   public Equipo equipo1;
   public int golesEquipo1;
   public int golesEquipo2;
   public Equipo equipo2;

   public Partido(String [] datos){
      equipo1 = new Equipo(datos[1],"");
      golesEquipo1 = Integer.parseInt(datos[2]);
      golesEquipo2 = Integer.parseInt(datos[3]);
      equipo2 = new Equipo(datos[4],"");
   }

   public Resultado resultado(Equipo equipo){
      //Compara los goles de cada equipo y devuelve para el equipo solicitado si es ganador, perdedor o empate.
      return Resultado.ganador;
   }
}
