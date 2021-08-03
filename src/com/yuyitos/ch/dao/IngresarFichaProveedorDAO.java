/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.dao;


import com.yuyitos.ch.entity.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tavo-
 */
public class IngresarFichaProveedorDAO {
    private String mensaje = "";
    
    public String agregarFichaProveedor(Connection con , Proveedor pro){ // Cliente se refiere a el objeto del paquete entidad(entity) creado anteriormente
        PreparedStatement pst = null;
        String sql = "insert into proveedor(id_proveedor, nombre_proveedor, rut_proveedor, dv_proveedor, DETALLE_PEDIDO_COD)" //se elimino detalle_pedido_cod porque es clave foranea
                +"values(IDPROVEEDOR_SEQ.NEXTVAL,?,?,?)" ;
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, pro.getNombreProveedor());
            pst.setInt(2, pro.getRutProveedor());
            pst.setString(3, pro.getDVProveedor()+"");
            pst.setInt(4, pro.getDetallePedidoCod()); 
           
            
            mensaje = "Guardado correctamente.";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se pudo guardar correctamente: "+e.getMessage();
        }
        
        return mensaje;
    }   
    public String ModificarFichaProveedor(Connection con , Proveedor pro){
        PreparedStatement pst = null;
        String sql = "Update proveedor set NOMBRE_PROVEEDOR = ?, RUT_PROVEEDOR = ?, DV_PROVEEDOR = ?, "
                    + "where ID_PROVEEDOR = ?";
        
        try {
            
            pst = con.prepareStatement(sql);
            
            pst.setString(1, pro.getNombreProveedor());
            pst.setInt(2, pro.getRutProveedor());
            pst.setString(3, pro.getDVProveedor()+"");
            pst.setInt(4, pro.getIdProveedor());
            
            mensaje = "Modificado correctamente.";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se pudo Modificar correctamente: "+e.getMessage();
        }
        return mensaje;
    }
    public String EliminarFichaProveedor(Connection con , int IdProveedor){
        PreparedStatement pst = null;
        String sql = "delete from proveedor where id_proveedor = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, IdProveedor);
           
            mensaje = "Eliminado correctamente.";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se pudo Eliminar correctamente: "+e.getMessage();
        }
        return mensaje;
    }
    
}
