package com.trabajo_integrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSQL {
   public static void main(String[] args) {
      testSQL();
   }

   public static void testSQL(){
      try {
         // Crear conexión a la BD:
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10612293", 
            "sql10612293", "ACwUKDKvbY");
         Statement stmt = con.createStatement();

         // Hacer query:
         String query = "";
         //query = "SHOW TABLES"; // EQUIPOS, PRONOSTICOS, RESULTADOS
         //query = "SHOW COLUMNS FROM EQUIPOS"; //ID_EQUIPO, EQUIPO
         //query = "SELECT EQUIPO FROM EQUIPOS"; // Nombres de equipos
         //query = "SHOW COLUMNS FROM PRONOSTICOS"; // ID_PRONOSTICO, NOMBRE, ID_RESULTADO, GANADOR
         //query = "SELECT ID_PRONOSTICO, NOMBRE, ID_RESULTADO, GANADOR FROM PRONOSTICOS";
         //query = "SHOW COLUMNS FROM RESULTADOS"; // ID_RESULTADO, FASE, RONDA, ID_EQUIPO_1, ID_EQUIPO_2, GOLES_1, GOLES_2
         //Equivalente a resultados.cvs con fase
         //query = "SELECT FASE, RONDA, E1.EQUIPO AS EQUIPO_1, E2.EQUIPO AS EQUIPO_2, GOLES_1, GOLES_2 FROM RESULTADOS R JOIN EQUIPOS E1 on R.ID_EQUIPO_1 = E1.ID_EQUIPO JOIN EQUIPOS E2 on R.ID_EQUIPO_2 = E2.ID_EQUIPO";
         /*ResultSet rs = stmt.executeQuery(query);
         String rondaActual = "";
         int prt = 1;
         while(rs.next()){
            if(!rondaActual.equals(rs.getString(2))){
               rondaActual = rs.getString(2);
               prt=1;
            }
            System.out.println(rs.getString(1) + ";" + rs.getString(2)+ ";" + prt + ";" + rs.getString(3)+ ";" + rs.getString(5)+ ";" + rs.getString(6)+ ";" + rs.getString(4));
            prt++;
         } */
         //Equivalente a resultados.cvs sin fase
         query = "SELECT RONDA, E1.EQUIPO AS EQUIPO_1, E2.EQUIPO AS EQUIPO_2, GOLES_1, GOLES_2 FROM RESULTADOS R JOIN EQUIPOS E1 on R.ID_EQUIPO_1 = E1.ID_EQUIPO JOIN EQUIPOS E2 on R.ID_EQUIPO_2 = E2.ID_EQUIPO";
         ResultSet rs = stmt.executeQuery(query);
         String rondaActual = "";
         int prt = 1;
         while(rs.next()){
            if(!rondaActual.equals(rs.getString(1))){
               rondaActual = rs.getString(1);
               prt=1;
            }
            System.out.println(rs.getString(1) + ";" + prt + ";" + rs.getString(2)+ ";" + rs.getString(4)+ ";" + rs.getString(5)+ ";" + rs.getString(3));
            prt++;
         }
         //Equivalente a pronosticos.cvs
        //query = "SELECT NOMBRE, FASE, RONDA, E1.EQUIPO AS EQUIPO_1, E2.EQUIPO AS EQUIPO_2, GANADOR FROM PRONOSTICOS P JOIN RESULTADOS R on P.ID_RESULTADO = R.ID_RESULTADO JOIN EQUIPOS E1 on R.ID_EQUIPO_1 = E1.ID_EQUIPO JOIN EQUIPOS E2 on R.ID_EQUIPO_2 = E2.ID_EQUIPO";
         /* ResultSet rs = stmt.executeQuery(query);
         String rondaActual = "";
         int prt = 1;
         while(rs.next()){
            if(!rondaActual.equals(rs.getString(3))){
               rondaActual = rs.getString(3);
               prt=1;
            }

            System.out.println(rs.getString(1) + ";" + rs.getString(2)+ ";" + rs.getString(3)+ ";" + prt + ";" + rs.getString(5)+ ";" + rs.getString(6)+ ";" + rs.getString(4));
            prt++;
         } */
         // Cerrar conexión a la BD:
         con.close();

      } catch (Exception e) {
         System.out.println("Ocurrio un problema al conectarse a la BD.");
         System.out.println("Error: " + e.toString());
      }
   }
}
