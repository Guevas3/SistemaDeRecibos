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
public class Proveedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Basic
    private String razonSocial;

    public Proveedor() {
    }

    public Proveedor(int codigo, String razonSocial) {
        this.codigo = codigo;
        this.razonSocial = razonSocial;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
}
