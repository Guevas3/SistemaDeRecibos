package com.mycompany.examensimulado2.controlador;

import com.mycompany.examensimulado2.modelo.Comprobante;
import com.mycompany.examensimulado2.modelo.ControladorModelo;
import com.mycompany.examensimulado2.modelo.Fecha;
import com.mycompany.examensimulado2.modelo.Proveedor;

import com.mycompany.examensimulado2.modelo.Recibo;
import com.mycompany.examensimulado2.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mauro
 */
public class ControladorVista implements ActionListener {

    private Fecha fecha;
    private Comprobante comprobante;
    private Recibo recibo;
    private Proveedor proveedor;
    private ControladorModelo controlModelo;
    private Vista vista;

    public ControladorVista(ControladorModelo controlModelo, Vista vista) {
        this.controlModelo = controlModelo;
        this.vista = vista;
        this.vista.jButton1.addActionListener(this);
        this.vista.setVisible(true);

        cargarReciboTextField();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (controlModelo.ValidaDato(this.vista.jTipoRecibo.getText()) && controlModelo.ValidaDato(this.vista.jMes.getText()) && controlModelo.ValidaDato(this.vista.jRazonSocial.getText()) && controlModelo.ValidaDato(this.vista.jDetalle.getText())) {
            if (e.getSource().equals(vista.jButton1)) {

                Proveedor p1 = new Proveedor(0, this.vista.jRazonSocial.getText());
                

                int dia = Integer.parseInt(this.vista.jDia.getText());
                int mes = Integer.parseInt(this.vista.jMes.getText()) - 1; // En Calendar, enero = 0
                int anio = Integer.parseInt(this.vista.jAnio.getText());

                Calendar cal = Calendar.getInstance();
                cal.set(anio, mes, dia);
                Date fechaConvertida = cal.getTime();

                Fecha f1 = new Fecha(0, fechaConvertida);

                int n1 = (int) (Math.random() * 100 + 1);
                Recibo r1 = new Recibo(
                        Float.parseFloat(this.vista.jTotal.getText()),
                        this.vista.jDetalle.getText(),
                        p1,
                        0,
                        this.vista.jTipoRecibo.getText(),
                        n1,
                        f1
                );

                controlModelo.crearProveedor(p1);
                controlModelo.crearFecha(f1);
                controlModelo.crearRecibo(r1);

                cargarReciboTextField();
            }
        }
    }

    private void cargarReciboTextField() {
        ArrayList<Recibo> listaRecibos = controlModelo.listaRecibo();
        int i = 0;
        int j = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for (Recibo listaRecibo : listaRecibos) {
            this.vista.jTable1.setValueAt(listaRecibo.getIdComprobante(), i, j);
            j++;
            this.vista.jTable1.setValueAt(listaRecibo.getTipo(), i, j);
            j++;
            this.vista.jTable1.setValueAt(listaRecibo.getNumero(), i, j);
            j++;
            this.vista.jTable1.setValueAt(formato.format(listaRecibo.getFecha().getFecha()), i, j);
            j++;
            this.vista.jTable1.setValueAt(listaRecibo.getTotal(), i, j);
            j++;
            this.vista.jTable1.setValueAt(listaRecibo.getDetalle(), i, j);
            j++;
            this.vista.jTable1.setValueAt(listaRecibo.getProveedor().getRazonSocial(), i, j);;
            j = 0;
            i++;
        }
    }

}
