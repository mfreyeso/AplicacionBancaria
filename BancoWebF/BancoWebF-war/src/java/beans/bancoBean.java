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
import modelo.Banco;
import negocio.bancoNegocio;

/**
 *
 * @author mario
 */
@ManagedBean
@SessionScoped
public class bancoBean {
    @EJB
    private bancoNegocio bancoNegocio;
    

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
        return "BancoCrearEditar";
    }
    
    public String prepararEditarBanco()
    {
        banco = new Banco();
        return "BancoCrearEditar";
    }
    
    public String prepararEliminarBanco()
    {
        banco = new Banco();
        return "BancoEliminar";
    }
    
    public String modificarBanco()
    {
        bancoNegocio.modificarBancoB(banco.getNitBanco(), banco.getNombreBanco(),
                banco.getDireccionBanco(), banco.getTelefono());
        return "BancoLista";
    }
    
     public String eliminarBanco()
    {
        bancoNegocio.eliminarBanco(banco);
        return "BancoLista";
    }
    
}
