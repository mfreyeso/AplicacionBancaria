/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "Banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByNitBanco", query = "SELECT b FROM Banco b WHERE b.nitBanco = :nitBanco"),
    @NamedQuery(name = "Banco.findByNombreBanco", query = "SELECT b FROM Banco b WHERE b.nombreBanco = :nombreBanco"),
    @NamedQuery(name = "Banco.findByTelefonoBanco", query = "SELECT b FROM Banco b WHERE b.telefonoBanco = :telefonoBanco"),
    @NamedQuery(name = "Banco.findByDireccionBanco", query = "SELECT b FROM Banco b WHERE b.direccionBanco = :direccionBanco")})
public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NitBanco")
    private Integer nitBanco;
    @Size(max = 32)
    @Column(name = "Nombre_Banco")
    private String nombreBanco;
    @Size(max = 32)
    @Column(name = "Telefono_Banco")
    private String telefonoBanco;
    @Size(max = 72)
    @Column(name = "Direccion_Banco")
    private String direccionBanco;
    @OneToMany(mappedBy = "idBanco")
    private List<Empleado> empleadoList;

    public Banco() {
    }

    public Banco(Integer nitBanco) {
        this.nitBanco = nitBanco;
    }

    public Integer getNitBanco() {
        return nitBanco;
    }

    public void setNitBanco(Integer nitBanco) {
        this.nitBanco = nitBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getTelefonoBanco() {
        return telefonoBanco;
    }

    public void setTelefonoBanco(String telefonoBanco) {
        this.telefonoBanco = telefonoBanco;
    }

    public String getDireccionBanco() {
        return direccionBanco;
    }

    public void setDireccionBanco(String direccionBanco) {
        this.direccionBanco = direccionBanco;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nitBanco != null ? nitBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.nitBanco == null && other.nitBanco != null) || (this.nitBanco != null && !this.nitBanco.equals(other.nitBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Banco[ nitBanco=" + nitBanco + " ]";
    }
    
}
