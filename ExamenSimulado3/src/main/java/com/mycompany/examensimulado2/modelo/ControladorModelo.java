package com.mycompany.examensimulado2.modelo;

import com.mycompany.examensimulado2.persistencia.ControladorPersistencia;
import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public class ControladorModelo {

    ControladorPersistencia controlPersis = new ControladorPersistencia();

    public void crearComprobante(Comprobante comprobante) {
        controlPersis.crearComprobante(comprobante);
    }

    public void crearProveedor(Proveedor proveedor) {
        controlPersis.crearProveedor(proveedor);
    }

    public void crearRecibo(Recibo recibo) {
        controlPersis.crearRecibo(recibo);
    }

    public void crearFecha(Fecha fecha) {
        controlPersis.crearFecha(fecha);
    }

    public Comprobante traerComprobante(int id) {
        return controlPersis.traerComprobante(id);
    }

    public Proveedor traerProveedor(int id) {
        return controlPersis.traerProveedor(id);
    }
    
    public Recibo traerRecibo(int id){
        return controlPersis.traerRecibo(id);
    }
    
    public Fecha traerFecha(int id){
        return controlPersis.traerFecha(id);
    }
    
    public ArrayList<Comprobante> listaComprobante(){
        return controlPersis.listaComprobante();
    }
    
    public ArrayList<Proveedor> listaProveedor(){
        return controlPersis.listaProveedor();
    }
    
    public ArrayList<Recibo> listaRecibo(){
        return controlPersis.listaRecibo();
    }
    
    public ArrayList<Fecha> listaFecha(){
        return controlPersis.listaFecha();
    }
    
    public boolean ValidaDato(String a){
        if (a.isEmpty() || a.isBlank()) {
            return false;
        } else {
            return true;
        }
    }
}
