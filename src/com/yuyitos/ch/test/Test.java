/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.test;

import com.yuyitos.ch.bo.IngresarFichaClienteBO;
import com.yuyitos.ch.entity.Cliente;

/**
 *
 * @author tavo-
 */
public class Test {
    IngresarFichaClienteBO ifcbo = new IngresarFichaClienteBO();
    Cliente cli = new Cliente();
    String mensaje = "";
    
    
    public void insertar(){
//        cli.setNombreCliente("walter");
//        cli.setDireccionCliente("pasaje #7 12830 la pintana");
//        cli.setRutCliente(20379209);
//        cli.setDVCliente('1');
//        cli.setTelefonoCliente(934813738);
//        cli.setFiadosCodFiado(1);
        
        cli.setNombreCliente("fabian lopez");
        cli.setDireccionCliente("pasaje #9 13430 el castillo ");
        cli.setRutCliente(20549252);
        cli.setDVCliente('3'); //me salio un error ora-12899 value too large, esto pasó porque el metodo ingresar ficha cliente estaba en int
        cli.setTelefonoCliente(943287664);
        cli.setFiadosCodFiado(2);
        mensaje = ifcbo.agregarFichaCliente(cli);
        System.out.println(mensaje);
    }
    public void modificar(){
//        cli.setNombreCliente("walter");
//        cli.setDireccionCliente("pasaje #7 12830 la pintana");
//        cli.setRutCliente(20379209);
//        cli.setDVCliente('1');
//        cli.setTelefonoCliente(934813738);
//        cli.setFiadosCodFiado(1);

        cli.setIdCliente(10);
        cli.setNombreCliente("JOSE PINTO");
        cli.setDireccionCliente("calle los pajaritos 123 ");
        cli.setRutCliente(20143252);
        cli.setDVCliente('2'); 
        cli.setTelefonoCliente(984826664);
        cli.setFiadosCodFiado(3);
        mensaje = ifcbo.ModificarFichaCliente(cli);
        System.out.println(mensaje);
       
    }
    
    public void eliminar(){
        mensaje = ifcbo.EliminarFichaCliente(11);
        System.out.println(mensaje);
    }
    public static void main (String[] args){
        Test test = new Test();
        //test.insertar();
        //test.modificar();
        //test.eliminar();
    }
}
