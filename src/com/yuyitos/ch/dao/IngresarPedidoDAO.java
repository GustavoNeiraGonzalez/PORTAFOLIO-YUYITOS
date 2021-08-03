/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.dao;

import com.yuyitos.ch.db.Conexion;
import com.yuyitos.ch.entity.Detalle;
import com.yuyitos.ch.entity.Discrepancias;
import com.yuyitos.ch.entity.Factura;
import com.yuyitos.ch.entity.Repartidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tavo-
 */
public class IngresarPedidoDAO {
    private String mensaje = "";
    
    Conexion cn = new Conexion();
    Connection con;
    
    PreparedStatement pst;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;
    PreparedStatement pst5;
    PreparedStatement pst6;
    ResultSet rs;
    
    public boolean agregarfactura(){
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String sql2 = "insert into factura(fecha,costo,iva,total)"
                        +"values(?,?,?,?)";

        try {
            con=cn.getConnection();
            
             pst2 = con.prepareStatement(sql2);

            //---------------hacer factura--------------------

            
            pst2.setString(1, dtf.format(LocalDateTime.now()));
            pst2.setInt(2, 0);
            pst2.setInt(3, 0);
            pst2.setInt(4, 0);
            pst2.executeUpdate();
            pst2.close();

            
            
            
            
           
            
            return true;
        }catch(Exception e){
            
           JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(e.toString());
            System.out.println("incorrecto factura");
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    public boolean agregardetallefactura(Detalle det){
        String sql = "insert into detallefactura(numfactura,producto,cantidad,precio)"
                +"values(?,?,?,?)" ;
        try {
            con = cn.getConnection();
                        //-----------------select num factura------------------------
            String sql5="select max(numfactura) from factura";
                
                pst5 = con.prepareStatement(sql5);
                 pst = con.prepareStatement(sql);//recordar hacer esto antes de cualquier pst.setint o similar porque da nullpointer exception
               
                ResultSet rs1 = pst5.executeQuery();
               
                if (rs1.next()){
                    pst.setInt(1,Integer.parseInt(rs1.getString(1)));
                }
                
                
            
          
            //agregar info a tabla detalle-------         
            pst.setInt(2, det.getProducto());
            pst.setInt(3, det.getCantidad());
            pst.setInt(4, det.getPrecio());
            pst.executeUpdate();
            
            
          
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
             System.out.println("incorrecto detalle");
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean agregarRepartidor(Repartidor rep){
        String sql = "insert into repartidor(nombre,apaterno,rut,dv,idEmpresa)"
                +"values(?,?,?,?,?)" ;
        try {
            con = cn.getConnection();
                        //-----------------select num factura------------------------
           
                 pst = con.prepareStatement(sql);//recordar hacer esto antes de cualquier pst.setint o similar porque da nullpointer exception

            //agregar info a tabla repartidor------- 
            pst.setString(1, rep.getNombre());
            pst.setString(2, rep.getApellidoPaterno());
            pst.setInt(3, rep.getRut());
            pst.setString(4, rep.getDv()+"");
            pst.setInt(5, rep.getIdEmpresa());
            pst.executeUpdate();
            
            
           
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
             System.out.println("incorrecto repartidor");
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean agregarDiscrepancia(Discrepancias disc){
        String sql = "insert into discrepancia(numfactura,cantidad,precio,informacionadicional)"
                +"values(?,?,?,?)" ;
        try {
            con = cn.getConnection();
                        //-----------------select num factura------------------------
           
                 pst = con.prepareStatement(sql);//recordar hacer esto antes de cualquier pst.setint o similar porque da nullpointer exception

            //agregar info a tabla repartidor------- 
            pst.setInt(1, disc.getNumfactura());
            pst.setInt(2, disc.getCantidad());
            pst.setInt(3, disc.getPrecio());
            pst.setString(4, disc.getInformacionAdicional());
            pst.executeUpdate();
            
            
           JOptionPane.showMessageDialog(null, "Discrepancia guardada con exito.");
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
             System.out.println("incorrecto discrepancia");
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean agregarpedido(JComboBox cb){
        
        
       
            String sql4="insert into pedido (idempleado,idrepartidor,numfactura)"
                    + "values(?,?,?)";
            String sql5="select max(idrepartidor) from repartidor";

        try {
            con=cn.getConnection();
            
            PreparedStatement pst5;
            pst5 = con.prepareStatement(sql5);
            
            
            ResultSet rs1 = pst5.executeQuery();
           pst2 = con.prepareStatement(sql4);
            if (rs1.next()){
                    pst2.setInt(2,Integer.parseInt(rs1.getString(1)));
                     
            }                
            pst2.setInt(1, 3);
            pst2.setInt(3, Integer.parseInt((String)cb.getSelectedItem()));
            pst2.executeUpdate();
            pst2.close();
            

          JOptionPane.showMessageDialog(null,"Pedido guardado con exito");
            return true;
        }catch(Exception e){
            
           JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(e.toString());
            System.out.println("incorrecto pedido");
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        
    }
    
    public void ListarProductosPedido(Connection con, JTable tabla,Factura fact){ //crear metodo de lista

        DefaultTableModel model; //llamamos al objeto de nuestra tabla
        String [] columnas = {"Nombre Empresa","Rut","Id Detalle","Descripción","Cantidad","precio"};//agregamos parametros a la columna
        model = new DefaultTableModel(null, columnas);//se los agragamos a la tabla 
        
        String sql = "select  emp.nombre, concat(emp.rut,' ',emp.dv), det.iddetalle,prod.descripcion, det.cantidad, det.precio from producto as prod\n" +
"        inner join detallefactura as det\n" +
"        	on prod.codproducto=det.producto\n" +
"        inner join empresa as emp\n" +
"	on emp.idempresa=prod.idempresa\n" +
"		inner join factura as fac\n" +
"	on det.numfactura=fac.numFactura\n" +
"where det.numfactura=?"; 

        
        String [] filas = new String [6];//creamos las filas
        PreparedStatement st = null;// statement ejecuta la query
        ResultSet rs = null;// obtendrá los resultados del sql
        
        try {
            con = cn.getConnection();
            
            st = con.prepareStatement(sql);//se crea el select
            System.out.println(fact.getNumFactura()+"");
            st.setInt(1, fact.getNumFactura());
            rs = st.executeQuery();//obtiene el resultado del select
            while (rs.next()) {           // aqui hará un recorrido del select     
                for (int i = 0; i < 6; i++) { //aqui con el for se limita el recorrido a la cantidad de filas (6)
                    filas[i] = rs.getString(i+1);//se guardará el resultado del rs en el dato filas
                }
                model.addRow(filas);//addrow significa agregar filas
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla: "+e.toString());
            System.out.println("tabla pedio "+e.toString());
        }
    }
    
    public boolean ListarProductosEmpresaPedidoCBO(JComboBox cb,JComboBox cb2){
        try {
                String sql="select prod.descripcion from producto as prod\n" +
                        "	inner join empresa as emp \n" +
                        "on prod.idempresa=emp.idempresa\n" +
                        "where emp.nombre=? order by prod.descripcion";
//                        "select concat(producto.descripcion) from producto left join familia on producto.familia = familia.idfamilia\n" +
//                               "union\n" +
//                               "select concat(producto.descripcion) from producto right join familia on producto.familia = familia.idfamilia;";
                con=cn.getConnection();
                PreparedStatement pst;
                 pst = con.prepareStatement(sql);  
                ResultSet rs;
                
                pst.setString(1, (String)cb2.getSelectedItem());
                rs = pst.executeQuery();
                
                
                //cb.addItem("");//para dejar un espacio en blanco en el combo box
               
                cb.removeAllItems();//para dejar vacio en caso de que la empresa no tenga productos
               
                while(rs.next()){
                cb.addItem(rs.getString(1));//aqui se agregará todos los productos asociados según la empresa que elegiste en el combobox

                }
               
                   
                
                
                
                return true;
                
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                    return false;
                }
                
        }
    
        public String NombreEmpresaImprimir(JComboBox cb){
       
        try {
            con=cn.getConnection();
            String sql5="select idempresa from empresa where nombre=? order by nombre";
            PreparedStatement pst5;
            pst5 = con.prepareStatement(sql5);
             pst5.setString(1, (String)cb.getSelectedItem());
            
            ResultSet rs1 = pst5.executeQuery();
            String resultado="";
            if (rs1.next()){
                    resultado=(rs1.getString(1));
                     
            }
                return resultado;
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            return "";
        }
    }
    
        public boolean EliminarDetallePedido(Detalle det){
        String sql = "Delete from detallefactura where iddetalle = ?";
        try {
            con=cn.getConnection();
            
            
                 pst= con.prepareStatement(sql);
               
              
              
                    pst.setInt(1,det.getIdDetalle());
              
           
            
            pst.execute();
            pst.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString() );
            }
        }
    }
        
    public boolean ModificarFactura(Factura fact ){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sql = "update factura set fecha=?,costo=?,iva=?,total=? "
                + "where numfactura=?";
        try {
            con=cn.getConnection();
            pst= con.prepareStatement(sql);
            int iva=fact.getTotal()*19/100;
            int costo=fact.getTotal()-iva;
            
            pst.setString(1, dtf.format(LocalDateTime.now()));
            pst.setInt(2, costo);
            pst.setInt(3, iva);
            pst.setInt(4, fact.getTotal());
            pst.setInt(5, fact.getNumFactura());
            pst.execute();
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
      
    }
    public int NumFacturaImprimir(){
       
        try {
            con=cn.getConnection();
            String sql5="select max(numfactura) from factura";
            PreparedStatement pst5;
            pst5 = con.prepareStatement(sql5);
           
            
            ResultSet rs1 = pst5.executeQuery();
            int numfactura=0;
            if (rs1.next()){
                    numfactura=Integer.parseInt(rs1.getString(1));
                     
            }
                return numfactura;
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            return 0;
        }
    }
    
    public void ListarProductosPedido2(Connection con, JTable tabla,JComboBox cb){ //crear metodo de lista

        DefaultTableModel model; //llamamos al objeto de nuestra tabla
        String [] columnas = {"NumFactura","Nombre Empresa","Rut","Id Detalle","Descripción","Cantidad","precio Productos","Suma valor Total"};//agregamos parametros a la columna
        model = new DefaultTableModel(null, columnas);//se los agragamos a la tabla 
        
        String sql = "select  det.numfactura,emp.nombre, concat(emp.rut,' ',emp.dv), det.iddetalle, prod.descripcion, det.cantidad, det.precio, fac.total from producto as prod\n" +
"        inner join detallefactura as det\n" +
"        	on prod.codproducto=det.producto\n" +
"        inner join empresa as emp\n" +
"	on emp.idempresa=prod.idempresa\n" +
"		inner join factura as fac\n" +
"	on det.numfactura=fac.numFactura\n" +
"    where det.numfactura=?"; 

        
        String [] filas = new String [8];//creamos las filas
        PreparedStatement st = null;// statement ejecuta la query
        ResultSet rs = null;// obtendrá los resultados del sql
        
        try {
            con = cn.getConnection();
            
            st = con.prepareStatement(sql);//se crea el select
            
             st.setString(1, (String)cb.getSelectedItem());
            rs = st.executeQuery();//obtiene el resultado del select
            while (rs.next()) {           // aqui hará un recorrido del select     
                for (int i = 0; i < 8; i++) { //aqui con el for se limita el recorrido a la cantidad de filas (6)
                    filas[i] = rs.getString(i+1);//se guardará el resultado del rs en el dato filas
                }
                model.addRow(filas);//addrow significa agregar filas
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla: "+e.toString());
            System.out.println("tabla pedio "+e.toString());
        }
    }
    
    public boolean ActualizarStock(JComboBox cb ){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sql = "update   inventario as inv inner join empleado as emp on inv.idempleado=emp.idEmpleado \n" +
"inner join producto as prod on prod.codproducto=inv.producto_codproducto inner join pedido as ped on ped.idempleado=emp.idempleado\n" +
"inner join factura as fact on ped.numfactura=fact.numfactura inner join detallefactura as detf on detf.numfactura=fact.numfactura\n" +
"set stock=stock+detf.cantidad where fact.numfactura=? ";
        try {
            con=cn.getConnection();
            pst= con.prepareStatement(sql);
            
            pst.setInt(1,  Integer.parseInt((String)cb.getSelectedItem()));
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Stock modificado con exito");
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
      
    }
    
    public boolean ActualizarValorIncrementFactura( ){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sql = "alter table factura auto_increment=? ";
        String sql2="select max(numfactura) from factura";
        try {
            con=cn.getConnection();
            pst= con.prepareStatement(sql);
            pst2=con.prepareStatement(sql2);
            rs = pst2.executeQuery();//obtiene el resultado del select
            if (rs.next()) {           // aqui hará un recorrido del select     
                 //aqui con el for se limita el recorrido a la cantidad de filas (6)
                    pst.setInt(1, Integer.parseInt(rs.getString(1)));//se guardará el resultado del rs en el dato filas
                }
           
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Stock modificado con exito");
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
      
    }
}
