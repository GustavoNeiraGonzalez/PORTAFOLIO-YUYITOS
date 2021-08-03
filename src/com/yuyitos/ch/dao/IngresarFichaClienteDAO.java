/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.dao;

import com.yuyitos.ch.entity.Cliente;
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
public class IngresarFichaClienteDAO {
    private String mensaje = "";
    
    public String agregarFichaCliente(Connection con , Cliente cli){ // Cliente se refiere a el objeto del paquete entidad(entity) creado anteriormente
        PreparedStatement pst = null;
        String sql = "insert into cliente(id_cliente, nombre_cliente, telefono_cliente, direccion_cliente, rut_cliente, dv_cliente, fiados_cod_fiado)"
                +"values(CLIENTE_SEQ.NEXTVAL,?,?,?,?,?,CODFIADOS_SEQ.NEXTVAL)" ;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cli.getNombreCliente());
            pst.setInt(2, cli.getTelefonoCliente());
            pst.setString(3, cli.getDireccionCliente());
            pst.setInt(4, cli.getRutCliente());
            pst.setString(5, cli.getDVCliente()+"");//para no convertirlo a char, de otra manera setCharacterStream se debe utilizar    
            
            mensaje = "Guardado correctamente.";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se pudo guardar correctamente: "+e.getMessage();
        }
        
        return mensaje;
    }   
    public String ModificarFichaCliente(Connection con , Cliente cli){
        PreparedStatement pst = null;
        String sql = "Update cliente set nombre_cliente = ?, telefono_cliente = ?, direccion_cliente = ?, rut_cliente = ?, dv_cliente = ?, fiados_cod_fiado = ?"
                    + "where id_cliente= ?";
        
        try {
            
            pst = con.prepareStatement(sql);
            
            pst.setString(1, cli.getNombreCliente());
            pst.setInt(2, cli.getTelefonoCliente());
            pst.setString(3, cli.getDireccionCliente());
            pst.setInt(4, cli.getRutCliente());
            pst.setString(5, cli.getDVCliente()+"");
            pst.setInt(6, cli.getFiadosCodFiado());
            pst.setInt(7, cli.getIdCliente());
            mensaje = "Modificado correctamente.";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se pudo Modificar correctamente: "+e.getMessage();
        }
        return mensaje;
    }
    public String EliminarFichaCliente(Connection con , int IdCliente){
        PreparedStatement pst = null;
        String sql = "delete from cliente where id_cliente = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, IdCliente);
           
            mensaje = "Eliminado correctamente.";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se pudo Eliminar correctamente: "+e.getMessage();
        }
        return mensaje;
    }
    public void ListarFichaCliente(Connection con, JTable tabla){ //crear metodo de lista
        
        DefaultTableModel model; //llamamos al objeto de nuestra tabla
        String [] columnas = {"ID","nombres","telefono","direccion","rut","DVRut","fiadosCODFiado"};//agregamos parametros a la columna
        model = new DefaultTableModel(null, columnas);//se los agragamos a la tabla 
        
        String sql = "select * from cliente order by id_cliente"; //el select que hará la consulta de datos
        
        String [] filas = new String [7];//creamos las filas
        Statement st = null;// statement ejecuta la query
        ResultSet rs = null;// obtendrá los resultados del sql
        
        try {
            st = con.createStatement();//se crea el select
            rs = st.executeQuery(sql);//obtiene el resultado del select
            while (rs.next()) {           // aqui hará un recorrido del select     
                for (int i = 0; i < 7; i++) { //aqui con el for se limita el recorrido a la cantidad de filas (7)
                    filas[i] = rs.getString(i+1);//se guardará el resultado del rs en el dato filas
                }
                model.addRow(filas);//addrow significa agregar filas
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla ");
        }
    }
    
}
