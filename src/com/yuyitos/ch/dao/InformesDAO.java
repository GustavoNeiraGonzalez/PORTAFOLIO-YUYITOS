/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.dao;

import com.yuyitos.ch.db.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tavo-
 */
public class InformesDAO {
    Conexion cn = new Conexion();
    Connection con;
    
    PreparedStatement pst;
    PreparedStatement pst2;
    
         public void PDFFiadosTotales(){
                try {
            String sql ="select concat(cli.nombre,' ',cli.apaterno,' ',cli.amaterno), fi.monto, bol.fecha from fiado as fi inner join cliente as cli on cli.fiado_idfiado=fi.idfiado inner join venta as ven on ven.idventa=fi.idventa \n" +
"inner join boleta as bol on ven.numboleta=bol.numboleta where fi.monto>0 order by bol.fecha";
            con=cn.getConnection();
            
                String nombre = "";
                String monto = "";  
                String fecha = "";
                
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
            ResultSet rs1 = pst.executeQuery();
            PDDocument documento = new PDDocument ();
            PDPage pagina = new PDPage(PDRectangle.A6);//nueva pagina a6 igual tipo de pagina
            
            documento.addPage(pagina);
            PDPageContentStream contenido=new PDPageContentStream(documento,pagina);
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
           
                contenido.showText("Los Yuyitos ");
                contenido.endText();
                
                contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            
            contenido.newLineAtOffset(200, pagina.getMediaBox().getHeight()-52);
         
                contenido.showText("Lista de fiados");
                contenido.endText();
                int i=10;//10 serian para el salto de linea, el cual seria un salto de linea ideal para que este abajo de numboleta 
                while(rs1.next()){
                    
                    contenido.beginText();        
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-(104+i));
                    i=i+10;//para que por cada producto comprado exista un pequeño salto de linea idoneo
                    nombre=(rs1.getString(1));
                    monto=(rs1.getString(2));
                    fecha=(rs1.getString(3));
                    contenido.showText("| Nombre del deudor "+nombre+" | monto: "+monto+" | Fecha de fiado: "+fecha);
                    contenido.endText();
                }

            contenido.close();
            documento.save("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
            
            JOptionPane.showMessageDialog(null, "pdf creado");
            try {
                    File path = new File ("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
                    Desktop.getDesktop().open(path);
               }catch (IOException ex) {
                    ex.printStackTrace();
               }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error pdf"+e);
        }
     }
         
        public void PDFVentaBoletaMes(){
                try {
            String sql ="select prod.descripcion,sum(det.cantidad),sum(bol.total) from producto as prod inner join detalleboleta as det on det.producto=prod.codproducto inner join boleta as bol on bol.numboleta=det.numboleta\n" +
"where bol.total>0 and month(fecha)=month(current_date()) group by prod.descripcion order by sum(bol.total)desc, sum(det.cantidad) desc ";
            con=cn.getConnection();
            
                String descripcion = "";
                String cantidad = "";  
                String total = "";
                
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
            ResultSet rs1 = pst.executeQuery();
            PDDocument documento = new PDDocument ();
            PDPage pagina = new PDPage(PDRectangle.A6);//nueva pagina a6 igual tipo de pagina
            
            documento.addPage(pagina);
            PDPageContentStream contenido=new PDPageContentStream(documento,pagina);
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
           
                contenido.showText("Los Yuyitos ");
                contenido.endText();
                
                contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            
            contenido.newLineAtOffset(150, pagina.getMediaBox().getHeight()-52);
         
                contenido.showText("Lista de ventas ultimo mes");
                contenido.endText();
                int i=10;//10 serian para el salto de linea, el cual seria un salto de linea ideal para que este abajo de numboleta 
                while(rs1.next()){
                    
                    contenido.beginText();        
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-(104+i));
                    i=i+10;//para que por cada producto comprado exista un pequeño salto de linea idoneo
                    descripcion=(rs1.getString(1));
                    cantidad=(rs1.getString(2));
                    total=(rs1.getString(3));
                    contenido.showText("| Nombre producto "+descripcion+" | Cantidad vendida: "+cantidad+" | Total: "+total);
                    contenido.endText();
                }

            contenido.close();
            documento.save("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
            
            JOptionPane.showMessageDialog(null, "pdf creado");
            try {
                    File path = new File ("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
                    Desktop.getDesktop().open(path);
               }catch (IOException ex) {
                    ex.printStackTrace();
               }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error pdf"+e);
        }
     }
        
                public void PDFProveedores(){
                try {
            String sql ="select nombre, rut, rubro, direccion, telefono, email from empresa order by nombre";
            con=cn.getConnection();
            
                String nombre = "";
                String rut = "";  
                String rubro = "";
                String direccion = "";
                String telefono = "";
                String email = "";
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
            ResultSet rs1 = pst.executeQuery();
            PDDocument documento = new PDDocument ();
            PDPage pagina = new PDPage(PDRectangle.A6);//nueva pagina a6 igual tipo de pagina
            
            documento.addPage(pagina);
            
            PDPageContentStream contenido=new PDPageContentStream(documento,pagina);
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
           
                contenido.showText("Los Yuyitos ");
                contenido.endText();
                
                contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            
            contenido.newLineAtOffset(170, pagina.getMediaBox().getHeight()-52);
         
                contenido.showText("Lista de Proveedores");
                contenido.endText();
                int i=10;//10 serian para el salto de linea, el cual seria un salto de linea ideal para que este abajo de numboleta 
                while(rs1.next()){

                    contenido.beginText();        
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-(104+i));
                    i=i+10;//para que por cada producto comprado exista un pequeño salto de linea idoneo
                    nombre=(rs1.getString(1));
                    rut=(rs1.getString(2));
                    rubro=(rs1.getString(3));
                    direccion=(rs1.getString(4));
                    telefono=(rs1.getString(5));
                    email=(rs1.getString(6));
                    contenido.showText("| Nombre proveedor "+nombre+" | Rut: "+rut+" | rubro: "+rubro);
                    contenido.endText();
                    
                    contenido.beginText();        
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-(104+i));
                    i=i+10;//para que por cada producto comprado exista un pequeño salto de linea idoneo
                    contenido.showText("| direccion: "+direccion+" | telefono: "+telefono+" | email: "+email);
                    contenido.endText();
                    i=i+15;//esto sumado al pequeño cambio de linea hará que exista un espacio mas grande entre cada informacion proveedor
                }
                
            contenido.close();
            documento.save("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
            
            JOptionPane.showMessageDialog(null, "pdf creado");
            try {
                    File path = new File ("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
                    Desktop.getDesktop().open(path);
               }catch (IOException ex) {
                    ex.printStackTrace();
               }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error pdf"+e);
        }
     }
                
                
       public void PDFEmpleados(){
                try {
            String sql ="select concat(nombre,' ',apaterno,' ',amaterno), rut, direccion, telefono, concat(fechacontrato,' - ',fechatermino),cargo,sueldo from empleado order by apaterno ";
            con=cn.getConnection();
            
                String nombre= "";
                String rut = "";  
                String direccion = "";
                String telefono = "";
                String fecha = "";
                String cargo = "";
                String sueldo = "";
                
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
            ResultSet rs1 = pst.executeQuery();
            PDDocument documento = new PDDocument ();
            PDPage pagina = new PDPage(PDRectangle.A6);//nueva pagina a6 igual tipo de pagina
            
            documento.addPage(pagina);
            PDPageContentStream contenido=new PDPageContentStream(documento,pagina);
            
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
           
                contenido.showText("Los Yuyitos ");
                contenido.endText();
                
                contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            
            contenido.newLineAtOffset(180, pagina.getMediaBox().getHeight()-52);
         
                contenido.showText("Lista de Empleados");
                contenido.endText();
                int i=10;//10 serian para el salto de linea, el cual seria un salto de linea ideal para que este abajo de numboleta 
                while(rs1.next()){

                    contenido.beginText();        
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-(104+i));
                    i=i+10;//para que por cada producto comprado exista un pequeño salto de linea idoneo
                    nombre=(rs1.getString(1));
                    rut=(rs1.getString(2));
                    direccion=(rs1.getString(3));
                    telefono=(rs1.getString(4));
                    fecha=(rs1.getString(5));
                    cargo=(rs1.getString(6));
                    sueldo=(rs1.getString(7));
                    
                    contenido.showText("| Nombre: "+nombre+" | rut: "+rut+" | dirección: "+direccion+" | sueldo: "+sueldo);
                    contenido.endText();
                    
                    
                    
                    contenido.beginText();        
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-(104+i));
                    i=i+10;//para que por cada producto comprado exista un pequeño salto de linea idoneo
                    contenido.showText("| telefono: "+telefono+" | fecha: "+fecha+" | cargo: "+cargo);
                    contenido.endText();
                    i=i+15;//esto sumado al pequeño cambio de linea hará que exista un espacio mas grande entre cada informacion proveedor
                    
                }

            contenido.close();
            documento.save("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
            
            JOptionPane.showMessageDialog(null, "pdf creado");
            try {
                    File path = new File ("C:\\Users\\tavo-\\OneDrive\\Escritorio\\portafolio\\pdfprueba pdf.pdf");
                    Desktop.getDesktop().open(path);
               }catch (IOException ex) {
                    ex.printStackTrace();
               }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error pdf"+e);
        }
     }
              
   public void GraficoVentas(){
        
        
        String sql2 = "select prod.descripcion,sum(bol.total) from producto as prod inner join detalleboleta as det on det.producto=prod.codproducto inner join boleta as bol on bol.numboleta=det.numboleta\n" +
    "where bol.total>0 and month(fecha)=month(current_date()) group by prod.descripcion order by sum(bol.total)desc, sum(det.cantidad) desc ";

        try {
            con=cn.getConnection();
            
             pst2 = con.prepareStatement(sql2);

            //---------------hacer factura--------------------
            String nombre="";
            ResultSet rs1 = pst2.executeQuery();
            DefaultCategoryDataset ds=new DefaultCategoryDataset();
            while(rs1.next()){
                int cantidad=Integer.parseInt(rs1.getString(2));
                nombre=rs1.getString(1);
                   ds.addValue(cantidad,nombre,Integer.toString(cantidad)+" "+nombre);// uno es el valor para la tabla int , dos es el nombre que saldra abajo string , tres es el string nombre que saldra justo abajo de cada dato
                }

            JFreeChart jf=ChartFactory.createBarChart3D("Ventas (Mes actual)","Productos","Ventas total $",ds,PlotOrientation.VERTICAL, true, true, true);//1 es el titulo del grafico,
            //2 seria el nombre en horizontal (-) y 3 seria el nombre en vertical (|) 4 es donde se guardo los datos en este caso ds. 5 la posicion de la tabla, lo demas no se xD
            ChartFrame f=new ChartFrame("ventas",jf);//cantidad de usuario seriá el nombre del panel que se desplegará
            f.setSize(1000,600);//tamaño
            f.setLocationRelativeTo(null);//
            f.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(e.toString());
            }
   }
            
           
}