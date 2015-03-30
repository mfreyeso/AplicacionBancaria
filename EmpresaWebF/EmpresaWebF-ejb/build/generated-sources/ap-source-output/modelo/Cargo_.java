package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Area;
import modelo.Empleado;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-01-21T23:04:37")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, String> nombreCargo;
    public static volatile ListAttribute<Cargo, Empleado> empleadoList;
    public static volatile SingularAttribute<Cargo, Integer> idCargo;
    public static volatile SingularAttribute<Cargo, Double> salario;
    public static volatile SingularAttribute<Cargo, String> descripcionCargo;
    public static volatile SingularAttribute<Cargo, Area> idAreaF;

}