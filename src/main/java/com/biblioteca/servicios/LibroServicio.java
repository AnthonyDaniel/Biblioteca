package com.biblioteca.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.LibroEntidad;
import com.biblioteca.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

	@Autowired
	public LibroRepositorio libroR;
	
	private boolean existeLibro(Long id) {
		if(libroR.existsById(id))
			return true;

		return false;
	}
	
	public boolean agregarLibro(LibroEntidad libro) {
		if(!existeLibro(libro.getId())) {
			libroR.save(libro);
			return true;
		}
		return false;
	}
	
	public boolean modificarLibro(LibroEntidad libro) {
		if(existeLibro(libro.getId())) {
			libroR.save(libro);
			return true;
		}
		return false;
	}
	
	public Optional<LibroEntidad> buscarLibroPorID(Long id) {
		if(existeLibro(id)) {
			return libroR.findById(id);
		}
		return null;
	}
	
	public List<LibroEntidad> obtenerLibros() {
		return libroR.findAll();
	}
	
	public boolean eliminarLibro(Long id) {
		if(existeLibro(id)) {
			libroR.deleteById(id);
			return true;
		}
		return false;
	}
}
