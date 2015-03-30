/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.CuentabancariaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Cuentabancaria;

/**
 *
 * @author mario
 */
@Stateless
@LocalBean
public class cuentaBancariaNegocio {
    @EJB
    private CuentabancariaFacade cuentabancariaFacade;
    
    public Cuentabancaria cuentaBancariaB;
    
    
    public List<Cuentabancaria> getTodosCuentas()
    {
        return cuentabancariaFacade.findAll();
    }
    
    
    public void crearCuentabancaria(Cuentabancaria cuenta)
    {
        cuentabancariaFacade.create(cuenta);
    }
    
    public void eliminarCuentabancaria(Cuentabancaria cuenta)
    {
        cuentabancariaFacade.remove(cuenta);
    }
    
    public Cuentabancaria buscarCuentabancaria(String idCuentabancaria)
    {
        cuentaBancariaB = cuentabancariaFacade.find(idCuentabancaria);
        return cuentaBancariaB;
    }
    
   public void modificarCuentabancariaB(String identificacionP, double saldoCambio) {
        
        
        buscarCuentabancaria(identificacionP);
        cuentaBancariaB.setSaldo(saldoCambio);
        cuentabancariaFacade.edit(cuentaBancariaB);
    }
}
