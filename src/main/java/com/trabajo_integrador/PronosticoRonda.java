package com.trabajo_integrador;

public class PronosticoRonda {
   public int nroRonda;
   //public int nroPartidos;
   public String[] equipo1;
   public String[] equipo2;
   public Resultado[] resultado1;
   public Resultado[] resultado2;

   public PronosticoRonda(int nroRonda, int nroPartidos, InterfacePronosticos interfacePronosticos){
      this.nroRonda = nroRonda;
      //this.nroPartidos = nroPartidos;
      equipo1 = new String[nroPartidos];
      equipo2 = new String[nroPartidos];
      resultado1 = new Resultado[nroPartidos];
      resultado2 = new Resultado[nroPartidos];

      cargarPronosticos(interfacePronosticos);
   }

   private void cargarPronosticos(InterfacePronosticos interfacePronosticos){
      int filaInicial = (nroRonda-1)*interfacePronosticos.partidos;
      int filaFinal = filaInicial+interfacePronosticos.partidos;
      for(int p = filaInicial; p<=filaFinal; p++){
         //interfacePronosticos.pronosticos.get(p)[0]; //nombrePersona
         equipo1[p-filaInicial] = interfacePronosticos.pronosticos.get(p)[1]; //equipo1
         resultado1[p-filaInicial] = Resultado.valueOf(interfacePronosticos.pronosticos.get(p)[2]); //resultado1
         resultado2[p-filaInicial] = Resultado.valueOf(interfacePronosticos.pronosticos.get(p)[3]); //resultado2
         equipo2[p-filaInicial] = interfacePronosticos.pronosticos.get(p)[4]; //equipo2
      }
   }

   public Resultado resultadoEquipo(int partido,String equipo){
      if(equipo1[partido] == equipo)
         return resultado1[partido];
      else if(equipo2[partido] == equipo)
         return resultado2[partido];
      else 
         return Resultado.error;
   }

   public int puntajeRonda(Ronda ronda){
      int puntos = 0;
      for(int p=0; p<ronda.nroPartidos; p++){
         if(ronda.resultado(p, equipo1[p]) == resultado1[p])
            puntos++;
      }

      return puntos;
   }
}
