/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JMagoSV
 */
@Entity
@Table(name = "libros")
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer codi_libr;
    @Column
    private String nomb_libr;
    @Column
    private String auto_libr;
    @Column
    private String gene_libr;
    @Column
    private Integer anio_libr;
    @Column
    private Integer esta_libr;

    public Libros() {
    }

    public Integer getCodi_libr() {
		return codi_libr;
	}



	public void setCodi_libr(Integer codi_libr) {
		this.codi_libr = codi_libr;
	}



	public String getNomb_libr() {
		return nomb_libr;
	}



	public void setNomb_libr(String nomb_libr) {
		this.nomb_libr = nomb_libr;
	}



	public String getAuto_libr() {
		return auto_libr;
	}



	public void setAuto_libr(String auto_libr) {
		this.auto_libr = auto_libr;
	}



	public String getGene_libr() {
		return gene_libr;
	}



	public void setGene_libr(String gene_libr) {
		this.gene_libr = gene_libr;
	}



	public Integer getAnio_libr() {
		return anio_libr;
	}



	public void setAnio_libr(Integer anio_libr) {
		this.anio_libr = anio_libr;
	}



	public Integer getEsta_libr() {
		return esta_libr;
	}



	public void setEsta_libr(Integer esta_libr) {
		this.esta_libr = esta_libr;
	}



	@Override
    public String toString() {
        return "com.sv.udb.modelos.Libros[ codi_libr=" + codi_libr + " ]";
    }
    
}
