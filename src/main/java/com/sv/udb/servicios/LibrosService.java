package com.sv.udb.servicios;

import java.util.List;

import com.sv.udb.modelos.Libros;

public interface LibrosService {

	public void guarLibro(Libros libro);	 
    public List<Libros> consTodo(); 
    public void elimLibro(Integer codiLibro); 
    public Libros actuLibro(Libros libro); 
    public Libros consLibro(int codiLibro);
}
