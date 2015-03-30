/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.BancoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Banco;

/**
 *
 * @author mario
 */
@Stateless
@LocalBean
public class BancoNegocio {
    @EJB
    private BancoFacade bancoFacade;

    public Banco bancoB;
    
    
    public List<Banco> getTodosBancos()
    {
        return bancoFacade.findAll();
    }
    
    
    public void crearBanco(Banco banco)
    {
        bancoFacade.create(banco);
    }
    
    public void eliminarBanco(Banco banco)
    {
        bancoFacade.remove(banco);
    }
    
    public Banco buscarBanco(int idBanco)
    {
        bancoB = bancoFacade.find(idBanco);
        return bancoB;
    }
    
   public void modificarBancoB(int identificacionP, String nombresBancoP,
            String direccionP, String telefonoP) {
        
        
        buscarBanco(identificacionP);
        bancoB.setNombreBanco(nombresBancoP);
        bancoB.setDireccionBanco(direccionP);
        bancoB.setTelefonoBanco(telefonoP);
        bancoFacade.edit(bancoB);
    }
}
