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
public class Producto {
    private int IdProducto;
    private int CodProducto;
    private String Descripcion;
    private int Stock;
    private int Costo;
    private int Precio;
    private int Tipo;
    private int FechaVencimiento;
    private String FechaElab;
    private int StockC;
    private int CodFTipoProducto;
    private int CodBarra;

    public Producto() {
    }

    public Producto(int IdProducto, int CodProducto, String Descripcion, int Stock, int Costo, int Precio, int Tipo, int FechaVencimiento, String FechaElab, int StockC, int CodFTipoProducto, int CodBarra) {
        this.IdProducto = IdProducto;
        this.CodProducto = CodProducto;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
        this.Costo = Costo;
        this.Precio = Precio;
        this.Tipo = Tipo;
        this.FechaVencimiento = FechaVencimiento;
        this.FechaElab = FechaElab;
        this.StockC = StockC;
        this.CodFTipoProducto = CodFTipoProducto;
        this.CodBarra = CodBarra;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCodProducto() {
        return CodProducto;
    }

    public void setCodProducto(int CodProducto) {
        this.CodProducto = CodProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public int getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(int FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public String getFechaElab() {
        return FechaElab;
    }

    public void setFechaElab(String FechaElab) {
        this.FechaElab = FechaElab;
    }

    public int getStockC() {
        return StockC;
    }

    public void setStockC(int StockC) {
        this.StockC = StockC;
    }

    public int getCodFTipoProducto() {
        return CodFTipoProducto;
    }

    public void setCodFTipoProducto(int CodFTipoProducto) {
        this.CodFTipoProducto = CodFTipoProducto;
    }

    public int getCodBarra() {
        return CodBarra;
    }

    public void setCodBarra(int CodBarra) {
        this.CodBarra = CodBarra;
    }

    @Override
    public String toString() {
        return "Producto{" + "IdProducto=" + IdProducto + ", CodProducto=" + CodProducto + ", Descripcion=" + Descripcion + ", Stock=" + Stock + ", Costo=" + Costo + ", Precio=" + Precio + ", Tipo=" + Tipo + ", FechaVencimiento=" + FechaVencimiento + ", FechaElab=" + FechaElab + ", StockC=" + StockC + ", CodFTipoProducto=" + CodFTipoProducto + ", CodBarra=" + CodBarra + '}';
    }
    
    
}
