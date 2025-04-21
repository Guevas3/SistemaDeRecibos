package com.mycompany.examensimulado2.modelo;

import com.mycompany.examensimulado2.modelo.Proveedor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-18T18:11:09", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Recibo.class)
public class Recibo_ extends Comprobante_ {

    public static volatile SingularAttribute<Recibo, Float> total;
    public static volatile SingularAttribute<Recibo, Proveedor> proveedor;
    public static volatile SingularAttribute<Recibo, String> detalle;

}