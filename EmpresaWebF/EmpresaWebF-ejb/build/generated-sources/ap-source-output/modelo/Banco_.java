package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Empleado;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-01-21T23:04:37")
@StaticMetamodel(Banco.class)
public class Banco_ { 

    public static volatile ListAttribute<Banco, Empleado> empleadoList;
    public static volatile SingularAttribute<Banco, String> direccionBanco;
    public static volatile SingularAttribute<Banco, Integer> nitBanco;
    public static volatile SingularAttribute<Banco, String> nombreBanco;
    public static volatile SingularAttribute<Banco, String> telefonoBanco;

}