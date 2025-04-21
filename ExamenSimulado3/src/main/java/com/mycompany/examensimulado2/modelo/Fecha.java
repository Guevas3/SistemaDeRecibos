
package com.mycompany.examensimulado2.modelo;
//import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author Desarrollo
 */

@Entity
public class Fecha implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFecha;
    
    @Basic
    Date fecha;
    

    public Fecha() {
    }

    public Fecha(int idFecha, Date fecha) {
        this.idFecha = idFecha;
        this.fecha = fecha;
    }

    public int getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(int idFecha) {
        this.idFecha = idFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
