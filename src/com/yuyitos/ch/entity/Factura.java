/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuyitos.ch.entity;

/**
 *
 * @author tavo-
 */
public class Factura {
    private int ProductoIdProducto;
    private int ProductoCodProducto;
    private int PedidoCodPedido;
    private int PedidoDetallePedidoCod;
    private int ProductoCodProducto1;

    public Factura() {
    }

    public Factura(int ProductoIdProducto, int ProductoCodProducto, int PedidoCodPedido, int PedidoDetallePedidoCod, int ProductoCodProducto1) {
        this.ProductoIdProducto = ProductoIdProducto;
        this.ProductoCodProducto = ProductoCodProducto;
        this.PedidoCodPedido = PedidoCodPedido;
        this.PedidoDetallePedidoCod = PedidoDetallePedidoCod;
        this.ProductoCodProducto1 = ProductoCodProducto1;
    }

    public int getProductoIdProducto() {
        return ProductoIdProducto;
    }

    public void setProductoIdProducto(int ProductoIdProducto) {
        this.ProductoIdProducto = ProductoIdProducto;
    }

    public int getProductoCodProducto() {
        return ProductoCodProducto;
    }

    public void setProductoCodProducto(int ProductoCodProducto) {
        this.ProductoCodProducto = ProductoCodProducto;
    }

    public int getPedidoCodPedido() {
        return PedidoCodPedido;
    }

    public void setPedidoCodPedido(int PedidoCodPedido) {
        this.PedidoCodPedido = PedidoCodPedido;
    }

    public int getPedidoDetallePedidoCod() {
        return PedidoDetallePedidoCod;
    }

    public void setPedidoDetallePedidoCod(int PedidoDetallePedidoCod) {
        this.PedidoDetallePedidoCod = PedidoDetallePedidoCod;
    }

    public int getProductoCodProducto1() {
        return ProductoCodProducto1;
    }

    public void setProductoCodProducto1(int ProductoCodProducto1) {
        this.ProductoCodProducto1 = ProductoCodProducto1;
    }

    @Override
    public String toString() {
        return "Factura{" + "ProductoIdProducto=" + ProductoIdProducto + ", ProductoCodProducto=" + ProductoCodProducto + ", PedidoCodPedido=" + PedidoCodPedido + ", PedidoDetallePedidoCod=" + PedidoDetallePedidoCod + ", ProductoCodProducto1=" + ProductoCodProducto1 + '}';
    }
    
    
}
