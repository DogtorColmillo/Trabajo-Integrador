package com.trabajo_integrador;

import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Word {
   private XWPFDocument documento = new XWPFDocument();
   public void crear(String texto){
      try {
         FileOutputStream output = new FileOutputStream("resultados de pronosticos.docx");

         XWPFParagraph parrafo = documento.createParagraph();
         XWPFRun run = parrafo.createRun();

         run.setText(texto);

         documento.write(output);
         output.close();
      } catch (Exception e) {
         // TODO: handle exception
         System.err.println(e.getMessage());
      }
   }
}
