

package com.mycompany.examensimulado2;

import com.mycompany.examensimulado2.controlador.ControladorVista;
import com.mycompany.examensimulado2.modelo.Comprobante;
import com.mycompany.examensimulado2.modelo.ControladorModelo;
import com.mycompany.examensimulado2.modelo.Fecha;
import com.mycompany.examensimulado2.modelo.Proveedor;
import com.mycompany.examensimulado2.modelo.Recibo;
import com.mycompany.examensimulado2.vista.Vista;

/**
 *
 * @author mauro
 */
public class ExamenSimulado2 {

    public static void main(String[] args) {
       
        ControladorModelo controlModelo = new ControladorModelo();
//        Proveedor p1 = new Proveedor(3, "Sabina");
//        Fecha f1 = new Fecha(3, 14, 5, 2020);
//        Recibo r1 = new Recibo(50003, "Vino", p1, 3, "B", 543, f1);
//        controlModelo.crearProveedor(p1);
//        controlModelo.crearFecha(f1);
//        controlModelo.crearRecibo(r1);
        
        
        Vista vista = new Vista();
        ControladorVista controlVista = new ControladorVista(controlModelo, vista);
        
    }
}
