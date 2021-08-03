/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.bo;


import com.yuyitos.ch.dao.IngresarFichaProveedorDAO;
import com.yuyitos.ch.db.Conexion;
import com.yuyitos.ch.entity.Proveedor;

import java.sql.Connection;

/**
 *
 * @author tavo-
 */
public class IngresarFichaProveedorBO {
        private String mensaje = "";
    private IngresarFichaProveedorDAO ifpdao = new IngresarFichaProveedorDAO();
    
    public String agregarFichaProveedor(Proveedor pro){ // Proveedor se refiere a el objeto del paquete entidad(entity) creado anteriormente
       Connection conn = Conexion.getConnection();
       try{
           mensaje = ifpdao.agregarFichaProveedor(conn, pro);
           //conn.rollback();//el rollback detiene los errores, por lo que si hay un error en un dato no se guardará en la base de datos
       }catch (Exception e){
           mensaje = mensaje + ""+ e.getMessage();
       }finally{
           try {
               if (conn != null){
                   conn.close();
               }
           } catch (Exception e) {
               mensaje = mensaje + "" + e.getMessage();
           }
       }
       return mensaje;
    }
    public String ModificarFichaProveedor(Proveedor pro){
        Connection conn = Conexion.getConnection();
       try{
           mensaje = ifpdao.ModificarFichaProveedor(conn, pro);
           //conn.rollback();//el rollback detiene los errores, por lo que si hay un error en un dato no se guardará en la base de datos
       }catch (Exception e){
           mensaje = mensaje + ""+ e.getMessage();
       }finally{
           try {
               if (conn != null){
                   conn.close();
               }
           } catch (Exception e) {
               mensaje = mensaje + "" + e.getMessage();
           }
       }
       return mensaje;
    }
    public String EliminarFichaProveedor(int IdProveedor){
        Connection conn = Conexion.getConnection();
       try{
           mensaje = ifpdao.EliminarFichaProveedor(conn, IdProveedor);
           //conn.rollback();//el rollback detiene los errores, por lo que si hay un error en un dato no se guardará en la base de datos
       }catch (Exception e){
           mensaje = mensaje + ""+ e.getMessage();
       }finally{
           try {
               if (conn != null){
                   conn.close();
               }
           } catch (Exception e) {
               mensaje = mensaje + "" + e.getMessage();
           }
       }
       return mensaje;
    }
}
