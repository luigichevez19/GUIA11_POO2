package com.sv.udb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.udb.modelos.Libros;

@Repository
public class LibrosDAOImpl implements LibrosDAO {
	@Autowired
    private SessionFactory sessionFactory;
	public void guarTipo(Libros libro) {
		sessionFactory.getCurrentSession().saveOrUpdate(libro);
	}

	@SuppressWarnings("unchecked")
	public List<Libros> consTodo() {
		return sessionFactory.getCurrentSession().createQuery("from Libros").list();
	}

	public void elimTipo(Integer codiLibro) {
		Libros libro = (Libros) sessionFactory.getCurrentSession().load(
				Libros.class, codiLibro);
        if (null != libro) {
            this.sessionFactory.getCurrentSession().delete(libro);
        }
	}

	public Libros actuTipo(Libros libro) {
		sessionFactory.getCurrentSession().update(libro);
        return libro;
	}

	public Libros consTipo(int codiLibro) {
		return (Libros) sessionFactory.getCurrentSession().get(
				Libros.class, codiLibro);
	}

	@Override
	public void guarLibro(Libros libro) {
		sessionFactory.getCurrentSession().saveOrUpdate(libro);
		
	}

	@Override
	public void elimLibro(Integer codiLibro) {
		Libros libro = (Libros) sessionFactory.getCurrentSession().load(
				Libros.class, codiLibro);
        if (null != libro) {
            this.sessionFactory.getCurrentSession().delete(libro);
        }
		
	}

	@Override
	public Libros actuLibro(Libros libro) {
		sessionFactory.getCurrentSession().update(libro);
        return libro;
	}

	@Override
	public Libros consLibro(int codiLibro) {
		// TODO Auto-generated method stub
		return (Libros) sessionFactory.getCurrentSession().get(
				Libros.class, codiLibro);
	}

}
