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
public class Pedido {
    private int CodPedido;
    private String FechaPedido;
    private String FechaEntrega;
    private int DetallePedidoCod;
    private int DetallePedido;
    private int IdProveedor;

    public Pedido() {
    }

    public Pedido(int CodPedido, String FechaPedido, String FechaEntrega, int DetallePedidoCod, int DetallePedido, int IdProveedor) {
        this.CodPedido = CodPedido;
        this.FechaPedido = FechaPedido;
        this.FechaEntrega = FechaEntrega;
        this.DetallePedidoCod = DetallePedidoCod;
        this.DetallePedido = DetallePedido;
        this.IdProveedor = IdProveedor;
    }

    public int getCodPedido() {
        return CodPedido;
    }

    public void setCodPedido(int CodPedido) {
        this.CodPedido = CodPedido;
    }

    public String getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(String FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public int getDetallePedidoCod() {
        return DetallePedidoCod;
    }

    public void setDetallePedidoCod(int DetallePedidoCod) {
        this.DetallePedidoCod = DetallePedidoCod;
    }

    public int getDetallePedido() {
        return DetallePedido;
    }

    public void setDetallePedido(int DetallePedido) {
        this.DetallePedido = DetallePedido;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    @Override
    public String toString() {
        return "Pedido{" + "CodPedido=" + CodPedido + ", FechaPedido=" + FechaPedido + ", FechaEntrega=" + FechaEntrega + ", DetallePedidoCod=" + DetallePedidoCod + ", DetallePedido=" + DetallePedido + ", IdProveedor=" + IdProveedor + '}';
    }
    
    
}
