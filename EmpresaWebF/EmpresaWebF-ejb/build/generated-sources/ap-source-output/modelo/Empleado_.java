package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Banco;
import modelo.Cargo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-01-21T23:04:37")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> identificacion;
    public static volatile SingularAttribute<Empleado, String> direccion;
    public static volatile SingularAttribute<Empleado, Cargo> idCargo;
    public static volatile SingularAttribute<Empleado, String> nombres;
    public static volatile SingularAttribute<Empleado, String> noCuentaBancaria;
    public static volatile SingularAttribute<Empleado, String> primerApellido;
    public static volatile SingularAttribute<Empleado, Integer> edad;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, Banco> idBanco;
    public static volatile SingularAttribute<Empleado, String> segundoApellido;

}