package com.sv.udb.dao;

import java.util.List;

import com.sv.udb.modelos.Libros;


public interface LibrosDAO {
	public void guarLibro(Libros libro);	 
    public List<Libros> consTodo(); 
    public void elimLibro(Integer codiLibro); 
    public Libros actuLibro(Libros libro); 
    public Libros consLibro(int codiLibro);
}
