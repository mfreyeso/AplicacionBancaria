/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.EmpleadoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Cargo;
import modelo.Empleado;

/**
 *
 * @author mario
 */
@Stateless
public class EmpresaNegocio implements EmpresaLocal {
    
    //Llamo al Dao
     @EJB
    private EmpleadoFacade empleadoFacade;
    
    
     
     
     
     public Empleado empleadoB;
     public Cargo cargoB;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    @Override
    public List<Empleado> getTodosEmpleados()
    {
        return empleadoFacade.findAll();
    }
    
    
     @Override
    public void crearEmpleado(Empleado empleado)
    {
        empleadoFacade.create(empleado);
    }
    
     @Override
    public void eliminarEmpleado(Empleado empleado)
    {
        empleadoFacade.remove(empleado);
    }
    
     @Override
    public Empleado buscarEmpleado(String idEmpleado)
    {
        empleadoB = empleadoFacade.find(idEmpleado);
        return empleadoB;
    }
    
    @Override
    public void modificarEmpleadoB(String identificacionP, String nombresP, String PrimerApellidoP, 
            String SegundoApellidoP, int EdadP, String DireccionP, String TelefonoP, Cargo IdCargoP) {
        
        
        buscarEmpleado(identificacionP);
        empleadoB.setNombres(nombresP);
        empleadoB.setPrimerApellido(PrimerApellidoP);
        empleadoB.setSegundoApellido(SegundoApellidoP);
        empleadoB.setEdad(EdadP);
        empleadoB.setDireccion(DireccionP);
        empleadoB.setTelefono(TelefonoP);
        //Esto queda en observacion de que sea necesario el identificador o el Objeto
        empleadoB.setIdCargo(IdCargoP);
        empleadoFacade.edit(empleadoB);
    }
    
    
    
    
}
