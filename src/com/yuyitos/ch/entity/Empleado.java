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
public class Empleado {
    private int IdEmpleado;
    private String CargoEmpleado;
    private String NombreEmpleado;
    private int TelefonoEmpleado;
    private String DireccionEmpleado;
    private String RutEmpleado;
    private String DvEmpleado;
    private String FechaContrato;
    private String FechaTerminoContrato;

    public Empleado() {
    }

    public Empleado(int IdEmpleado, String CargoEmpleado, String NombreEmpleado, int TelefonoEmpleado, String DireccionEmpleado, String RutEmpleado, String DvEmpleado, String FechaContrato, String FechaTerminoContrato) {
        this.IdEmpleado = IdEmpleado;
        this.CargoEmpleado = CargoEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.TelefonoEmpleado = TelefonoEmpleado;
        this.DireccionEmpleado = DireccionEmpleado;
        this.RutEmpleado = RutEmpleado;
        this.DvEmpleado = DvEmpleado;
        this.FechaContrato = FechaContrato;
        this.FechaTerminoContrato = FechaTerminoContrato;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getCargoEmpleado() {
        return CargoEmpleado;
    }

    public void setCargoEmpleado(String CargoEmpleado) {
        this.CargoEmpleado = CargoEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public int getTelefonoEmpleado() {
        return TelefonoEmpleado;
    }

    public void setTelefonoEmpleado(int TelefonoEmpleado) {
        this.TelefonoEmpleado = TelefonoEmpleado;
    }

    public String getDireccionEmpleado() {
        return DireccionEmpleado;
    }

    public void setDireccionEmpleado(String DireccionEmpleado) {
        this.DireccionEmpleado = DireccionEmpleado;
    }

    public String getRutEmpleado() {
        return RutEmpleado;
    }

    public void setRutEmpleado(String RutEmpleado) {
        this.RutEmpleado = RutEmpleado;
    }

    public String getDvEmpleado() {
        return DvEmpleado;
    }

    public void setDvEmpleado(String DvEmpleado) {
        this.DvEmpleado = DvEmpleado;
    }

    public String getFechaContrato() {
        return FechaContrato;
    }

    public void setFechaContrato(String FechaContrato) {
        this.FechaContrato = FechaContrato;
    }

    public String getFechaTerminoContrato() {
        return FechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String FechaTerminoContrato) {
        this.FechaTerminoContrato = FechaTerminoContrato;
    }

    @Override
    public String toString() {
        return "Empleado{" + "IdEmpleado=" + IdEmpleado + ", CargoEmpleado=" + CargoEmpleado + ", NombreEmpleado=" + NombreEmpleado + ", TelefonoEmpleado=" + TelefonoEmpleado + ", DireccionEmpleado=" + DireccionEmpleado + ", RutEmpleado=" + RutEmpleado + ", DvEmpleado=" + DvEmpleado + ", FechaContrato=" + FechaContrato + ", FechaTerminoContrato=" + FechaTerminoContrato + '}';
    }
    
    
}
