package src;
public class Partido {
   public Equipo equipo1;
   public Equipo equipo2;
   public int golesEquipo1;
   public int golesEquipo2;

   public Resultado resultado(Equipo equipo){
      //Compara los goles de cada equipo y devuelve para el equipo solicitado si es ganador, perdedor o empate.
      return Resultado.ganador;
   }
}
