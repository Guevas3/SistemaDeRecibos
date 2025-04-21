package com.mycompany.examensimulado2.modelo;

import com.mycompany.examensimulado2.modelo.Fecha;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-18T18:11:09", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comprobante.class)
public class Comprobante_ { 

    public static volatile SingularAttribute<Comprobante, Fecha> fecha;
    public static volatile SingularAttribute<Comprobante, String> tipo;
    public static volatile SingularAttribute<Comprobante, Integer> numero;
    public static volatile SingularAttribute<Comprobante, Integer> idComprobante;

}