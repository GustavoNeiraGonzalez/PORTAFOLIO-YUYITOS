/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.test;

import com.yuyitos.ch.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tavo-
 */
public class asd {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement pst2;
        String sql2 = "select ifnull(max(idcliente+1), 1) from cliente";
        con=cn.getConnection();
        try {
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select * from persona");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
    }
}
