package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cargo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-01-21T23:04:37")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, String> descripcionArea;
    public static volatile SingularAttribute<Area, Integer> idArea;
    public static volatile SingularAttribute<Area, String> nombreArea;
    public static volatile ListAttribute<Area, Cargo> cargoList;

}