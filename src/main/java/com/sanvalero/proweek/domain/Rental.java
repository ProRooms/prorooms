package com.sanvalero.proweek.domain;

/**
 * UN ALQUILER
 */
public class Rental {
    
    private int id_alquiler;
    private String fecha_inicio;
    private String fecha_fin;
    private int id_casa;
    private int id_usuario;
   
    public Rental(int id_alquiler, String fecha_inicio, String fecha_fin, int id_casa, int id_usuario) {
        this.id_alquiler = id_alquiler;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_usuario = id_usuario;
    }

    public Rental(String fecha_inicio, String fecha_fin, int id_casa, int id_usuario) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_usuario = id_usuario;;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}