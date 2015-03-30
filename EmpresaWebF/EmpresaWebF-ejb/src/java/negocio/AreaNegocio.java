/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.AreaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Area;

/**
 *
 * @author mario
 */
@Stateless
@LocalBean
public class AreaNegocio {
    @EJB
    private AreaFacade areaFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Area areaB;
    
    public List<Area> getTodosAreas()
    {
        return areaFacade.findAll();
    }
    
    
    public void crearArea(Area area)
    {
        areaFacade.create(area);
    }
    
    public void eliminarArea(Area area)
    {
        areaFacade.remove(area);
    }
    
    public Area buscarArea(int idArea)
    {
        areaB = areaFacade.find(idArea);
        return areaB;
    }
    
   public void modificarAreaB(int identificacionP, String nombresAreaP,
            String descripcionArea) {
        
        
        buscarArea(identificacionP);
        areaB.setNombreArea(nombresAreaP);
        areaB.setDescripcionArea(descripcionArea);
        areaFacade.edit(areaB);
    }
    
}
