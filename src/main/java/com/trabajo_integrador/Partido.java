package com.trabajo_integrador;
public class Partido {
   public String equipo1;
   public String equipo2;
   public int golesEquipo1;
   public int golesEquipo2;

   public Partido(String [] datos){
      //Recibe de resultado algo como: partido[0]=["Argentina","2","1","Arabia Saudita"]
      equipo1 = datos[1];
      golesEquipo1 = Integer.parseInt(datos[2]);
      golesEquipo2 = Integer.parseInt(datos[3]);
      equipo2 = datos[4];
   }

   public Resultado resultado(String equipo){
      //Compara los goles de cada equipo y devuelve para el equipo solicitado si es ganador, perdedor o empate.
      if(equipo == equipo1)
         if (golesEquipo1 - golesEquipo2 > 0)
            return Resultado.ganador;
         else if (golesEquipo1 - golesEquipo2 < 0)
            return Resultado.perdedor;
         else return Resultado.empate;
      else if(equipo == equipo2)
         if (golesEquipo2 - golesEquipo1 < 0)
            return Resultado.ganador;
         else if (golesEquipo2 - golesEquipo1 > 0)
            return Resultado.perdedor;
         else return Resultado.empate;
      else return Resultado.error;
   }
}
