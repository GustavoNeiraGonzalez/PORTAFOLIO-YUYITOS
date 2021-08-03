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
    private int RutEmpleado;
    private String FechaInicioContrato;
    private String FechaTerminoContrato;
    private String cargo;
    private int sueldo;

    public Empleado() {
    }

    public Empleado(int RutEmpleado, String FechaInicioContrato, String FechaTerminoContrato, String cargo, int sueldo) {
        this.RutEmpleado = RutEmpleado;
        this.FechaInicioContrato = FechaInicioContrato;
        this.FechaTerminoContrato = FechaTerminoContrato;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public int getRutEmpleado() {
        return RutEmpleado;
    }

    public void setRutEmpleado(int RutEmpleado) {
        this.RutEmpleado = RutEmpleado;
    }

    public String getFechaInicioContrato() {
        return FechaInicioContrato;
    }

    public void setFechaInicioContrato(String FechaInicioContrato) {
        this.FechaInicioContrato = FechaInicioContrato;
    }

    public String getFechaTerminoContrato() {
        return FechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String FechaTerminoContrato) {
        this.FechaTerminoContrato = FechaTerminoContrato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "RutEmpleado=" + RutEmpleado + ", FechaInicioContrato=" + FechaInicioContrato + ", FechaTerminoContrato=" + FechaTerminoContrato + ", cargo=" + cargo + ", sueldo=" + sueldo + '}';
    }
    
    
}
