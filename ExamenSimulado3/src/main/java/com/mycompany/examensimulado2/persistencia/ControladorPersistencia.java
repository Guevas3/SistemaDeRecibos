

package com.mycompany.examensimulado2.persistencia;

import com.mycompany.examensimulado2.modelo.Comprobante;
import com.mycompany.examensimulado2.modelo.Fecha;
import com.mycompany.examensimulado2.modelo.Proveedor;
import com.mycompany.examensimulado2.modelo.Recibo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauro
 */
public class ControladorPersistencia {

    ComprobanteJpaController comprobanteJPA = new ComprobanteJpaController();
    ProveedorJpaController proveedorJPA = new ProveedorJpaController();
    ReciboJpaController reciboJPA = new ReciboJpaController();
    FechaJpaController fechaJPA = new FechaJpaController();

    public void crearComprobante(Comprobante comprobante) {
        comprobanteJPA.create(comprobante);
    }

    public void crearProveedor(Proveedor proveedor) {
        proveedorJPA.create(proveedor);
    }

    public Comprobante traerComprobante(int id) {
        return comprobanteJPA.findComprobante(id);
    }

    public Proveedor traerProveedor(int id) {
        return proveedorJPA.findProveedor(id);
    }

    public void crearRecibo(Recibo recibo) {
        reciboJPA.create(recibo);
    }

    public void crearFecha(Fecha fecha) {
        fechaJPA.create(fecha);
    }

    public Recibo traerRecibo(int id) {
        return reciboJPA.findRecibo(id);
    }

    public Fecha traerFecha(int id) {
        return fechaJPA.findFecha(id);
    }

    public ArrayList<Comprobante> listaComprobante() {
        List<Comprobante> lista = comprobanteJPA.findComprobanteEntities();
        ArrayList<Comprobante> listaComprobante = new ArrayList<Comprobante>(lista);
        return listaComprobante;
    }

    public ArrayList<Proveedor> listaProveedor() {
        List<Proveedor> lista = proveedorJPA.findProveedorEntities();
        ArrayList<Proveedor> listaProveedor = new ArrayList<Proveedor>(lista);
        return listaProveedor;
    }

    public ArrayList<Recibo> listaRecibo() {
        List<Recibo> lista = reciboJPA.findReciboEntities();
        ArrayList<Recibo> listaRecibo = new ArrayList<Recibo>(lista);
        return listaRecibo;
    }

    public ArrayList<Fecha> listaFecha() {
        List<Fecha> lista = fechaJPA.findFechaEntities();
        ArrayList<Fecha> listaFecha = new ArrayList<Fecha>(lista);
        return listaFecha;
    }
}
