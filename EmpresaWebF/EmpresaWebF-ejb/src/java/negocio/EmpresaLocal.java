/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Cargo;
import modelo.Empleado;

/**
 *
 * @author mario
 */
@Local
public interface EmpresaLocal {
    
    public List<Empleado> getTodosEmpleados();
    public void crearEmpleado(Empleado empleado);
    public void modificarEmpleadoB(String identificacionP, String nombresP,
                String PrimerApellidoP, String SegundoApellidoP, int EdadP, 
                String DireccionP, String TelefonoP, Cargo IdCargoP);
    
    public void eliminarEmpleado(Empleado empleado);
    
    public Empleado buscarEmpleado(String idEmpleado);
}
