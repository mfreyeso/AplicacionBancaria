/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Banco;
import negocio.BancoNegocio;

/**
 *
 * @author mario
 */
@ManagedBean
@RequestScoped
public class bancoBean {
    @EJB
    private BancoNegocio bancoNegocio;

    /**
     * Creates a new instance of bancoBean
     */
    public bancoBean() {
    }
    
    private List<Banco> bancos;
    private Banco banco;
    
        
   public List<Banco> getBancos() {
        bancos = bancoNegocio.getTodosBancos();
        return bancos;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco bancoP) {
        this.banco = bancoP;
    }
    
    public String guardarBanco()
    {
        bancoNegocio.crearBanco(banco);
        return "BancoLista";
    }
    
    public String prepararNuevoBanco()
    {
        banco = new Banco();
        return "BancoCrear";
    }
    
    public String prepararEditarBanco()
    {
        banco = new Banco();
        return "BancoEditar";
    }
    
    public String prepararEliminarBanco()
    {
        banco = new Banco();
        return "EliminarBanco";
    }
    
    public String modificarBanco()
    {
        bancoNegocio.modificarBancoB(banco.getNitBanco(), banco.getNombreBanco(),
                banco.getDireccionBanco(), banco.getTelefonoBanco());
        return "BancoLista";
    }
    
     public String eliminarBanco()
    {
        bancoNegocio.eliminarBanco(banco);
        return "BancoLista";
    }
    
}
