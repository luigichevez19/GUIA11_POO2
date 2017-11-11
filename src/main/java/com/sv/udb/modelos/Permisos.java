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
@Table(name = "permisos", catalog = "dropbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByCodiPerm", query = "SELECT p FROM Permisos p WHERE p.codiPerm = :codiPerm")
    , @NamedQuery(name = "Permisos.findByNombPerm", query = "SELECT p FROM Permisos p WHERE p.nombPerm = :nombPerm")
    , @NamedQuery(name = "Permisos.findByDescPerm", query = "SELECT p FROM Permisos p WHERE p.descPerm = :descPerm")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_perm")
    private Integer codiPerm;
    @Column(name = "nomb_perm")
    private String nombPerm;
    @Column(name = "desc_perm")
    private String descPerm;
    @OneToMany(mappedBy = "codiUsua", fetch = FetchType.EAGER)
    private Collection<PermisosUsuarios> permisosUsuariosCollection;

    public Permisos() {
    }

    public Permisos(Integer codiPerm) {
        this.codiPerm = codiPerm;
    }

    public Integer getCodiPerm() {
        return codiPerm;
    }

    public void setCodiPerm(Integer codiPerm) {
        this.codiPerm = codiPerm;
    }

    public String getNombPerm() {
        return nombPerm;
    }

    public void setNombPerm(String nombPerm) {
        this.nombPerm = nombPerm;
    }

    public String getDescPerm() {
        return descPerm;
    }

    public void setDescPerm(String descPerm) {
        this.descPerm = descPerm;
    }

    @XmlTransient
    public Collection<PermisosUsuarios> getPermisosUsuariosCollection() {
        return permisosUsuariosCollection;
    }

    public void setPermisosUsuariosCollection(Collection<PermisosUsuarios> permisosUsuariosCollection) {
        this.permisosUsuariosCollection = permisosUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiPerm != null ? codiPerm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.codiPerm == null && other.codiPerm != null) || (this.codiPerm != null && !this.codiPerm.equals(other.codiPerm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Permisos[ codiPerm=" + codiPerm + " ]";
    }
    
}
