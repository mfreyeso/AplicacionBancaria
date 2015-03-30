/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cargo;
import negocio.cargoNegocio;

/**
 *
 * @author mario
 */
@ManagedBean
@SessionScoped
public class cargoBean {
    @EJB
    private cargoNegocio cargoNegocio;
    
    

    /**
     * Creates a new instance of cargoBean
     */
    private List<Cargo> cargos;
    private Cargo cargo;
    
    
    public cargoBean() {
    }
    
        
   public List<Cargo> getCargos() {
        cargos = cargoNegocio.getTodosCargos();
        return cargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargoP) {
        this.cargo = cargoP;
    }
    
    public String guardarCargo()
    {
        cargoNegocio.crearCargo(cargo);
        return "CargoLista";
    }
    
    public String prepararNuevoCargo()
    {
        cargo = new Cargo();
        return "CargoCrear";
    }
    
    public String prepararEditarCargo()
    {
        cargo = new Cargo();
        return "CargoEditar";
    }
    
    public String prepararEliminarCargo()
    {
        cargo = new Cargo();
        return "EliminarCargo";
    }
    
    public String modificarCargo()
    {
        cargoNegocio.modificarCargoB(cargo.getIdCargo(), cargo.getNombreCargo(),
                cargo.getSalario(), cargo.getIdAreaF());
        return "CargoLista";
    }
    
     public String eliminarCargo()
    {
        cargoNegocio.eliminarCargo(cargo);
        return "CargoLista";
    }
    
}
