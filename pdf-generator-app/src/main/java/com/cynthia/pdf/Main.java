package com.cynthia.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    private static final String inputPath = "/home/cynthiah/workspace/pdf-generator/pdf-generator-app/src/main/resources/text.txt";
    private static final String outputPath = "/home/cynthiah/workspace/pdf-generator/pdf-generator-app/src/main/resources/pdftext.pdf";

    public static void main(String[] args) {

        System.out.println("main is running");
//        StringBuilder textToPdf = new StringBuilder("Weather" + "\n");

        Document doc = new Document();
        Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
        try {
            Scanner scanner = new Scanner(new File(inputPath));
            PdfWriter.getInstance(doc, new FileOutputStream(outputPath));

            while (scanner.hasNext()) {
                Paragraph paragraph = new Paragraph(scanner.nextLine(), font);
                doc.open();
                doc.add(paragraph);
                doc.add(Chunk.NEWLINE);
            }

            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
