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
    private int PrecioVentaProducto;
    private String DescripcionProducto;
    private int TipoProducto;
    private int FechaElabProducto;
    private int FechaVencProduct;
    private int StockProducto;
    private int StockCriticoProducto;

    public Producto() {
    }

    public Producto(int IdProducto, int CodProducto, int PrecioVentaProducto, String DescripcionProducto, int TipoProducto, int FechaElabProducto, int FechaVencProduct, int StockProducto, int StockCriticoProducto) {
        this.IdProducto = IdProducto;
        this.CodProducto = CodProducto;
        this.PrecioVentaProducto = PrecioVentaProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.TipoProducto = TipoProducto;
        this.FechaElabProducto = FechaElabProducto;
        this.FechaVencProduct = FechaVencProduct;
        this.StockProducto = StockProducto;
        this.StockCriticoProducto = StockCriticoProducto;
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

    public int getPrecioVentaProducto() {
        return PrecioVentaProducto;
    }

    public void setPrecioVentaProducto(int PrecioVentaProducto) {
        this.PrecioVentaProducto = PrecioVentaProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public int getTipoProducto() {
        return TipoProducto;
    }

    public void setTipoProducto(int TipoProducto) {
        this.TipoProducto = TipoProducto;
    }

    public int getFechaElabProducto() {
        return FechaElabProducto;
    }

    public void setFechaElabProducto(int FechaElabProducto) {
        this.FechaElabProducto = FechaElabProducto;
    }

    public int getFechaVencProduct() {
        return FechaVencProduct;
    }

    public void setFechaVencProduct(int FechaVencProduct) {
        this.FechaVencProduct = FechaVencProduct;
    }

    public int getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(int StockProducto) {
        this.StockProducto = StockProducto;
    }

    public int getStockCriticoProducto() {
        return StockCriticoProducto;
    }

    public void setStockCriticoProducto(int StockCriticoProducto) {
        this.StockCriticoProducto = StockCriticoProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "IdProducto=" + IdProducto + ", CodProducto=" + CodProducto + ", PrecioVentaProducto=" + PrecioVentaProducto + ", DescripcionProducto=" + DescripcionProducto + ", TipoProducto=" + TipoProducto + ", FechaElabProducto=" + FechaElabProducto + ", FechaVencProduct=" + FechaVencProduct + ", StockProducto=" + StockProducto + ", StockCriticoProducto=" + StockCriticoProducto + '}';
    }
    
    
}
