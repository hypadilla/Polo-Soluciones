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
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.kernel.colors.DeviceRgb;
import static com.itextpdf.kernel.pdf.PdfName.DeviceRGB;
import com.itextpdf.layout.property.UnitValue;
import controlador.ControladorReporteProductos;
import java.util.ArrayList;

import static javafx.scene.text.Font.font;
import modelo.Conexion;
import modelo.Entidades.Productos;
import src.Constantes;

/**
 *
 * @author cdap_
 */
public class ReporteProductos {
    int i=1;
    public static final String DEST = "C:\\reporteProductos.pdf";
    
    ControladorReporteProductos controlador= new ControladorReporteProductos();
    
    String QuerySQL = "Select Codigo, Referencia, Descripcion, CostoNeto, VentaNeto, CostoIva, VentaUtilidad, Cantidad from " +Constantes.TABLAPRODUCTOS;
    public void crearPdf(String dest) throws IOException, SQLException{
        PdfWriter   writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
        
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        document.setTextAlignment(TextAlignment.JUSTIFIED).setFont(font);
        
        Table table = new Table(8);
        table.setBorder(Border.NO_BORDER);
        table.setWidth(UnitValue.createPercentValue(100));  
            
            
            DeviceRgb color = new DeviceRgb(211, 211, 211);
        
            Cell cell2;
            Paragraph p2;
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("Codigo");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("Referencia");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("Descripcion");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("CostoNeto");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("VentaNeto");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);          
            p2 = new Paragraph();
            p2.add("CostoIva");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("VentaUtilidad");
            cell2.add(p2);
            table.addCell(cell2);
            
            cell2 = new Cell();
            cell2.setBorder(Border.NO_BORDER).setBackgroundColor(color);            
            p2 = new Paragraph();
            p2.add("Cantidad");
            cell2.add(p2);
            table.addCell(cell2);
        
            
         
         
        ArrayList<Object> productos = controlador.MostrarTodosReportes();
        productos.stream().map((item) -> (Productos) item).forEach((producto) -> {
            DeviceRgb color2;
            if(i%2 ==0){
                color2= new DeviceRgb(211,211,211);
            }else{
                color2= new DeviceRgb(255, 255, 255);
            }
            i=i+1;
            
            Cell cell;
            Paragraph p;
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(producto.getCodigo());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(producto.getReferencia());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph().setBackgroundColor(color2);
            p.add(producto.getDescripcion());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(""+producto.getCostoNeto());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(""+producto.getVentaNeto());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(""+producto.getCostoIva());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(""+producto.getVentaUtilidad());
            cell.add(p);
            table.addCell(cell);
            
            cell = new Cell();
            cell.setBorder(Border.NO_BORDER).setBackgroundColor(color2);            
            p = new Paragraph();
            p.add(""+producto.getCantidad());
            cell.add(p);
            table.addCell(cell);
        });
        
        document.add(table.setBorder(Border.NO_BORDER));
        document.close();
        
    }
    
}
