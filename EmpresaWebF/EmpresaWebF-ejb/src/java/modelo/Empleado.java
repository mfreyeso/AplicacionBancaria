/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdentificacion", query = "SELECT e FROM Empleado e WHERE e.identificacion = :identificacion"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByPrimerApellido", query = "SELECT e FROM Empleado e WHERE e.primerApellido = :primerApellido"),
    @NamedQuery(name = "Empleado.findBySegundoApellido", query = "SELECT e FROM Empleado e WHERE e.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Empleado.findByEdad", query = "SELECT e FROM Empleado e WHERE e.edad = :edad"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado.findByNoCuentaBancaria", query = "SELECT e FROM Empleado e WHERE e.noCuentaBancaria = :noCuentaBancaria")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Identificacion")
    private String identificacion;
    @Size(max = 72)
    @Column(name = "Nombres")
    private String nombres;
    @Size(max = 32)
    @Column(name = "Primer_ Apellido")
    private String primerApellido;
    @Size(max = 32)
    @Column(name = "Segundo_Apellido")
    private String segundoApellido;
    @Column(name = "Edad")
    private Integer edad;
    @Size(max = 72)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 32)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 48)
    @Column(name = "No_CuentaBancaria")
    private String noCuentaBancaria;
    @JoinColumn(name = "idCargo", referencedColumnName = "IdCargo")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "idBanco", referencedColumnName = "NitBanco")
    @ManyToOne
    private Banco idBanco;

    public Empleado() {
    }

    public Empleado(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNoCuentaBancaria() {
        return noCuentaBancaria;
    }

    public void setNoCuentaBancaria(String noCuentaBancaria) {
        this.noCuentaBancaria = noCuentaBancaria;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleado[ identificacion=" + identificacion + " ]";
    }
    
}
