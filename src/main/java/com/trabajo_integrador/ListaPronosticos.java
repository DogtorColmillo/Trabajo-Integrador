package com.trabajo_integrador;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListaPronosticos {
   List<String> pronosticos;

   public ListaPronosticos(String url, String user, String pass){
      pronosticos = new ArrayList<String>();

      try {
         // Crear conexión a la BD:
         Connection con = DriverManager.getConnection(url,user,pass);
         Statement stmt = con.createStatement();

         // Hacer query:
         String query = "";
         
         //Equivalente a pronosticos.cvs
         query = "SELECT NOMBRE, FASE, RONDA, E1.EQUIPO AS EQUIPO_1, E2.EQUIPO AS EQUIPO_2, GANADOR FROM PRONOSTICOS P JOIN RESULTADOS R on P.ID_RESULTADO = R.ID_RESULTADO JOIN EQUIPOS E1 on R.ID_EQUIPO_1 = E1.ID_EQUIPO JOIN EQUIPOS E2 on R.ID_EQUIPO_2 = E2.ID_EQUIPO";
         ResultSet rs = stmt.executeQuery(query);
         String rondaActual = "";
         int prt = 1;
         while(rs.next()){
            if(!rondaActual.equals(rs.getString(3))){
               rondaActual = rs.getString(3);
               prt=1;
            }

            pronosticos.add(rs.getString(1) + ";" + rs.getString(2)+ ";" + rs.getString(3)+ ";" + prt + ";" + rs.getString(5)+ ";" + rs.getString(6)+ ";" + rs.getString(4));
            prt++;
         }
         
         // Cerrar conexión a la BD:
         con.close();

      } catch (Exception e) {
         System.out.println("Ocurrio un problema al conectarse a la BD.");
         System.out.println("Error: " + e.toString());
      }
   }
}
