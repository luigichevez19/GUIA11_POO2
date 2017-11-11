package com.sv.udb.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sv.udb.modelos.Libros;
import com.sv.udb.servicios.LibrosService;


@Controller
@RequestMapping(value = {"/libros"})
public class LibrosController {
	
	private static final Logger logger = Logger.getLogger(Libros.class);
	public LibrosController() {
        System.out.println("TiposController()");
    }
	  @Autowired
	    private LibrosService librosService;
	 
	    @RequestMapping(value = "/")
	    public ModelAndView listLibro(ModelAndView model) throws IOException {
	    	List<Libros> listLibro = librosService.consTodo();
	        model.addObject("listLibro", listLibro);
	        model.setViewName("libros/home");
	        return model;
	    }
	    
	    @RequestMapping(value = "/nuevoLibro", method = RequestMethod.GET)
	    public ModelAndView newContact(ModelAndView model) {
	    	Libros libro = new Libros();
	        model.addObject("objeLibro", libro);
	        model.setViewName("libros/libroForm");
	        return model;
	    }
	    
	    @RequestMapping(value = "/guardarLibro", method = RequestMethod.POST)
	    public ModelAndView guarTipo(@ModelAttribute Libros libro) {
	        if (libro.getCodi_libr() == null) { // Si es 0 hay que crearlo
	        	librosService.guarLibro(libro);
	        } else {
	        	librosService.actuLibro(libro);
	        }
	        return new ModelAndView("redirect:/libros/");
	    }
	    
	    @RequestMapping(value = "/editarLibro", method = RequestMethod.GET)
	    public ModelAndView editarTipo(HttpServletRequest request) {
	        int codi_libro = Integer.parseInt(request.getParameter("codi"));
	        System.out.println("Respuesta:" + codi_libro);
	        Libros libro = librosService.consLibro(codi_libro);
	        ModelAndView model = new ModelAndView("q/libroForm");
	        model.addObject("objeLibro", libro);
	        return model;
	    }
	    
	    @RequestMapping(value = "/eliminarLibro", method = RequestMethod.GET)
	    public ModelAndView eliminarTipo(HttpServletRequest request) {
	        int codi_libro = Integer.parseInt(request.getParameter("codi"));
	        librosService.elimLibro(codi_libro);
	        return new ModelAndView("redirect:/libros/");
	    }
}
