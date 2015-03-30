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
import modelo.Area;
import negocio.AreaNegocio;

/**
 *
 * @author mario
 */
@ManagedBean
@SessionScoped
public class areaBean {
    @EJB
    private AreaNegocio areaNegocio;
    

    /**
     * Creates a new instance of areaBean
     */
    public areaBean() {
    }
    
    private List<Area> areas;
    private Area area;
    
        
   public List<Area> getAreas() {
        areas = areaNegocio.getTodosAreas();
        return areas;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area areaP) {
        this.area = areaP;
    }
    
    public String guardarArea()
    {
        areaNegocio.crearArea(area);
        return "AreaLista";
    }
    
    public String prepararNuevoArea()
    {
        area = new Area();
        return "AreaCrear";
    }
    
    public String prepararEditarArea()
    {
        area = new Area();
        return "AreaEditar";
    }
    
    public String prepararEliminarArea()
    {
        area = new Area();
        return "EliminarArea";
    }
    
    public String modificarArea()
    {
        areaNegocio.modificarAreaB(area.getIdArea(), area.getNombreArea(),
                area.getDescripcionArea());
        return "AreaLista";
    }
    
    public String eliminarArea()
    {
        areaNegocio.eliminarArea(area);
        return "AreaLista";
    }
}
