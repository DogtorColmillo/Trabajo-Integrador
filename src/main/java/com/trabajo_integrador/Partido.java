package com.trabajo_integrador;

public class Partido {
   public String equipo1;
   public String equipo2;
   public int golesEquipo1;
   public int golesEquipo2;

   public Partido (String equipo1, int golesEquipo1, int golesEquipo2, String equipo2){
      this.equipo1 = equipo1;
      this.equipo2 = equipo2;
      this.golesEquipo1 = golesEquipo1;
      this.golesEquipo2 = golesEquipo2;
   }

   public Resultado resultado(String equipo){
      if(equipo.equals(equipo1)){
         if(golesEquipo1>golesEquipo2)
            return Resultado.valueOf("ganador");
         else if(golesEquipo1==golesEquipo2)
            return Resultado.valueOf("empate");
         else
            return Resultado.valueOf("perdedor");
      }else{
         if(golesEquipo2>golesEquipo1)
            return Resultado.valueOf("ganador");
         else if(golesEquipo2==golesEquipo1)
            return Resultado.valueOf("empate");
         else
            return Resultado.valueOf("perdedor");
      }
   }
}
