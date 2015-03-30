/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.CargoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Area;
import modelo.Cargo;

/**
 *
 * @author mario
 */
@Stateless
@LocalBean
public class cargoNegocio {
    @EJB
    private CargoFacade cargoFacade;
    
    public Cargo cargoB;
    
    public List<Cargo> getTodosCargos()
    {
        return cargoFacade.findAll();
    }
    
    
    public void crearCargo(Cargo cargo)
    {
        cargoFacade.create(cargo);
    }
    
    public void eliminarCargo(Cargo cargo)
    {
        cargoFacade.remove(cargo);
    }
    
    public Cargo buscarCargo(int idCargo)
    {
        cargoB = cargoFacade.find(idCargo);
        return cargoB;
    }
    
   public void modificarCargoB(int identificacionP, String nombresCargoP,
            double salario, Area areaP) {
        
        
        buscarCargo(identificacionP);
        cargoB.setNombreCargo(nombresCargoP);
        cargoB.setSalario(salario);
        cargoB.setIdAreaF(areaP);
        cargoFacade.edit(cargoB);
    }
    
}
