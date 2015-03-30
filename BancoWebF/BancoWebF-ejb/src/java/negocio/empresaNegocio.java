/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.EmpresaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Cuentabancaria;
import modelo.Empresa;

/**
 *
 * @author mario
 */
@Stateless
@LocalBean
public class empresaNegocio {
    @EJB
    private EmpresaFacade empresaFacade;
   public Empresa empresaB;
    
    
    public List<Empresa> getTodosCuentas()
    {
        return empresaFacade.findAll();
    }
    
    
    public void crearEmpresa(Empresa cuenta)
    {
        empresaFacade.create(cuenta);
    }
    
    public void eliminarEmpresa(Empresa cuenta)
    {
        empresaFacade.remove(cuenta);
    }
    
    public Empresa buscarEmpresa(String idEmpresa)
    {
        empresaB = empresaFacade.find(idEmpresa);
        return empresaB;
    }
    
   public void modificarEmpresaB(String identificacionP, String razonSocialP,
           String direccionP, String telefonoP, String passwordP, Cuentabancaria cuentaP) {
        
        
        buscarEmpresa(identificacionP);
        empresaB.setRazonSocial(identificacionP);
        empresaB.setDireccion(identificacionP);
        empresaB.setTelefono(identificacionP);
        empresaB.setPassword(identificacionP);
        empresaB.setNumeroCuentaBancaria(cuentaP);
        
        empresaFacade.edit(empresaB);
    }
}
