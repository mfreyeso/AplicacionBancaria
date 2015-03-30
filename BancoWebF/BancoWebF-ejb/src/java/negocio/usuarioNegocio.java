/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Banco;
import modelo.Cuentabancaria;
import modelo.Usuario;

/**
 *
 * @author mario
 */
@Stateless
@LocalBean
public class usuarioNegocio {
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public Usuario usuarioB;
    
    
    public List<Usuario> getTodosCuentas()
    {
        return usuarioFacade.findAll();
    }
    
    
    public void crearUsuario(Usuario cuenta)
    {
        usuarioFacade.create(cuenta);
    }
    
    public void eliminarUsuario(Usuario cuenta)
    {
        usuarioFacade.remove(cuenta);
    }
    
    public Usuario buscarUsuario(String idUsuario)
    {
        usuarioB = usuarioFacade.find(idUsuario);
        return usuarioB;
    }
    
   public void modificarUsuarioB(String identificacionP, String nombresP,
           String primerApellidoP, String segundoApellidoP, String direccionP,
           String telefonoP, int edadP, Banco bancoP, Cuentabancaria cuentaP) {
        
        
        buscarUsuario(identificacionP);
        usuarioB.setNombres(nombresP);
        usuarioB.setPrimerApellido(primerApellidoP);
        usuarioB.setSegundoApellido(segundoApellidoP);
        usuarioB.setDireccion(direccionP);
        usuarioB.setTelefono(telefonoP);
        usuarioB.setEdad(edadP);
        usuarioB.setIdBanco(bancoP);
        usuarioB.setNumeroCuentaBancaria(cuentaP);
        usuarioFacade.edit(usuarioB);
    }
}
