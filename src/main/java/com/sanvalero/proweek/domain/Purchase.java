package com.sanvalero.proweek.domain;

/**
 * UN ALQUILER
 */
public class Purchase {
    
    private int id_purchase;
    private String fecha_inicio;
    private int id_casa;
    private int id_usuario;
   
    public Purchase(int id_purchase, String fecha_inicio, int id_casa, int id_usuario) {
        this.id_purchase = id_purchase;
        this.fecha_inicio = fecha_inicio;
        this.id_casa = id_casa;
        this.id_usuario = id_usuario;
    }

    public Purchase(String fecha_inicio, int id_casa, int id_usuario) {
        this.fecha_inicio = fecha_inicio;
        this.id_casa = id_casa;
        this.id_usuario = id_usuario;;
    }

    public int getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(int id_purchase) {
        this.id_purchase = id_purchase;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
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