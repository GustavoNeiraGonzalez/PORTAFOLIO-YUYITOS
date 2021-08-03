/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author tavo-
 */
public class Conexion 
{
        private static Connection conn = null; /*static para que no sean llamados por otro paquete*/
        private static String login = "yuyitos21"; /*nombre de usuario que se conecta a sqldeveloper*/
        private static String clave = "asdfg";    /*contraseña*/
        private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        public static Connection getConnection(){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url,login,clave); /* url login y clave para utilizar la conexion de base de datos */
                conn.setAutoCommit(false);
                if (conn != null){ /*si los datos son correctos saltara el print*/
                    System.out.println("Conexion Exitosa.");
                }else{
                    System.out.println("Conexion Erronea. ");
                }
            } catch (ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, "Conexion erronea "+ e.getMessage()); //e.getmessage para indicar el error en el print
            }
            return conn;
        }
        public void desconexion(){
            try{
                conn.close();
            } catch (Exception e){
                System.out.println("Error al desconectar "+ e.getMessage()); /*e.getmessage para indicar el error en el print*/ 
            }
        }
        public static void main(String[] args){
            Conexion c = new Conexion();
            c.getConnection();
            
        }
            
}
