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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuentabancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentabancaria.findAll", query = "SELECT c FROM Cuentabancaria c"),
    @NamedQuery(name = "Cuentabancaria.findByNumeroCuenta", query = "SELECT c FROM Cuentabancaria c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "Cuentabancaria.findBySaldo", query = "SELECT c FROM Cuentabancaria c WHERE c.saldo = :saldo")})
public class Cuentabancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "Numero_Cuenta")
    private String numeroCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Saldo")
    private Double saldo;
    @JoinColumn(name = "Identificacion_Banco", referencedColumnName = "Nit_Banco")
    @ManyToOne
    private Banco identificacionBanco;
    @OneToMany(mappedBy = "numeroCuentaBancaria")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "numeroCuentaBancaria")
    private List<Empresa> empresaList;

    public Cuentabancaria() {
    }

    public Cuentabancaria(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Banco getIdentificacionBanco() {
        return identificacionBanco;
    }

    public void setIdentificacionBanco(Banco identificacionBanco) {
        this.identificacionBanco = identificacionBanco;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCuenta != null ? numeroCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentabancaria)) {
            return false;
        }
        Cuentabancaria other = (Cuentabancaria) object;
        if ((this.numeroCuenta == null && other.numeroCuenta != null) || (this.numeroCuenta != null && !this.numeroCuenta.equals(other.numeroCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cuentabancaria[ numeroCuenta=" + numeroCuenta + " ]";
    }
    
}
