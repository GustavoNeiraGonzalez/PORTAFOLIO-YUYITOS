/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.test;


import com.yuyitos.ch.bo.IngresarFichaProveedorBO;

import com.yuyitos.ch.entity.Proveedor;

/**
 *
 * @author tavo-
 */
public class TestProveedor {
    IngresarFichaProveedorBO ifpbo = new IngresarFichaProveedorBO();
    Proveedor pro = new Proveedor();
    String mensaje = "";
    
    
    public void insertar(){
//        cli.setNombreCliente("walter");
//        cli.setDireccionCliente("pasaje #7 12830 la pintana");
//        cli.setRutCliente(20379209);
//        cli.setDVCliente('1');
//        cli.setTelefonoCliente(934813738);
//        cli.setFiadosCodFiado(1);

        pro.setNombreProveedor("fabian lopez");                                                              
        pro.setRutProveedor(20549252);                                                                                                                                                                                                                                                            
        pro.setDVProveedor('3');
        pro.setDetallePedidoCod(20549252);//al parecer detallepedidocod es clave foranea foreign key por lo que no se puede hacer esto
        
        
        mensaje = ifpbo.agregarFichaProveedor(pro);
        System.out.println(mensaje);
    }
//    public void modificar(){
////        cli.setNombreCliente("walter");
////        cli.setDireccionCliente("pasaje #7 12830 la pintana");
////        cli.setRutCliente(20379209);
////        cli.setDVCliente('1');
////        cli.setTelefonoCliente(934813738);
////        cli.setFiadosCodFiado(1);
//
//        cli.setIdCliente(10);
//        cli.setNombreCliente("JOSE PINTO");
//        cli.setDireccionCliente("calle los pajaritos 123 ");
//        cli.setRutCliente(20143252);
//        cli.setDVCliente('2'); 
//        cli.setTelefonoCliente(984826664);
//        cli.setFiadosCodFiado(3);
//        mensaje = ifcbo.ModificarFichaCliente(cli);
//        System.out.println(mensaje);
//       
//    }
//    
//    public void eliminar(){
//        mensaje = ifpbo.EliminarFichaCliente(11);
//        System.out.println(mensaje);
//    }
    public static void main (String[] args){
        TestProveedor test = new TestProveedor();
        test.insertar();
        //test.modificar();
        //test.eliminar();
    }
}
