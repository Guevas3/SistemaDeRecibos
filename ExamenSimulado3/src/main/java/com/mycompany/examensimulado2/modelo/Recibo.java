/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examensimulado2.modelo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


/**
 *
 * @author Desarrollo
 */
@Entity
public class Recibo extends Comprobante{
    
    
    
    @Basic
    private float total;
    private String detalle;
    
    @OneToOne
    private Proveedor proveedor;

    public Recibo() {
    }


    public Recibo(float total, String detalle, Proveedor proveedor, int idComprobante, String tipo, int numero, Fecha fecha) {
        super(idComprobante, tipo, numero, fecha);
        this.total = total;
        this.detalle = detalle;
        this.proveedor = proveedor;
    } 

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
