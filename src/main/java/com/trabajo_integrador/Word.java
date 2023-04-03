package com.trabajo_integrador;

import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Word {
   private XWPFDocument documento = new XWPFDocument();
   public void crear(String texto){
      try {
         FileOutputStream output = new FileOutputStream("resultados de pronosticos.docx");
         documento.write(output);
         output.close();
      } catch (Exception e) {
         // TODO: handle exception
         System.err.println(e.getMessage());
      }
   }
}
