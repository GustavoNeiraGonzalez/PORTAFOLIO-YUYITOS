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
public class Cliente {
    private int IdCliente;
    private String NombreCliente;
    private int TelefonoCliente;
    private String DireccionCliente;
    private int RutCliente;
    private char DVCliente;
    private int FiadosCodFiado;

    public Cliente() {
    }

    public Cliente(int IdCliente, String NombreCliente, int TelefonoCliente, String DireccionCliente, int RutCliente, char DVCliente, int FiadosCodFiado) {
        this.IdCliente = IdCliente;
        this.NombreCliente = NombreCliente;
        this.TelefonoCliente = TelefonoCliente;
        this.DireccionCliente = DireccionCliente;
        this.RutCliente = RutCliente;
        this.DVCliente = DVCliente;
        this.FiadosCodFiado = FiadosCodFiado;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public int getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(int TelefonoCliente) {
        this.TelefonoCliente = TelefonoCliente;
    }

    public String getDireccionCliente() {
        return DireccionCliente;
    }

    public void setDireccionCliente(String DireccionCliente) {
        this.DireccionCliente = DireccionCliente;
    }

    public int getRutCliente() {
        return RutCliente;
    }

    public void setRutCliente(int RutCliente) {
        this.RutCliente = RutCliente;
    }

    public char getDVCliente() {
        return DVCliente;
    }

    public void setDVCliente(char DVCliente) {
        this.DVCliente = DVCliente;
    }

    public int getFiadosCodFiado() {
        return FiadosCodFiado;
    }

    public void setFiadosCodFiado(int FiadosCodFiado) {
        this.FiadosCodFiado = FiadosCodFiado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "IdCliente=" + IdCliente + ", NombreCliente=" + NombreCliente + ", TelefonoCliente=" + TelefonoCliente + ", DireccionCliente=" + DireccionCliente + ", RutCliente=" + RutCliente + ", DVCliente=" + DVCliente + ", FiadosCodFiado=" + FiadosCodFiado + '}';
    }
    
    
    
}
