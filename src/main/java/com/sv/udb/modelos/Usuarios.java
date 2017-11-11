/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "usuarios", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByCodiUsua", query = "SELECT u FROM Usuarios u WHERE u.codiUsua = :codiUsua")
    , @NamedQuery(name = "Usuarios.findByNombUsua", query = "SELECT u FROM Usuarios u WHERE u.nombUsua = :nombUsua")
    , @NamedQuery(name = "Usuarios.findByAcceUsua", query = "SELECT u FROM Usuarios u WHERE u.acceUsua = :acceUsua")
    , @NamedQuery(name = "Usuarios.findByContUsua", query = "SELECT u FROM Usuarios u WHERE u.contUsua = :contUsua")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_usua")
    private Integer codiUsua;
    @Basic(optional = false)
    @Column(name = "nomb_usua")
    private String nombUsua;
    @Basic(optional = false)
    @Column(name = "acce_usua")
    private String acceUsua;
    @Basic(optional = false)
    @Column(name = "cont_usua")
    private String contUsua;
    @OneToMany(mappedBy = "codiPerm", fetch = FetchType.EAGER)
    private Collection<PermisosUsuarios> permisosUsuariosCollection;
    @OneToMany(mappedBy = "codiUsua", fetch = FetchType.EAGER)
    private Collection<Listas> listasCollection;
    @OneToMany(mappedBy = "codiUsua", fetch = FetchType.EAGER)
    private Collection<Prestamos> prestamosCollection;

    public Usuarios() {
    }

    public Usuarios(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Usuarios(Integer codiUsua, String nombUsua, String acceUsua, String contUsua) {
        this.codiUsua = codiUsua;
        this.nombUsua = nombUsua;
        this.acceUsua = acceUsua;
        this.contUsua = contUsua;
    }

    public Integer getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getNombUsua() {
        return nombUsua;
    }

    public void setNombUsua(String nombUsua) {
        this.nombUsua = nombUsua;
    }

    public String getAcceUsua() {
        return acceUsua;
    }

    public void setAcceUsua(String acceUsua) {
        this.acceUsua = acceUsua;
    }

    public String getContUsua() {
        return contUsua;
    }

    public void setContUsua(String contUsua) {
        this.contUsua = contUsua;
    }

    @XmlTransient
    public Collection<PermisosUsuarios> getPermisosUsuariosCollection() {
        return permisosUsuariosCollection;
    }

    public void setPermisosUsuariosCollection(Collection<PermisosUsuarios> permisosUsuariosCollection) {
        this.permisosUsuariosCollection = permisosUsuariosCollection;
    }

    @XmlTransient
    public Collection<Listas> getListasCollection() {
        return listasCollection;
    }

    public void setListasCollection(Collection<Listas> listasCollection) {
        this.listasCollection = listasCollection;
    }

    @XmlTransient
    public Collection<Prestamos> getPrestamosCollection() {
        return prestamosCollection;
    }

    public void setPrestamosCollection(Collection<Prestamos> prestamosCollection) {
        this.prestamosCollection = prestamosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsua != null ? codiUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codiUsua == null && other.codiUsua != null) || (this.codiUsua != null && !this.codiUsua.equals(other.codiUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Usuarios[ codiUsua=" + codiUsua + " ]";
    }
    
}
