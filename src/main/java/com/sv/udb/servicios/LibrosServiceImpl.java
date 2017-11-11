package com.sv.udb.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.udb.dao.LibrosDAO;
import com.sv.udb.modelos.Libros;


@Service
@Transactional
public class LibrosServiceImpl  implements LibrosService {
	@Autowired
    private LibrosDAO librosDAO;
	
	public void guarLibro(Libros libro) {
		librosDAO.guarLibro(libro);		
	}

	public List<Libros> consTodo() {
		return librosDAO.consTodo();
	}

	public void elimLibro(Integer codiLibro) {
		librosDAO.elimLibro(codiLibro);
		
	}

	public Libros actuLibro(Libros libro) {
		return librosDAO.actuLibro(libro);
	}

	public Libros consLibro(int codiLibro) {
		return librosDAO.consLibro(codiLibro);
	}
	


}
