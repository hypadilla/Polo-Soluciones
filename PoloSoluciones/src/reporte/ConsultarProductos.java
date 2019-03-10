/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.sun.javafx.font.FontFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Entidades.Productos;
import src.FileManager;

/**
 *
 * @author hypadilla
 */
public class ConsultarProductos {

    private final String NombreArchivo = "\\Consulta de Productos  " + (new SimpleDateFormat("dd-MM-yyyy")).format(new Date()) + ".pdf";
    private final String path = "C:\\Faro Soluciones Empresariales\\Reportes\\Consulta de productos";

    public void Generar(ArrayList<Productos> productos) {
        try {
            FileManager.Crear(path);
            PdfWriter writer;
            writer = new PdfWriter(path + NombreArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            try (Document document = new Document(pdf, PageSize.A4)) {
                document.setMargins(20, 20, 20, 20);
                Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
                table.setWidth(UnitValue.createPercentValue(100));
                //document.add(new Paragraph("Hello World!"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ConsultarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
