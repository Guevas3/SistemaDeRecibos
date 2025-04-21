/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examensimulado2.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Desarrollo
 */
@Entity
public class Comprobante implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idComprobante;
    
    @Basic
    private String tipo;
    private int numero;
    
    @OneToOne
    private Fecha fecha;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, String tipo, int numero, Fecha fecha) {
        this.idComprobante = idComprobante;
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    
}
