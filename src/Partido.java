package src;
public class Partido {
   public Equipo equipo1;
   public int golesEquipo1;
   public int golesEquipo2;
   public Equipo equipo2;

   public Partido(String [] datos){
      //Recibe de resultado algo como: partido[0]=["Argentina","2","1","Arabia Saudita"]
      equipo1 = new Equipo(datos[0],"");
      golesEquipo1 = Integer.parseInt(datos[1]);
      golesEquipo2 = Integer.parseInt(datos[2]);
      equipo2 = new Equipo(datos[3],"");
   }

   public Resultado resultado(Equipo equipo){
      //Compara los goles de cada equipo y devuelve para el equipo solicitado si es ganador, perdedor o empate.
      if(equipo.nombre == equipo1.nombre)
         if (golesEquipo1 - golesEquipo2 > 0)
            return Resultado.ganador;
         else if (golesEquipo1 - golesEquipo2 < 0)
            return Resultado.perdedor;
         else return Resultado.empate;
      else if (golesEquipo2 - golesEquipo1 < 0)
            return Resultado.ganador;
         else if (golesEquipo2 - golesEquipo1 > 0)
            return Resultado.perdedor;
         else return Resultado.empate;
   }
}
