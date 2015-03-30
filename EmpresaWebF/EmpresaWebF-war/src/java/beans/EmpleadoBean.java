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
import modelo.Empleado;
import negocio.EmpresaLocal;

/**
 *
 * @author mario
 */
@ManagedBean
@SessionScoped
public class EmpleadoBean {
    //Llamo al negocio donde puedo realizar las distintas operaciones.
    @EJB
    private EmpresaLocal empresaNegocio;
    
    
    private List<Empleado> empleados;
    
    private Empleado empleado;
    
    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
    }
    
   public List<Empleado> getEmpleados() {
        empleados = empresaNegocio.getTodosEmpleados();
        return empleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleadoP) {
        this.empleado = empleadoP;
    }
    
    public String guardarEmpleado()
    {
        empresaNegocio.crearEmpleado(empleado);
        return "EmpleadoLista";
    }
    
    public String prepararNuevoEmpleado()
    {
        empleado = new Empleado();
        return "EmpleadoCrear";
    }
    
    public String prepararEditarEmpleado()
    {
        empleado = new Empleado();
        return "EmpleadoEditar";
    }
    
    public String prepararEliminarEmpleado()
    {
        empleado = new Empleado();
        return "EliminarEmpleado";
    }
    
    public String modificarEmpleado()
    {
        empresaNegocio.modificarEmpleadoB(empleado.getIdentificacion(), empleado.getNombres(),
                empleado.getPrimerApellido(), empleado.getSegundoApellido(), empleado.getEdad(), 
                empleado.getDireccion(), empleado.getTelefono(), empleado.getIdCargo());
        return "EmpleadoLista";
    }
    
    public String eliminarEmpleado()
    {
        empresaNegocio.eliminarEmpleado(empleado);
        return "EmpleadoLista";
    }
    
}
